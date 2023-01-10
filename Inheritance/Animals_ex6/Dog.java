package Inheritance.Animals_ex6;

public class Dog extends Animal {
    final static String DOG_SOUND = "Woof!";

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return DOG_SOUND;
    }
}
