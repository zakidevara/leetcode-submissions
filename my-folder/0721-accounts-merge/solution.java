class Solution {

    Map<String, List<String>> adjacent = new HashMap<String, List<String>>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // build adjacency list
        for (List<String> account : accounts) {
            String accountFirstEmail = account.get(1);

            for (int j = 2; j < account.size(); j++) {
                String accountEmail = account.get(j);
                
                adjacent.computeIfAbsent(accountFirstEmail, key -> new ArrayList<>()).add(accountEmail);
                adjacent.computeIfAbsent(accountEmail, key -> new ArrayList<>()).add(accountFirstEmail);
            }
        }

        // traverse over all accounts to merge accounts
        Set<String> visited = new HashSet<>();
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accounts) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);

            if (!visited.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();

                mergedAccount.add(accountName);
                dfs(mergedAccount, accountFirstEmail, visited);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }

        return mergedAccounts;
    }

    private void dfs(List<String> mergedAccount, String email, Set<String> visited) {
        visited.add(email);
        mergedAccount.add(email);

        if (!adjacent.containsKey(email)) return;

        for (String neighbor : adjacent.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(mergedAccount, neighbor, visited);
            }
        }
    }
}
