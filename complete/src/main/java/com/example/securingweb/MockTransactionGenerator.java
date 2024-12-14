package com.example.securingweb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MockTransactionGenerator {

    // Sample transaction descriptions
    private static final String[] DESCRIPTIONS = {
        "Kroger Store #200", "Olive Garden", "Costco Gas", "Amazon", "CoServ Electic",
        "Netflix", "Salary", "Bonus", "Rent", "Geico"
    };

    public static void main(String[] args) {
        List<Transaction> transactions = generateMockTransactions(10);
        transactions.forEach(System.out::println);
    }

    public static List<Transaction> generateMockTransactions(int numberOfTransactions) {
        List<Transaction> transactions = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfTransactions; i++) {
            // Generate random amount between -1000 and 1000
            double amount = -1000 + (2000) * random.nextDouble();
            // Generate random date within the last 30 days
            LocalDate date = LocalDate.now().minus(random.nextInt(30), ChronoUnit.DAYS);
            // Pick a random description from the sample descriptions
            String description = DESCRIPTIONS[random.nextInt(DESCRIPTIONS.length)] + ((amount < 0) ? " Refund":" Payment");

            // Create a new transaction and add it to the list
            transactions.add(new Transaction(date, amount, description));
        }

        return transactions;
    }

    // Transaction class representing a bank transaction
    static class Transaction {
        public LocalDate date;
        public double amount;
        public String description;

        public Transaction(LocalDate date, double amount, String description) {
            this.date = date;
            this.amount = amount;
            this.description = description;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "date=" + date +
                    ", amount=" + amount +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
