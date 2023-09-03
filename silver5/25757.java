import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int players=0, ans;

        if(game.equals("Y")) players=1;
        else if(game.equals("F")) players=2;
        else if(game.equals("O")) players=3;

        Set<String> set = new HashSet<>();

        for(int i=0;i<n;i++) {
            String name = br.readLine();
            set.add(name);
        }

        ans=set.size()/players;

        System.out.println(ans);
    }

}
