package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

// Ініціалізація структури бд
public class DatabaseInitService {
    public static void main(String[] args) {
        // Шлях до SQL файлу для ініціалізації БД
        String sqlFile = "sql/init_db.sql";

        try {
            // Читаємо файл
            String sql = new String(Files.readAllBytes(Paths.get(sqlFile)));

            // Підключення до бд через Database
            try (Connection connection = Database.getInstance().getConnection();
                 // Створюємо об'єкт Statement для SQL запитів
                 Statement statement = connection.createStatement()) {

                // Виконання SQL запитів для створення структури бд
                statement.execute(sql);
                System.out.println("Успіх!");
            } catch (SQLException e) {
                // Помилки при виконанні запитів
                e.printStackTrace();
                System.err.println("Помилка виконання");
            }
        } catch (IOException e) {
            // Помилки при читанні файлу
            e.printStackTrace();
            System.err.println("Помилка при прочитанні SQL файлу");
        }
    }
}