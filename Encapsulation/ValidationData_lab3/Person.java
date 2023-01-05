package Encapsulation.ValidationData_lab3;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() < 30) {
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 200));
        } else {
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 100));
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.trim().length() > 3) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First name cannot be at least 3 symbols.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.trim().length() > 3) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name cannot be at least 3 symbols.");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age cannot be zero or negative.");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 460.00) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary cannot be less than 460.00 leva.");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.1f leva", this.getFirstName(), this.getLastName(), this.getSalary());
    }
}
