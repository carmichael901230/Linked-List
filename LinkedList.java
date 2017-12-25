class LinkedList implements Collection {
	private Node head;
	private Node tail;
	private int size;
  
	public LinkedList() {
		Node dummy = new Node(-1,null);
		head = dummy;
		tail = dummy;
		size = 0;
	}

	public void insert(int index, int data) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index... List Size: " + size);
		}
		else if (head == tail) {
			this.append(data);
		}
		else if (index == size) {
			this.append(data);
		}
		else {
			Node curr = head;
			for (int i = 0; i < index; i++) {
				curr = curr.getNext();
			}
			curr.setNext(new Node(data, curr.getNext()));
			size ++;
		}
	}

	public void append(int data) {
		Node temp = new Node(data);
		tail.setNext(temp);
		tail = tail.getNext();
		size ++;
	}

	public void prepend(int data) {
		if (head == tail) {
			this.append(data);
		}
		else {
			Node temp = new Node(data, head.getNext());
			head.setNext(temp);
			size ++;
		}
	}

	public int get(int index) {
		Node curr = head;
		if (index > size-1 || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index... List Size: " + size);
		}
		else {
			for (int i = 0; i<=index; i++) {
				curr = curr.getNext();
			}
		}
		return curr.getData();
	}

	public int getFirst() {
		Node temp = head.getNext();
		if (temp == null) {
			throw new NullPointerException("Getting element from empty list");
		}
		else {
			return temp.getData();
		}
	}

	public int getLast() {
		if (tail == head) {
			throw new NullPointerException("Getting element from empty list");
		}
		else {
			return tail.getData();
		}
	}

	public void remove(int index) {
		if (head == tail) {
			throw new NullPointerException("Deleting element from emtpy list");
		}
		else if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index... List Size: " + size);
		}
		else if (index == size-1) {
			this.removeLast();
		}
		else {
			Node curr = head;
			for (int i = 0; i<index; i++) {
				curr = curr.getNext();
			}
			curr.setNext(curr.getNext().getNext());
			size --;
		}	
	}

	public void removeFirst() {
		if (head == tail) {
			throw new NullPointerException("Deleting element from empty list");
		}
		else if (size == 1) {
			tail = head;
			head.setNext(null);
			size --;
		}
		else {
			head.setNext(head.getNext().getNext());
			size --;
		}
	}

	public void removeLast() {
		if (head == tail) {
			throw new NullPointerException("Deleting element from empty list");
		}
		else {
			Node curr = head;
			while (curr.getNext().getNext() != null) {
				curr = curr.getNext();
			}
			tail = curr;
			tail.setNext(null);
			size --;
		}
	}

	public int size() {
		return size;
	}
  
	public void showList() {
		for (Node p = head.getNext(); p != null;) {
			System.out.print(p.getData() + " ");
			p = p.getNext();
		}
		System.out.println("\nSize: " + this.size());
		System.out.println("Tail: " + this.tail.getData());
	}
}