package org.example;

public class Client {
    private final long id;
    private String name;

    public Client(long id, String name) {
        this.id = id;
        setName(name);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 100) {
            throw new IllegalArgumentException("Ім'я не має містити більше 100 символів! Спробуйте ще раз.");
        }
        this.name = name;
    }
}