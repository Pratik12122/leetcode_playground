package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;

// Link : https://leetcode.com/problems/task-scheduler/description/
public class TaskScheduler {

	public static void main(String[] args) {
		char[] tasks = { 'A','A','A','B','B','B' };

		System.out.println(leastInterval(tasks, 2));
	}
	
	 public static int leastInterval(char[] tasks, int n) {
	        // Step 1: Calculate frequency of each task
	        Map<Character, Integer> taskCount = new HashMap<>();
	        for (char task : tasks) {
	            taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
	        }
	        
	        // Step 2: Create a max heap to prioritize tasks by frequency
	        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	        maxHeap.addAll(taskCount.values());
	        
	        // Step 3: Process tasks and cooldown periods
	        int intervals = 0;
	        while (!maxHeap.isEmpty()) {
	            List<Integer> cooldown = new ArrayList<>();
	            
	            // Execute tasks up to n + 1 tasks (n + 1 is the interval)
	            for (int i = 0; i < n + 1; i++) {
	                if (!maxHeap.isEmpty()) {
	                    int count = maxHeap.poll();
	                    if (count > 1) {
	                        cooldown.add(count - 1);
	                    }
	                }
	                intervals++;
	                
	                // Break if no more tasks to schedule
	                if (maxHeap.isEmpty() && cooldown.isEmpty()) {
	                    break;
	                }
	            }
	            
	            // Add the cooldown tasks back to the heap
	            maxHeap.addAll(cooldown);
	        }
	        
	        return intervals;
	    }
	
	
	
	
	

	public static int leastInterval_Me(char[] tasks, int n) {

		var charCountMap = new String(tasks).chars() // Convert char array to String for stream creation
				.mapToObj(c -> (char) c) // Convert int (from chars()) back to char
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream() // Stream
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().intValue()));

		PriorityQueue<Character> maxHeap = new PriorityQueue<Character>(
				(a, b) -> charCountMap.get(b) - charCountMap.get(a));

		for (Character ch : charCountMap.keySet()) {
			maxHeap.offer(ch);
		}
		int timeOfExecution = 1;

		var lastTimeTaskExecutionMap = new HashMap<Character, Integer>();

		while (!maxHeap.isEmpty()) {
			Character task = maxHeap.poll();
			if (lastTimeTaskExecutionMap.containsKey(task)) {
				int lastExecutedTime = lastTimeTaskExecutionMap.get(task);

				if (timeOfExecution - lastExecutedTime > n) {
					timeOfExecution = executeTask(charCountMap, maxHeap, timeOfExecution, lastTimeTaskExecutionMap,
							task);
				} else {
					var pendingTastList = new ArrayList<Character>();
					pendingTastList.add(task);
					boolean isNextTaskExecuted = false;

					while (!isNextTaskExecuted && !maxHeap.isEmpty()) {
						var nextTask = maxHeap.poll();
						if (!lastTimeTaskExecutionMap.containsKey(nextTask)) {
							timeOfExecution = executeTask(charCountMap, maxHeap, timeOfExecution,
									lastTimeTaskExecutionMap, nextTask);
							isNextTaskExecuted = true;
						} else {
							int lastExecutedTimeOfNextTask = lastTimeTaskExecutionMap.get(nextTask);

							if (timeOfExecution - lastExecutedTimeOfNextTask > n) {
								timeOfExecution = executeTask(charCountMap, maxHeap, timeOfExecution,
										lastTimeTaskExecutionMap, nextTask);
								isNextTaskExecuted = true;
							} else {
								pendingTastList.add(nextTask);
							}
						}
					}
					if (!isNextTaskExecuted) {
						timeOfExecution++;
					}
					maxHeap.addAll(pendingTastList);
				}
			} else {
				timeOfExecution = executeTask(charCountMap, maxHeap, timeOfExecution, lastTimeTaskExecutionMap, task);
			}

		}

		return timeOfExecution - 1;
	}

	private static int executeTask(Map<Character, Integer> charCountMap, PriorityQueue<Character> maxHeap,
			int timeOfExecution, HashMap<Character, Integer> lastTimeTaskExecutionMap, Character task) {
		lastTimeTaskExecutionMap.put(task, timeOfExecution++);
		charCountMap.put(task, charCountMap.get(task) - 1);

		if (charCountMap.get(task) > 0) {
			maxHeap.add(task);
		}
		return timeOfExecution;
	}

}
