package app3;



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AdjacencyList
{
    public static class Node
    {
        int depth;
        int distance;
        boolean visited;
       
        public Node(int depth)
        {
            this.depth = depth;
        }
       
        public String toString()
        {
            return "(" + depth + ",d=" + distance + ")";
        }
    }
   
    Map<Node, List<Node>> nodes;

    public AdjacencyList()
    {
        nodes = new HashMap<Node, List<Node>>();
    }
   
    public void addNeighbours(Node n1, Node n2)
    {
        if (nodes.containsKey(n1)) {
            nodes.get(n1).add(n2);
        } else {
            ArrayList<Node> listofNeighbours = new ArrayList<Node>();
            listofNeighbours.add(n2);
            nodes.put(n1, listofNeighbours);
        }
    }
   
    public void bfs(Node s)
    {
        Set<Node> keys = nodes.keySet();
        for (Node u : keys) {
            if (u != s) {
                u.visited = false;
                u.distance = Integer.MAX_VALUE;
            }
        }
        s.visited = true;
        s.distance = 0;
        Queue<Node> q = new ArrayDeque<Node>();
        q.add(s);
        while (!q.isEmpty()) {
            Node u = q.remove();
            List<Node> adj_u = nodes.get(u);
            if (adj_u != null) {
                for (Node v : adj_u) {
                    if (!v.visited) {
                        v.visited = true;
                        v.distance = u.distance + 1;
                        q.add(v);
                    }
                }
            }
            System.out.print("(" + u.depth + ",d=" + u.distance + ")" + " ");
        }
    }
   
    public static void main(String[] args)
    {
        AdjacencyList graph = new AdjacencyList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
       
        graph.addNeighbours(n1, n2);
       
        graph.addNeighbours(n2, n1);
        graph.addNeighbours(n2, n3);
        graph.addNeighbours(n3, n4);
        graph.addNeighbours(n3, n2);
       
        graph.addNeighbours(n4, n3);
        graph.addNeighbours(n4, n5);
        graph.addNeighbours(n4, n6);
       
        graph.addNeighbours(n5, n4);
        graph.addNeighbours(n5, n6);
        graph.addNeighbours(n5, n7);
       
        graph.addNeighbours(n6, n4);
        graph.addNeighbours(n6, n5);
        graph.addNeighbours(n6, n7);
        graph.addNeighbours(n6, n8);
       
        graph.addNeighbours(n7, n5);
        graph.addNeighbours(n7, n6);
        graph.addNeighbours(n7, n8);
       
        graph.addNeighbours(n8, n6);
        graph.addNeighbours(n8, n7);
       
        graph.bfs(n3);

    }
}




