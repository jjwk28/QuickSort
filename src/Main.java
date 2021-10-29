import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int idx = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("[각 단계별 정렬결과를 출력하고, 만약 정렬이 되지 않은 경우 공백으로 출력]");
		System.out.print("10개의 숫자를 입력하시오 > ");
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[10]; // 10개의 숫자를 입력받도록 크기 10의 배열 선언
		for(int i = 0; i < 10; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println();
		
		// 링크드리스트 방식 사용
		NLinkedList<Integer> list = new NLinkedList<>();
		for(int i = 0; i < 10; i++) {
			list.add(i, a[i]); // i번째 인덱스에 a[i]를 저장
		}
		
		int L = 0; // 왼쪽 끝 값의 위치
		int R = list.size()-1; // 오른쪽 끝 값의 위치
		
		// 퀵 정렬 구현의 가장 큰 핵심은 '재귀'
		// quickSort는 list의 값들을 퀵 정렬해준다.
		quickSort(list, L, R);
		
		System.out.print("퀵 정렬 결과 >> ");
		show(list);
	}
	static void quickSort(NLinkedList<Integer> list, int L, int R) {
		if(L >= R) { // L이 R보다 큰 경우에는 정렬 X
			return;
		}
		
		System.out.println(++idx + "단계 > ");
		int tmp = partition(list, L, R); // tmp값을 기준으로 두개의 부분집합으로 분할하여 연산
		quickSort(list, L, tmp-1); // L에서 tmp-1까지의 경우
		quickSort(list, tmp+1, R); // tmp+1에서 R까지의 경우
	}
	static void swap(NLinkedList<Integer> list, int a, int b) { // a와 b의 위치를 서로 교환
		list.add(a, list.remove(b));
		if(b - a != 1) {
			list.add(b, list.remove(a+1));
		}
	}
	static int partition(NLinkedList<Integer> list, int L, int R) {
		int idx_pivot = (L+R) / 2; // pivot의 위치는 정렬되지 않은 범위의 가운데 값
		int pivot = list.get(idx_pivot);
		
		while(L < R) { // L과 R이 같아지면 while문 종료
			// L은 pivot보다 크거나 같은 원소를 찾을때까지 증가. 단 L이 R과 같아지면 정지.
			while(list.get(L) < pivot && L < R) {
				L++;
			}
			// R은 pivot보다 작은 원소를 찾을때까지 감소. 단 R이 L과 같아지면 정지.
			while(list.get(R) >= pivot && L < R) {
				R--;
			}
			
			if(L < R) { // L과 R이 같지 않은 경우, 두 위치의 값을 서로 교환한다. 
				
				swap(list, L, R); 
				
				if(L == idx_pivot) { // L과 R값이 교환되었기 때문에, pivot의 위치를 R로 바꾸어준다.
					idx_pivot = R;
				}
				show(list);
			}
		}
		
		// R의 값과 pivot의 값이 서로 같을 경우 교환해줄 필요가 없으므로 그대로 퀵 정렬 종료
		if(list.get(R) == pivot) { 
			System.out.println();
			return R;
		}
		// R의 값과 pivot의 값이 서로 다른 경우에는 교환
		swap(list, R, idx_pivot);
		show(list);
		
		System.out.println();
		return R; // 교환된 R 위치를 pivot 위치로 확정하고 현재 단계의 퀵 정렬 종료
	}
	static void show(NLinkedList<Integer> list) { // 정렬된 list의 값들을 출력한다.
		for(int i = 0; i < 10; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
}
