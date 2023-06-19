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

        int n=Integer.parseInt(br.readLine());
        int[] arr= new int[n+1];
        for (int i=0; i<=n; i++) arr[i]=i;
        int left=0,right=0,firstParent,currParent;

        for (int i=0; i<n-2; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            left=Integer.parseInt(st.nextToken());
            right=Integer.parseInt(st.nextToken());

            arr[find(arr,left)]=find(arr,right);
        }

        //merge하고 정답찾기
        firstParent=find(arr,1);
        for (int i=2; i<=n; i++){
            currParent=find(arr,i);
            if (currParent!=firstParent){
                left=firstParent;
                right=currParent;
                break;
            }
        }

        //OUTPUT
        bw.write(left+" "+right);
        bw.flush();
        bw.close();
    }

    public static int find(int[] arr, int num){

        if (arr[num]==num) return num;

        arr[num]= find(arr,arr[num]); //★ 탐색하는 과정에서 부모들을 같이 업데이트 시켜주자!
        return arr[num];
    }

}
