package local.algorithm.leetcode;

import java.util.*;

public class InvalidTransactions {

    static class Transaction {
        String name;
        int time;
        int amount;
        String city;

        public Transaction(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> transactionsByName = new HashMap<>();
        for (String transaction : transactions) {
            String[] split = transaction.split(",");
            transactionsByName.putIfAbsent(split[0], new ArrayList<>());
            transactionsByName.get(split[0]).add(new Transaction(split[0],
                    Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3]));
        }

        Set<String> invalid = new HashSet<>();
        for (Map.Entry<String, List<Transaction>> transactionsOneName : transactionsByName.entrySet()) {
            List<Transaction> trans = transactionsOneName.getValue();
            for (int i = 0; i < trans.size(); i++) {
                Transaction transaction = trans.get(i);
                if (transaction.amount > 1000) {
                    invalid.add(transaction.toString());
                }
                for (int j = i + 1; j < trans.size(); j++) {
                    Transaction other = trans.get(j);
                    if (!other.city.equals(transaction.city) && Math.abs(other.time - transaction.time) <= 60) {
                        invalid.add(transaction.toString());
                        invalid.add(other.toString());
                    }
                }
            }
        }
        return new ArrayList<>(invalid);
    }
}
