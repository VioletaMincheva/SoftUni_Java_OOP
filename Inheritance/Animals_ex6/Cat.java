package Inheritance.Animals_ex6;

public class Cat extends Animal {
    final static String CAT_SOUND = "Meow meow";

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return CAT_SOUND;
    }
}
