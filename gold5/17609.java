import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            System.out.println(palindrome(br.readLine(),0));
        }

    }

    public static int palindrome(String s,int depth){ //문자열의 길이가 10만이기 때문에 depth 계산해서 잘라줘야함 아니면 메모리&시간초과
        //System.out.println(s);
        if (depth>=2) return 2; //깊이가 2이상이라는 것은, 다른 쌍이 2개 이상 나왔다는 것. 더 탐색할 필요 없다

        int len=s.length();

        int pseudoCount=0;

        for (int i=0; i<len/2; i++){
            int j=len-i-1;
            if (s.charAt(i)!=s.charAt(j)){
                //System.out.println("S : "+s+" "+s.substring(i,j)+" "+s.substring(i+1,j+1));
                if (palindrome(s.substring(i,j),depth+1)==0 || palindrome(s.substring(i+1,j+1),depth+1)==0) {
                    pseudoCount=1;
                    break;
                }
                else{
                    pseudoCount=2;
                    break;
                }
            }
        }

        if (pseudoCount==0) return 0;
        else if (pseudoCount==1) return 1;
        else return 2;

    }


}
