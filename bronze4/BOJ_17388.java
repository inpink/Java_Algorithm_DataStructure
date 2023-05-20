import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main { //class명 Main 필수
    public static void main(String[] args)  throws IOException { //예외 처리 필수

        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int sU= Integer.parseInt(st.nextToken());
        int kU= Integer.parseInt(st.nextToken());
        int hU= Integer.parseInt(st.nextToken());

        //DATA
        int sum=sU+kU+hU;
        String ans;

        int[] scores=new int[] {sU,kU,hU};
        HashMap<Integer, String> map = new HashMap<>(){{
            put(sU,"Soongsil");
            put(kU,"Korea");
            put(hU,"Hanyang");
        }};

        //MAIN LOGIC
        if (sum>=100)  ans="OK";
        else  ans=findBottom(scores, map);

        //OUTPUT
        bw.write(ans); bw.flush(); bw.close();
    }

    //꼴지를 찾아 이름을 반환
    public static String findBottom(int[] scores, HashMap<Integer, String> map){
        Arrays.sort(scores);
        return map.get(scores[0]);
    }
}
