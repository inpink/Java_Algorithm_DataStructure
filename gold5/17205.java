import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        String s=br.readLine();
        long ans=0;

        //a(26,0,4)+1 # a부터 azzzzz까지

        //각 자리수에 대해, 자기와 같거나 작은 것들 개수를 다 세주면 됨
        for (char c : s.toCharArray()){
            int count=c-'a';
            ans+= ( count* (Math.pow(26,n) -1)/25 ) +1;
            n--;
        }


        System.out.println(ans);

    }

    //사용X. 시간단축을 위해 재귀가 아닌 "등비수열의 합 공식" 이용함.
    public static long countBeforeAlpha(long num, int curDepth, int endDepth){
        if (curDepth==endDepth) return num;

        num=(1+num)*26;
        return countBeforeAlpha(num,curDepth+1,endDepth);
    }
}
