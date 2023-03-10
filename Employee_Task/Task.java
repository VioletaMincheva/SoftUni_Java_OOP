package EmployeeApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    private String title;
    private String description;
    private String assignedEmployeeFullName;
    private String dueDate;
    private String statusCompleted;

    public Task(String title, String description, String assignedEmployeeFullName, String dueDate, String statusCompleted) {
        this.setTitle(title);
        this.setDescription(description);
        this.setAssignedEmployeeFullName(assignedEmployeeFullName);
        this.setDueDate(dueDate);
        this.setStatusCompleted(statusCompleted);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TITLE);
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DESCRIPTION);
        }
        this.description = description;
    }

    public String getAssignedEmployeeFullName() {
        return assignedEmployeeFullName;
    }

    public void setAssignedEmployeeFullName(String assignedEmployeeFullName) {
        this.assignedEmployeeFullName = assignedEmployeeFullName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        String regex = "^2023-[A-Z][a-z]{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dueDate);
        if (matcher.find()) {
            this.dueDate = dueDate;
        }
    }

    public String getStatusCompleted() {
        return statusCompleted;
    }

    public void setStatusCompleted(String statusCompleted) {
        if (!statusCompleted.equals("yes") && !statusCompleted.equals("no")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_STATUS);
        }
        this.statusCompleted = statusCompleted;
    }

    @Override
    public String toString() {
        StringBuilder reportTasks = new StringBuilder();
        reportTasks.append("Task: ")
                .append(System.lineSeparator())
                .append("Title: ").append(getTitle())
                .append(System.lineSeparator())
                .append("Description: ").append(getDescription())
                .append(System.lineSeparator())
                .append("Assigned employee full name: ").append(getAssignedEmployeeFullName())
                .append(System.lineSeparator())
                .append("Due date: ").append(getDueDate())
                .append(System.lineSeparator())
                .append("Completed status: ").append(getStatusCompleted())
                .append(System.lineSeparator());
        return reportTasks.toString().trim();
    }
}
