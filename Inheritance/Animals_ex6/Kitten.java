package Inheritance.Animals_ex6;

public class Kitten extends Cat{
    final static String GENDER = "Female";
    final static String KITTEN_SOUND = "Meow";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return KITTEN_SOUND;
    }
}
