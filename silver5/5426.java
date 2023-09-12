import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){

            String s= br.readLine();
            int sqrtN = (int) Math.sqrt(s.length());

            StringBuilder result = new StringBuilder();
            for (int y = sqrtN-1; y >= 0; y--) { //뒤집어 진 곳의 (x,y)순서대로 접근
                for (int x = 0; x < sqrtN; x++) {
                    result.append(s.charAt(x*sqrtN+y)); //위치 공식
                }
            }

            System.out.println(result.toString());
        }

    }


}
