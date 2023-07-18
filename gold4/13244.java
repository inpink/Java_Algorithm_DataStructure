import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t= Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++){
            int n= Integer.parseInt(br.readLine());
            int m= Integer.parseInt(br.readLine());

            int[] parentArr=new int[n + 1];
            for (int j = 1; j <= n; j++) parentArr[j] = j; //부모 정보는 1,2,3,4..  초기화 필요

            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                //오른쪽을 왼쪽에 편입시킴
                //★ find 재귀 호출 2번 필요함. 각각 진짜 부모 찾고, 가는 길 업데이트 시켜주기
                int leftP=find(parentArr,left);
                int rightP=find(parentArr,right);

                parentArr[rightP]=leftP; //left<-right
            }
            //System.out.println(Arrays.toString(parentArr));

            String ans="tree";
            if (n-1!=m) ans="graph"; //1. n-1==m이어야 트리
            else { //2. 모든 노드가 "하나의 집합"이어야 한다. (Union-Find 사용)
                for (int j=1; j<n; j++) {
                    if (find(parentArr,j)!=find(parentArr,j+1)) {
                        ans="graph";
                        break;
                    }
                }
            }
            //System.out.println(Arrays.toString(parentArr));

            bw.write(ans+"\n");
        }

        //OUTPUT
        bw.flush();
        bw.close();
    }

    public static int find(int[] arr, int num){

        if (arr[num]==num) return num;

        arr[num]= find(arr,arr[num]); //★ 탐색하는 과정에서 부모들을 같이 업데이트 시켜주자!
        return arr[num];
    }


}
