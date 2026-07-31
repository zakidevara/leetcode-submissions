class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        int left = 0;
        int right = 0;
        while (right < path.length() && left < path.length()) {
            while (left < path.length() && path.charAt(left) == '/') {
                left++;
            }
            right = left;

            while (right < path.length() && path.charAt(right) != '/') {
                right++;
            }

            String currDir = path.substring(left, right);

            if (currDir.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!currDir.isEmpty() && !currDir.equals(".")) {
                stack.push(currDir);
            }
            left = right + 1;
        }

        List<String> list = new LinkedList<>();
        while (!stack.isEmpty()) {
            list.addFirst(stack.pop());
        }


        return "/" + String.join("/", list);
    }
}
