package Polymorphism.WildFarm_ex3;

public class Tiger extends Feline {
    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setLivingRegion(livingRegion);
    }


    @Override
    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            super.eat(food);
        }else {
            System.out.printf("%s are not eating that type of food!%n", this.getClass().getSimpleName());
        }
    }
}
