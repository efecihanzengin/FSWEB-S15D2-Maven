package org.example.entity;

public class Task {
    private String project;
    private String description;
    private String assignee;
    private Status status;
    private Priority priority;

    public Task(String project, String description, String assignee, Status status, Priority priority) {
        this.project = project;
        this.description = description;
        this.assignee = assignee;
        this.status = status;
        this.priority = priority;
    }

    // Getter metotları da eklemeniz gerekecek (aşağıdaki hatalara bakın).
    public String getAssignee() {
        return assignee;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getProject() {
        return project;
    }

    public Status getStatus() {
        return status;
    }
}