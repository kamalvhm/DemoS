package com.graph;

import java.util.*;


public class GraphCodec {
    
    // Encode the graph into a list of integers
    public List<Integer> encode(Node node, Map<Integer, Node> graph) {
        List<Integer> encoded = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(node);
        visited.add(node.data);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            encoded.add(curr.data);
            encoded.add(curr.outEdges.size()); // Store the number of edges

            for (int neighbor : curr.outEdges) {
                encoded.add(neighbor);
                if (!visited.contains(neighbor)) {
                    queue.add(graph.get(neighbor));
                    visited.add(neighbor);
                }
            }
        }

        return encoded;
    }

    // Decode the list of integers back to a graph
    public Node decode(List<Integer> encoded) {
        if (encoded.isEmpty()) return null;

        Map<Integer, Node> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;

        while (i < encoded.size()) {
            int nodeId = encoded.get(i++);
            int edgeCount = encoded.get(i++);

            Node node = graph.getOrDefault(nodeId, new Node(nodeId));
            graph.put(nodeId, node);

            for (int j = 0; j < edgeCount; j++) {
                int neighborId = encoded.get(i++);
                Node neighbor = graph.getOrDefault(neighborId, new Node(neighborId));
                graph.put(neighborId, neighbor);

                node.outEdges.add(neighborId);
            }

            queue.add(nodeId);
        }

        return graph.get(encoded.get(0)); // Return the root node
    }

    // Helper function to print the graph
    public static void printGraph(Node node, Map<Integer, Node> graph) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(node);
        visited.add(node.data);
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println("Node: " + curr.data + " -> " + curr.outEdges);
            
            for (int neighbor : curr.outEdges) {
                if (!visited.contains(neighbor)) {
                    queue.add(graph.get(neighbor));
                    visited.add(neighbor);
                }
            }
        }
    }

class Node {
    int data;
    List<Integer> outEdges;

    Node(int data) {
        this.data = data;
        this.outEdges = new ArrayList<>();
    }
}
    //You have a class Node as below how to write endcode and decode method for this graph
    public static void main(String[] args) {
        // Sample graph creation
        Map<Integer, Node> graph = new HashMap<>();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.outEdges.add(2);
        node1.outEdges.add(3);
        node2.outEdges.add(4);
        node3.outEdges.add(4);
        
        graph.put(1, node1);
        graph.put(2, node2);
        graph.put(3, node3);
        graph.put(4, node4);

        GraphCodec codec = new GraphCodec();
        List<Integer> encoded = codec.encode(node1, graph);
        System.out.println("Encoded: " + encoded);

        Node decodedRoot = codec.decode(encoded);
        printGraph(decodedRoot, graph);
    }
}
