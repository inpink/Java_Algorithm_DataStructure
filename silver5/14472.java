import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int ans=0;
        String[][] arr= new String[n][m];


        //input
        for (int i=0; i<n; i++){
            arr[i]=br.readLine().split("");
        }

        //가로 먼저 카운트
        for (int i=0; i<n; i++) {
            String[] row=String.join("",arr[i]).split("#");

            for (int j=0; j< row.length; j++){
                String s = row[j];
                //System.out.println(s);

                if (s.length()>=d) ans+=(s.length()-d+1);
            }
        }
        //System.out.println(ans);

        //세로 카운트
        for (int i=0; i<m; i++) {
            int finalI = i;
            String[] column = String.join("",
                    Arrays.stream(arr).map(row->row[finalI]).toArray(String[]::new))
                    .split("#");
            //String[]::new는 메소드 참조 표현식임. 실제로 메소드 호출하지 않고 메소드 호출을 참조만
            //size -> new String[size]를 뜻함. size를 구해서 배열을 생성해주기 때문에 스트림을 배열로 변환할 때 유용하게 사용
            for (int j=0; j< column.length; j++){
                String s = column[j];
                //System.out.println(s);

                if (s.length()>=d) ans+=(s.length()-d+1);
            }
        }

        System.out.println(ans);
    }
}
