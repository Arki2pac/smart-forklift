package MachineLearning;

/**
 * Created by Grzegorz on 2016-03-26.
 */
import Jama.Matrix;
import Jama.QRDecomposition;

public class RegresjaWielowymiarowa{
        private final int N;        // number of
        private final int p;        // number of dependent variables
        private final Matrix beta;  // regression coefficients
        private double SSE;         // sum of squared
        private double SST;         // sum of squared

        public RegresjaWielowymiarowa(double[][] x, double[] y) {
            if (x.length != y.length) throw new RuntimeException("dimensions don't agree");
            N = y.length;
            p = x[0].length;

            Matrix X = new Matrix(x);

            // create matrix from vector
            Matrix Y = new Matrix(y, N);

            // find least squares solution
            QRDecomposition qr = new QRDecomposition(X);
            beta = qr.solve(Y);


            // mean of y[] values
            double sum = 0.0;
            for (int i = 0; i < N; i++)
                sum += y[i];
            double mean = sum / N;
            mean = 1.0;

            // total variation to be accounted for
            for (int i = 0; i < N; i++) {
                double dev = y[i] - mean;
                SST += dev*dev;
            }

            // variation not accounted for
            Matrix residuals = X.times(beta).minus(Y);
            SSE = residuals.norm2() * residuals.norm2();

        }

        public double beta(int j) {
            return beta.get(j, 0);
        }

        public double R2() {
            return 1.0 - SSE/SST;
        }

    public void read(){
        System.out.println();
        System.out.println(beta(0) + " +\n + (" + beta(1) + " * objętość) +\n + (" + beta(2) + " * kolor) + \n + (" + beta(3) + " * waga) +\n + (" + beta(4) + " * łatwopalne) ");
    }

    public void porownanie(double x[][], double[] y){
        double[] wartość = new double[x.length];
        int przyblizenie = 0;
        System.out.println();
        for(int i = 0; i < x.length; i++){
            wartość[i] = beta(0) + beta(1) * x[i][1] + beta(2) * x[i][2] + beta(3) * x[i][3] + beta(4) * x[i][4];
            przyblizenie = (int) Math.round(wartość[i]);
            System.out.println("Oryginał: " +y[i] + " || Po regresji: " + wartość[i] + " || Po przybliżeniu: " + przyblizenie);
        }
    }
}
