package app2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class App2
{
    public static class Node
    {
        int no;
        int depth;
        boolean visited;
       
        public Node(int depth)
        {
            this.no = depth;
        }
    }
   
    Map<Node, List<Node>> nodes;

    public App2()
    {
        nodes = new HashMap<Node, List<Node>>();
    }
   
    public void addFunc(Node n1, Node n2)
    {
        if (nodes.containsKey(n1)) {
            nodes.get(n1).add(n2);
        } else {
            ArrayList<Node> list = new ArrayList<Node>();
            list.add(n2);
            nodes.put(n1, list);
        }
    }
   
    public void search(Node s)
    {
        Set<Node> keys = nodes.keySet();
        for (Node u : keys) {
            if (u != s) {
                u.visited = false;
                u.depth = 1000;
            }
        }
        s.visited = true;
        s.depth = 0;
        Queue<Node> q = new ArrayDeque<Node>();
        q.add(s);
        while (!q.isEmpty()) {
            Node u = q.remove();
            List<Node> c = nodes.get(u);
            if (c != null) {
                for (Node v : c) {
                    if (!v.visited) { 
                        v.visited = true;
                        v.depth = u.depth + 1;
                        q.add(v);
                    }
                }
            }
            System.out.print("(Node:" + u.no + ", depth=" + u.depth + ")" + " ");
        }
    }
   
    public static void main(String[] args)
    {
        App2 app3 = new App2();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
       
        app3.addFunc(n2, n1);
        app3.addFunc(n3, n4);
        app3.addFunc(n3, n2);
        app3.addFunc(n4, n5);
        app3.addFunc(n4, n6);
        app3.addFunc(n6, n7);
        app3.addFunc(n6, n8);
        app3.search(n3);

    }
}

