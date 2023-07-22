import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        Map<Character,Integer> mapToIdx = new HashMap<>(){{
            put('A',0);
            put('C',1);
            put('G',2);
            put('T',3);
        }};

        Map<Integer,Character> mapToChar = new HashMap<>(){{
            put(0,'A');
            put(1,'C');
            put(2,'G');
            put(3,'T');
        }};

        char[][] arr= new char[n][m];

        StringBuilder sb= new StringBuilder();

        for (int i=0; i<n; i++) arr[i]=br.readLine().toCharArray();

        for (int j=0; j<m; j++){
            int[] countArr= new int[4];

            for (int i=0; i<n; i++){
                char thisChar=arr[i][j];
                int seq=mapToIdx.get(thisChar);

                countArr[seq]++;
            }

            int max=0;
            char maxChar='A';
            for (int k=0; k<4; k++){
                int a=countArr[k];
                if (max<a){
                    max=a;
                    maxChar=mapToChar.get(k);
                }
            }

            sb.append(maxChar);
        }

        String ansStr=sb.toString();

        //위에서 문자열DNA이 정해졌다.
        //모든 문자열을 대상으로 서로 다른 개수 Hamming Distance을 계산
        int ansCount=0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (arr[i][j]!=sb.charAt(j)) ansCount++;
            }
        }

        //OUTPUT
        bw.write(ansStr+"\n"+ansCount);

        bw.flush();
        bw.close();
    }



}
