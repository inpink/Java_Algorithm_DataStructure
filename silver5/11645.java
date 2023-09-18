import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t= Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++){
            int n= Integer.parseInt(br.readLine());

            Set<String> set= new HashSet<>();
            for (int j=0; j<n; j++){
                String city=br.readLine();
                set.add(city);
            }
            System.out.println(set.size());
        }

    }




}
