
public class NLinkedList<E> {
	private Node<E> start; // �� ���� ���
	private Node<E> end; // �� �������� ���
	private int size;
	
	public NLinkedList() {
		this.start = null;
		this.end = null;
		this.size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public Node<E> searchIndex(int idx) { // idx ��ġ�� node�� ��ȯ
		Node<E> node = start;
		
		for(int i = 0; i < idx; i++) {
			node = node.getNext();
		}
		return node;
	}
	
	public void addFirst(E data) { // �� �տ� data ���� �߰�
		Node<E> node = new Node<E>(data, start);
		start = node;
		size++;
		
		if(start.getNext() == null) {
			end = start;
		}
	}
	
	public void addLast(E data) { // �� �������� data ���� �߰�
		Node<E> node = new Node<E>(data, null);
		
		if(size() == 0) {
			addFirst(data);
			return;
		}
		end.setNext(node);
		end = node;
		size++;
	}
	
	public void add(int idx, E data) { // idx ��ġ�� data ���� �߰�
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
	
	public E remove(int idx) { // idx ��ġ�� ����� ���� ����
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
	
	public E get(int idx) { // idx ��ġ�� ����� ���� ��ȯ
		return searchIndex(idx).getItem();
	}
}
