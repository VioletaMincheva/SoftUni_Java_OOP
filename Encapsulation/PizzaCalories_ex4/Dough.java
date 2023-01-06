package Encapsulation.PizzaCalories_ex4;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public String getFlourType() {
        return flourType;
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy")
                && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private double getDoughModifiersFlourType(String flourType) {
        switch (flourType) {
            case "White":
                return 1.5;
            case "Wholegrain":
                return 1.0;
        }
        return 0.0;
    }

    private double getDoughModifiersBakingTechniques(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                return 0.9;
            case "Chewy":
                return 1.1;
            case "Homemade":
                return 1.0;
        }
        return 0.0;
    }

    public double calculateCalories() {
        return 2 * this.weight
                * getDoughModifiersFlourType(this.flourType)
                * getDoughModifiersBakingTechniques(this.bakingTechnique);
    }
}
