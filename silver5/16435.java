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

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int l=Integer.parseInt(st.nextToken());

        StringTokenizer st2=new StringTokenizer(br.readLine());
        int[] array=new int[n];
        for(int i=0; i<n; i++) array[i]=Integer.parseInt(st2.nextToken());

        Arrays.sort(array);

        for(int i=0; i<n; i++){
            if (array[i]>l) break;
            l++;
        }

       ///Output
        bw.write(Integer.toString(l));
        bw.flush();
        bw.close();
    }
}
