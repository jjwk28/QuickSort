
public class Node<E> {
	private E item;
	private Node<E> next;
	
	public Node(E item, Node<E> node) {
		this.item = item;
		next = node;
	}

	E getItem() {
		return item;
	}

	Node<E> getNext() {
		return next;
	}

	void setItem(E item) {
		this.item = item;
	}

	void setNext(Node<E> next) {
		this.next = next;
	}
	
}
