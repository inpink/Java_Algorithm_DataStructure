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

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int left,right,beforeP,curP,leftClassCount,ans=0;


        int[] arr= new int[n+1];
        for (int i=0; i<n+1; i++) arr[i]=i; //초기화

        for (int i=0; i<m; i++) {
            StringTokenizer st2= new StringTokenizer(br.readLine());
            left=Integer.parseInt(st2.nextToken());
            right=Integer.parseInt(st2.nextToken());

            arr[find(arr,left)]=find(arr,right);
        }

        //merge하며 정답구하기
        //첫번째거는 미리 구해놓기
        StringTokenizer st3=new StringTokenizer(br.readLine());
        beforeP=find(arr,Integer.parseInt(st3.nextToken()));
        leftClassCount=st3.countTokens();
        for (int i=0; i<leftClassCount; i++) {
            curP=find(arr,Integer.parseInt(st3.nextToken()));
            if (beforeP!=curP) ans++;

            beforeP=curP;
        }

        //OUTPUT
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }

    public static int find(int[] arr, int num){

        if (arr[num]==num) return num;

        arr[num]= find(arr,arr[num]); //★ 탐색하는 과정에서 부모들을 같이 업데이트 시켜주자!
        return arr[num];
    }

}
