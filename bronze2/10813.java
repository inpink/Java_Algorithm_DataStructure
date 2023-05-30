import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int i,j;

        int[] array=new int[n+1];
        initArray(array,n);

        for (int a=0; a<m;a++){
            StringTokenizer st2= new StringTokenizer(br.readLine());
            i=Integer.parseInt(st2.nextToken());
            j=Integer.parseInt(st2.nextToken());
            trade(array,i,j);

            //System.out.println(Arrays.toString(array));
        }

        //Output
        for (int a=1; a<=n; a++) bw.write(array[a]+" ");
        bw.flush();
        bw.close();
    }

    //배열[]은 객체 참조 가능
    public static void initArray(int[] array, int n){
        for (int a=0; a<=n; a++){
            array[a]=a;
        }
    }

    public static void trade(int[] array, int i, int j){

        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;

    }
}
