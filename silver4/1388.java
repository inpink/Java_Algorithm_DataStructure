import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int ans=0;
        String[] arr= new String[n];
        for (int i=0; i<n; i++){
            arr[i]=br.readLine();
        }

        //가로 먼저 세기(split써줌)
        for (int i=0; i<n; i++){
            ans+=countFloor(arr[i],"\\|"); //★
        }
        //System.out.println("ans = " + ans);


        //세로 세기
        for (int i=0; i<m; i++) {
            StringBuilder height=new StringBuilder();
            for (int j = 0; j < n; j++) {
                height.append(arr[j].charAt(i));
            }
            ans+=countFloor(height.toString(),"-");

        }
        //System.out.println("ans = " + ans);

        //OUTPUT
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }

    public static int countFloor(String s, String character){
        String[] tmp=s.split(character);
        int count=0;
        for (int j=0; j<tmp.length; j++) {
            if (tmp[j].length()>0) count++;
        }

        return count;
    }

}
