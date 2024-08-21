package stack;

public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	static ListNode toLinkedList(int[] arrays) {
		ListNode dummyHead = new ListNode(0);
		ListNode current = dummyHead;

		for (int val : arrays) {
			current.next = new ListNode(val);
			current = current.next;
		}

		return dummyHead.next;
	}
	
	
	static void printLinkedList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + "]";
	}
	
	
}
