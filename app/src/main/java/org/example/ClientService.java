package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private final Connection connection;

    public ClientService(Connection connection) {
        this.connection = connection;
    }

    // Додавання нового клієнта, та його ідентифікатор
    public long create(String name) throws SQLException {
        String sql = "INSERT INTO clients (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getLong(1);
                } else {
                    throw new SQLException("Не вдалося отримати ID нового клієнта.");
                }
            }
        }
    }

    // Ім'я клієнта за ідентифікатором
    public Client getById(long id) throws SQLException {
        String sql = "SELECT id, name FROM clients WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Client(
                            resultSet.getLong("id"),
                            resultSet.getString("name")
                    );
                } else {
                    throw new SQLException("Клієнта з ID " + id + " не знайдено.");
                }
            }
        }
    }

    // Нове ім'я для клієнта за ідентифікатором
    public void setName(long id, String name) throws SQLException {
        String sql = "UPDATE clients SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setLong(2, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Клієнта з ID " + id + " не знайдено.");
            }
        }
    }

    // Видалення клієнта за ідентифікатором
    public void deleteById(long id) throws SQLException {
        String sql = "DELETE FROM clients WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0) {
                throw new SQLException("Клієнта з ID " + id + " не знайдено.");
            }
        }
    }

    // Повернення списку всіх клієнтів
    public List<Client> listAll() throws SQLException {
        String sql = "SELECT id, name FROM clients";
        List<Client> clients = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                clients.add(new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                ));
            }
        }
        return clients;
    }
}