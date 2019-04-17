package spread_algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class MapBucketNoron {

    ArrayList<Node> mapNODE;
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
        Node node = new Node();
        node.setUpNode(description,listOperator);
        mapNODE.add(node);
    }//End


    public boolean isContainedInTheRecipe(String element,int indexRecipe){

        Node x = mapNODE.get(indexRecipe);
                for (int i = 0 ; i < x.arrayRecipeIngredients.length; i++ ){
                    if(x.arrayRecipeIngredients[i].compareTo(element) == 0){
                        return true;
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
    }//End


    public void runAroundMatrixSpread(int [][] matrixSpread ,int height , int width, String findResult,String [] arrNameVariableInBoxRecipe, SolveTheOperator solveTheOperator,ManagerVariable<String,Double> managerVariable){

//        ArrayList <String> listStepPrint = new ArrayList<>();
        ArrayList <Node> listOutRecipe = new ArrayList<>();
        ArrayList <String> listOutVariable = new ArrayList<>();
        ArrayList <Double> listOutValue = new ArrayList<>();

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

                listOutRecipe.add(mapNODE.get(indexRecipe));
                listOutVariable.add(arrNameVariableInBoxRecipe[rowToTurnOn]);
                double outValue = solveTheOperator.SolveRecipeByRequest(mapNODE.get(indexRecipe).getDescription(),arrNameVariableInBoxRecipe[rowToTurnOn],managerVariable);
                listOutValue.add(outValue);

//              String x = "Cong Thuc " + String.valueOf(indexRecipe+1) + " : ["+ mapNODE.get(indexRecipe).getDescription() +"]" +" -> " + arrNameVariableInBoxRecipe[rowToTurnOn] + " = ";
//              String y = String.valueOf(solveTheOperator.SolveRecipeByRequest(mapNODE.get(indexRecipe).getDescription(),arrNameVariableInBoxRecipe[rowToTurnOn],managerVariable));
//              listStepPrint.add(x+y);
            }
            if (findResult.compareTo(arrNameVariableInBoxRecipe[rowToTurnOn]) == 0){
                checkFound = true;
            }
        }
        /*--------------------------------------------------------------------------*/
        // TODO : Show result

        System.out.println("-----------------------------------------");
        for (Node recipe : listOutRecipe){
            System.out.println(recipe.getDescription());
        }
        System.out.println("-----------------------------------------");
        for (String varOut : listOutVariable){
            System.out.println(varOut);
        }
        System.out.println("-----------------------------------------");
        for (double value : listOutValue){
            System.out.println(value);
        }
        System.out.println("-----------------------------------------");
        // TODO : Now filter result best need
        int sizeList = listOutVariable.size();
        ArrayList <Remover> rowDelete = new ArrayList<>();
        for (int i = 0 ; i < sizeList ; i++){
            boolean need = false;
            String varOut = listOutVariable.get(i);

            for (int j = (sizeList-1) ; j > i ; j--){
                Node temp = listOutRecipe.get(j);
                int length = temp.arrayRecipeIngredients.length;
                for (int k = 0 ; k < length ; k++){
                    if (varOut.compareTo(temp.arrayRecipeIngredients[k]) == 0){
                        need = true;
                    }
                }
            }
            if (i == (sizeList-1)){
                need = true;
            }
            if (need == false){
                Remover remover = new Remover(listOutRecipe.get(i).getDescription(),listOutVariable.get(i),listOutValue.get(i));
                rowDelete.add(remover);
            }
        }

        System.out.println("-----------------------------------------");
        System.out.println("Show delete Object");
        for (Remover x : rowDelete){
            System.out.println(x.toString());
            delete(listOutRecipe,listOutVariable,listOutValue,x);
        }

        System.out.println("-----------------------------------------");
        System.out.println("===== After Filter Result");
        sizeList = listOutRecipe.size();
        for (int i = 0 ; i < sizeList ; i++){
            System.out.println("Cong Thuc " + " : [" + listOutRecipe.get(i).getDescription() +"]" +" -> " + listOutVariable.get(i) + " = " + listOutValue.get(i));
        }
        /*--------------------------------------------------------------------------*/

    }//End


    public void delete(ArrayList <Node> listOutRecipe , ArrayList <String> listOutVariable , ArrayList <Double> listOutValue, Remover remover){
        for (Node x : listOutRecipe){
            if (x.getDescription().compareTo(remover.recipe) == 0){
                listOutRecipe.remove(x);
                break;
            }
        }
        listOutVariable.remove(remover.variable);
        listOutValue.remove(remover.value);
    }


    public void display(){
        for (Node x: mapNODE) {
            System.out.println(x.toString());
        }
    }//End


}

// System.out.print("Cong thuc " + (indexRecipe+1)+ " : ["+ mapNODE.get(indexRecipe).getDescription() +"]" +" -> " + arrNameVariableInBoxRecipe[rowToTurnOn] );
// double resultPrint = solveTheOperator.SolveRecipeByRequest(mapNODE.get(indexRecipe).getDescription(),arrNameVariableInBoxRecipe[rowToTurnOn],managerVariable);

