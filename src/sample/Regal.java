package sample;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by infokomes on 05.06.16.
 */
public class Regal {

    private Map<Integer, List<Integer>> Regal;
    public Regal() {
        Regal = new HashMap<>();
    }

    public void addData(Integer key, Integer property) {
        if (Regal.containsKey(key)) {
            addDataToKey(key, property);
        } else {
            addNewKey(key, property);
        }
    }

    public void addNewKey(Integer key, Integer property) {
        List<Integer> properties = new ArrayList<>();
        properties.add(property);
        Regal.put(key, properties);
    }

    public void addDataToKey(Integer key, Integer property) {
        List<Integer> properties = Regal.get(key);
        properties.add(property);
        Regal.put(key, properties);
    }

    public Map<Integer, List<Integer>> getRegal() {
        return Regal;
    }

    public Boolean BooleanFree(Integer key) {

        Boolean free;
        if(Regal.get(key).size() < 5){
            free = true;
        }
        else {
            free = false;
        }

        return free;
    }
}
