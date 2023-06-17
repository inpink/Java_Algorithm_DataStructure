import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //어떻게 거쳐가든 상관없다. "단순히 같이 연결되어 있는지(=같은 집합인지)"를 묻는 것이므로,
        //Union-Find

        String ans="YES";
        int n= Integer.parseInt(br.readLine());
        int m= Integer.parseInt(br.readLine());
        int firstParent, currParent, lastTokenCount;
        int[] arr = new int[n+1];
        for (int i=0; i<=n; i++) arr[i]=i; //초기화 : 자기 자신을 부모로 가짐


        for (int i=1; i<=n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());

            for (int j=1; j<=n; j++) {

                if (st.nextToken().equals("1")) {
                    arr[find(arr,i)]=find(arr,j);  //i <- j 편입시키기
                }
            }
        }
        //System.out.println(Arrays.toString(arr));

        //마지막줄 가능한지 판단
        StringTokenizer lastInput = new StringTokenizer(br.readLine());
        //하나 먼저 구하기
        firstParent=find (arr, arr[Integer.parseInt(lastInput.nextToken())]);
        lastTokenCount=lastInput.countTokens();
        for (int i=0; i< lastTokenCount; i++ ){
            currParent= find (arr, arr[Integer.parseInt(lastInput.nextToken())]);
            if (currParent!=firstParent) {

                ans="NO";
                break;
            }
        }

        //OUTPUT
        bw.write(ans);
        bw.flush();
        bw.close();
    }

    public static int find(int[] arr, int num){

        if (arr[num]==num) return num;

        arr[num]= find(arr,arr[num]); //★ 탐색하는 과정에서 부모들을 같이 업데이트 시켜주자!
        return arr[num];
    }




}
