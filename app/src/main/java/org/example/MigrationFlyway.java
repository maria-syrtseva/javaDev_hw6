package org.example;

import org.flywaydb.core.Flyway;

public class MigrationFlyway {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:./database/testdb", "sa", "")
                .locations("classpath:db")
                .load();

        flyway.migrate();

        System.out.println("Flyway міграції виконані успішно!");
    }
}