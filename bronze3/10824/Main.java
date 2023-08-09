import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String a = st.nextToken();
        String b = st.nextToken();
        long f = Long.parseLong(a+b);  //각 숫자가 최대 10^7이므로, a+b은 10^14까지 가능하다. long써야함.
        
        String c = st.nextToken();
        String d = st.nextToken();
        long s = Long.parseLong(c+d);
        
        System.out.print(f + s);
    }
}
