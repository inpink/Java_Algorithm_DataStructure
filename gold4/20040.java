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
        int ans=0;

        //Union-Find
        int[] arr=new int[n];
        for (int i=0; i<n; i++) arr[i]=i; //초기화 : 자기 자신을 부모로 가짐

        int left,right, leftP, rightP;
        for (int i=0; i<m; i++){
            StringTokenizer st1= new StringTokenizer(br.readLine());
            left=Integer.parseInt(st1.nextToken());
            right=Integer.parseInt(st1.nextToken());

            //오른쪽을 왼쪽에 편입시킴
            //★ find 재귀 호출 2번 필요함. 각각 진짜 부모 찾고, 가는 길 업데이트 시켜주기
            leftP=find(arr,left);
            rightP=find(arr,right);

            arr[rightP]=leftP;
            //System.out.println(Arrays.toString(arr));

            if (leftP==rightP) { //이미 같은 집합에 있는데 left와 right가 이어지면 사이클 형성
                ans=i+1; break;
            }
        }


       //Output
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }

    //진짜 부모 찾는 메소드
    public static int find(int[] arr, int num){

        if (arr[num]==num) return num;

        arr[num]= find(arr,arr[num]); //★ 탐색하는 과정에서 부모들을 같이 업데이트 시켜주자!
        return arr[num];
    }

}
