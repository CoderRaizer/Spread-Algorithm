package spread_algorithm;

import java.util.Scanner;

public class Node {

    private boolean isRecipe = false;
    private Double variableSingle = null;
    private String description = null;
    String [] arrayRecipeIngredients;

    Scanner o;

    public Node(){

    }

    public boolean getRecipe() {
        return isRecipe;
    }

    public void setRecipe(boolean recipe) {
        isRecipe = recipe;
    }

    public Double getVariableSingle() {
        return variableSingle;
    }

    public void setVariableSingle(Double variableSingle) {
        this.variableSingle = variableSingle;
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

    public void inputNode(boolean isrecipe){

        if (isrecipe == true){
            this.isRecipe = isrecipe;
            o = new Scanner(System.in);
            System.out.print("Enter (Description Recipe) : ");this.description = o.nextLine();
            int number;
            System.out.print("how many element for recipe : ");number = o.nextInt();
            this.arrayRecipeIngredients = new String[number];
            for (int i = 0 ; i < arrayRecipeIngredients.length ; i++){
                System.out.print("Input : ");o = new Scanner(System.in);String ele = o.nextLine();
                this.arrayRecipeIngredients[i] = ele;
            }

        } else {
            this.isRecipe = false;
            o = new Scanner(System.in);
            System.out.print("Enter (Variable) : ");this.description = o.nextLine();
        }

    }

//    public void setUpNodeIsRecipe(String description, ArrayList<String> listOperator){
//
//            this.isRecipe =true;
//            this.description = description;
//            this.arrayRecipeIngredients = new String[listOperator.size()];
//            int i = 0;
//            for (String operate : listOperator){
//                this.arrayRecipeIngredients[i] = operate;
//            }
//    }
//
//    public void setUpNodeIsElement(String description){
//        this.description = description;
//    }


    @Override
    public String toString() {
        if (this.isRecipe == true){
            return "[RootNode : " + "isRecipe=" + isRecipe + ", description= " + "'"+description+"'" + "]:::> ";
        }else {
            return description +" ";
        }

    }
}
