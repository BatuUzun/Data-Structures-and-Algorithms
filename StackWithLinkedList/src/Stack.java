import java.util.EmptyStackException;

public class Stack {
	Node top;
	int size = 0;

	public void push(int data) {
		Node n = new Node(data);

		size++;
		n.next = top;
		top = n;
	}

	public int pop() {

		if (top != null) {
			int value = top.data;

			top = top.next;
			return value;
		} else {
			throw new EmptyStackException();
		}
	}
	
	public int peek() {
		if(top != null) {
			return top.data;
		}
		else {
			throw new EmptyStackException();
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		top = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(int data) {
		Node n = top;
		while(n != null) {
			if(n.data == data) {
				
				return true;
			}
			n = n.next;
		}
		return false;
	}
	
	public int search(int data) {
		int index = 0;
		
		Node n = top;
		while(n != null) {
			if(n.data == data) {
				return index;
			}
			index++;
			n = n.next;
		}
		
		return -1;
	}
	
	public void reverse() {
		Node previous = null, next, current = top;
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		top = previous;
	}
	
	@Override
	public String toString() {
		String output = "";
		Node n = top;
		while (n != null) {
			output += n.data + "\n";
			n = n.next;
		}

		return output;
	}

}
