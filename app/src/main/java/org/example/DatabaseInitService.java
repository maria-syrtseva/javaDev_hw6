package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

// Ініціалізація структури бд
public class DatabaseInitService {
    public static void main(String[] args) {
        // Використання File для вказування шляху до SQL файлу
        File sqlFile = new File("D:\\javaDev_hw6\\app\\src\\main\\resources\\sql\\init_db.sql"); // Відносний шлях до файлу

        try {
            // Читаємо SQL з файлу
            String sql = new String(Files.readAllBytes(sqlFile.toPath())); // Перетворення File у Path

            // Підключення до БД через клас Database
            try (Connection connection = Database.getInstance().getConnection();
                 // Створюємо об'єкт Statement для SQL запитів
                 Statement statement = connection.createStatement()) {

                // Виконання SQL запитів для створення структури БД
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