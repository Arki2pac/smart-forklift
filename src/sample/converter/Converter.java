package sample.converter;

/**
 * Created by Grzegorz on 2016-06-04.
 */
public class Converter {

    public Double[] toConvert(String[] dane){
        Double przekonwerotwane[] = new Double[4];
        for(int i=0; i<dane.length; i++){
            if(dane[i].equals("gray")){
                przekonwerotwane[i] = 1.0;
            }
            if(dane[i].equals("metal")){
                przekonwerotwane[i] = 2.0;
            }
            if(dane[i].equals("heavy")){
                przekonwerotwane[i] = 3.0;
            }
            if(dane[i].equals("middleweight")){
                przekonwerotwane[i] = 4.0;
            }
        }
        return przekonwerotwane;
    }

}