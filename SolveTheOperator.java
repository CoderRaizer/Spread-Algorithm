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
    }//End

    public Double SolveRecipeByRequest(String recipe , String variable, ManagerVariable<String,Double> managerVariable){

        double result = 0;
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if(recipe.compareTo("A+B+C=180") == 0){ // CT : A+B+C=180

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
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if(recipe.compareTo("a/sinA=b/sinB") == 0){// CT : a/sinA=b/sinB
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
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if(recipe.compareTo("b/sinB=c/sinC") == 0){ // CT : b/sinB=c/sinC
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
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if(recipe.compareTo("a/sinA=c/sinC") == 0){ // CT : a/sinA=c/sinC
            if (variable.compareTo("a") == 0){
                double A = managerVariable.collectionVariable.get("A");
                double c = managerVariable.collectionVariable.get("c");
                double C = managerVariable.collectionVariable.get("C");

                double x = Math.toRadians(A);
                double sinA = Math.sin(x);

                double y = Math.toRadians(C);
                double sinC = Math.sin(y);

                result = (c*sinA)/sinC;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("A") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double c = managerVariable.collectionVariable.get("c");
                double C = managerVariable.collectionVariable.get("C");

                double radians = (a*Math.sin(C))/c; // Sin(A)
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("c") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double A = managerVariable.collectionVariable.get("A");
                double C = managerVariable.collectionVariable.get("C");

                double x = Math.toRadians(C);
                double sinC = Math.sin(x);

                double y = Math.toRadians(A);
                double sinA = Math.sin(y);

                result = (a*sinC)/sinA;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("C") == 0){

                double a = managerVariable.collectionVariable.get("a");
                double A = managerVariable.collectionVariable.get("A");
                double c = managerVariable.collectionVariable.get("c");

                double radians = (c*Math.sin(A))/a;// Sin(C)
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("a/sinA=2R") == 0){
            if (variable.compareTo("a") == 0){
                double A = managerVariable.collectionVariable.get("A");
                double R = managerVariable.collectionVariable.get("R");

                double x = Math.toRadians(A);
                double sinA = Math.sin(x);

                result = 2*R*sinA;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("A") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double R = managerVariable.collectionVariable.get("R");

                double radians = a/(2*R); // Sin(A)
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("R") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double A = managerVariable.collectionVariable.get("A");

                double x = Math.toRadians(A);
                double sinA = Math.sin(x);

                result = a/(2*sinA);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("b/sinB=2R") == 0){
            if (variable.compareTo("b") == 0){
                double B = managerVariable.collectionVariable.get("B");
                double R = managerVariable.collectionVariable.get("R");

                double x = Math.toRadians(B);
                double sinB = Math.sin(x);

                result = 2*R*sinB;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("B") == 0){
                double b = managerVariable.collectionVariable.get("b");
                double R = managerVariable.collectionVariable.get("R");

                double radians = b/(2*R); // Sin(B)
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("R") == 0){
                double b = managerVariable.collectionVariable.get("b");
                double B = managerVariable.collectionVariable.get("B");

                double x = Math.toRadians(B);
                double sinB = Math.sin(x);

                result = b/(2*sinB);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("c/sinC=2R") == 0){
            if (variable.compareTo("c") == 0){
                double C = managerVariable.collectionVariable.get("C");
                double R = managerVariable.collectionVariable.get("R");

                double x = Math.toRadians(C);
                double sinC = Math.sin(x);

                result = 2*R*sinC;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("C") == 0){
                double c = managerVariable.collectionVariable.get("c");
                double R = managerVariable.collectionVariable.get("R");

                double radians = c/(2*R); // Sin(C)
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("R") == 0){
                double c = managerVariable.collectionVariable.get("c");
                double C = managerVariable.collectionVariable.get("C");

                double x = Math.toRadians(C);
                double sinC = Math.sin(x);

                result = c/(2*sinC);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if(recipe.compareTo("p=(a+b+c)/2") == 0){ // CT :  p=(a+b+c)/2:p a b c
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
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("(a^2)=(b^2)+(c^2)-(2bc*CosA)") == 0){
            if (variable.compareTo("a") == 0){
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");
                double A = managerVariable.collectionVariable.get("A");

                double x = Math.toRadians(A);
                double cosA = Math.cos(x);

                double temp = Math.pow(b,2) + Math.pow(c,2) - (2*b*c*cosA);
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);

            }
            if (variable.compareTo("A") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");

                double radians = (Math.pow(b,2) + Math.pow(c,2) - Math.pow(a,2))/(2*b*c); // Cos(A)
                result = Math.toDegrees(Math.acos(Math.cos(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("(b^2)=(a^2)+(c^2)-(2ac*CosB)") == 0){
            if (variable.compareTo("b") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double c = managerVariable.collectionVariable.get("c");
                double B = managerVariable.collectionVariable.get("B");

                double x = Math.toRadians(B);
                double cosB = Math.cos(x);

                double temp = Math.pow(a,2) + Math.pow(c,2) - (2*a*c*cosB);
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);

            }
            if (variable.compareTo("B") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");

                double radians = (Math.pow(a,2) + Math.pow(c,2) - Math.pow(b,2))/(2*a*c); // Cos(B)
                result = Math.toDegrees(Math.acos(Math.cos(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("(c^2)=(a^2)+(b^2)-(2ab*CosC)") == 0){
            if (variable.compareTo("c") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double C = managerVariable.collectionVariable.get("C");

                double x = Math.toRadians(C);
                double cosC = Math.cos(x);

                double temp = Math.pow(a,2) + Math.pow(b,2) - (2*a*b*cosC);
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);

            }
            if (variable.compareTo("C") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");

                double radians = (Math.pow(a,2) + Math.pow(b,2) - Math.pow(c,2))/(2*a*b); // Cos(C)
                result = Math.toDegrees(Math.acos(Math.cos(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("(ma)^2=(2*(b^2+c^2)-a^2)/4") == 0){
            if (variable.compareTo("ma") == 0){
                double b = managerVariable.collectionVariable.get("b");
                double c  =managerVariable.collectionVariable.get("c");
                double a  =managerVariable.collectionVariable.get("a");

                double temp = (2*(Math.pow(b,2)+Math.pow(c,2))-Math.pow(a,2))/4;
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("a") == 0){
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");
                double ma = managerVariable.collectionVariable.get("ma");

                double temp = 2*Math.pow(b,2) + 2*Math.pow(c,2) - 4*Math.pow(ma,2);
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("b") == 0){
                double ma = managerVariable.collectionVariable.get("ma");
                double c = managerVariable.collectionVariable.get("c");
                double a = managerVariable.collectionVariable.get("a");

                double temp = (4*Math.pow(ma,2) - 2*Math.pow(c,2) + Math.pow(a,2))/2;
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("c") == 0){
                double ma = managerVariable.collectionVariable.get("ma");
                double b = managerVariable.collectionVariable.get("b");
                double a = managerVariable.collectionVariable.get("a");

                double temp = (4*Math.pow(ma,2) - 2*Math.pow(b,2) + Math.pow(a,2))/2;
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("(mb)^2=(2*(a^2+c^2)-b^2)/4") == 0){
            if (variable.compareTo("mb") == 0){
                double a  =managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double c  =managerVariable.collectionVariable.get("c");

                double temp = (2*(Math.pow(a,2)+Math.pow(c,2))-Math.pow(b,2))/4;
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("a") == 0){
                double mb = managerVariable.collectionVariable.get("mb");
                double c = managerVariable.collectionVariable.get("c");
                double b = managerVariable.collectionVariable.get("b");

                double temp = (4*Math.pow(mb,2) - 2*Math.pow(c,2) + Math.pow(b,2))/2;
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("b") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double c = managerVariable.collectionVariable.get("c");
                double mb = managerVariable.collectionVariable.get("mb");

                double temp = 2*Math.pow(a,2) + 2*Math.pow(c,2) - 4*Math.pow(mb,2);
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("c") == 0){
                double mb = managerVariable.collectionVariable.get("mb");
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");

                double temp = (4*Math.pow(mb,2) - 2*Math.pow(a,2) + Math.pow(b,2))/2;
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("(mc)^2=(2*(a^2+b^2)-c^2)/4") == 0){
            if (variable.compareTo("mc") == 0){
                double a  =managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double c  =managerVariable.collectionVariable.get("c");

                double temp = (2*(Math.pow(a,2)+Math.pow(b,2))-Math.pow(c,2))/4;
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("a") == 0){
                double mc = managerVariable.collectionVariable.get("mc");
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");

                double temp = (4*Math.pow(mc,2) - 2*Math.pow(b,2) + Math.pow(c,2))/2;
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("b") == 0){
                double mc = managerVariable.collectionVariable.get("mc");
                double a = managerVariable.collectionVariable.get("a");
                double c = managerVariable.collectionVariable.get("c");

                double temp = (4*Math.pow(mc,2) - 2*Math.pow(a,2) + Math.pow(c,2))/2;
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("c") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double mc = managerVariable.collectionVariable.get("mc");

                double temp = 2*Math.pow(a,2) + 2*Math.pow(b,2) - 4*Math.pow(mc,2);
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if(recipe.compareTo("S=(1/2)*a*ha") == 0){ // CT : S=(1/2)*a*ha:S a ha
            if (variable.compareTo("S") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double ha = managerVariable.collectionVariable.get("ha");
                result = (a*ha)/2;
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
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if(recipe.compareTo("S=(1/2)*b*hb") == 0){ // CT : S=(1/2)*b*hb:S b hb
            if (variable.compareTo("S") == 0){
                double b = managerVariable.collectionVariable.get("b");
                double hb = managerVariable.collectionVariable.get("hb");
                result = (b*hb)/2;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("b") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double hb = managerVariable.collectionVariable.get("hb");
                result = (2*S)/hb;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("hb") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double b = managerVariable.collectionVariable.get("b");
                result = (2*S)/b;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if(recipe.compareTo("S=(1/2)*c*hc") == 0){ // CT : S=(1/2)*c*hc:S c hc
            if (variable.compareTo("S") == 0){
                double c = managerVariable.collectionVariable.get("c");
                double hc = managerVariable.collectionVariable.get("hc");
                result = (c*hc)/2;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("c") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double hc = managerVariable.collectionVariable.get("hc");
                result = (2*S)/hc;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("hc") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double c = managerVariable.collectionVariable.get("c");
                result = (2*S)/c;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("S=(1/2)*b*c*sinA") == 0){

            if (variable.compareTo("S") == 0){
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");
                double A = managerVariable.collectionVariable.get("A");

                double x = Math.toRadians(A);
                double sinA = Math.sin(x);

                result = (b*c*sinA)/2;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("b") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double c = managerVariable.collectionVariable.get("c");
                double A = managerVariable.collectionVariable.get("A");

                double x = Math.toRadians(A);
                double sinA = Math.sin(x);

                result = (2*S)/c*sinA;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("c") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double b = managerVariable.collectionVariable.get("b");
                double A = managerVariable.collectionVariable.get("A");

                double x = Math.toRadians(A);
                double sinA = Math.sin(x);

                result = (2*S)/b*sinA;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("A") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");

                double radians = (2*S)/(b*c); // Sin(A)
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("S=(1/2)*a*c*sinB") == 0){

            if (variable.compareTo("S") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double c = managerVariable.collectionVariable.get("c");
                double B = managerVariable.collectionVariable.get("B");

                double x = Math.toRadians(B);
                double sinB = Math.sin(x);

                result = (a*c*sinB)/2;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("a") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double c = managerVariable.collectionVariable.get("c");
                double B = managerVariable.collectionVariable.get("B");

                double x = Math.toRadians(B);
                double sinB = Math.sin(x);

                result = (2*S)/c*sinB;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("c") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double a = managerVariable.collectionVariable.get("a");
                double B = managerVariable.collectionVariable.get("B");

                double x = Math.toRadians(B);
                double sinB = Math.sin(x);

                result = (2*S)/a*sinB;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("B") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double a = managerVariable.collectionVariable.get("a");
                double c = managerVariable.collectionVariable.get("c");

                double radians = (2*S)/(a*c); // Sin(B)
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("S=(1/2)*a*b*sinC") == 0){

            if (variable.compareTo("S") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double C = managerVariable.collectionVariable.get("C");

                double x = Math.toRadians(C);
                double sinC = Math.sin(x);

                result = (a*b*sinC)/2;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("a") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double b = managerVariable.collectionVariable.get("b");
                double C = managerVariable.collectionVariable.get("C");

                double x = Math.toRadians(C);
                double sinC = Math.sin(x);

                result = (2*S)/b*sinC;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("b") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double a = managerVariable.collectionVariable.get("a");
                double C = managerVariable.collectionVariable.get("C");

                double x = Math.toRadians(C);
                double sinC = Math.sin(x);

                result = (2*S)/a*sinC;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("C") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");

                double radians = (2*S)/(a*b); // Sin(C)
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("S=(a*b*c)/4R") == 0){
            if (variable.compareTo("S") == 0){
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");
                double R = managerVariable.collectionVariable.get("R");

                result = (a*b*c)/(4*R);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);

            }
            if (variable.compareTo("a") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");
                double R = managerVariable.collectionVariable.get("R");

                result = (4*R*S)/(b*c);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("b") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double a = managerVariable.collectionVariable.get("a");
                double c = managerVariable.collectionVariable.get("c");
                double R = managerVariable.collectionVariable.get("R");

                result = (4*R*S)/(a*c);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("c") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double R = managerVariable.collectionVariable.get("R");

                result = (4*R*S)/(a*b);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("R") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double a = managerVariable.collectionVariable.get("a");
                double b = managerVariable.collectionVariable.get("b");
                double c = managerVariable.collectionVariable.get("c");

                result = (a*b*c)/(4*S);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("S=p*r") == 0){
            if (variable.compareTo("S") == 0){
                double p = managerVariable.collectionVariable.get("p");
                double r = managerVariable.collectionVariable.get("r");

                result = p*r;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("p") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double r = managerVariable.collectionVariable.get("r");

                result = S/r;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("r") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double p = managerVariable.collectionVariable.get("p");

                result = S/p;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }

        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if(recipe.compareTo("S=sqrt(p*(p-a)(p-b)(p-c))") == 0){ // CT : S=sqrt(p*(p-a)(p-b)(p-c)):S p a b c

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
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        if (recipe.compareTo("S=2*(R^2)*sinA*sinB*sinC") == 0){
            if (variable.compareTo("S") == 0){
                double R = managerVariable.collectionVariable.get("R");
                double A = managerVariable.collectionVariable.get("A");
                double B = managerVariable.collectionVariable.get("B");
                double C = managerVariable.collectionVariable.get("C");

                double x = Math.toRadians(A);
                double y = Math.toRadians(B);
                double z = Math.toRadians(C);

                double sinA = Math.sin(x);
                double sinB = Math.sin(y);
                double sinC = Math.sin(z);

                result = 2*Math.pow(R,2)*sinA*sinB*sinC;
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("R") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double A = managerVariable.collectionVariable.get("A");
                double B = managerVariable.collectionVariable.get("B");
                double C = managerVariable.collectionVariable.get("C");

                double x = Math.toRadians(A);
                double y = Math.toRadians(B);
                double z = Math.toRadians(C);

                double sinA = Math.sin(x);
                double sinB = Math.sin(y);
                double sinC = Math.sin(z);

                double temp = S/(2*sinA*sinB*sinC);
                result = Math.sqrt(temp);
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("A") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double R = managerVariable.collectionVariable.get("R");
                double B = managerVariable.collectionVariable.get("B");
                double C = managerVariable.collectionVariable.get("C");

                double x = Math.toRadians(B);
                double y = Math.toRadians(C);

                double sinB = Math.sin(x);
                double sinC = Math.sin(y);

                double radians = S/(2*Math.pow(R,2)*sinB*sinC);
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("B") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double R = managerVariable.collectionVariable.get("R");
                double A = managerVariable.collectionVariable.get("A");
                double C = managerVariable.collectionVariable.get("C");

                double x = Math.toRadians(A);
                double y = Math.toRadians(C);

                double sinA = Math.sin(x);
                double sinC = Math.sin(y);

                double radians = S/(2*Math.pow(R,2)*sinA*sinC);
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
            if (variable.compareTo("C") == 0){
                double S = managerVariable.collectionVariable.get("S");
                double R = managerVariable.collectionVariable.get("R");
                double A = managerVariable.collectionVariable.get("A");
                double B = managerVariable.collectionVariable.get("B");

                double x = Math.toRadians(A);
                double y = Math.toRadians(B);

                double sinA = Math.sin(x);
                double sinB = Math.sin(y);

                double radians = S/(2*Math.pow(R,2)*sinA*sinB);
                result = Math.toDegrees(Math.asin(Math.sin(radians)));
                result = Math.ceil(result * 100) / 100;
                managerVariable.add(variable,result);
            }
        }
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

        return result;
    }//End


}
