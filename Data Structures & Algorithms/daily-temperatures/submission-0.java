class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       int[] res = new int[temperatures.length];
       Deque<Integer> stack = new ArrayDeque<>();

       for (int i = 0; i < temperatures.length; i++) {
        while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            res[stack.peek()] = i - stack.peek();
            stack.poll();
        }
        stack.push(i);
       }
       return res;
    }
}
