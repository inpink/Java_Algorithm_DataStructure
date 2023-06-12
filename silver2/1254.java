import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String s = br.readLine();
        int n= s.length();

        ArrayList<Character> arr = new ArrayList<>(); //리스트 이용하여 brute force
        for (int i=0; i<n; i++) arr.add(s.charAt(i));

        int ans=n, left=0, right=n-1; //최소 n개, left&right 포인터

        while (true){
            if (left>=right) break; //총 팰린드롬 길이가 홀수이면 left==right일때, 짝수면 left>right일 때 종료

            if (arr.get(left)==arr.get(right)) {
                left++;
                right--;
            }
            else { //안맞으면 앞에서 하나 빼고 초기화
                n--;
                left=0;
                right=n-1;
                ans++;
                arr.remove(0);
            }
        }
        
        //OUTPUT
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }
}
