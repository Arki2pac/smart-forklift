/**
 * Created by s396413 on 2016-03-21.
 */
public class Dane {

        public double objetosc = 0.0;
        public double kolor = 0.0;
        public double waga = 0.0;
        public double latwopalne = 0.0;

        double[][] tablicaregresji = new double[1000][5];



    public Dane(double objetosc, double kolor, double waga, double latwopalne){
        this.objetosc = objetosc;
        this.kolor = kolor;
        this.waga = waga;
        this.latwopalne = latwopalne;
    }

    public double getobj(){
        return objetosc;
    }

    public double getKolor(){
        return kolor;
    }

    public double getWaga(){
        return waga;
    }

    public double getLatwo(){
        return latwopalne;
    }

    public double[][] zerowanie(double[][] tablicaregresji) {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 5; j++) {
                tablicaregresji[i][j] = 0.0;
            }
        }
        return tablicaregresji;
    }

    public double[][] AddToArray(double[][] tablicaregresji){
        for (int i = 0; i < 1000; i++){
            if (tablicaregresji[i][0] == 0.0){
                tablicaregresji[i][1] = getobj();
                tablicaregresji[i][2] = getKolor();
                tablicaregresji[i][3] = getWaga();
                tablicaregresji[i][4] = getLatwo();
            }
        }
        return tablicaregresji;
    }
}
