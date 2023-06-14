import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n= Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        int[] ans=new int[n];
        for (int i=0; i<n; i++) arr[i]=Integer.parseInt(br.readLine());

        //1쌍만 정해지면 그 다음것들은 자동으로 정해짐 => O(min(arr))
        //구현의 편리를 위해 0번째로 결정
        int a,b;
        for (int i=0; i<=arr[0]; i++){
            a=i;
            b=arr[0]-a;

            ans[0]=a;
            ans[1]=b;
            if(isAns(arr,ans)){
                printArr(ans);
            }
        }


       /* //OUTPUT
        bw.flush();
        bw.close();*/
    }

    public static boolean isAns(int[] arr, int[] ans){
        int n=arr.length;
        for (int i=2; i<n; i++){
            ans[i]=arr[i-1]-ans[i-1];
        }

        //마지막값에서 first+last=value가 되면 성공
        if (arr[n-1]==ans[0]+ans[n-1]) return true;

        return false;
    }

    public static void printArr(int[] ans){
        for (int i=0; i<ans.length; i++ ) System.out.println(ans[i]);
    }

}
