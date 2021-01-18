package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge20210118 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> unionSet = new HashMap<>();
        Map<String, String> mailToName = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstMail = null;
            for (int i = 1; i < account.size(); i++) {
                String mail = account.get(i);
                mailToName.put(mail, name);
                if (!unionSet.containsKey(mail)) {
                    unionSet.put(mail, mail);
                }
                if (firstMail == null) {
                    firstMail = mail;
                } else {
                    merge(unionSet, firstMail, mail);
                }
            }
        }
        Map<String, List<String>> groups = new HashMap<>();
        for (String mail : unionSet.keySet()) {
            String root = findRoot(unionSet, mail);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(mail);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> value : groups.values()) {
            List<String> copy = new ArrayList<>(value);
            copy.sort(String::compareTo);
            copy.add(0, mailToName.get(copy.get(0)));
            result.add(copy);
        }
        return result;
    }

    private void merge(Map<String, String> unionSet, String mail1, String mail2) {
        String root1 = findRoot(unionSet, mail1);
        String root2 = findRoot(unionSet, mail2);
        unionSet.put(root1, root2);
    }

    private String findRoot(Map<String, String> unionSet, String mail) {
        String find = mail;
        while (!unionSet.get(find).equals(find)) {
            find = unionSet.get(find);
        }
        unionSet.put(mail, unionSet.get(find));
        return find;
    }
}
