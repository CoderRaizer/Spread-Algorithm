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

    public static void showMatrixSpread(int [][] matrixSpread, int height, int width){
        for (int i = 0 ; i < height ;i++){
            for (int j = 0 ; j < width ; j++){
                System.out.print(matrixSpread[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    public static void main(String[] args) {

        Scanner o = new Scanner(System.in);

        System.out.println(" <------- SPREAD ALGORITHM ------> ");
        SolveTheOperator solveTheOperator = new SolveTheOperator();
        ManagerVariable<String,Double> managerVariable = new ManagerVariable<>();
        BootDataRecipe bootDataRecipe = new BootDataRecipe();
        MapBucketNoron mapBucketNoron = new MapBucketNoron();
        /*-----------------------------------------------*/

        bootDataRecipe.readDataRecipe();
        bootDataRecipe.pushDataToMapNode(mapBucketNoron,solveTheOperator);
        mapBucketNoron.display();
        System.out.print("\n" + "Size MapNode : " + mapBucketNoron.mapNODE.size() + "\n");

        /*-----------------------------------------------*/
        /* Show list recipe in Solve Operator */
        solveTheOperator.showListRecipeInSolveOperator();
        /* Show list recipe in Solve Operator */


        // Copy List variable in Box Recipe
        int soluongBien = bootDataRecipe.listVariableInBoxRecipe.size();
        String [] arrNameVariableInBoxRecipe = new String[soluongBien];
        int r = 0;
        for (String x : bootDataRecipe.listVariableInBoxRecipe){
            arrNameVariableInBoxRecipe[r] = x;
            r++;
        }
        System.out.print("List Variable In Box Recipe : ");
        for (int i = 0 ; i < arrNameVariableInBoxRecipe.length ; i++){
            System.out.print(arrNameVariableInBoxRecipe[i] + " ");
        }
        System.out.print("\n");



        /* ----- TODO : CREATE MATRIX SPREAD ----- */
        int [][] matrixSpread;
        matrixSpread = new int[soluongBien][mapBucketNoron.mapNODE.size()];
        firstInitMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size());
        showMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size());
        System.out.println("--------------------------------");

        /* ----- TODO : SETUP MATRIX AVAILABLE ZONE RECIPE (-1) ----- */
        mapBucketNoron.setupMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size(),arrNameVariableInBoxRecipe);
        showMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size());



        /* ----- TODO : INPUT VARIABLE KNOWN WHEN START ----- */
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
        managerVariable.displayAll();


        /* ----- TODO : ACTIVATE NODE ALREADY KNOWN (1) ----- */
        mapBucketNoron.activatedNodeAlreadyKnown(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size(),arrayVarKnown,arrNameVariableInBoxRecipe);
        showMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size());


        /* ----- TODO : RUN TO SOLVE ----- */
        System.out.print("Thanh Phan Muon Tinh : ");
        o = new Scanner(System.in);
        String findResult;findResult = o.nextLine();

        mapBucketNoron.runAroundMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size(),findResult,arrNameVariableInBoxRecipe,solveTheOperator,managerVariable);
        System.out.print("{==== End Program ====}");

    }
}
