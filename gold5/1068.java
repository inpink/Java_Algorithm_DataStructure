import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int removeIdx=Integer.parseInt(br.readLine());
        int leafNodeCount;

        int[] parentArr=new int[n];

        for (int i=0; i<n; i++){
            parentArr[i]= Integer.parseInt(st.nextToken());
        }

        removeNode(parentArr,n,removeIdx);
        leafNodeCount=countLeafNode(parentArr,n);
        //System.out.println(Arrays.toString(parentArr));
        System.out.println(leafNodeCount);
    }

    public static void removeNode(int[] parent, int n, int idx) {
        parent[idx] = -2;

        for(int i = 0 ; i < n ; i++){
            if(parent[i] == idx)
                removeNode(parent,n,i);
        }
    }

    public static int countLeafNode(int[] parent, int n) {
        int leafNodeCount=0;
        int[] leafArr=new int[n];

        for(int i = 0 ; i < n ; i++){
            int parentI=parent[i];

            if (parentI==-1) continue;
            else if (parentI==-2){
                leafArr[i]=-2;
            }
            else{
                leafArr[parentI]++;
            }
        }

        for(int i = 0 ; i < n ; i++) {
            if (leafArr[i]==0) leafNodeCount++;
        }

        return  leafNodeCount;
    }

}

