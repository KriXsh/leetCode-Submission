import java.util.*;

// Class to demonstrate BFS on a graph
public class BFSExample {
    // BFS function to traverse the graph from a starting node
    public static void bfs(int start, List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n]; // Track visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS traversal
        
        // Step 1: Add the starting node to the queue and mark it as visited
        visited[start] = true;
        queue.add(start);
        
        // Step 2: BFS loop
        while (!queue.isEmpty()) {
            // Dequeue the front node
            int node = queue.poll();
            System.out.print(node + " "); // Process the current node
            
            // Step 3: Visit all unvisited neighbors
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) { // If the neighbor is not visited
                    visited[neighbor] = true; // Mark as visited
                    queue.add(neighbor); // Enqueue the neighbor
                }
            }
        }
    }

    public static void main(String[] args) {
        // Number of nodes in the graph
        int n = 5;

        // Step 1: Create an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Add edges to the graph (Undirected Graph Example)
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);
        graph.get(3).add(1);
        graph.get(4).add(1);
        graph.get(2).add(0);
        graph.get(1).add(0);

        // Step 3: Start BFS traversal
        System.out.println("BFS Traversal starting from node 0:");
        bfs(0, graph, n); // Start BFS from node 0
    }
}
