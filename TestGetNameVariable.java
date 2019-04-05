package spread_algorithm;

import java.lang.reflect.Field;

public class TestGetNameVariable {

    public static void main(String[] args) {

        Class<?> c = Node.class;
        for (Field field : c.getDeclaredFields()){
                System.out.println(field.getName());
        }
    }






}
