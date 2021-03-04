package com.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.lang.Math.min;
//https://www.youtube.com/watch?v=hKhLj7bfDKk&list=PLDV1Zeh2NRsDGO4--qE8yH72HFL1Km93P&index=24
//LeetCode :-1192. Critical Connections in a Network | https://leetcode.com/problems/critical-connections-in-a-network/
public class TarjanSccSolverAdjacencyList {

  private int n;
  private List<List<Integer>> graph;

  private boolean solved;
  private int sccCount, id;
  private boolean[] visited;
  private int[] ids, low, sccs;
  private Deque<Integer> stack;

  private static final int UNVISITED = -1;

  public TarjanSccSolverAdjacencyList(List<List<Integer>> graph) {
    if (graph == null) throw new IllegalArgumentException("Graph cannot be null.");
    n = graph.size();
    this.graph = graph;
  }

  // Returns the number of strongly connected components in the graph.
  public int sccCount() {
    if (!solved) solve();
    return sccCount;
  }

  // Get the connected components of this graph. If two indexes
  // have the same value then they're in the same SCC.
  public int[] getSccs() {
    if (!solved) solve();
    return sccs;
  }

  public void solve() {
    if (solved) return;

    ids = new int[n];
    low = new int[n];
    sccs = new int[n];
    visited = new boolean[n];
    stack = new ArrayDeque<>();
    Arrays.fill(ids, UNVISITED);

    for (int i = 0; i < n; i++) {
      if (ids[i] == UNVISITED) {
        dfs(i);
      }
    }

    solved = true;
  }

  private void dfs(int at) {
    ids[at] = low[at] = id++;
    stack.push(at);
    visited[at] = true;

    for (int to : graph.get(at)) {
      if (ids[to] == UNVISITED) {
        dfs(to);
      }
      if (visited[to]) {//this will allow low link values to propagate through out cycle Its checking if it in the stack
        low[at] = min(low[at], low[to]);
      }
      /*
       TODO(william): investigate whether the proper way to update the lowlinks
       is the following bit of code. From my experience this doesn't seem to
       matter if the output is placed in a separate output array, but this needs
       further investigation.
       if (ids[to] == UNVISITED) {
         dfs(to);
         low[at] = min(low[at], low[to]);
       }
       if (visited[to]) {
         low[at] = min(low[at], ids[to]);
       }
      */

    }
    //after havinf visited all the neighbours of 'at' if we're at the start of SCC empty the seen 
    //stack until we're back to the start of the SCC
    // On recursive callback, if we're at the root node (start of SCC)
    // empty the seen stack until back to root.
    if (ids[at] == low[at]) {
      for (int node = stack.pop(); ; node = stack.pop()) {
        visited[node] = false;
        sccs[node] = sccCount; //which node belongs to which stongly connected componentt
        if (node == at) break;
      }
      sccCount++;
    }
  }

  // Initializes adjacency list with n nodes.
  public static List<List<Integer>> createGraph(int n) {
    List<List<Integer>> graph = new ArrayList<>(n);
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    return graph;
  }

  // Adds a directed edge from node 'from' to node 'to'
  public static void addEdge(List<List<Integer>> graph, int from, int to) {
    graph.get(from).add(to);
  }

  /* Example usage: */

  public static void main(String[] arg) {
    int n = 8;
    List<List<Integer>> graph = createGraph(n);

    addEdge(graph, 6, 0);
    addEdge(graph, 6, 2);
    addEdge(graph, 3, 4);
    addEdge(graph, 6, 4);
    addEdge(graph, 2, 0);
    addEdge(graph, 0, 1);
    addEdge(graph, 4, 5);
    addEdge(graph, 5, 6);
    addEdge(graph, 3, 7);
    addEdge(graph, 7, 5);
    addEdge(graph, 1, 2);
    addEdge(graph, 7, 3);
    addEdge(graph, 5, 0);

    TarjanSccSolverAdjacencyList solver = new TarjanSccSolverAdjacencyList(graph);

    int[] sccs = solver.getSccs();
    Map<Integer, List<Integer>> multimap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (!multimap.containsKey(sccs[i])) multimap.put(sccs[i], new ArrayList<>());
      multimap.get(sccs[i]).add(i);
    }

    // Prints:
    // Number of Strongly Connected Components: 3
    // Nodes: [0, 1, 2] form a Strongly Connected Component.
    // Nodes: [3, 7] form a Strongly Connected Component.
    // Nodes: [4, 5, 6] form a Strongly Connected Component.
    System.out.printf("Number of Strongly Connected Components: %d\n", solver.sccCount());
    for (List<Integer> scc : multimap.values()) {
      System.out.println("Nodes: " + scc + " form a Strongly Connected Component.");
    }
  }
  
  
  
  
  /****************************************LEET CODE PROBLEM ******************************///1192. Critical Connections in a Network
  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
      // Results sets
      List<List<Integer>> criticalConnections = new ArrayList<>();
      
      // Graph
      Map<Integer, List<Integer>> map = new HashMap<>();
      
      // Keep track of visited vertices for dfs
      boolean[] visited = new boolean[n];
      
      // Keep track of Strongly Conected Compoments low-link value
      int[] lowLinkValues = new int[n];
      
      // Keep track of cycles, in dfs we increment and then set time to current lowLinkValues[] & discoverd[] values
      int time = 0;
      
      // Load graph with vertices and connections
      for (List<Integer> connection : connections) {
          // Get [a,b] vertices from connections
          int a = connection.get(0); 
          int b = connection.get(1);
          
          // Intialize [a ,b] in graph if not already
          map.putIfAbsent(a, new ArrayList<>());
          map.putIfAbsent(b, new ArrayList<>());
          
          // Add vertices to each respective List
          map.get(a).add(b);
          map.get(b).add(a);
      }
      
      // Iterate through vertices in map and call dfs on unvisited vertices
      for (int i = 0; i < map.size(); i++) {
          if (!visited[i]) {
              dfs(i, i, visited, lowLinkValues, map, time, criticalConnections);
          }
      }
      
      return criticalConnections;
  }
  
  private void dfs(int currentVertice, int parentVertice, boolean[] visited, int[] lowLinkValues, Map<Integer, List<Integer>> map, int time, List<List<Integer>> criticalConnections) {
      // Increment time per cycle
      time++;
      
      // set current vertice's low link value to cycle time
      lowLinkValues[currentVertice] = time;
      
      // Set discoveredValue to cycle time to avoid comparing 
      int discoverdValue = time;
      
      // Avoid infinite loop
      visited[currentVertice] = true;
      
      // Iterate through edges
      for (int vertice : map.get(currentVertice)) {
          
          // Skip look to avoid comparing in reverse. Ex: if A -> B don't compare B -> A
          if (vertice == parentVertice) continue;
          
          // Process only unique vertices to avoid leaving a strongly connected component
          if (!visited[vertice]) {
              
              dfs(vertice, currentVertice, visited, lowLinkValues, map, time, criticalConnections);
              
              // This means there is an edge that connects strongly connected components
              if (discoverdValue < lowLinkValues[vertice]) {
                  criticalConnections.add(Arrays.asList(currentVertice, vertice));
              }
          }
          
          // Update lowlinkValues
          lowLinkValues[currentVertice] = Math.min(lowLinkValues[currentVertice], lowLinkValues[vertice]);
      }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}