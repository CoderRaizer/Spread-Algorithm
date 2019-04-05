package spread_algorithm;

public class TestGetElementOfRecipeString {

    public static void main(String[] args) {

        String congthuc = "S=1/2*a*ha";
        System.out.println("Length : " + congthuc.length());


        for (int i = 0 ; i < congthuc.length() ; i++) {
            String x = "";
            if(((int)congthuc.charAt(i) >= 65 && (int)congthuc.charAt(i) <= 90) || ((int)congthuc.charAt(i) >= 97 && (int)congthuc.charAt(i) <= 122)){
                x = String.valueOf(congthuc.charAt(i));
                for (int j = i + 1; j < congthuc.length(); j++) {
                    if (((int)congthuc.charAt(j) >= 65 && (int)congthuc.charAt(j) <= 90) || ((int)congthuc.charAt(j) >= 97 && (int)congthuc.charAt(j) <= 122)){
                        String nextX = String.valueOf(congthuc.charAt(j));
                        x+= nextX;
                        i++;
                    } else {
                        break;
                    }
                }
            }
            if (x != ""){
                System.out.println("Variable : " + x);
            }

        }

    }
}
