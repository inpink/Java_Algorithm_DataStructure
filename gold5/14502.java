package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.*;
import java.util.*;

public class Main { //class name은 Main 이어야 함
	public static void main(String[] args) throws IOException { //예외처리 꼭 해줘야 함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//이건 알고리즘이고 뭐고 할 거 없이, 그냥 구현, 시뮬레이션 문제임.
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int row=Integer.parseInt(st.nextToken());
		int col=Integer.parseInt(st.nextToken());
		
		StringTokenizer st2= new StringTokenizer(br.readLine());
		
		int x=Integer.parseInt(st2.nextToken());
		int y=Integer.parseInt(st2.nextToken());
		int dir=Integer.parseInt(st2.nextToken());
		
		int[][] plane=new int[row][col];
		for (int i=0;i<row;i++) {
			StringTokenizer st3= new StringTokenizer(br.readLine());
			for (int j=0;j<col;j++) plane[i][j]=Integer.parseInt(st3.nextToken());
		}
		
		
		int[][] directions = { {-1,0}, {0,1}, {1,0},{0,-1}};
		
		int count=0;
		boolean go=false;
		while (true) {
			//1.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if (plane[x][y]==0) {
				plane[x][y]=-1; //청소됨은 -1으로 표시함
				count++;
			}
			else {
				go=false; //주변 4칸이 모두 0이 아님(주변에 청소되지 않은 빈칸이 없음)
				for (int i=0; i<4; i++) {
					if ( plane[x+directions[i][0]][y+directions[i][1]] ==0) {
						go=true;
						break;
					}
				}
				if (go==false) { //현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
					if ( plane[x-directions[dir][0]][y-directions[dir][1]]!=1) { // 한 칸 후진할 수 있다면(=뒤에가 벽이 아니라면)
						x-=(directions[dir][0]);
						y-=(directions[dir][1]);
						continue;
					}
					else break;
						//유일한 종료조건으로 두면 되는 것 
						//: 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우, 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
				}
				else { //현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
					dir=(dir+3)%4; //원형 큐에서 배운 것.. start와 end index를 연결하는 방법.. //반시계 방향으로 90도 회전한다.
					if (plane[x+directions[dir][0]][y+directions[dir][1]]==0) {
						x+=(directions[dir][0]);
						y+=(directions[dir][1]);
					}
				}
			}
		} System.out.println(count);
		
		/*
		 * for (int i=0;i<row;i++) { for (int j=0; j<col;j++) {
		 * System.out.print(plane[i][j]+" "); }System.out.println(); }
		 */
		
    }


	
		
		
}
	
