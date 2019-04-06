package spread_algorithm;

import java.util.Scanner;

public class Main {


    public static void inputVariable(String [] arrNameVariableInBoxRecipe){

        Scanner o = new Scanner(System.in);
        String nameVariable;
        for (int i = 0 ; i < arrNameVariableInBoxRecipe.length ; i++){
            System.out.print("Input Var : ");
            nameVariable = o.nextLine();
            arrNameVariableInBoxRecipe[i] = nameVariable;
        }
    }

    public static void firstInitMatrixSpread(int [][] matrixSpread, int height, int width){
        for (int i = 0 ; i < height ; i++){
            for (int j = 0 ; j < width ; j++){
                matrixSpread[i][j] = 0;
            }
        }
    }


    public static void main(String[] args) {

        Scanner o = new Scanner(System.in);

        System.out.println(" <------- SPREAD ALGORITHM ------> ");
        SolveTheOperator solveTheOperator = new SolveTheOperator();
        ManagerVariable<String,Double> managerVariable = new ManagerVariable<>();
        MapBucketNoron mapBucketNoron = new MapBucketNoron();

        /*-----------------------------------------------*/
        BootDataRecipe bootDataRecipe = new BootDataRecipe();
        bootDataRecipe.readDataRecipe();
        bootDataRecipe.pushDataToMapNode(mapBucketNoron,solveTheOperator);
        mapBucketNoron.display();
        System.out.print("\n" + "Size MapNode : " + mapBucketNoron.mapNODE.size() + "\n");

        /* SHOW LISTRECIPE IN SOLVEOPERATOR */
        solveTheOperator.showListRecipeInSolveOperator();
        /* SHOW LISTRECIPE IN SOLVEOPERATOR */


        int soluongBien = bootDataRecipe.listVariableInRecipe.size();
        String [] arrNameVariableInBoxRecipe = new String[soluongBien];
        int r = 0;
        for (String x : bootDataRecipe.listVariableInRecipe){
            arrNameVariableInBoxRecipe[r] = x;
            r++;
        }

        System.out.print("List Variable In Box Recipe : ");
        for (int i = 0 ; i < arrNameVariableInBoxRecipe.length ; i++){
            System.out.print(arrNameVariableInBoxRecipe[i] + " ");
        }
        System.out.print("\n");


        /*-----------------------------------------------*/
        // TODO : CREATE MATRIX SPREAD
        int [][] matrixSpread;
        matrixSpread = new int[soluongBien][mapBucketNoron.mapNODE.size()];
        // TODO : FIRST INIT FOR MATRIX
        firstInitMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size());
        for (int i = 0 ; i < soluongBien ; i++){
            for (int j = 0 ; j < mapBucketNoron.mapNODE.size() ; j++){
                System.out.print(matrixSpread[i][j] + " ");
            }
            System.out.print("\n");
        }

//        //TODO : SETUP MATRIX AVAILABLE ZONE RECIPE
        mapBucketNoron.setupMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size(),arrNameVariableInBoxRecipe);
//        //TODO : SHOW MATRIX
        /*Step 2*/
        for (int i = 0 ; i < soluongBien ; i++){
            for (int j = 0 ; j < mapBucketNoron.mapNODE.size() ; j++){
                System.out.print(matrixSpread[i][j] + " ");
            }
            System.out.print("\n");
        }

        // TODO : Activated Node Already Known
        System.out.println("==========================================");
        System.out.print("Co Bao Nhieu Thanh Phan Da Biet (Cho Truoc) : ");
        int quantityKnown; quantityKnown = o.nextInt();
        String [] arrayVarKnown;
        arrayVarKnown = new String[quantityKnown];
        for (int i = 0 ; i < quantityKnown ; i++){
            o = new Scanner(System.in);
            System.out.print("Input Key variable known["+i+"] : ");String key = o.nextLine();
            System.out.print("Input value of this variable : ");double val = o.nextInt();
            // Add Here to managerVariable
            managerVariable.add(key,val);
            arrayVarKnown[i] = key;
        }
        // TODO : Show Collection
        managerVariable.displayAll();


        o = new Scanner(System.in);
        System.out.print("Thanh Phan Muon Tinh : ");String findResult;findResult = o.nextLine();
        mapBucketNoron.activatedNodeAlreadyKnown(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size(),arrayVarKnown,arrNameVariableInBoxRecipe);
        //TODO : SHOW MATRIX
        /*Step 3*/
        for (int i = 0 ; i < soluongBien ; i++){
            for (int j = 0 ; j < mapBucketNoron.mapNODE.size() ; j++){
                System.out.print(matrixSpread[i][j] + " ");
            }
            System.out.print("\n");
        }

        mapBucketNoron.runAroundMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size(),findResult,arrNameVariableInBoxRecipe,solveTheOperator,managerVariable);
        System.out.print("{==== End Program ====}");




    }
}
