class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        int[] vis = new int[numCourses];

        // 0 = unvisited
        // 1 = visiting (in current recursion)
        // 2 = visited

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < numCourses; i++) {

            if(vis[i] == 0) {

                if(!dfs(adj, vis, stack, i)) {
                    return new int[0];
                }
            }
        }

        int[] res = new int[numCourses];

        int index = 0;

        while(!stack.isEmpty()) {
            res[index++] = stack.pop();
        }

        return res;
    }

    private boolean dfs(
        List<List<Integer>> adj,
        int[] vis,
        Stack<Integer> stack,
        int node
    ) {

        if(vis[node] == 1) {
            return false;
        }

        if(vis[node] == 2) {
            return true;
        }

        vis[node] = 1;

        for(int nei : adj.get(node)) {
            if(!dfs(adj, vis, stack, nei)) {
                return false;
            }
        }

        vis[node] = 2;
        stack.push(node);

        return true;
    }
}