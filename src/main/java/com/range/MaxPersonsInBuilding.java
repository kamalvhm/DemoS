package com.range;

import java.util.Map;
import java.util.TreeMap;

class MaxPersonsInBuilding {
	/**
	 * 
	 	Inserting into TreeMap  O(N log N) (N events, each insertion takes O(log N))
		Iterating through TreeMap  O(N)
		Total Complexity: O(N log N) (due to sorting)
	 */
    public static int findMaxPersons(int[][] events) {
        TreeMap<Integer, Integer> timeline = new TreeMap<>();

        // Process events and update the timeline
        for (int[] event : events) {
            int timeStamp = event[2];
            boolean eventType = event[1]==1?true:false;

            // +1 for entry, -1 for exit
            timeline.put(timeStamp, timeline.getOrDefault(timeStamp, 0) + (eventType ? 1 : -1));
        }

        // Finding the maximum number of persons in the building
        int maxPersons = 0, currentCount = 0, maxTime = -1;

        for (Map.Entry<Integer, Integer> entry : timeline.entrySet()) {
            currentCount += entry.getValue(); // Update current count
            if (currentCount > maxPersons) {
                maxPersons = currentCount;
                maxTime = entry.getKey();
            }
        }

        System.out.println("Maximum persons in the building: " + maxPersons + " at time " + maxTime);
        return maxPersons;
    }

    public static void main(String[] args) {
        int[][] events = {
            {1, 1, 1},  // Person1 enters at time 1
            {3, 1, 3},  // Person3 enters at time 3
            {2, 1, 2},  // Person2 enters at time 2
            {4, 1, 4},  // Person4 enters at time 4
            {1, 0, 5}, // Person1 exits at time 5
            {2, 0, 5}  // Another person2 exits at time 5
        };

        findMaxPersons(events);
    }
    
/**    Sorting the list of timestamps: O(N log N)
		Processing the sorted events (single pass): O(N)
		Total Complexity: O(N log N)
    public static int findMaxPersons(int[][] events) {
        List<int[]> timeline = new ArrayList<>();

        // Convert events into (timestamp, +1 for entry / -1 for exit)
        for (int[] event : events) {
            int timeStamp = event[2];
            boolean eventType = event[1];

            timeline.add(new int[]{timeStamp, eventType ? 1 : -1});
        }

        // Sort by time, if times are same, prioritize exit (-1) before entry (+1)
        timeline.sort((a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        // Finding the maximum number of persons in the building
        int maxPersons = 0, currentCount = 0, maxTime = -1;

        for (int[] entry : timeline) {
            currentCount += entry[1]; // Update running count
            if (currentCount > maxPersons) {
                maxPersons = currentCount;
                maxTime = entry[0];
            }
        }

        System.out.println("Maximum persons in the building: " + maxPersons + " at time " + maxTime);
        return maxPersons;
    }  */
}