package spread_algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class MapBucketNoron {

    ArrayList<ListRootNode> mapNODE;
    Scanner o;

    public MapBucketNoron(){
        mapNODE = new ArrayList<>();
    }


    public boolean checkCharacter(String [] arrNameVariableInBoxRecipe,String x){
        for (int i = 0 ; i < arrNameVariableInBoxRecipe.length ; i++){
            if (arrNameVariableInBoxRecipe[i].compareTo(x) == 0){
                return true;
            }
        }
        return false;
    }//End


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
    }//End


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


    public void setupMatrixSpread(int [][] matrixSpread, int height , int width , String [] arrNameVariableInBoxRecipe){

        for (int i = 0 ; i < height ; i++){ // Variable
            for (int j = 0 ; j < width ; j++){ // Recipe
                if (isContainedInTheRecipe(arrNameVariableInBoxRecipe[i],j) == true){
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

    public void activatedNodeAlreadyKnown(int [][] matrixSpread,int height , int width, String [] arrayVarKnown,String [] arrNameVariableInBoxRecipe){
        for (int i = 0 ; i < height ; i++){
            if (isMatchingVariableBetweenVarKnownAndArrayVariable(arrayVarKnown,arrNameVariableInBoxRecipe[i]) == true){//Phan Tu Nam trong DS cac thanh phan da biet
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


    public void runAroundMatrixSpread(int [][] matrixSpread ,int height , int width, String findResult,String [] arrNameVariableInBoxRecipe, SolveTheOperator solveTheOperator,ManagerVariable<String,Double> managerVariable){

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

                System.out.print("Cong thuc " + (indexRecipe+1)+ " : ["+ mapNODE.get(indexRecipe).listRoot.getFirst().getDescription() +"]" +" -> " + arrNameVariableInBoxRecipe[rowToTurnOn] );
                // Add here
                double resultPrint = solveTheOperator.SolveRecipeByRequest(mapNODE.get(indexRecipe).listRoot.getFirst().getDescription(),arrNameVariableInBoxRecipe[rowToTurnOn],managerVariable);
                System.out.println(" - Ket Qua = " + resultPrint + "\n");
            }
            if (findResult.compareTo(arrNameVariableInBoxRecipe[rowToTurnOn]) == 0){
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

