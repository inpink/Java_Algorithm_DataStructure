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

        int t=Integer.parseInt(br.readLine());
        while (true) {
            if (t--==0) break;

            int n = Integer.parseInt(br.readLine());
            int[] parentArr = new int[n * 2]; //Parent 정보 담음  최대 2n개 들어올 수 있다
            for (int i = 0; i < n * 2; i++) parentArr[i] = i; //부모 정보는 1,2,3,4..  초기화 필요
            int[] connectCountArr = new int[n * 2]; //각 노드에서의 연결된 개수를 담음
            for (int i = 0; i < n * 2; i++) connectCountArr[i] = 1; //연결된 개수는 초기값 1로 초기화 필요. 자기 자신이 1개이기 때문
            Map<String, Integer> map = new HashMap<>(); //이름:번호 로 사용함
            int mapIdx = 0, leftI, rightI, leftP, rightP;

            String left, right;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                left = st.nextToken();
                right = st.nextToken();

                if (!map.containsKey(left)) map.put(left, mapIdx++);
                if (!map.containsKey(right)) map.put(right, mapIdx++);

                leftI = map.get(left);
                rightI = map.get(right);

                leftP = find(parentArr, leftI);
                rightP = find(parentArr, rightI);

                //이미 같은 집합이면 개수 추가 하면 안됨. 통합도 굳이 필요없음
                if (leftP != rightP){ //다른 집합이면  집합 통합하고, 개수도 통합
                    parentArr[leftP] = rightP; //집합 통합

                    //개수 통합은 rightP에만 해둬도 됨. leftP가 부모 찾아 올 것이기 때문
                    //But, 둘 다 해주면 당연히 성능이 2배로 좋아짐! 찾는 시간이 줄어드니까
                    connectCountArr[rightP] = connectCountArr[leftP] + connectCountArr[rightP];
                    connectCountArr[leftP] = connectCountArr[leftP] + connectCountArr[rightP];

                }
                System.out.println(connectCountArr[rightP]);
            }

            //System.out.println(Arrays.toString(parentArr)+Arrays.toString(connectCountArr));
        }
        //OUTPUT
        /*bw.write(left+" "+right);
        bw.flush();
        bw.close();*/
    }

    public static int find(int[] arr, int num){

        if (arr[num]==num) return num;

        arr[num]= find(arr,arr[num]); //★ 탐색하는 과정에서 부모들을 같이 업데이트 시켜주자!
        return arr[num];
    }

}
