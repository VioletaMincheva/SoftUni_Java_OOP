package Polymorphism.WildFarm_ex3;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            super.eat(food);
        }else {
            System.out.printf("%s are not eating that type of food!%n", this.getClass().getSimpleName());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
