import java.util.*;

public class DFSExample {
    public static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " "); // Process the current node
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);

        System.out.println("DFS Traversal:");
        boolean[] visited = new boolean[n];
        dfs(0, graph, visited); // Start DFS from node 0
    }
}
