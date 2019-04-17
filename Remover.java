package spread_algorithm;

public class Remover {

    String recipe;
    String variable;
    double value;

    public Remover(){

    }

    public Remover(String recipe, String variable, double value) {
        this.recipe = recipe;
        this.variable = variable;
        this.value = value;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Remover{" +
                "recipe='" + recipe + '\'' +
                ", variable='" + variable + '\'' +
                ", value=" + value +
                '}';
    }
}
