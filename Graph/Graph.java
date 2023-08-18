import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 8));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 8));

        graph[4].add(new Edge(4, 2, 2));
    }

    public static void bfs(ArrayList<Edge>[] graph) {// O(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {// (O(E+V))
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    // for given src nd dest, tell if a path exists from src to dest

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {// O(V+E)
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        // for (int i = 0; i < V; i++) {
        // graph[i] = new ArrayList<>();
        // }

        // graph[0].add(new Edge(0, 1, 5));

        // graph[1].add(new Edge(1, 0, 5));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[1].add(new Edge(1, 3, 3));

        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 3, 8));
        // graph[2].add(new Edge(2, 4, 2));

        // graph[3].add(new Edge(3, 1, 3));
        // graph[3].add(new Edge(3, 2, 8));

        // graph[4].add(new Edge(4, 2, 2));

        // for (int i = 0; i < graph[2].size(); i++) {
        // Edge e = graph[2].get(i);
        // System.out.println(e.dest);
        // }
        createGraph(graph);
        // bfs(graph);
        dfs(graph, 0, new boolean[V]);

        System.out.println();
        System.out.println(hasPath(graph, 0, 12, new boolean[V]));
    }
}