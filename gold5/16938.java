import java.io.*;
import java.util.*;

public class Main {

    static int n,l,r,x,ans=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1= new StringTokenizer(br.readLine());
        StringTokenizer st2= new StringTokenizer(br.readLine());

        //nC2, nC3... nCn 모든 조합구하기 (brute force)
        //조합의 합 공식 2^n으로 시간 내 넉넉히 통과

        n=Integer.parseInt(st1.nextToken());
        l=Integer.parseInt(st1.nextToken());
        r=Integer.parseInt(st1.nextToken());
        x=Integer.parseInt(st1.nextToken());

        int[] arr= new int[n];
        boolean[] visited= new boolean[n];

        for (int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st2.nextToken());
        }

        for (int i=1; i<=n; i++) { //모든 조합 구해서 문제화 할 수 있는지
            combiAndIsPossible(arr,visited,0,n,i);
        }

        System.out.println(ans);

    }

    static void combiAndIsPossible(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            if(toCombiArr(arr,visited,n)) ans++;
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combiAndIsPossible(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }


    // 사용 가능한 조합인지 판단
    static boolean toCombiArr(int[] arr, boolean[] visited, int n) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                arrayList.add(arr[i]);
            }
        }

        int sum=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for (int i : arrayList){
            sum+=i;
            min=Math.min(min,i);
            max=Math.max(max,i);
        }

        if (sum>=l && sum<=r && (max-min)>=x) return true;

        return false;

    }
}
