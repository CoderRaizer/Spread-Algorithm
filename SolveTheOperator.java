package spread_algorithm;

import java.util.ArrayList;

public class SolveTheOperator {

    ArrayList <String> listRecipe;

    public SolveTheOperator(){
        listRecipe = new ArrayList<>();
    }

    public void showListRecipeInSolveOperator(){
        System.out.println("===== IN SolveTheOperator =====");
        for (String recipe : listRecipe){
            System.out.println(recipe);
        }
        System.out.println("===== IN SolveTheOperator =====");
    }

    public Double SolveRecipeByRequest(String recipe , String variable, ManagerVariable<String,Double> managerVariable){
        int indexRecipe = 0;
        for (int i = 0 ; i < listRecipe.size() ; i++){
            if (listRecipe.get(i).compareTo(recipe) == 0){
                indexRecipe = i;
                break;
            }
        }
        return DetailSolveRecipe(variable,indexRecipe,managerVariable);
    }


    public Double DetailSolveRecipe(String variable , int indexRecipe , ManagerVariable<String,Double> managerVariable){

        double result = 0;

        if(indexRecipe == 0){ // CT 1 : A+B+C=180 -- Correctly

            if (variable.compareTo("A") == 0){
                double B = managerVariable.collectionVariable.get("B");
                double C = managerVariable.collectionVariable.get("C");
                result = 180 - (B + C);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("B") == 0){
                double A = managerVariable.collectionVariable.get("A");
                double C = managerVariable.collectionVariable.get("C");
                result = 180 - (A + C);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("C") == 0){
                double A = managerVariable.collectionVariable.get("A");
                double B = managerVariable.collectionVariable.get("B");
                result = 180 - (A + B);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }


        if(indexRecipe == 1){ // CT 2 : b/sinB=c/sinC
            if (variable.compareTo("b") == 0){
                double B = managerVariable.collectionVariable.get("B");
                double c = managerVariable.collectionVariable.get("c");
                double C = managerVariable.collectionVariable.get("C");

                double x = Math.toRadians(B);
                double sinB = Math.sin(x);

                double y = Math.toRadians(C);
                double sinC = Math.sin(y);

                result = (c*sinB)/sinC;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("B") == 0){
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");
                double C = managerVariable.collectionVariable.get("C");

                double radians = (b*Math.sin(C))/c; // Sin(B)
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("c") == 0){
                double b = managerVariable.collectionVariable.get("b");
                double B = managerVariable.collectionVariable.get("B");
                double C = managerVariable.collectionVariable.get("C");

                double x = Math.toRadians(C);
                double sinC = Math.sin(x);

                double y = Math.toRadians(B);
                double sinB = Math.sin(y);

                result = (b*sinC)/sinB;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("C") == 0){

                double b = managerVariable.collectionVariable.get("b");
                double B = managerVariable.collectionVariable.get("B");
                double c = managerVariable.collectionVariable.get("c");

                double radians = (c*Math.sin(B))/b;// Sin(C)
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }

        if(indexRecipe == 2){ // CT 3 : S=sqrt(p*(p-a)(p-b)(p-c)):S p a b c -- Correctly

            if (variable.compareTo("S") == 0){
                double p = managerVariable.collectionVariable.get("p");
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");

                double x1 = p-a;
                double x2 = p-b;
                double x3 = p-c;
                double x = p*x1*x2*x3;
                result = Math.sqrt(x);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("p") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");
                result = (a+b+c)/2;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("a") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double p = managerVariable.collectionVariable.get("p");
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");
                result = p - (Math.pow(S,2)/(p*(p-b)*(p-c)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("b") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double p = managerVariable.collectionVariable.get("p");
                double a = managerVariable.collectionVariable.get("a");
                double c = managerVariable.collectionVariable.get("c");
                result = p - (Math.pow(S,2)/(p*(p-a)*(p-c)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("c") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double p = managerVariable.collectionVariable.get("p");
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                result = p - (Math.pow(S,2)/(p*(p-a)*(p-b)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }

        if(indexRecipe == 3){ // CT 4 :  p=(a+b+c)/2:p a b c -- Correctly
            if (variable.compareTo("p") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");
                result = (a+b+c)/2;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("a") == 0){
                double p = managerVariable.collectionVariable.get("p");
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");
                result = (2*p) - (b+c);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("b") == 0){
                double p = managerVariable.collectionVariable.get("p");
                double a = managerVariable.collectionVariable.get("a");
                double c = managerVariable.collectionVariable.get("c");
                result = (2*p) - (a+c);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("c") == 0){
                double p = managerVariable.collectionVariable.get("p");
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                result = (2*p) - (a+b);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }

        if(indexRecipe == 4){ // CT 5 : S=(1/2)*a*ha:S a ha -- Correctly
            if (variable.compareTo("S") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double ha = managerVariable.collectionVariable.get("ha");
                result = (1/2)*a*ha;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("a") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double ha = managerVariable.collectionVariable.get("ha");
                result = (2*S)/ha;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("ha") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double a = managerVariable.collectionVariable.get("a");
                result = (2*S)/a;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        // CT 6 : a/sinA=b/sinB
        if(indexRecipe == 5){
            if (variable.compareTo("a") == 0){
                double A = managerVariable.collectionVariable.get("A");
                double b = managerVariable.collectionVariable.get("b");
                double B = managerVariable.collectionVariable.get("B");

                double x = Math.toRadians(A);
                double sinA = Math.sin(x);

                double y = Math.toRadians(B);
                double sinB = Math.sin(y);

                result = (b+sinA)/sinB;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("A") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double B = managerVariable.collectionVariable.get("B");

                double radians = (a*Math.sin(B))/b; // sin(A)
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("b") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double A = managerVariable.collectionVariable.get("A");
                double B = managerVariable.collectionVariable.get("B");

                double x = Math.toRadians(B);
                double sinB = Math.sin(x);

                double y = Math.toRadians(A);
                double sinA = Math.sin(y);

                result = (a*sinB)/sinA;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("B") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double A = managerVariable.collectionVariable.get("A");
                double b = managerVariable.collectionVariable.get("b");

                double radians = (b*Math.sin(A))/a; // sin(B)
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }

        return result;
    }




}
