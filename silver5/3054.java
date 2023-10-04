import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str=br.readLine();
        int n= str.length();
        int row=5;
        int col=4*n+1;
        char[][] arr=new char[row][col];
        char deco;

        //기본적으로 전부 .을 찍어놓기
        /*for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                arr[i][j]='.';
            }
        }*/
        for (int i=0; i<row; i++) { //가독성을 위해 Arrays.fill 메소드 사용
            Arrays.fill(arr[i], '.');
        }

        for (int i=1; i<=n; i++){
            if (i%3==0) deco='*';
            else deco='#';

            drawFrame(arr,deco, str.charAt(i-1),(4*(i-1)));
        }

        printArr(arr,row,col);
    }

    public static void drawFrame(char[][] arr, char deco, char alpha, int start){

        //.이 아닌 부분만 추가
        arr[0][start+2]=deco;

        arr[1][start+1]=deco;
        arr[1][start+3]=deco;

        //웬디 프레임과 피터팬 프레임이 겹칠 경우에는, 웬디 프레임이 위에 있다.
        if (arr[2][start]!='*') arr[2][start]=deco;
        arr[2][start+2]=alpha;
        arr[2][start+4]=deco;

        arr[3][start+1]=deco;
        arr[3][start+3]=deco;

        arr[4][start+2]=deco;
    }

    public static void printArr(char[][] arr, int row, int col){
        StringBuilder sb= new StringBuilder();

        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
