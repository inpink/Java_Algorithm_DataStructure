import java.io.*;
import java.util.Arrays;

//qbqtzqqt => qt 두번 나옴
//=> 반드시 idx 시작점이 0이 아닐 수 있음. 모든 시작점에 대해 다 검사해줘야함.
//O(5000*5000)
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = br.readLine();
        int max=0;

        for (int i=0; i<t.length(); i++){
            int[] table = makeTable(t.substring(i));
            //System.out.println(t.substring(i));
            max=Math.max(max,Arrays.stream(table).max().getAsInt());

        }

        System.out.println(max);
        //Arrays의 stream을 이용하여 편하게 max값을 구하고, OptionalInt로 반환해주기 때문에 getAsInt로 value 꺼내쓰면 된다.
        //배열에 값이 없을 때 table=[] , 이 배열에 stream.max()를 하면 값이 없다.
        // 이 때 getAsInt를 하면 바로 예외가 떠버리기 때문에, Optional로 감싸둔 것..
        //이 문제에서는 반드시 길이가 1 이상인 t가 들어오므로 상관없지만,
        // 0일 수 있을 때는 isPresent()로 max값이 구해졌는지(Optional안에 값이 있는지) 검사하고 있을 때만 꺼내줘야 한다.
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
