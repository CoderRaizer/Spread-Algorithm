package spread_algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Node {

    private boolean isRecipe = false;
    private String description = null;
    String [] arrayRecipeIngredients = null;

    Scanner o;

    public Node(){

    }

    public boolean getRecipe() {
        return isRecipe;
    }

    public void setRecipe(boolean recipe) {
        isRecipe = recipe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getArrayRecipeIngredients() {
        return arrayRecipeIngredients;
    }

    public void setArrayRecipeIngredients(String[] arrayRecipeIngredients) {
        this.arrayRecipeIngredients = arrayRecipeIngredients;
    }

    public Scanner getO() {
        return o;
    }

    public void setO(Scanner o) {
        this.o = o;
    }


    public void setUpNode(String description, ArrayList<String> listOperator){

            this.isRecipe =true;
            this.description = description;
            this.arrayRecipeIngredients = new String[listOperator.size()];
            int i = 0;
            for (String operate : listOperator){
                this.arrayRecipeIngredients[i] = operate;
                i++;
            }
    }

    @Override
    public String toString() {
        String printOut = "RECIPE : " + "[" + this.description + "] ::> ";
        for (int i = 0 ; i < arrayRecipeIngredients.length ; i++){
            printOut += arrayRecipeIngredients[i] + " ";
        }
            return printOut;
    }
}
