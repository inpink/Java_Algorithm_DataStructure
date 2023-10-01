import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb= new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(st.nextToken(), 0);
        }

        for(int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int size=st1.countTokens();
            for (int j=0; j<size; j++){
                String s = st1.nextToken();
                map.put(s, map.get(s) + 1);
            }

        }

        List<String> keyList = new ArrayList<>(map.keySet());

        keyList.sort((o1, o2) -> {

            int o1Score=map.get(o1);
            int o2Score=map.get(o2);

            if( o1Score == o2Score ) {
                return o1.compareTo(o2);
            }
            return Integer.compare(o2Score, o1Score);
        });

        for(String key : keyList) {
            sb.append(key+" "+map.get(key)+"\n");
        }

        System.out.println(sb.toString());

    }
}
