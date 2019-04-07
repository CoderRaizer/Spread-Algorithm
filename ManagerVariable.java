package spread_algorithm;

import java.util.HashMap;

public class ManagerVariable<K,V> {

    HashMap<K, V> collectionVariable;

    public ManagerVariable(){
        collectionVariable = new HashMap<>();
    }

    public void add(K key, V value) {
        if (!collectionVariable.containsValue(key)) {
            collectionVariable.put(key, value);
        }
    }//End

    public void displayAll() {
        System.out.println("< Element In HashMap >");
        collectionVariable.forEach((K,V)-> System.out.println(
                "[ Key= " + K + " , Value= " + V + " ]"
        ));
    }//End
}
