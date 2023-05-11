import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함

    public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력, 데이터 정제
        int n=Integer.parseInt(br.readLine());
        int[][] l= new int[n][3];
        int goldIdx=0, silverIdx=1,bronzeIdx=2;
        int goldNat,silverNat,bronzeNat;
        int natIdx=0, numIdx=1, scoreIdx=2;

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<3;j++) l[i][j]= Integer.parseInt(st.nextToken());
        }

        //람다식 이용하여 편리하게 정렬! 2번쨰 요소 기준으로, 빼기를 통해 더 큰값이 앞으로 가게 했다! (오..매우 간편)
        Arrays.sort(l,  (o1,o2) -> o2[2]-o1[2]);

        //금,은,동 뽑기.
        goldNat=l[goldIdx][natIdx];
        silverNat=l[silverIdx][natIdx];
        bronzeNat=l[bronzeIdx][natIdx];

        //문제가 되는 경우는, 금==은 + 은==동 일때만임.
        if (goldNat==silverNat){
            while(silverNat==bronzeNat){
                bronzeIdx++;
                bronzeNat=l[bronzeIdx][natIdx]; //동 다시 갱신
            }
        }

        //정답 출력
        StringBuilder sbG=new StringBuilder();
        sbG.append(l[goldIdx][natIdx]);
        sbG.append(" ");
        sbG.append(l[goldIdx][numIdx]);
        sbG.append("\n");

        StringBuilder sbS=new StringBuilder();
        sbG.append(l[silverIdx][natIdx]);
        sbG.append(" ");
        sbG.append(l[silverIdx][numIdx]);
        sbG.append("\n");

        StringBuilder sbB=new StringBuilder();
        sbG.append(l[bronzeIdx][natIdx]);
        sbG.append(" ");
        sbG.append(l[bronzeIdx][numIdx]);

        bw.write(sbG.toString());
        bw.write(sbS.toString());
        bw.write(sbB.toString());

        bw.flush(); bw.close();
    }
}
