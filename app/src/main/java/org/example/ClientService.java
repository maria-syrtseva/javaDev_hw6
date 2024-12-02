package org.example;

import java.util.*;

public class ClientService {
    private final Map<Long, Client> clientStorage = new HashMap<>();
    private long nextId = 1; // ідентифікатор

    // Додавання нового клієнта, та його ідентифікатор
    public long create(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 100) {
            throw new IllegalArgumentException("Ім'я не має містити більше 100 символів! Спробуйте ще раз.");
        }
        Client client = new Client(nextId++, name);
        clientStorage.put(client.getId(), client);
        return client.getId();
    }

    // Ім'я клієнта за ідентифікатором
    public String getById(long id) {
        Client client = clientStorage.get(id);
        if (client == null) {
            throw new NoSuchElementException("Клієнт з ID " + id + " не знайдений.");
        }
        return client.getName();
    }

    // Нове ім'я для клієнта за ідентифікатором
    public void setName(long id, String name) {
        Client client = clientStorage.get(id);
        if (client == null) {
            throw new NoSuchElementException("Клієнт з ID " + id + " не знайдений.");
        }
        client.setName(name);
    }

    // Видалення клієнта за ідентифікатором
    public void deleteById(long id) {
        if (!clientStorage.containsKey(id)) {
            throw new NoSuchElementException("Клієнт з ID " + id + " не знайдений.");
        }
        clientStorage.remove(id);
    }

    // Повернення списку всіх клієнтів
    public List<Client> listAll() {
        return new ArrayList<>(clientStorage.values());
    }
}