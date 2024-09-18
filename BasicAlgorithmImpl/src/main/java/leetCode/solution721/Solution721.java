package leetCode.solution721;

import java.util.*;

public class Solution721 {
    Set<String> visited = new HashSet<>();
    Map<String, List<String>> adjacent = new HashMap<>();

    private void DFS(List<String> mergedAccount, String email) {
        visited.add(email);
        mergedAccount.add(email);
        if (!adjacent.containsKey(email)) {
            return;
        }
        for (String neighbour : adjacent.get(email)) {
            if (!visited.contains(neighbour)) {
                DFS(mergedAccount, neighbour);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accountListSize = accounts.size();

        for (List<String> account : accounts) {
            int accountSize = account.size();

            String accountFirstEmail = account.get(1);
            for (int j = 2; j < accountSize; j++) {
                String accountEmail = account.get(j);
                if (!adjacent.containsKey(accountFirstEmail)) {
                    adjacent.put(accountFirstEmail, new ArrayList<>());
                }
                adjacent.get(accountFirstEmail).add(accountEmail);
                if (!adjacent.containsKey(accountEmail)) {
                    adjacent.put(accountEmail, new ArrayList<>());
                }
                adjacent.get(accountEmail).add(accountFirstEmail);
            }
        }
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accounts) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);

            if (!visited.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(accountName);
                DFS(mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }
        return mergedAccounts;
    }
}
