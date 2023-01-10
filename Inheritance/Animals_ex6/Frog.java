package Inheritance.Animals_ex6;

public class Frog extends Animal{
    final  static String FROG_SOUND = "Ribbit";

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return FROG_SOUND;
    }
}
