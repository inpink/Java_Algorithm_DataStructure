import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum=0;
        //입력
        while (true){
            int num= Integer.parseInt(br.readLine());

            if (num==-1) break;

            sum+=num;
        }

        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
    }


}
