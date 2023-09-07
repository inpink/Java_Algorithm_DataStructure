import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr= new String[n];
        int[] sequence = new int[n];
        String ans;

        for (int i=0; i<n; i++){
            arr[i]=br.readLine();
        }

        for (int i=1; i<n; i++) {
            sequence[i] = arr[i-1].compareTo(arr[i]);
        }

        boolean isIncreasing=true;
        for (int i=1; i<n; i++) {
            if (sequence[i]<0) continue;
            else {
                isIncreasing=false;
                break;
            }
        }

        boolean isDecreasing=true;
        for (int i=1; i<n; i++) {
            if (sequence[i]>0) continue;
            else {
                isDecreasing=false;
                break;
            }
        }

        if (isIncreasing) ans="INCREASING";
        else if (isDecreasing) ans="DECREASING";
        else ans="NEITHER";

        System.out.println(ans);
    }

}
