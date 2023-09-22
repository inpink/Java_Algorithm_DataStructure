import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        String[] colorArr = new String[]{st1.nextToken(), st1.nextToken(), st2.nextToken(), st2.nextToken()};
        Set<String> answerSet = new HashSet<>();
        String[] answerArr;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String pairStr = colorArr[i] + " " + colorArr[j];
                answerSet.add(pairStr);
            }
        }

        answerArr =  answerSet.toArray(String[]::new);
        Arrays.sort(answerArr);

        for (int i = 0; i < answerArr.length; i++) {
            sb.append(answerArr[i]);
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}
