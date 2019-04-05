package spread_algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class MapBucketNoron {

    ArrayList<ListRootNode> mapNODE;
    Scanner o;

    public MapBucketNoron(){
        mapNODE = new ArrayList<>();
    }


    public boolean checkCharacter(String [] arrNameVariable,String x){
        for (int i = 0 ; i < arrNameVariable.length ; i++){
            if (arrNameVariable[i].compareTo(x) == 0){
                return true;
            }
        }
        return false;
    }//End








    /*------- CHANGING HERE -------*/
//    public void inputForEachElementMap(String [] arrNameVariable){
//        ListRootNode listTemp = new ListRootNode();
//        System.out.println(" |--- INPUT NODE ---| ");
//        Node rootNode = new Node();
//        rootNode.inputNode(true);
//        listTemp.addNodeToList(rootNode);
//
//        // TODO : Now Find many variable is need for RECIPE
//        for (int i = 0 ; i < rootNode.arrayRecipeIngredients.length ; i++){
//            if (checkCharacter(arrNameVariable,rootNode.arrayRecipeIngredients[i]) == true){
//                Node subNode = new Node();
//                subNode.setDescription(rootNode.arrayRecipeIngredients[i]);
//                listTemp.addNodeToList(subNode);
//            }
//        }
//        mapNODE.add(listTemp);
//    }//End
//
//    // There is nope :((
//    public void inputMapNODE(int soluongCT,String [] arrNameVariable){
//        for (int i = 0 ; i < soluongCT ; i++){
//            inputForEachElementMap(arrNameVariable);
//            System.out.println("-------------------------------");
//        }
//    }// End
    /*------- CHANGING HERE AND REPLACE BOTTOM -------*/

    public void getDataRecipe(String description, ArrayList<String> listOperator){
        ListRootNode listTemp = new ListRootNode();
        Node rootNode = new Node();
        rootNode.setUpNodeIsRecipe(description,listOperator);
        listTemp.addNodeToList(rootNode);
        for (String operator : listOperator){
            Node subNode = new Node();
            subNode.setUpNodeIsElement(operator);
            listTemp.addNodeToList(subNode);
        }
        mapNODE.add(listTemp);
    }






    public boolean isContainedInTheRecipe(String element,int indexRecipe){
        ListRootNode listTemp = mapNODE.get(indexRecipe);
            for (Node x: listTemp.getListRoot()) {
            if(x.getRecipe() == true){
                for (int i = 0 ; i < x.arrayRecipeIngredients.length; i++ ){
                    if(x.arrayRecipeIngredients[i].compareTo(element) == 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }//End


    public void setupMatrixSpread(int [][] matrixSpread, int height , int width , String [] arrNameVariable){

        for (int i = 0 ; i < height ; i++){ // Variable
            for (int j = 0 ; j < width ; j++){ // Recipe
                if (isContainedInTheRecipe(arrNameVariable[i],j) == true){
                    matrixSpread[i][j] = -1;
                }
            }
        }

    }//End


    public boolean isMatchingVariableBetweenVarKnownAndArrayVariable(String []arrayVarKnown, String nameVariableAtIndex){
        for (int i = 0 ; i < arrayVarKnown.length ; i++){
            if (arrayVarKnown[i].compareTo(nameVariableAtIndex) == 0){
                return true;
            }
        }
        return false;
    }//End

    public void activatedNodeAlreadyKnown(int [][] matrixSpread,int height , int width, String [] arrayVarKnown,String [] arrNameVariable){
        for (int i = 0 ; i < height ; i++){
            if (isMatchingVariableBetweenVarKnownAndArrayVariable(arrayVarKnown,arrNameVariable[i]) == true){//Phan Tu Nam trong DS cac thanh phan da biet
                for (int j = 0 ; j < width ; j++){
                    if (matrixSpread[i][j] == -1){
                        matrixSpread[i][j] = 1;
                    }
                }
            }
        }
    }//End

    public void changeMatrixSpreadAtRow(int [][] matrixSpread , int height , int width , int rowTurnOn){
        for (int i = 0 ; i < height ; i++){
            if (i == rowTurnOn){
                for (int j = 0 ; j < width ; j++){
                    if (matrixSpread[i][j] == -1){
                        matrixSpread[i][j] = 1;
                    }
                }
                return;
            }
        }
    }



    public void runAroundMatrixSpread(int [][] matrixSpread ,int height , int width, String findResult,String [] arrNameVariable){

        boolean checkFound = false;
        while (checkFound == false){
            int count = 0;
            int rowToTurnOn = 0;
            int indexRecipe = 0;

            for (int j = 0 ; j < width ; j++){
                for (int i = 0 ; i < height ; i++){
                    if (matrixSpread[i][j] == -1){
                        count += 1;
                        rowToTurnOn = i;
                        indexRecipe = j;
                    }
                }
                if (count == 1){
                    break;
                } else {
                    count = 0;
                }
            }
            if (count == 1){
                changeMatrixSpreadAtRow(matrixSpread,height,width,rowToTurnOn);
                System.out.print("Cong thuc " + (indexRecipe+1) +" -> " + arrNameVariable[rowToTurnOn] + "\n");
            }
            if (findResult.compareTo(arrNameVariable[rowToTurnOn]) == 0){
                checkFound = true;
            }
        }




    }//End



    public void display(){
        for (ListRootNode l: mapNODE) {
            l.display();
        }
    }//End


}











//    public void inputForEachElementMap(String [] arrNameVariable){
//        ListRootNode listTemp = new ListRootNode();
//        System.out.println(" |--- INPUT NODE ---| ");
//        Node rootNode = new Node();
//        rootNode.inputNode(true);
//        listTemp.addNodeToList(rootNode);
//
//        // TODO : Now Find many variable is need for RECIPE
//        for (int i = 0 ; i < rootNode.getDescription().length() ; i++) {
//            String x = "";
//            if(((int)rootNode.getDescription().charAt(i) >= 65 && (int)rootNode.getDescription().charAt(i) <= 90) || ((int)rootNode.getDescription().charAt(i) >= 97 && (int)rootNode.getDescription().charAt(i) <= 122)){
//                x = String.valueOf(rootNode.getDescription().charAt(i));
//                for (int j = i + 1; j < rootNode.getDescription().length(); j++) {
//                    if (((int)rootNode.getDescription().charAt(j) >= 65 && (int)rootNode.getDescription().charAt(j) <= 90) || ((int)rootNode.getDescription().charAt(j) >= 97 && (int)rootNode.getDescription().charAt(j) <= 122)){
//                        String nextX = String.valueOf(rootNode.getDescription().charAt(j));
//                        x+= nextX;
//                        i++;
//                    } else {
//                        break;
//                    }
//                }
//            }
//            if (x != ""){
//                if (checkCharacter(arrNameVariable,x) == true){
//                    Node subNode = new Node();
//                    subNode.setDescription(x);
//                    listTemp.addNodeToList(subNode);
//                }
//            }
//
//        }
//        mapNODE.add(listTemp);
//    }
