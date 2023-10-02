import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans=0;

        boolean[][] aArr =  new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    aArr[i][j] = true;
                }
            }
        }

        boolean[][] bArr =  new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    bArr[i][j] = true;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean c = false;
                for (int k = 0; k < n; k++) {
                    c =  c | (aArr[i][k] & bArr[k][j]); //비트연산자
                    if (c) {
                        ans++;
                        break; //한번 1이 나오면 이후로도 계속 1이 나옴
                    }
                }
            }
        }

        System.out.println(ans);

    }


}
