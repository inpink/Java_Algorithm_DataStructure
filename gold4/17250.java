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


        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] parentArr = new int[n + 1]; //Parent 정보 담음  최대 n개 들어올 수 있다  1번부터 사용하므로 n+1
        for (int i = 1; i <= n; i++) parentArr[i] = i; //부모 정보는 1,2,3,4..  초기화 필요
        int[] connectCountArr = new int[n + 1]; //각 노드에서의 연결된 개수를 담음
        for (int i = 1; i <= n; i++) connectCountArr[i] = Integer.parseInt(br.readLine()); //입력값을 초기값으로 가지고 있다
        int leftP, rightP;

        int left, right;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());

            leftP = find(parentArr, left);
            rightP = find(parentArr, right);

            //★Union(통합)
            //이미 같은 집합이면 개수 추가 하면 안됨. 통합도 굳이 필요없음
            if (leftP != rightP) { //다른 집합이면  집합 통합하고, 개수도 통합

                parentArr[leftP] = rightP; //집합 통합

                //개수 통합은 rightP에만 해둬도 됨. leftP가 부모 찾아 올 것이기 때문
                //But, 둘 다 해주면 당연히 성능이 2배로 좋아짐! 찾는 시간이 줄어드니까
                connectCountArr[rightP] = connectCountArr[leftP] + connectCountArr[rightP];
                connectCountArr[leftP] = connectCountArr[leftP] + connectCountArr[rightP];

            }
            bw.write(Integer.toString(connectCountArr[rightP])+"\n"); //SOUT를 쓰면 시간차이가 매우 많이 난다
        }

        //System.out.println(Arrays.toString(parentArr)+Arrays.toString(connectCountArr));

        //OUTPUT
        bw.flush();
        bw.close();
    }

    public static int find(int[] arr, int num){

        if (arr[num]==num) return num;

        arr[num]= find(arr,arr[num]); //★ 탐색하는 과정에서 부모들을 같이 업데이트 시켜주자!
        return arr[num];
    }

}
