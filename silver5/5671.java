import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5001]; //미리 개수 다 담아놓기. 누적합

        for (int i=1; i<=5000; i++){
            arr[i]=arr[i-1];

            boolean isPossible = checkPossible(Integer.toString(i));
            if (isPossible) arr[i]++;
        }

        String input = "";
        while((input=br.readLine())!=null) {
            String[] str = input.split(" ");

            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int cnt = arr[m]-arr[n-1];

            System.out.println(cnt);
        }
    }

    public static boolean checkPossible(String s){

        int len= s.length();
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);

        if (set.size()==len) return true;
        else return false;
    }
}
