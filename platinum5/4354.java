import java.io.*;
import java.util.Arrays;

public class Main { //Main으로 해야함
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String t = br.readLine();
            if (t.equals(".")) break;

            int n=t.length();

            int[] table = makeTable(t);
            int aLen= n-table[n-1];
            int ans=n/aLen;

            if (n%aLen!=0) ans=1; //예외처리
            //System.out.println(n+" "+aLen+" "+table[n-1]);
            System.out.println(Integer.toString(ans));

        }

    }

    static int[] makeTable(String pattern) { //부분 일치 테이블 생성. 이또한 KMP이용
        int n = pattern.length();
        int[] table = new int[n];
        int idx = 0; //어디서부터 일치해야 "일치 개수 점수"를 줄 수 있는지. = 어디까지 일치되는지
        // 처음에는 맨 처음 0번째인 a부터.

        // i= 항상 맨 끝문자.
        // ☆idx번째와 i번째가 일치하는지 검사해야함☆
        for(int i=1; i<n; i++) { //어차피 i=0일 땐 0이 담김. 모든 i~(0,n) 부분 문자열에 대해 테이블 형성

            while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1]; //★KMP가 적용되는 것!
            }
            if(pattern.charAt(i) == pattern.charAt(idx)) { //같으면
                table[i] = ++idx; //현재 idx+1개수만큼은 접두사 ,접미사 일치하는 것
            }

        }
        //System.out.println(Arrays.toString(table));
        return table;
    }
}
