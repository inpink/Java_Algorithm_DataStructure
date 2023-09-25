import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        String m= st.nextToken();

        int ans=0;

        for (int i = 1; i <= n; i++) {
            String strI= Integer.toString(i);
            String replacedStrI=strI.replace(m,"");
            int thisCount = strI.length() -replacedStrI.length();

            ans+=thisCount;
        }

        System.out.println(ans);
    }

}
