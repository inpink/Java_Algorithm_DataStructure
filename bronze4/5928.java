import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        //1일은 1440분, 1시간은 60분, 1분은 1분
        int ADate=11;
        int AHour=11;
        int AMin=11;
        int ATotal=ADate*1440+AHour*60+AMin;

        int BDate= Integer.parseInt(st.nextToken());
        int BHour= Integer.parseInt(st.nextToken());
        int BMin= Integer.parseInt(st.nextToken());
        int BTotal=BDate*1440+BHour*60+BMin;

        int ans=BTotal-ATotal;
        if (ans<0) ans=-1;

        System.out.println(ans);
    }

}
