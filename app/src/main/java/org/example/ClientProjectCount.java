package org.example;

// Результат запиту клієнтів з максимальною кількістю проєктів
public class ClientProjectCount {
    private String name;
    private int projectCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }
}