package doublylinklist;

class Node {
	int data;
	Node prev;
	Node next;

	public Node(int data) {

		this.data = data;
		this.prev = null;
		this.next = null;
	}

}

class DoublelinkedList {
	Node head;
	Node tail;

	void print() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();

	}

	void printRevers() {
		Node curr = this.tail;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.prev;
		}
		System.out.println();

	}

	void add(int element) {
		Node temp = new Node(element);
		if (head == null) {
			head = temp;
			tail = temp;
		} else {
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}
	}

	void addFirst(int element) {
		Node temp = new Node(element);
		if (head == null) {
			this.head = temp;
			this.tail = temp;
		} else {
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
	}

	void add(int index, int element) {
		Node temp = new Node(element);
		int count = 0;
		Node curr = this.head;
		while (count < index - 1) {
			curr = curr.next;
			count++;
		}
		curr.next.prev = temp;
		temp.next = curr.next;
		curr.next = temp;
		temp.prev = curr;
	}

	void addAll(int[] elements) {
		for (int element : elements) {
			this.add(element);
		}
	}

	void removeFirst() {
		if (head == null) {

		} else if (head.next == null) {
			head = null;
			tail = null;
		} else if (head.next != null) {
			Node curr = head;
            head=head.next;
            curr.next=null;
            head.prev=null;
		}
	}
	void removelast() {
		if (head == null) {

		} else if (head.next == null) {
			head = null;
			tail = null;
		} else if (head.next != null) {
			Node curr = tail;
            tail=tail.prev;
            curr.prev=null;
            tail.next=null;
		}
	}
}

public class DoublyLinkList {

	public static void main(String[] args) {
		DoublelinkedList dll = new DoublelinkedList();
		dll.add(5);
		dll.add(15);
		dll.add(20);
		dll.add(10);
////		dll.addFirst(100);
//		dll.add(3, 100);
////		System.out.println(dll.head.data);
////		System.out.println(dll.tail.data);
//		dll.print();
////		dll.printRevers();
//		int[] ar = { 100, 200, 300, 400 };
//		dll.addAll(ar);
		
		dll.print();
		dll.removelast();
		dll.print();

	}

}
