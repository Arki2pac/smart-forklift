package sample.MachineLearning;
import sample.KnowledgeBase;

/**
 * Created by infokomes on 02.06.16.
 */
public interface LearningStrategy {
    public int[] findDestinationPlace(KnowledgeBase knowledgeBase, String caseName);
}
