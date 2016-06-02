package sample.MachineLearning;

import sample.KnowledgeBase;
import java.util.*;

/**
 * Created by infokomes on 02.06.16.
 */
public class MultipleRegression implements LearningStrategy{

    private List<String> blackArea;
    private List<String> blueArea;
    private List<String> greenArea;
    private List<String> brownArea;
    private List<String> yellowArea;
    private List<String> redArea;

    private int numberOfProperties;

    public MultipleRegression() {
        System.out.println("Using CandidateEliminationLearningStrategy");
        numberOfProperties = 4;
        learn();
    }

    private void learn() {
        Map<List<String>, Boolean> blackAreaLearningSet = prepareBlackAreaLearningSet();
        Map<List<String>, Boolean> blueAreaLearningSet = prepareBlueAreaLearningSet();
        Map<List<String>, Boolean> greenAreaLearningSet = prepareGreenAreaLearningSet();
        Map<List<String>, Boolean> brownAreaLearningSet = prepareBrownAreaLearningSet();
        Map<List<String>, Boolean> yellowAreaLearningSet = prepareYellowAreaLearningSet();
        Map<List<String>, Boolean> redAreaLearningSet = prepareRedAreaLearningSet();

        blackArea = learnArea(blackAreaLearningSet);
        blueArea = learnArea(blueAreaLearningSet);
        greenArea = learnArea(greenAreaLearningSet);
        brownArea = learnArea(brownAreaLearningSet);
        yellowArea = learnArea(yellowAreaLearningSet);
        redArea = learnArea(redAreaLearningSet);


        System.out.println("Black area " + blackArea);
        System.out.println("Blue area " + blueArea);
        System.out.println("Green area " + greenArea);
        System.out.println("Brown area " + brownArea);
        System.out.println("Yellow area " + yellowArea);
        System.out.println("Red area " + redArea);

    }

    private Map<List<String>, Boolean> prepareBlueAreaLearningSet() {
        //should be liquid and metal
        Map<List<String>, Boolean> propertyDecision = new HashMap<>();

        List<String> properties;

        properties = new ArrayList<>();
        properties.add("white");
        properties.add("metal");
        properties.add("light");
        properties.add("liquid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("yellow");
        properties.add("metal");
        properties.add("light");
        properties.add("liquid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("red");
        properties.add("paper");
        properties.add("light");
        properties.add("liquid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("gray");
        properties.add("metal");
        properties.add("light");
        properties.add("solid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("gray");
        properties.add("metal");
        properties.add("heavy");
        properties.add("liquid");
        propertyDecision.put(properties, true);
        return propertyDecision;
    }

    private Map<List<String>, Boolean> prepareGreenAreaLearningSet() {
        //Should be transparent, light, solid
        Map<List<String>, Boolean> propertyDecision = new HashMap<>();

        List<String> properties;

        properties = new ArrayList<>();
        properties.add("white");
        properties.add("transparent");
        properties.add("light");
        properties.add("solid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("yellow");
        properties.add("transparent");
        properties.add("light");
        properties.add("solid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("red");
        properties.add("paper");
        properties.add("light");
        properties.add("liquid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("gray");
        properties.add("metal");
        properties.add("light");
        properties.add("liquid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("gray");
        properties.add("paper");
        properties.add("heavy");
        properties.add("solid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("red");
        properties.add("transparent");
        properties.add("light");
        properties.add("solid");
        propertyDecision.put(properties, true);

        return propertyDecision;

    }

    private Map<List<String>, Boolean> prepareBrownAreaLearningSet() {
        //Should be labelled - rest doesn't matter
        Map<List<String>, Boolean> propertyDecision = new HashMap<>();

        List<String> properties;

        properties = new ArrayList<>();
        properties.add("white");
        properties.add("labelled");
        properties.add("light");
        properties.add("solid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("yellow");
        properties.add("labelled");
        properties.add("light");
        properties.add("solid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("red");
        properties.add("labelled");
        properties.add("light");
        properties.add("liquid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("gray");
        properties.add("metal");
        properties.add("light");
        properties.add("liquid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("gray");
        properties.add("paper");
        properties.add("heavy");
        properties.add("solid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("red");
        properties.add("labelled");
        properties.add("light");
        properties.add("solid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("red");
        properties.add("labelled");
        properties.add("heavy");
        properties.add("solid");
        propertyDecision.put(properties, true);

        return propertyDecision;
    }

    private Map<List<String>, Boolean> prepareYellowAreaLearningSet() {
        //Should be light and paper - rest doesn't matter
        Map<List<String>, Boolean> propertyDecision = new HashMap<>();

        List<String> properties;

        properties = new ArrayList<>();
        properties.add("white");
        properties.add("paper");
        properties.add("light");
        properties.add("solid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("yellow");
        properties.add("paper");
        properties.add("light");
        properties.add("solid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("red");
        properties.add("paper");
        properties.add("light");
        properties.add("liquid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("gray");
        properties.add("metal");
        properties.add("light");
        properties.add("liquid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("gray");
        properties.add("paper");
        properties.add("heavy");
        properties.add("solid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("red");
        properties.add("paper");
        properties.add("light");
        properties.add("solid");
        propertyDecision.put(properties, true);

        return propertyDecision;
    }

    private Map<List<String>, Boolean> prepareRedAreaLearningSet() {
        //Should be brown and wooden
        Map<List<String>, Boolean> propertyDecision = new HashMap<>();

        List<String> properties;

        properties = new ArrayList<>();
        properties.add("brown");
        properties.add("wooden");
        properties.add("heavy");
        properties.add("solid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("yellow");
        properties.add("metal");
        properties.add("heavy");
        properties.add("solid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("gray");
        properties.add("metal");
        properties.add("light");
        properties.add("solid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("yellow");
        properties.add("metal");
        properties.add("light");
        properties.add("liquid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("brown");
        properties.add("wooden");
        properties.add("heavy");
        properties.add("solid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("brown");
        properties.add("wooden");
        properties.add("light");
        properties.add("liquid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("red");
        properties.add("metal");
        properties.add("heavy");
        properties.add("solid");
        propertyDecision.put(properties, false);

        return propertyDecision;
    }

    private Map<List<String>, Boolean> prepareBlackAreaLearningSet() {
        //Should be heavy, solid and metal - color doesn't matter
        Map<List<String>, Boolean> propertyDecision = new HashMap<>();

        List<String> properties;

        properties = new ArrayList<>();
        properties.add("gray");
        properties.add("metal");
        properties.add("heavy");
        properties.add("solid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("yellow");
        properties.add("metal");
        properties.add("heavy");
        properties.add("solid");
        propertyDecision.put(properties, true);
        properties = new ArrayList<>();
        properties.add("gray");
        properties.add("metal");
        properties.add("light");
        properties.add("solid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("gray");
        properties.add("metal");
        properties.add("heavy");
        properties.add("liquid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("gray");
        properties.add("wood");
        properties.add("heavy");
        properties.add("solid");
        propertyDecision.put(properties, false);
        properties = new ArrayList<>();
        properties.add("red");
        properties.add("metal");
        properties.add("heavy");
        properties.add("solid");
        propertyDecision.put(properties, true);

        return propertyDecision;
    }

    private List<String> learnArea(Map<List<String>, Boolean> blackAreaLearningSet) {
        List<List<String>> generalHypothesis = new ArrayList<>();
        List<List<String>> specificHypothesis = new ArrayList<>();
        generalHypothesis.add(new ArrayList<>());
        specificHypothesis.add(new ArrayList<>());

        for (int i = 0; i < 4; i++) {
            generalHypothesis.get(0).add("?");
            specificHypothesis.get(0).add("0");
        }

        for (List<String> example : blackAreaLearningSet.keySet()) {
            parseExample(blackAreaLearningSet, example, generalHypothesis, specificHypothesis);
        }

//        System.out.println(generalHypothesis);
//        System.out.println(specificHypothesis);

        return specificHypothesis.get(0);
    }

    private void parseExample(Map<List<String>, Boolean> blackAreaLearningSet, List<String> example, List<List<String>> generalHypothesis, List<List<String>> specificHypothesis) {
        if (exampleIsPositive(example, blackAreaLearningSet)) {
            parsePositiveExample(blackAreaLearningSet, example, generalHypothesis, specificHypothesis);
        } else {
            parseNegativeExample(blackAreaLearningSet, example, generalHypothesis, specificHypothesis);
        }
    }

    private void parsePositiveExample(Map<List<String>, Boolean> blackAreaLearningSet, List<String> example, List<List<String>> generalHypothesis, List<List<String>> specificHypothesis) {
        for (List<String> hypothesis : generalHypothesis) {
            if (!hypothesisDoesCover(example, hypothesis)) {
                System.out.println(hypothesis + " doesn't cover " + example + " so it's deleted (general positive)");
                removeHypothesis(generalHypothesis, hypothesis);
            } else {
                System.out.println(hypothesis + " does cover " + example + " (general positive)");
            }
        }

        for (List<String> hypothesis : specificHypothesis) {
            if (!hypothesisDoesCover(example, hypothesis)) {
                System.out.println(hypothesis + " doesn't cover " + example + " so it's deleted (specific positive)");
                removeHypothesis(specificHypothesis, hypothesis);
                addMinimalGeneralizations(specificHypothesis, hypothesis, generalHypothesis, example);
                deleteMoreGeneralHypothesis(specificHypothesis, hypothesis);
            } else {
                System.out.println(hypothesis + " does cover " + example + " (specific positive)");
            }
        }
    }

    private void removeHypothesis(List<List<String>> specificHypothesis, List<String> hypothesis) {
        specificHypothesis.remove(hypothesis);
    }

    private boolean hypothesisDoesCover(List<String> example, List<String> hypothesis) {
        for (int i = 0; i < 4; i++) {
            if (!hypothesis.get(i).equals(example.get(i)) && !hypothesis.get(i).equals("?"))
                return false;
        }
        return true;
    }


    private void addMinimalGeneralizations(List<List<String>> specificHypothesis, List<String> hypothesis, List<List<String>> generalHypothesis, List<String> example) {
        List<List<String>> possibleMinimalGeneralizations;
        possibleMinimalGeneralizations = findPossibleMinimalGeneralizations(hypothesis, example);

        for (List<String> possibleGeneralization : possibleMinimalGeneralizations) {
            if (generalHasMoreGeneralHypothesis(possibleGeneralization, generalHypothesis)) {
                specificHypothesis.add(possibleGeneralization);
            }
        }
    }

    private List<List<String>> findPossibleMinimalGeneralizations(List<String> hypothesis, List<String> example) {
        List<List<String>> possibleGeneralizations = new ArrayList<>();

        List<String> current = new ArrayList<>();
        for (int i = 0; i < numberOfProperties; i++) {
            if (!hypothesis.get(i).equals(example.get(i)) && !hypothesis.get(i).equals("0"))
                current.add("?");
            else
                current.add(example.get(i));
        }

        possibleGeneralizations.add(current);

        return possibleGeneralizations;
    }

    private boolean generalHasMoreGeneralHypothesis(List<String> hypothesis, List<List<String>> generalHypothesis) {
        return true;
    }

    private void deleteMoreGeneralHypothesis(List<List<String>> specificHypothesis, List<String> hypothesis) {
    }

    private void parseNegativeExample(Map<List<String>, Boolean> blackAreaLearningSet, List<String> example, List<List<String>> generalHypothesis, List<List<String>> specificHypothesis) {

    }

    private void addMinimalSpecializations(List<List<String>> generalHypothesis, List<String> hypothesis) {
    }

    private void deleteMoreSpecificHypothesis(List<List<String>> generalHypothesis, List<String> hypothesis) {

    }

    private boolean exampleIsPositive(List<String> example, Map<List<String>, Boolean> learningSet) {
        Boolean aBoolean = learningSet.get(example);
        return aBoolean;
    }

    @Override
    public int[] findDestinationPlace(KnowledgeBase knowledgeBase, String caseName) {
        //destinationPlace[0] is x and destinationPlace[1] is y

        List<String> properties = knowledgeBase.getKnowledgeBase().get(caseName);
        System.out.println("Current case properties: " + properties);

        if (hypothesisDoesCover(properties, blackArea)) System.out.println("Black");
        if (hypothesisDoesCover(properties, blueArea)) System.out.println("Blue");
        if (hypothesisDoesCover(properties, greenArea)) System.out.println("Green");
        if (hypothesisDoesCover(properties, yellowArea)) System.out.println("Yellow");
        if (hypothesisDoesCover(properties, brownArea)) System.out.println("Brown");
        if (hypothesisDoesCover(properties, redArea)) System.out.println("Red");

        int[] destinationPlace = new int[2];
        destinationPlace[0] = 15;
        destinationPlace[1] = 15;

        return destinationPlace;
    }

}
