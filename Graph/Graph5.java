import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.html.HTMLIsIndexElement;

public class Graph5 {

    /*
     * Cheapest Flights within K Stops
     * 
     * There are n cities connected by some number of flights. You are given an
     * Array flights where
     * flight[i]=[from,to,price]
     * indicates that there is a flight.
     * you are also given three integers src, and k,return the cheapest price from
     * src to dist with
     * at most k stops if there is no such route, return -1
     * All values are positive
     */
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.dest = d;
            this.src = s;
            this.wt = w;
        }
    }

    public static void createGraph(int flight[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flight.length; i++) {
            graph[flight[i][0]].add(new Edge(flight[i][0], flight[i][1], flight[i][2]));
        }
    }

    static class Info {
        int v, cost, stops;

        public Info(int v, int s, int st) {
            this.cost = s;
            this.stops = st;
            this.v = v;
        }
    }

    public static int cheapestFlight(int n, int flight[][], int src, int dest, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flight, graph);

        int dist[] = new int[n];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = dist[u] + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;

        } else
            return dist[dest];
    }

    public static void main(String[] args) {
        int n = 4;
        int flight[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        System.out.println(cheapestFlight(n, flight, 0, 3, 1));

    }
}
