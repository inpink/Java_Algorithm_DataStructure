import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = br.readLine();
        String p = br.readLine();

        KMP(t,p);
    }

    // idx=P에서 처음부터 일치된 개수 , i=T의맨끝   <-으로 둘을 분리해서 보는 것이 중요하다.
    static void KMP(String parent, String pattern){
        int[] table = makeTable(pattern); //부분 테이블 형성해서 가져오기
        StringBuilder sb = new StringBuilder();

        int n1 = parent.length(), n2 = pattern.length();
        int idx=0; //P문자열 일치 개수
        int cnt=0; //T에서 P가 일치하는 개수
        for(int i=0; i<n1; i++) { //T의 하나하나 검사.

            while(idx>0 && parent.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1]; //★table값을 쓰는 것들은 모두 KMP가 적용되는 것!
            }

            if(parent.charAt(i) == pattern.charAt(idx)) { //일치하는
                if(idx == n2-1) { //P의 문자열 끝까지 다 맞으면 count
                    sb.append((i-idx+1)+" "); //P가 나타나는 시작 idx
                    cnt++;
                    idx = table[idx]; //★KMP가 적용되는 것! ★일치 하나 시켰으면, 다시 돌아가서 P개를 셀 수 있게 해줘야함!
                    //예를 들어 p=abcab가 일치했으면, table[5]=2고, t와 ab는 일치한다는 것을 아니까,
                    // p의 c부터(2번쨰) 탐색하도록 하는 것. ★★★이 다음의 i는 c와 일치하는지만 검사하면 됨★★★
                }else { //아직 P의 문자열 끝까지는 아니면 idx+=1(P문자열 일치 개수 +=1)
                    idx +=1;
                }
            }
        }

        System.out.println(cnt); //일치하는 문자열 개수
        System.out.println(sb.toString()); //P가 나타나는 위치를 차례대로 공백으로 구분해 출력

    }


    // idx=P에서 처음부터 일치된 개수 , i=P의맨끝   <-으로 둘을 분리해서 보는 것이 중요하다.
    //위에서 달라진 점은 i가 T의 맨끝이 아니라 P의 맨끝일 뿐. 결국 둘은 비슷하게 KMP알고리즘을 쓰고있는 것.
    //둘은 idx번쨰와 i번째 문자가 일치할 때, 적용해주는 부분만 조금 다름
    static int[] makeTable(String pattern) { //부분 일치 테이블 생성. 이또한 KMP이용
        int n = pattern.length();
        int[] table = new int[n]; //table에,
        // 각 문자 a, ab, abc, abcd, abcda, abcdab, abcdabd에 대한 "접두사 접미사 일치 개수"를 담음.
        //0 0 0 0 1 2 0 이 담김.
        //일치 개수만큼, 달라지는 부분에서 뒤로 가서 탐색 지속하면 됨.
        //예를 들어, t=abcdabc..에서 c!=d로 멈춤. c빼고 지금까지 일치된 "abcdab"는 일치 개수가 2였음. (ab접두사와 ab접미사)
        //c의 2자리 뒤인 a부터 탐색할 수 있다는 것.

        //t= ababcd,  p=abcd라면
        //테이블이 a ab abc abcd고, 0 0 0 0이 됨.
        //t=aba...에서 a!=c로 멈춤. "ab"는 일치개수가 0임. 즉, 틀린 부분 t의 a부터 다시 탐색 지속.
        //위와 같이 접두사, 접미사가 없는 경우에도 O(N+M)인 것! 일치하는 문자가 없다는것조차 힌트가 되기 때문!

        int idx = 0; //어디서부터 일치해야 "일치 개수 점수"를 줄 수 있는지. = 어디까지 일치되는지
        // 처음에는 맨 처음 0번째인 a부터.

        // i= 항상 맨 끝문자.
        // ☆idx번째와 i번째가 일치하는지 검사해야함☆
        for(int i=1; i<n; i++) { //어차피 i=0일 땐 0이 담김. 모든 i~(0,n) 부분 문자열에 대해 테이블 형성
            //☆매번 일치하는 범위를  bruteforce로 다 검사하면 대략 M*M=100만*100만으로 이 또한 시간초과.
            //KMP이용해야 함.

            //이전에 "일치 개수"가 있고(idx>0), 이전에 일치하는 문자 그 다음(현재 idx)이, 맨끝(i)이 일치하지 않는 경우,
            //일치 개수(idx)를 줄여줘야 함.
            //abcdabd에서, ab ab까지는 맞았는데, abc에 abd가 맞지 않는다. abc가 되어야 일치하는 idx개수를 +1해줄 수 있는건데.
            //이 경우, ☆idx==0이 되거나, 맨끝(i)와 일치하는 idx를 찾을때까지 이 while문은 반복된다.
            //★결국 이 반복문에서 i입장에서 중요한 것은 맨끝과 일치하는 i가 있는지이다!★
            //☆현재의 idx에서는 일치하지 않아서 idx를 줄여줘야 한다고 했다.
            // 그럼 어디서부터 검사할 것인가?
            // =>★ 이 또한 KMP를 적용해서 빠르게 탐색해주자!
            //★ idx>0인 상태이기 때문에, idx-1까지는 일치한다는 것을 알 수 있다. idx까지는 일치하지 않지만 idx-1까지는 일치한다.
            //★★=> table[idx-1]=a라면, a번째까지는
            //i는 a번째부터 검사하면 된다는 뜻

            //P=ababac에 대한 테이블을 만들 때, 부분문자열이 abac일 때, 끝에서 일치하지않음.
            //이 때, aba까지는 맞다는 것을 알 수 있었음. 이 때, table["aba"]=1임. 처음 a와 끝의 a가 같으므로, 1번째인 b부터 같으면 된다는 의미로 idx=1를 준 것임!!!
            // 0번째 a가 일치하므로, abac가 아니었지만, 줄여서 ab는 검사해볼만 하다는 것. 
            // 하지만 이또한 ab!=ac로 결국 table["abac"]=0이 됨.

            //예)  ab, abc, abcd, abcda시점에선 아직까지 이전에 "일치 개수"가 없어서(idx==0), 이 while문 패스
            //예) abcdabd시점에선 a,b두개가 일치해서 idx=2가 되어있음. 근데 c!=d임. idx=table[1]=0이 됨
            while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1]; //★KMP가 적용되는 것!
            }
            if(pattern.charAt(i) == pattern.charAt(idx)) { //같으면
                table[i] = ++idx; //현재 idx+1개수만큼은 접두사 ,접미사 일치하는 것
            }

        }
        return table;
    }
}
