class Solution {
    public String simplifyPath(String path) {
        List<String> stack = new ArrayList<>();
        int previousSlashIdx = 0;

        if (!path.endsWith("/")) path += "/";

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {

                String token = path.substring(previousSlashIdx+1, i);
                if (i - previousSlashIdx == 1) {
                    // do nothing
                } else if ("..".equals(token)) {
                    if (stack.size() > 0) stack.remove(stack.size()-1);
                } else if (!".".equals(token)){
                    stack.add(path.substring(previousSlashIdx+1, i));
                }
                previousSlashIdx = i;
            }
        }

        return constructPath(stack);
    }

    private String constructPath(List<String> stack) {
        String result = "";
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i) != null) result += "/" + stack.get(i);
        }
        return result.isEmpty() ? "/" : result;
    }
}
