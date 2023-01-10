package Inheritance.Animals_ex6;

public class Tomcat extends Cat {
    final static String GENDER = "Male";
    final static String TOMCAT_SOUND = "MEOW";

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return TOMCAT_SOUND;
    }
}
