package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Arkadiusz Chrobak on 08.05.2016.
 */
public class KnowledgeBase {
    private Map<String, List<String>> knowledgeBase;

    public KnowledgeBase() {
        knowledgeBase = new HashMap<>();
    }

    public void addData(String key, String property) {
        if (knowledgeBase.containsKey(key)) {
            addDataToKey(key, property);
        } else {
            addNewKey(key, property);
        }
    }

    private void addDataToKey(String key, String property) {
        List<String> properties = knowledgeBase.get(key);
        properties.add(property);
        knowledgeBase.put(key, properties);
    }

    private void addNewKey(String key, String property) {
        List<String> properties = new ArrayList<>();
        properties.add(property);
        knowledgeBase.put(key, properties);
    }

    public Map<String, List<String>> getKnowledgeBase() {
        return knowledgeBase;
    }
}