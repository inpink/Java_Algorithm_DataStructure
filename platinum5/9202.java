import java.io.*;
import java.util.*;

public class Main{

    //전체 프로그램에서 공용으로 쓰는 것 static(전역 공유)로 관리
    static int boardSize=4;
    static int maxWorldLen;

    // 왼, 왼위대각, 위, 오른위대각, 오른, 오른아래대각, 아래, 왼아래대각 8방향
    static int[][] dir= new int[][] { {-1,0}, {-1,-1}, {0,-1}, {1,-1}, {1,0}, {1,1}, {0,1}, {-1,1}};
    static Set<String> set= new HashSet<>(); //set에 담음
    static Map<Integer,Integer> scoreMap = new HashMap<>(){{
        put(1,0);
        put(2,0);
        put(3,1);
        put(4,1);
        put(5,2);
        put(6,3);
        put(7,5);
        put(8,11);
    }};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int w=Integer.parseInt(br.readLine()); //단어 개수
        for (int i=0; i<w; i++){
            String s=br.readLine();
            set.add(s);
            maxWorldLen=Math.max(maxWorldLen, s.length());
        }
        br.readLine(); //한줄 입력

        int b=Integer.parseInt(br.readLine()); //보드 개수
        for (int i=0; i<b; i++) {
            char[][] board=new char[boardSize][boardSize]; //보드는 4x4

            for (int j=0; j<4; j++) board[j]=br.readLine().toCharArray();

            String ans=findBoggle(board);
            bw.write(ans+"\n");

            if (i!=b-1) br.readLine(); //한줄 입력. 마지막 줄에서는 입력받으면 안됨!
        }

        bw.flush();
        bw.close();
    }

    //최종 정답을 구하고, 정답 형식 맞춰서 String으로 반환
    public static String findBoggle(char[][] board){

        //찾은 단어를 담는 Set (단어 중복으로 찾아도 1개로 취급)
        Set<String> wordFound = new HashSet<>();

        //정답 담을 StringBuilder
        StringBuilder sb= new StringBuilder();

        //모든 요소가 시작점이 될 수 있음
        for (int x=0; x<boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                boolean[][] visited= new boolean[boardSize][boardSize]; //visited 매번 초기화

                //board, 찾은 단어 담을 set, visited, xy좌표(시작점으로 시작), 현재까지 이어지는 단어 ,dfs 깊이
                dfs(board,wordFound,visited,x,y,"",0);
            }
        }

        //찾은 모든 단어에 대해 정답 형식 만들기
        Object[] wordFoundArr = wordFound.toArray(); //set to 배열
        Arrays.sort(wordFoundArr); //사전순을 위해 정렬

        int score=0;
        int maxLen=0;
        String maxWord="";
        int countWords=wordFound.size();
        for ( Object s : wordFoundArr){
            String word=s.toString();
            int thisWordLen= word.length();

            if (maxLen<thisWordLen){
                maxLen=thisWordLen;
                maxWord=word;
            }

            score+=scoreMap.get(thisWordLen);
        }

        sb.append(score+" ");
        sb.append(maxWord+" ");
        sb.append(countWords);

        return sb.toString();
    }

    //dfs하며 찾은 단어를 담아줌
    public static void dfs(char[][] board, Set<String> wordFound, boolean[][] visited, int x, int y, String word, int depth){

        //dfs 종료 조건
        if (depth>maxWorldLen) {
            return;
        }
        //System.out.println("현재까지 단어 "+word+" "+depth);

        visited[x][y]=true; //방문처리
        word+=board[x][y]; //방문한 곳이라면 단어 차곡차곡 담아주고
        if (set.contains(word)) wordFound.add(word); //만약 있는 단어면 set에 담아주자

        for (int i=0; i<8; i++){ //모든 방향에 대해 검사
            int dirX=dir[i][0];
            int dirY=dir[i][1];

            int nextX=x+dirX;
            int nextY=y+dirY;

            //이미 방문했거나, 벽이면 PASS
            if ( nextX<0 || nextX>=boardSize || nextY<0 || nextY>=boardSize || visited[nextX][nextY]  ) continue;

            //System.out.println(nextX+" "+nextY);

            dfs(board,wordFound,visited,nextX,nextY,word,depth+1);
            visited[nextX][nextY]=false;//백트래킹 해줘야함! 하나의 word에서 같은 char을 여러번 사용하면 안되는데, 탐색 방향이 여러개이기 때문
        }

    }
}
