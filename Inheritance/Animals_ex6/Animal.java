package Inheritance.Animals_ex6;

public class Animal {
    protected String name;
    protected int age;
    protected String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null && name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null && gender.trim().isEmpty()
                && !gender.equals("Female") && !gender.equals("Male")
                && !gender.equals("Tomcat") && !gender.equals("Kitten")) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.gender = gender;
    }

    public String produceSound() {
        return null;
    }

    @Override
    public String toString() {
        String output = this.getClass().getSimpleName() + System.lineSeparator()
                + this.getName() + " " + this.getAge() + " " + this.getGender() + System.lineSeparator()
                + this.produceSound();
        return output;
    }
}
