package org.example;

import java.util.List;

// Клас для виведення файлів
public class Main {
    public static void main(String[] args) {
        // Створення екземпляра DatabaseQueryService
        DatabaseQueryService queryService = new DatabaseQueryService();

        // Вивід методу findMaxSalary()
        System.out.println("Найбільші зарплати:");
        List<WorkerSalary> maxSalaries = queryService.findMaxSalary();
        for (WorkerSalary salary : maxSalaries) {
            System.out.println("Ім'я: " + salary.getName() + ", Зарплата: " + salary.getSalary());
        }

        // Вивід методу findMaxProjectsClient()
        System.out.println("\nКлієнти з максимальною кількістю проєктів:");
        List<ClientProjectCount> maxProjectsClients = queryService.findMaxProjectsClient();
        for (ClientProjectCount client : maxProjectsClients) {
            System.out.println("Клієнт: " + client.getName() + ", Кількість проєктів: " + client.getProjectCount());
        }

        // Вивід методу findYoungestAndEldestWorker()
        System.out.println("\nНаймолодший та найстаріший працівник:");
        List<WorkerAge> youngestAndEldestWorkers = queryService.findYoungestAndEldestWorker();
        for (WorkerAge worker : youngestAndEldestWorkers) {
            System.out.println(worker.getType() + " - Ім'я: " + worker.getName() + ", Дата народження: " + worker.getBirthday());
        }

        // Вивід методу findProjectPrice()
        System.out.println("\nВартість проєктів:");
        List<ProjectPrice> projectPrices = queryService.findProjectPrice();
        for (ProjectPrice price : projectPrices) {
            System.out.println("Проєкт: " + price.getProjectName() + ", Вартість: " + price.getProjectPrice());
        }
    }
}