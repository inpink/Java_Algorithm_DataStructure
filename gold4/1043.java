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

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int knowLen = Integer.parseInt(st2.nextToken());

        boolean[] knowArr = new boolean[n + 1]; //기본값은 false
        int knowNum;
        for (int i = 0; i < knowLen; i++) { //비밀 아는 사람 knowArr에 체크함
            knowNum = Integer.parseInt(st2.nextToken());
            knowArr[knowNum] = true;
        }
        //System.out.println(Arrays.toString(knowArr));

        int[] parentArr = new int[n + 1]; //Parent 정보 담음  최대 n개 들어올 수 있다  1번부터 사용하므로 n+1
        for (int i = 1; i <= n; i++) parentArr[i] = i; //부모 정보는 1,2,3,4..  초기화 필요

        ArrayList<Integer>[] partyArr = new ArrayList[m]; //☆배열에 Arraylist넣기 1
        for (int i = 0; i < m; i++) partyArr[i] = new ArrayList<>();  //☆배열에 Arraylist넣기 2
        int partyNum, left, right,leftP, rightP=0;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            partyNum= Integer.parseInt(st.nextToken());
            left = Integer.parseInt(st.nextToken());
            partyArr[i].add(left);

            if (partyNum==1) continue;

            for (int j=0; j<partyNum-1; j++){
                right = Integer.parseInt(st.nextToken());
                partyArr[i].add(right);
                leftP = find(parentArr, left); //☆ lefP가 이 반복문에서 업데이트되므로, 매번 구해줘야 함
                rightP = find(parentArr, right);

                //★Union(통합)
                if (leftP != rightP) { //다른 집합이면  집합 통합
                    parentArr[leftP] = rightP;
                }
            }
            //System.out.println(Arrays.toString(parentArr));
        }

        if (knowLen == 0) { //비밀을 아는 사람이 없으면 모든 파티에서 거짓말 가능
            System.out.println(Integer.toString(m));
            return;
        }

        //알고 있는 사람이 포함된 집합의 P도 knowArr로 포함시킴 (union-find를 하며 알고있는 사람이 아닌 사람이 집합의 P가 아닐 수 있기 때문. 예제2번 참고)
        for (int i=1; i<=n; i++){
            if (knowArr[i]==true) {
                leftP=find(parentArr, i);
                knowArr[leftP]=true;
            }
        }
        //System.out.println(Arrays.toString(knowArr));

        ArrayList<Integer> thisParty;
        int thisPartyP,ans=0;
        for (int i = 0; i < m; i++) { // 다시 순회하며 거짓말 할 수 있는 파티인지 확인
            boolean isPossible=true;
            thisParty=partyArr[i];

            for (int party : thisParty){
                thisPartyP=find(parentArr, party);
                if (knowArr[thisPartyP]) {
                    isPossible=false;
                }
            }

            if (isPossible) {
                ans++;
                //System.out.println("참가 가능한 party"+thisParty);
            }
        }

        //OUTPUT
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }

    public static int find(int[] arr, int num) {

        if (arr[num] == num) return num;

        arr[num] = find(arr, arr[num]); //★ 탐색하는 과정에서 부모들을 같이 업데이트 시켜주자!
        return arr[num];
    }
}
