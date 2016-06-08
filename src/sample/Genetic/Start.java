package sample.Genetic;

import static sample.Main.RegalGood;

public class Start {
    public static int estimation = 0;
    public static String HEAVY_AREA = "11110101001";
    public static String LIGHT_AREA = "11111010001";
    public static String COOL_AREA = "10101111010";
    public static String FLAMMABLE_AREA = "11111111100";

    public static int finalEstimation = 0;

    public Start() {

    }

    public static void main(String[] args) {

//        startAlgorithm(HEAVY_AREA);
//        startAlgorithm(COOL_AREA);
        startAlgorithm(HEAVY_AREA);
//        startAlgorithm(LIGHT_AREA);
//        startAlgorithm(FLAMMABLE_AREA);



    }
    public static void startAlgorithm(String area) {
        // Ustaw oczekiwane rozwiązanie (genotyp odpowiedniej strefy)
        FitnessCalc.setSolution(area);

        // Stwórz losowo lub z wcześniej zdefiniowanych osobników nową populację
        Population myPop = new Population(20, true);

        // Liczba generacji
        int generationCount = 0;
        //   while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {
        // for(int i=0; i<500; i++) {

//        while(calculateEstimation(myPop.getFittest(), area) < calculateSolutionEstimation(area)) {
for (generationCount = 0;generationCount < 10; generationCount++){

//            generationCount++;
            System.out.println("");
            for(int j=0; j< 5; j++) {
                System.out.println("Current genes package" + getCaseGenes(myPop.getIndividual(j)));
            }
            System.out.println("Generation: " + generationCount + "      Fittest: " + myPop.getFittest().getFitness() + "       Case genes: " + getCaseGenes(myPop.getFittest()) + "      Estimation: " + calculateEstimation(myPop.getFittest(), area));

            //następna generacja
            myPop = Algorithm.evolvePopulation(myPop);
        }
        System.out.println("");
        System.out.println("Solution:");
        System.out.println("Generation: " + generationCount);
        System.out.println("Best current case genes:");
        System.out.println(getCaseGenes(myPop.getFittest()));

        if(area == COOL_AREA){
            RegalGood[0]=getCaseGenes(myPop.getFittest());}
        if(area == HEAVY_AREA){
            RegalGood[1]=getCaseGenes(myPop.getFittest());}
        if(area == LIGHT_AREA){
            RegalGood[2]=getCaseGenes(myPop.getFittest());}
        if(area == FLAMMABLE_AREA){
            RegalGood[3]=getCaseGenes(myPop.getFittest());}


        System.out.println( "Final Estimation: " + calculateEstimation(myPop.getFittest(), area));
        System.out.println("Max estimation: " + calculateSolutionEstimation(area));

    }

    public static double calculateEstimation(Individual genesArray, String solution) {
        estimation = 0;

        if( genesArray.getGene(0) == 1 ||  genesArray.getGene(1) == 1 || genesArray.getGene(2) == 1 || genesArray.getGene(3) == 1)
            if(genesArray.getGene(0) == Byte.parseByte(solution.substring(0,1)) &&
                    genesArray.getGene(1) == Byte.parseByte(solution.substring(1,2)) &&
                    genesArray.getGene(2) == Byte.parseByte(solution.substring(2,3)) &&
                    genesArray.getGene(3) == Byte.parseByte(solution.substring(3,4))) {
                estimation += 10;
            }
        if(  genesArray.getGene(4) == 1 || genesArray.getGene(5) == 1)
            if(genesArray.getGene(4) == Byte.parseByte(solution.substring(4,5)) &&
                    genesArray.getGene(5) == Byte.parseByte(solution.substring(5,6))) {
                estimation += 30;
            }

        if( genesArray.getGene(6) == 1 ||  genesArray.getGene(7) == 1)
            if(genesArray.getGene(6) == Byte.parseByte(solution.substring(6,7)) &&
                    genesArray.getGene(7) == Byte.parseByte(solution.substring(7,8))) {
                estimation += 20;
            }
        if( genesArray.getGene(8) == 1 ||  genesArray.getGene(9) == 1 || genesArray.getGene(10) == 1)
            if(genesArray.getGene(8) == Byte.parseByte(solution.substring(8,9)) &&
                    genesArray.getGene(9) == Byte.parseByte(solution.substring(9,10)) &&
                    genesArray.getGene(10) == Byte.parseByte(solution.substring(10,11))){
                estimation += 40;
            }
        return estimation;
    }

    public static int calculateSolutionEstimation(String solution) {
        finalEstimation = 0;
        boolean blockColor = false;
        boolean blockWeight = false;
        boolean blockMaterial = false;
        boolean blockState = false;
        for(int i = 0; i< solution.length(); i++) {
            if(Byte.parseByte(solution.substring(i,i+1)) == 1) {
                if(i<4) {
                    finalEstimation += 5;
                    blockWeight = true;
                }
                if(i>3 && i<6) {
                    finalEstimation += 20;
                    blockMaterial = true;
                }
                if(i>5 && i<8) {
                    finalEstimation += 10;
                    blockState = true;
                }
                if(i>7 && i<11 && !blockColor) {
                    finalEstimation += 30;
                    blockColor = true;
                }
            }
        }
        return finalEstimation;
    }
    public static String getCaseGenes(Individual genesArray) {
        String[] genesString = new String[11];
        String genes = "[ ";
        if(genesArray.getGene(0) == 1) {
            genesString[0] = "Metal";
        }
        if(genesArray.getGene(1) == 1) {
            genesString[1] = "Paper";
        }
        if(genesArray.getGene(2) == 1) {
            genesString[2] = "Gas";
        }
        if(genesArray.getGene(3) == 1) {
            genesString[3] = "Wood";
        }
        if(genesArray.getGene(4) == 1) {
            genesString[4] = "Light";
        }
        if(genesArray.getGene(5) == 1) {
            genesString[5] = "Heavy";
        }
        if(genesArray.getGene(6) == 1) {
            genesString[6] = "Small";
        }
        if(genesArray.getGene(7) == 1) {
            genesString[7] = "Big";
        }
        if(genesArray.getGene(8) == 1) {
            genesString[8] = "Flammable";
        }
        if(genesArray.getGene(9) == 1) {
            genesString[9] = "Cool";
        }
        if(genesArray.getGene(10) == 1) {
            genesString[10] = "Normal";
        }
        for(int i=0; i< 11; i++) {
            if(genesString[i] != null)
                genes += genesString[i] + " ";
        }
        genes += "]";
        return genes;

    }


}