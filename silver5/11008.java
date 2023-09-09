import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String s=st.nextToken();
            String p=st.nextToken();

            int ans=checkTime(s,p);
            System.out.println(ans);
        }

    }

    public static int checkTime(String s, String p){
        String replacedS= s.replace(p,"1");
        //System.out.println(replacedS);
        int ans=replacedS.length();

        return ans;
    }


}
