import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb= new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            String[] words = new String[k];
            boolean isPossible = false;

            for (int a = 0; a < k; a++) {
                words[a] = br.readLine();
            }

            loop:
            for (int b = 0; b < k; b++) {
                for (int c = 0; c < k; c++) {
                    if (b == c) {
                        continue;
                    }

                    String word = words[b]+words[c];
                    if (isPalindrome(word)) {
                        sb.append(word + "\n");
                        isPossible = true;
                        break loop;
                    }
                }
            }

            if (isPossible==false) {
                sb.append(0 + "\n");
            }
        }

        System.out.println(sb.toString());

    }

    public static boolean isPalindrome(String word) {
        int n = word.length();
        for (int i = 0; i < (n / 2); i++) {
            if (word.charAt(i) != word.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }
}
