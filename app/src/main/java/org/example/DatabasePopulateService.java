package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String sqlFile = "D:\\javaDev_hw6\\app\\src\\main\\resources\\sql\\populate_db.sql";  // Шлях до SQL файлу для заповнення бд

        try {
            // Читаємо SQL
            String sql = new String(Files.readAllBytes(Paths.get(sqlFile)));

            // Підключення до БД через клас Database
            try (Connection connection = Database.getInstance().getConnection();
                 Statement statement = connection.createStatement()) {

                // Виконання SQL для заповнення БД
                statement.execute(sql);
                System.out.println("бд успішно заповнена!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Помилка при виконанні SQL запитів");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Помилка при прочитанні SQL файлу");
        }
    }
}