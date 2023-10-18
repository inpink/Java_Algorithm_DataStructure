import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans=0;
        int[] arr= new int[10];

        for (int i=0; i<5;i++){
            int num= Integer.parseInt(br.readLine());
            arr[num]++;
        }

        for (int i=0; i<10;i++) {
            if (arr[i] % 2 != 0) System.out.println(i);
        }
    }


}

