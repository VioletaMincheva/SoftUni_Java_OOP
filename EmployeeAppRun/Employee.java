package EmployeeApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private Double monthlySalary;

    public Employee(String fullName, String email, String phoneNumber, String dateOfBirth, Double monthlySalary) {
        this.setFullName(fullName);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setDateOfBirth(dateOfBirth);
        this.setMonthlySalary(monthlySalary);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            this.email = email;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        String regex = "^[+]\\d{12}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.find()) {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        String regex = "^\\d{4}-[A-Z][a-z]{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateOfBirth);
        if (matcher.find()) {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        if (monthlySalary <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SALARY);
        }
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        StringBuilder report = new StringBuilder();
        report.append("Employee: ")
                .append(System.lineSeparator())
                .append("Full name: ").append(getFullName())
                .append(System.lineSeparator())
                .append("Email: ").append(getEmail())
                .append(System.lineSeparator())
                .append("Phone number: ").append(getPhoneNumber())
                .append(System.lineSeparator())
                .append("Date of Birth: ").append(getDateOfBirth())
                .append(System.lineSeparator())
                .append("Monthly salary: ").append(getMonthlySalary())
                .append(System.lineSeparator());
        return report.toString().trim();
    }
}
