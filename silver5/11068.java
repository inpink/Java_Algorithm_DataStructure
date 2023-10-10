import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i= 0; i < t; i++) {
            int ans = 0;

            int num = Integer.parseInt(br.readLine());


            for (int j = 2; j <= 64; j++) {
                ArrayList<Integer> arr = new ArrayList<>(); //참고로 100만은 2진수로 20자리이기에, 최대 20자리 올 수 있음
                int transNum=num;
                boolean isPaline = true;

                while(transNum!=0) {
                    arr.add(transNum%j);
                    transNum /= j;
                }

                int size=arr.size();

                for (int k = 0; k <= (size/2); k++) {
                    if(arr.get(k)!= arr.get(size-1-k)) {
                        isPaline = false;
                        break;
                    }
                }

                if (isPaline==true){
                    ans=1;
                    break;
                }
            }

            System.out.println(ans);
        }

    }
}
