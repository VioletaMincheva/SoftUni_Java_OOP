package Polymorphism.WildFarm_ex3;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.setLivingRegion(livingRegion);
    }


    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    DecimalFormat decimalFormat = new DecimalFormat("##.#");
    @Override
    public String toString() {
        return String.format("%s [%s, %s, %s, %d]", super.getAnimalType(), super.getAnimalName(),
               decimalFormat.format(super.getAnimalWeight()), this.getLivingRegion(), super.getFoodEaten());
    }

}
