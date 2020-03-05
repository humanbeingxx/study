package local.algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<List<String>>> groupByName = accounts.stream().collect(Collectors.groupingBy(strings -> strings.get(0)));
        for (Map.Entry<String, List<List<String>>> entry : groupByName.entrySet()) {
            String name = entry.getKey();
            List<List<String>> accountEmails = processOneName(entry.getValue());
            for (List<String> accountEmail : accountEmails) {
                accountEmail.sort(String::compareTo);
                accountEmail.add(0, name);
                result.add(accountEmail);
            }
        }
        return result;
    }

    List<List<String>> processOneName(List<List<String>> accountEmails) {
        Map<String, Set<String>> emailConnections = new HashMap<>();
        Set<String> allEmails = new HashSet<>();
        for (List<String> accountEmail : accountEmails) {
            if (accountEmail.size() == 2) {
                allEmails.add(accountEmail.get(1));
                continue;
            }
            for (int i = 1; i < accountEmail.size() - 1; i++) {
                String email = accountEmail.get(i);
                String nextEmail = accountEmail.get(i + 1);
                allEmails.add(email);
                allEmails.add(nextEmail);
                emailConnections.putIfAbsent(email, new HashSet<>());
                emailConnections.get(email).add(nextEmail);
                emailConnections.putIfAbsent(nextEmail, new HashSet<>());
                emailConnections.get(nextEmail).add(email);
            }
        }
        return splitByConnection(allEmails, emailConnections);
    }

    List<List<String>> splitByConnection(Set<String> nodes, Map<String, Set<String>> connections) {
        List<List<String>> split = new ArrayList<>();
        List<String> oneSplit = new ArrayList<>();
        Set<String> saw = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        while (!nodes.isEmpty()) {
            String node = nodes.iterator().next();
            queue.add(node);
            nodes.remove(node);
            saw.add(node);
            oneSplit.add(node);
            while (!queue.isEmpty()) {
                String poll = queue.poll();
                if (connections.get(poll) != null) {
                    for (String next : connections.get(poll)) {
                        if (!saw.contains(next)) {
                            queue.add(next);
                            nodes.remove(next);
                            saw.add(next);
                            oneSplit.add(next);
                        }
                    }
                }
            }
            if (!oneSplit.isEmpty()) {
                split.add(new ArrayList<>(oneSplit));
                oneSplit.clear();
                saw.clear();
            }
        }
        return split;
    }
}
