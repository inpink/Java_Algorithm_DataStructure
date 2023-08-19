import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int j = Integer.parseInt(br.readLine());

        int n= Integer.parseInt(st1.nextToken());
        int m= Integer.parseInt(st1.nextToken());
        int result = 0, start=1, end=m, dist;

        for(int i = 0; i < j; i++) {
            int apple = Integer.parseInt(br.readLine());
            //System.out.println(start+" "+end+" "+apple+" "+result+"☆");
            if (start<=apple && apple<=end) continue; //이미 안에 있으면 움직X
            else if (end<apple) { // 오른쪽으로 이동시켜줘야 하는 경우
                dist=apple-end;

                end=apple;
                start+=dist;
            }
            else { //왼쪽으로 이동시켜줘야 하는 경우
                dist=start-apple;

                start=apple;
                end-=dist;
            }
            result+=dist;
            //System.out.println(start+" "+end+" "+apple+" "+result+"★");
        }

        System.out.println(result);
    }

}
