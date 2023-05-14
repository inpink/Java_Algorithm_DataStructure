package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { 
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Input
		int n = Integer.parseInt(br.readLine());
		StringTokenizer InputL = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(br.readLine());

		// Data
		PriorityQueue<int[]> heapq = new PriorityQueue<>(
				(o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

		int[] update = new int[n + 1];
		int tmp, minVal, minIdx, chgIdx, chgVal;

		for (int i = 0; i < n; i++) {
			tmp = Integer.parseInt(InputL.nextToken());
			heapq.add(new int[] { tmp, i + 1 });
			update[i + 1] = tmp;
		}

		// Main Logic 	
		for (int i = 0; i < m; i++) {
			StringTokenizer order = new StringTokenizer(br.readLine());
			order.nextToken();
			if (order.countTokens() == 0) {
				while (true) {
					minVal = heapq.element()[0];
					minIdx = heapq.element()[1];

					if (update[minIdx] == minVal)break;
					heapq.remove();
					heapq.add(new int[] { update[minIdx], minIdx });
				}
				bw.write(minIdx+"\n");
			} else {
				chgIdx = Integer.parseInt(order.nextToken());
				chgVal = Integer.parseInt(order.nextToken());
				update[chgIdx] = chgVal;
				heapq.add(new int[] { chgVal, chgIdx });
			}
			//System.out.println("힙 사이즈: "+heapq.size());
			//System.out.println(Arrays.toString(heapq.element()));
		}
		 bw.flush(); bw.close();
	}
}
