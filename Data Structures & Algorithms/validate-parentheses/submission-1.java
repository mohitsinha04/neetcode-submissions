class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else if ((stack.peek() == '(' && c != ')') ||
                        (stack.peek() == '{' && c != '}') ||
                        (stack.peek() == '[' && c != ']')) return false;
                stack.poll();
            }
        }
        return stack.isEmpty();
    }
}
