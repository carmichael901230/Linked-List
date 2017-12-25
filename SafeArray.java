class SafeArray implements Collection {
	private int size;
	private int capacity;
	private int[] arr;
	
	public SafeArray() {
		size = 0;
		capacity = 1;
		arr = new int[1];
	}
	
	private void grow() {
		int[] newArr = new int[capacity*2];
		for (int i = 0; i<size; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
		capacity *= 2;
	}
	
	private void shrink() {
		int[] newArr = new int[capacity/2];
		for (int i = 0; i<size; i ++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
		capacity /= 2;
	}
	

	public void insert(int index, int data) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index... List Size: " + size);
		}
		else {
			if (size+1 >= capacity) {
				this.grow();
			}
			int i;
			for (i = size-1; i>=index; i--) {
				arr[i+1] = arr[i];
			}
			arr[i+1] = data;
			size ++;
		}
	}

	public void append(int data) {
		if (size+1 >= capacity) {
			this.grow();
		}
		arr[size] = data;
		size ++;
	}
	
	
	public void prepend(int data) {
		if (size+1 >= capacity) {
			this.grow();
		}
		for (int i = size-1; i>=0; i--) {
			arr[i+1] = arr[i];
		}
		arr[0] = data;
		size ++;
		
	}

	public int get(int index) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index... List Size: " + size);
		}
		else {
			return arr[index];
		}
	}
	
	public int getFirst() {
		if (size == 0) {
			throw new NullPointerException("Getting element from empty list");
		}
		return arr[0];
	}
	
	public int getLast() {
		if (size == 0) {
			throw new NullPointerException("Getting element from empty list");
		}
		return arr[size-1];
	}
	
	public void remove(int index) {
		if (size == 0) {
			throw new NullPointerException("Deleting element from emtpy list");
		}
		else if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index... List Size: " + size);
		}
		for (int i = index; i<size; i++) {
			arr[i] = arr[i+1];
		}
		size --;
		if (size < capacity/2) this.shrink();
	}
	
	public void removeFirst() {
		if (size == 0) {
			throw new NullPointerException("Deleting element from empty list");
		}
		else {
			for (int i = 1; i<size; i++) {
				arr[i-1] = arr[i];
			}
			size --;
			if (size < capacity/2) this.shrink();
		}
		
	}
	
	public void removeLast() {
		if (size == 0) {
			throw new NullPointerException("Deleting element from empty list");
		}
		else {
			size --;
			if (size < capacity/2) this.shrink();
		}
		
	}
	
	public void showList() {
		for (int i = 0; i<size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\nSize: " + this.size());
		System.out.println("Cap: " + this.capacity);
	}
	
	public int size() {
		return size;
	}
}
