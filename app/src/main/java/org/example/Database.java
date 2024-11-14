package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Сінглтон для підключення до бд
public class Database {
 private static Database instance;
 private final Connection connection;
 private static final String CONNECTION_URL = "jdbc:h2:./test"; // Адреса бд

 // Створюємо єдиний екземпляр
 private Database() throws SQLException {
  // Підключення до бд
  this.connection = DriverManager.getConnection(CONNECTION_URL);
 }

 // Отримуємо один екземпляр
 public static Database getInstance() throws SQLException {
  if (instance == null) {
   instance = new Database();
  }
  return instance;
 }

 // Метод для отримання з'єднання
 public Connection getConnection() {
  return connection;
 }

 // Тестування підключення
 public static void main(String[] args) {
  try {
   // Спроба отримати з'єднання
   Connection conn = Database.getInstance().getConnection();
   if (conn != null) {
    System.out.println("Успіх!");
   } else {
    System.out.println("Підключення не вдалося!");
   }
  } catch (SQLException e) {
   e.printStackTrace();
  }
 }
}