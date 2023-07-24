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

        String str=br.readLine();
        int len= str.length();
        int times= len/3;
        ArrayList<String> ansList=new ArrayList<>();

        int pointer=len;
        for(int i=0; i<times; i++){
            String subString=str.substring(pointer-3,pointer);
            twoToEight(ansList,subString);
            pointer-=3;
        }
        //System.out.println(pointer);
        
        //앞에 남은것 있으면 처리
        if (pointer!=0){
            String subString=str.substring(0,pointer);
            twoToEight(ansList,subString);
        }

        //System.out.println(ansList);
        
        //OUTPUT
        for (int i=ansList.size()-1; i>=0; i--) bw.write(ansList.get(i));
        bw.flush();
        bw.close();
    }

    public static void twoToEight(ArrayList<String> arr,String subString){

        //System.out.println(subString);
        int twoToTen=Integer.parseInt(subString,2);
        //System.out.println(twoToTen);
        String tenToEight=Integer.toOctalString(twoToTen);
        arr.add(tenToEight);

    }

}
