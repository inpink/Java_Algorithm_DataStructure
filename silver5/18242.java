import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int startX=0,startY=0,endX=0,endY=0;
        boolean foundStart=false, foundEnd=false;
        String ans="";
        String[][] boardArr= new String[n][m];

        //input
        for (int i=0; i<n; i++){
                boardArr[i]=br.readLine().split("");
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (boardArr[i][j].equals("#")){
                    startX=i;
                    startY=j;
                    foundStart=true;
                    break;
                }
            }
            if (foundStart) break;

        }

        for (int i=n-1; i>=0; i--){
            for (int j=m-1; j>=0; j--){
                if (boardArr[i][j].equals("#")){
                    endX=i;
                    endY=j;
                    foundEnd=true;
                    break;
                }
            }
            if (foundEnd) break;
        }

        //System.out.println(startX+" "+startY+" "+endX+" "+endY);
        ans=getRectangleDirection(boardArr,startX,startY,endX,endY);

        System.out.println(ans);
    }

    public static String getRectangleDirection(String[][] boardArr, int startX, int startY, int endX, int endY){
        String[] directionArr = new String[] {"UP","DOWN","LEFT","RIGHT"};
        String ans="";
        int[] sharpCountArr = countSharpOnSides(boardArr,startX,startY,endX,endY);

        for (int i=0; i<4; i++){
            if (sharpCountArr[i]==1) {
                ans=directionArr[i];
            }
        }
        //System.out.println(Arrays.toString(sharpCountArr));
        return ans;
    }

    public static int[] countSharpOnSides(String[][] boardArr,int startX, int startY, int endX, int endY){
        int[] sharpCountArr = new int[4];

        //Up, down
        sharpCountArr[0] = (int) Arrays.stream(boardArr[startX], startY, endY+1).filter(s -> s.equals(".")).count();
        sharpCountArr[1] = (int) Arrays.stream(boardArr[endX], startY, endY+1).filter(s -> s.equals(".")).count();

        //Left, right
        for (int i=startX; i<=endX; i++) {
            if (boardArr[i][startY].equals("."))
                sharpCountArr[2]=1;
        }

        for (int i=startX; i<=endX; i++) {
            if (boardArr[i][endY].equals("."))
                sharpCountArr[3]=1;
        }

        return sharpCountArr;
    }


}
