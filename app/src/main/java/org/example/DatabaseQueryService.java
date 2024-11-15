package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    // Метод для читання SQL-запиту
    private String readSqlFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    // Найбільші зарплати
    public List<WorkerSalary> findMaxSalary() {
        List<WorkerSalary> result = new ArrayList<>();
        try {
            String sql = readSqlFromFile("D:\\javaDev_hw6\\app\\src\\main\\resources\\sql\\find_max_salary_worker.sql");
            try (Connection conn = Database.getInstance().getConnection()) {
                Statement stmt;
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    WorkerSalary workerSalary = new WorkerSalary();
                    workerSalary.setName(rs.getString("NAME"));
                    workerSalary.setSalary(rs.getDouble("SALARY"));
                    result.add(workerSalary);
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Максимальна кількість проєктів
    public List<ClientProjectCount> findMaxProjectsClient() {
        List<ClientProjectCount> result = new ArrayList<>();
        try {
            String sql = readSqlFromFile("D:\\javaDev_hw6\\app\\src\\main\\resources\\sql\\find_max_projects_client.sql");
            try (Connection conn = Database.getInstance().getConnection()) {
                Statement stmt;
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    ClientProjectCount client = new ClientProjectCount();
                    client.setName(rs.getString("NAME"));
                    client.setProjectCount(rs.getInt("PROJECT_COUNT"));
                    result.add(client);
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Наймолодший і найстаріший працівник
    public List<WorkerAge> findYoungestAndEldestWorker() {
        List<WorkerAge> result = new ArrayList<>();
        try {
            String sql = readSqlFromFile("D:\\javaDev_hw6\\app\\src\\main\\resources\\sql\\find_youngest_and_eldest_worker.sql");
            try (Connection conn = Database.getInstance().getConnection()) {
                Statement stmt;
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    WorkerAge worker = new WorkerAge();
                    worker.setType(rs.getString("TYPE"));
                    worker.setName(rs.getString("NAME"));

                    Date birthday = rs.getDate("BIRTHDAY");
                    worker.setBirthday(birthday);  // Встановлюємо дату народження

                    result.add(worker);
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    // Вартість проєкту
    public List<ProjectPrice> findProjectPrice() {
        List<ProjectPrice> result = new ArrayList<>();
        try {
            String sql = readSqlFromFile("D:\\javaDev_hw6\\app\\src\\main\\resources\\sql\\find_project_price.sql");
            try (Connection conn = Database.getInstance().getConnection()) {
                Statement stmt;
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    ProjectPrice price = new ProjectPrice();
                    price.setProjectName(rs.getString("Project_Name"));
                    price.setProjectPrice(rs.getDouble("Project_Price"));
                    result.add(price);
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}