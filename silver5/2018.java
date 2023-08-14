import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//qbqtzqqt => qt 두번 나옴
//=> 반드시 idx 시작점이 0이 아닐 수 있음. 모든 시작점에 대해 다 검사해줘야함.
//O(5000*5000)
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());
        int ans=1, sum=1, start=1, end=1; //자신과 같은 경우 1개

        //투포인터로 해결
        while (true){
            //System.out.println(start+" "+end+" "+sum);
            if (start==n && end==n) break;

            if(sum == n) ans++;

            if(sum < n) sum+= ++end;
            else if(sum >= n) sum -= start++;
        }

        System.out.println(ans);
    }

}
