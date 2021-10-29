
public class NLinkedList<E> {
	private Node<E> start; // 맨 앞의 노드
	private Node<E> end; // 맨 마지막의 노드
	private int size;
	
	public NLinkedList() {
		this.start = null;
		this.end = null;
		this.size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public Node<E> searchIndex(int idx) { // idx 위치의 node를 반환
		Node<E> node = start;
		
		for(int i = 0; i < idx; i++) {
			node = node.getNext();
		}
		return node;
	}
	
	public void addFirst(E data) { // 맨 앞에 data 값을 추가
		Node<E> node = new Node<E>(data, start);
		start = node;
		size++;
		
		if(start.getNext() == null) {
			end = start;
		}
	}
	
	public void addLast(E data) { // 맨 마지막에 data 값을 추가
		Node<E> node = new Node<E>(data, null);
		
		if(size() == 0) {
			addFirst(data);
			return;
		}
		end.setNext(node);
		end = node;
		size++;
	}
	
	public void add(int idx, E data) { // idx 위치에 data 값을 추가
		if(idx == 0) {
			addFirst(data);
			return;
		}
		if(idx == size()) {
			addLast(data);
			return;
		}
		
		Node<E> prev = searchIndex(idx - 1);
		Node<E> now = prev.getNext();
		Node<E> n = new Node<E>(data, now);
		
		prev.setNext(null);
		prev.setNext(n);
		size++;
	}
	
	public E remove(int idx) { // idx 위치에 저장된 값을 삭제
		if(idx == 0) {
			E temp = start.getItem();
			Node<E> node = start.getNext();
			start.setNext(null);
			start.setItem(null);
			start = node;
			size--;
			
			if(size() == 0) {
				end = null;
			}
			return temp;
		}
		
		Node<E> prev = searchIndex(idx - 1);
		Node<E> now = prev.getNext();
		Node<E> n = now.getNext();
		E temp = now.getItem();
		
		if(idx == size()-1) {
			prev.setNext(null);
			end = prev;
		}
		else {
			prev.setNext(n);
		}
		
		now.setNext(null);
		now.setItem(null);
		size--;
		return temp;
	}
	
	public E get(int idx) { // idx 위치에 저장된 값을 반환
		return searchIndex(idx).getItem();
	}
}
