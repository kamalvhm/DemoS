package com.graph;

import java.util.*;

import java.util.*;


class Node {
    int data;
    List<Node> outEdges;

    Node(int data) {
        this.data = data;
        this.outEdges = new ArrayList<>();
    }
}

public class GraphCodec {
	
    // Encode the graph into a list of integers
    public List<Integer> encode(Node node) {
        List<Integer> encoded = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
       // Map<Integer, Node> nodeMap = new HashMap<>();

        queue.add(node);
        visited.add(node.data);
       // nodeMap.put(node.data, node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            encoded.add(curr.data);
            encoded.add(curr.outEdges.size()); // Store number of outgoing edges

            for (Node neighbor : curr.outEdges) {
                encoded.add(neighbor.data); // Store neighbor's data
                if (!visited.contains(neighbor.data)) {
                    visited.add(neighbor.data);
                    queue.add(neighbor);
                   // nodeMap.put(neighbor.data, neighbor);
                }
            }
        }

        return encoded;
    }

    // Decode the list of integers back to a graph
    public Node decode(List<Integer> encoded) {
        if (encoded.isEmpty()) return null;

        Map<Integer, Node> nodeMap = new HashMap<>();
        int i = 0;

        while (i < encoded.size()) {
            int nodeId = encoded.get(i++);
            int edgeCount = encoded.get(i++);

            // Get or create the node
            Node node = nodeMap.computeIfAbsent(nodeId, Node::new);

            for (int j = 0; j < edgeCount; j++) {
                int neighborId = encoded.get(i++);
                
                // Get or create the neighbor node
                Node neighbor = nodeMap.computeIfAbsent(neighborId, Node::new);

                // **Fix: Correctly link nodes together**
                node.outEdges.add(neighbor);
            }
        }

        return nodeMap.get(encoded.get(0)); // Return the root node
    }

    // Helper function to print the graph
    public static void printGraph(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(node);
        visited.add(node.data);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print("Node " + curr.data + " -> [");
            for (Node neighbor : curr.outEdges) {
                System.out.print(neighbor.data + " ");
                if (!visited.contains(neighbor.data)) {
                    queue.add(neighbor);
                    visited.add(neighbor.data);
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        // Sample graph creation
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.outEdges.add(node2);
        node1.outEdges.add(node3);
        node2.outEdges.add(node4);
        node3.outEdges.add(node4);

        GraphCodec codec = new GraphCodec();
        List<Integer> encoded = codec.encode(node1);
        System.out.println("Encoded: " + encoded);

        Node decodedRoot = codec.decode(encoded);
        printGraph(decodedRoot);
    }
}
