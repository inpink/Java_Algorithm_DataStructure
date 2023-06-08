import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //System.out.println(Arrays.toString("..XXX.XX..X".split("X")));

        int n=Integer.parseInt(br.readLine());
        int leftC=0, rightC=0;
        String[][] arr = new String[n][n];
        String left,right;

        //left
        for(int i=0; i<n; i++) {
            left=br.readLine();
            leftC+=countPlace(left);

            arr[i]=left.split(""); //right를 위해 대입해놓음
        }


        //right
        for(int j=0; j<n; j++) {
            StringBuilder sb= new StringBuilder();
            for (int i=0; i<n; i++){
                sb.append(arr[i][j]);
            }
            right=sb.toString();
            rightC+=countPlace(right);
        }

        //Output
        bw.write(leftC+" "+rightC);
        bw.flush();
        bw.close();
    }


    public static int countPlace(String str){

        String[] placeArr;
        int placeCount = 0;

        placeArr=str.split("X");

        for (int j=0; j<placeArr.length; j++) {
            if (placeArr[j].length()>=2) placeCount++;
        }

        return placeCount;
    }
}
