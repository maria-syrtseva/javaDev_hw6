package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        // Використання File для вказування шляху до SQL файлу
        File sqlFile = new File("src/main/resources/sql/populate_db.sql"); // Відносний шлях до файлу

        try {
            // Читаємо SQL з файлу
            String sql = new String(Files.readAllBytes(sqlFile.toPath())); // Перетворення File у Path

            // Підключення до БД через клас Database
            try (Connection connection = Database.getInstance().getConnection();
                 Statement statement = connection.createStatement()) {

                // Виконання SQL для заповнення БД
                statement.execute(sql);
                System.out.println("Успіх!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Помилка виконання");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Помилка при прочитанні SQL файлу");
        }
    }
}