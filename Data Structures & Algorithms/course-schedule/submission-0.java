class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int[] p : prerequisites) {
            int a = p[0];
            int b = p[1];

            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
            inDegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            if (graph.containsKey(curr)) {
                for (int adj : graph.get(curr)) {
                    inDegree[adj]--;
                    if (inDegree[adj] == 0) {
                        q.offer(adj);
                    }
                }
            }
        }

        return res.size() == numCourses;
    }
}
