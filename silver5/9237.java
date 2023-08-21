import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());
        int now=1, ans=0; //1일부터 시작. now는 나무를 심는 현재의 날짜
        int[] arr=new int[n];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) arr[i]= Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        //뒤에서부터(오래 걸리는 나무부터)
        for (int i=n-1; i>=0; i--){
            now++; //심고나면 1일 추가됨
            int tree= arr[i];
            int need= now+tree;

            ans=Math.max(ans,need);
        }


        System.out.println(ans);
    }

}
