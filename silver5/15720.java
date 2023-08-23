import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int b= Integer.parseInt(st.nextToken());
        int c= Integer.parseInt(st.nextToken());
        int d= Integer.parseInt(st.nextToken());

        int min=Math.min(b,Math.min(c,d)), sum=0, discountPrice=0;
        Integer[] bArr=new Integer[b];
        Integer[] cArr=new Integer[c];
        Integer[] dArr=new Integer[d];
        StringTokenizer stB= new StringTokenizer(br.readLine());
        StringTokenizer stC= new StringTokenizer(br.readLine());
        StringTokenizer stD= new StringTokenizer(br.readLine());

        for (int i=0; i<b; i++) {
            bArr[i]=Integer.parseInt(stB.nextToken());
            sum+=bArr[i];
        }

        for (int i=0; i<c; i++) {
            cArr[i]=Integer.parseInt(stC.nextToken());
            sum+=cArr[i];
        }

        for (int i=0; i<d; i++){
            dArr[i]=Integer.parseInt(stD.nextToken());
            sum+=dArr[i];
        }

        Arrays.sort(bArr, Collections.reverseOrder());
        Arrays.sort(cArr, Collections.reverseOrder());
        Arrays.sort(dArr, Collections.reverseOrder());


        for (int i=0; i<min; i++)  discountPrice+= (int) ((bArr[i]+cArr[i]+dArr[i] ) * 0.9);

        for (int i=min; i<b; i++) discountPrice+=bArr[i];
        for (int i=min; i<c; i++) discountPrice+=cArr[i];
        for (int i=min; i<d; i++) discountPrice+=dArr[i];


        System.out.println(sum);
        System.out.println(discountPrice);
    }

}
