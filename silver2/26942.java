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

        //Union-Find
        Set<Integer> ansSet= new HashSet<>();
        int n= Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        for (int i=0; i<n; i++) arr[i]=i; //초기화
        Map<String,Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) map.put(br.readLine(),i);

        int m=Integer.parseInt(br.readLine());
        String leftS, rightS;
        int leftI, rightI;
        for (int i=0; i<m; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            leftS=st.nextToken();
            rightS=st.nextToken();
            leftI=map.get(leftS);
            rightI=map.get(rightS);

            arr[find(arr,leftI)]=find(arr,rightI);
        }
        //System.out.println(Arrays.toString(arr));

        //merge하며 최종 답 구하기
        for (int i=0; i<n; i++) ansSet.add(find(arr,i));


        //OUTPUT
        bw.write(Integer.toString(ansSet.size()));
        bw.flush();
        bw.close();
    }

    public static int find(int[] arr, int num){

        if (arr[num]==num) return num;

        arr[num]= find(arr,arr[num]); //★ 탐색하는 과정에서 부모들을 같이 업데이트 시켜주자!
        return arr[num];
    }




}
