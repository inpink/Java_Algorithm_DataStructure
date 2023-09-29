import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력을 읽어와서 리스트에 저장
        List<String> times = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n= Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            times.add(input);
        }

        //리스트를 시간이 작은 순으로 정렬
        Collections.sort(times, new Comparator<String>() {
            @Override
            public int compare(String time1, String time2) {
                StringTokenizer tokenizer1 = new StringTokenizer(time1);
                StringTokenizer tokenizer2 = new StringTokenizer(time2);

                int hour1 = Integer.parseInt(tokenizer1.nextToken());
                int minute1 = Integer.parseInt(tokenizer1.nextToken());
                int second1 = Integer.parseInt(tokenizer1.nextToken());

                int hour2 = Integer.parseInt(tokenizer2.nextToken());
                int minute2 = Integer.parseInt(tokenizer2.nextToken());
                int second2 = Integer.parseInt(tokenizer2.nextToken());

                // 시간, 분, 초를 초로 변환하여 비교
                int totalSeconds1 = hour1 * 3600 + minute1 * 60 + second1;
                int totalSeconds2 = hour2 * 3600 + minute2 * 60 + second2;

                return Integer.compare(totalSeconds1, totalSeconds2);
            }
        });

        // 정렬된 결과 출력
        for (String time : times) {
            System.out.println(time);
        }
    }
}
