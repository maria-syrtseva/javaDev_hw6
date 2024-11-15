package org.example;

import java.sql.Date;

public class WorkerAge {
    private String type;
    private String name;
    private Date birthday;  // Тип java.sql.Date для дати народження

    // Метод для дати народження
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}