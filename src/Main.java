import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int idx = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("[�� �ܰ躰 ���İ���� ����ϰ�, ���� ������ ���� ���� ��� �������� ���]");
		System.out.print("10���� ���ڸ� �Է��Ͻÿ� > ");
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[10]; // 10���� ���ڸ� �Է¹޵��� ũ�� 10�� �迭 ����
		for(int i = 0; i < 10; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println();
		
		// ��ũ�帮��Ʈ ��� ���
		NLinkedList<Integer> list = new NLinkedList<>();
		for(int i = 0; i < 10; i++) {
			list.add(i, a[i]); // i��° �ε����� a[i]�� ����
		}
		
		int L = 0; // ���� �� ���� ��ġ
		int R = list.size()-1; // ������ �� ���� ��ġ
		
		// �� ���� ������ ���� ū �ٽ��� '���'
		// quickSort�� list�� ������ �� �������ش�.
		quickSort(list, L, R);
		
		System.out.print("�� ���� ��� >> ");
		show(list);
	}
	static void quickSort(NLinkedList<Integer> list, int L, int R) {
		if(L >= R) { // L�� R���� ū ��쿡�� ���� X
			return;
		}
		
		System.out.println(++idx + "�ܰ� > ");
		int tmp = partition(list, L, R); // tmp���� �������� �ΰ��� �κ��������� �����Ͽ� ����
		quickSort(list, L, tmp-1); // L���� tmp-1������ ���
		quickSort(list, tmp+1, R); // tmp+1���� R������ ���
	}
	static void swap(NLinkedList<Integer> list, int a, int b) { // a�� b�� ��ġ�� ���� ��ȯ
		list.add(a, list.remove(b));
		if(b - a != 1) {
			list.add(b, list.remove(a+1));
		}
	}
	static int partition(NLinkedList<Integer> list, int L, int R) {
		int idx_pivot = (L+R) / 2; // pivot�� ��ġ�� ���ĵ��� ���� ������ ��� ��
		int pivot = list.get(idx_pivot);
		
		while(L < R) { // L�� R�� �������� while�� ����
			// L�� pivot���� ũ�ų� ���� ���Ҹ� ã�������� ����. �� L�� R�� �������� ����.
			while(list.get(L) < pivot && L < R) {
				L++;
			}
			// R�� pivot���� ���� ���Ҹ� ã�������� ����. �� R�� L�� �������� ����.
			while(list.get(R) >= pivot && L < R) {
				R--;
			}
			
			if(L < R) { // L�� R�� ���� ���� ���, �� ��ġ�� ���� ���� ��ȯ�Ѵ�. 
				
				swap(list, L, R); 
				
				if(L == idx_pivot) { // L�� R���� ��ȯ�Ǿ��� ������, pivot�� ��ġ�� R�� �ٲپ��ش�.
					idx_pivot = R;
				}
				show(list);
			}
		}
		
		// R�� ���� pivot�� ���� ���� ���� ��� ��ȯ���� �ʿ䰡 �����Ƿ� �״�� �� ���� ����
		if(list.get(R) == pivot) { 
			System.out.println();
			return R;
		}
		// R�� ���� pivot�� ���� ���� �ٸ� ��쿡�� ��ȯ
		swap(list, R, idx_pivot);
		show(list);
		
		System.out.println();
		return R; // ��ȯ�� R ��ġ�� pivot ��ġ�� Ȯ���ϰ� ���� �ܰ��� �� ���� ����
	}
	static void show(NLinkedList<Integer> list) { // ���ĵ� list�� ������ ����Ѵ�.
		for(int i = 0; i < 10; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
}
