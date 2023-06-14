import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        HashMap<Character,String> dicMap= new HashMap<>(){{
            put('1',"one");
            put('2',"two");
            put('3',"three");
            put('4',"four");
            put('5',"five");
            put('6',"six");
            put('7',"seven");
            put('8',"eight");
            put('9',"nine");
            put('0',"zero");
        }};
        HashMap<String, Integer> numMap= new HashMap<>();
        ArrayList<String> numNames= new ArrayList<>();

        String stringI, transNum;
        for (int i=n; i<=m; i++){
            stringI=Integer.toString(i);
            StringBuilder stringNum = new StringBuilder();
            for (int j=0; j<stringI.length(); j++){
                stringNum.append(dicMap.get(stringI.charAt(j)));
            }
            transNum=stringNum.toString();
            numMap.put(transNum.toString(),i);
            numNames.add(transNum.toString());
        }

        //System.out.println(numMap);\
        Collections.sort(numNames);

        for (int i=1; i<=numNames.size(); i++){

            transNum=numNames.get(i-1);
            bw.write(numMap.get(transNum)+" ");

            if (i%10==0) bw.write("\n");

        }


        //OUTPUT
        bw.flush();
        bw.close();
    }

}
