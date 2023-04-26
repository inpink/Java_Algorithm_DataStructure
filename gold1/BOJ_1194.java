package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함

	static String toBinary(int num) {
		
		String ans=Integer.toBinaryString(num);
		StringBuilder sb = new StringBuilder();
		if (ans.length()<6) {
			for (int i=0; i<6-ans.length(); i++) {
				sb.append("0");
			}
		}sb.append(ans);
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//System.out.println(toBinary(25).charAt(0)=='0');	
		
		//bfs 사용 ( 한 번의 움직임에서 상하좌우로 1번 이동하는 것이 평등 )
		//시작위치 0, 탈출구 1, 이동가능 . , 벽 #, 열쇠 a~f 6개(여러 번 사용 가능),  문 A~F 6개
		//최대 50x50
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		int startX=0,startY=0;
		
		String[][] maze= new String[n][m]; //모든 map정보는 String으로 담기는 것 주의 
		
		for (int i=0; i<n; i++) {
			maze[i]=br.readLine().split("");
			//System.out.println(Arrays.toString(maze[i]));
			for (int j=0; j<maze[i].length; j++) {
				if (maze[i][j].equals("0")) {
					startX=i;
					startY=j;
					maze[i][j]="."; //시작점도 .으로 해줘서 여기로도 이동할 수 있게
				}
			}
		}
		//System.out.println(startX+" "+startY);
		//System.out.println((int) "A".charAt(0)); //★ 자바 string to char to int (아스키 코드) , 반대로 int to char 아스키코드는 (char)하면 됨 , A=65, a=97 외우자
		Deque<int[]> dq= new ArrayDeque<>(); //★int는 일반 자료형이라 Deque안에 넣을 수 없지만, int[]배열은 객체이기 때문에 사용가능하다!!★
		
		//Integer[][] test= new Integer[][] {{startX},{startY}}; //★하드코딩으로 초기화 ★하드코딩으로 초기화 시, 크기 지정XX!!!

		//startX, startY, keys, count
		dq.add(new int[] {startX,startY,0,1}); //★여기서 new Integer[5]를 한 경우, Integer는 int와 다르게 "참조변수"이기에 초기값이 null이다!!!
		//System.out.println(Integer.toString(dq.getFirst()[2][0]));
		
		//★자바에서 일반 배열[] 깊은 복사하는 방법. 1) 배열.clone();  2)배열.copyOfRange(배열, 복사할시작index, 끝index)
		//☆배열 = 배열 하면 얕은 복사(주소까지 복사)됨
		int curX,curY,ascii,count,keys; //keys가 0이면 아무 키도 없는 것  //count는 1부터 시작
		int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};  //상 하 좌 우
		int[][][] visited= new int[n][m][64];
		visited[startX][startY][0]=1;
		
		while (true) {
			if (dq.size()==0) {//여기서 멈췄다는 건 더 이상 탐색후보가 없고 탈출 불가능하다는 것 
				bw.write(Integer.toString(-1)); bw.flush(); bw.close();
				return; 
			}

			curX=dq.getFirst()[0];
			curY=dq.getFirst()[1];
			keys=dq.getFirst()[2];
			count=dq.getFirst()[3];
			dq.removeFirst();
			//System.out.println(dq.removeFirst());
			//System.out.println(count+" X:"+curX+" Y:"+curY);
			
			//visited[curX][curY][keys]=count; //방문처리 
			
			ascii=(int) maze[curX][curY].charAt(0);
			
			//현재 자기 위치에 대해 검사
			if (maze[curX][curY].equals("1")) { //출구 찾음 (유일한 탈출) 
				//System.out.println("찾음");
				bw.write(Integer.toString(count-1)); bw.flush(); bw.close();
				return; //즉시 종료 
			}
			else if ( ascii>=97 && ascii<=102) { //key 발견
				if (toBinary(keys).charAt(102-ascii)=='0') { //발견하지 않은 key라면 
					keys+=Math.pow(2,ascii-97);//key 있음 체크
				}
			}
			
			String BinaryKey=toBinary(keys);
			//자기 위치에서 할 수 있는 것은 다했다. 이제 새로운 탐색 위치를 정해서 덱에 넣어준다.
			//보내줄 때 클론
			for (int i=0; i<4;i++) {
				int dirX=direction[i][0];
				int dirY=direction[i][1];
				int moveX=curX+dirX;
				int moveY=curY+dirY;
				if (moveX<0 || moveX>=n || moveY<0 || moveY>=m) continue; //범위를 벗어나면 탐색 X
				
				String str=maze[moveX][moveY];
				ascii=(int) str.charAt(0);
				//System.out.println("이동할 곳의 아스키 : "+ascii+" "+moveX+" "+moveY+" "+BinaryKey+" ");
				if (str.equals("#") || (ascii>=65 && ascii<=70 && BinaryKey.charAt(70-ascii)=='0' )) continue; //못가는 경우 1) 벽임 2) 문인데 열쇠가 없음
				else if (visited[moveX][moveY][keys]==0 || visited[moveX][moveY][keys]>count+1) {
					//System.out.println("데큐에 넣음"+moveX+" "+moveY+" "+count+" "+BinaryKey+" "+visited[moveX][moveY][keys]);
					dq.add(new int[] {moveX, moveY, keys, count+1}); //★if문 가지치기
					visited[moveX][moveY][keys]=count+1; //★방문처리를 여기서 해줘야 하는 이유? 
				}
			}
		}
		/*★HashMap 만들면서 초기화하기!
		HashMap<String,Integer> map=new HashMap<>() {{
			put("a",1);
		}};
		System.out.println(map.get("a"));*/

	   }

}
