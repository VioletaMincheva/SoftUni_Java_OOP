package Polymorphism.WildFarm_ex3;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setBreed(breed);
    }


    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }
    @Override
    public String toString() {
        return String.format("%s [%s, %s, %.2f, %s, %d]", super.getAnimalType(), super.getAnimalName(), this.getBreed(),
                super.getAnimalWeight(), super.getLivingRegion(), super.getFoodEaten());
    }
}
