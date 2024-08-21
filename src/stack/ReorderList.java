package stack;

import java.util.List;
import java.util.Stack;

public class ReorderList {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4, 5 };
		ListNode head = ListNode.toLinkedList(nums);

		reorderList(head);
		ListNode.printLinkedList(head);
	}

	public static void reorderList(ListNode head) {
		
		
		ListNode start = head;
		ListNode end = head;
		
		var stack = new Stack<ListNode>();
		
		
		while(end != null) {
			stack.add(end);
			end = end.next;
		}
		
		int size = stack.size()/2;
		
		int count = 0;
		
		while(count < size) {
			ListNode next = start.next;
			ListNode last = stack.pop();
			
			start.next = last;
			last.next = next;
			start = next;
			count++;
		}
		
		start.next = null;
		
	}

}
