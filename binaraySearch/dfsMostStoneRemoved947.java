import java.util.*;

class dfsMostStoneRemoved947 {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = buildGraph(stones);
        int connectedComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                connectedComponents++;
            }
        }

        return n - connectedComponents;
    }

    // Build the graph where edges exist between stones that share the same row or column
    private List<List<Integer>> buildGraph(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int row = stones[i][0];
            int col = stones[i][1];

            if (!rowMap.containsKey(row)) {
                rowMap.put(row, new ArrayList<>());
            }
            if (!colMap.containsKey(col)) {
                colMap.put(col, new ArrayList<>());
            }

            rowMap.get(row).add(i);
            colMap.get(col).add(i);
        }

        for (List<Integer> indices : rowMap.values()) {
            for (int i = 1; i < indices.size(); i++) {
                graph.get(indices.get(0)).add(indices.get(i));
                graph.get(indices.get(i)).add(indices.get(0));
            }
        }

        for (List<Integer> indices : colMap.values()) {
            for (int i = 1; i < indices.size(); i++) {
                graph.get(indices.get(0)).add(indices.get(i));
                graph.get(indices.get(i)).add(indices.get(0));
            }
        }

        return graph;
    }

    // Perform DFS to mark all nodes in the same connected component
    private void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                for (int neighbor : graph.get(current)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
