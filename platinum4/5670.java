import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);

        //입력
        while(sc.hasNextLine()) { //EOF

            Trie trie = new Trie(); // 각 케이스당 Trie 트리 하나 만들어줌

            int n = Integer.parseInt(sc.nextLine());
            String[] wordArr= new String[n];
            String s;

            for(int j = 0; j < n; j++) {
                s= sc.nextLine();
                wordArr[j]=s; //배열에 차곡차곡 담아두고
                trie.insert(s); //★중요한 메소드. 입력받은 "문자열"을 trie에 삽입
            }

            //각각 몇번 걸리는지 세기
            int sum=0;
            float avg;
            for(int j = 0; j < n; j++) {
                s=wordArr[j];
                sum+=(trie.countPush(s));
                //System.out.println(trie.countPush(s));
            }
            avg=sum/(float) n;
            System.out.println(String.format("%.2f",avg));//소수점 둘째자리까지
        }

    }

    static class TrieNode { //Trie노드 ☆하나 하나☆를 나타내는 class.

        Map<Character, TrieNode> childNodes = new HashMap<>(); //☆각 노드의 자식들을 map에 담아둠!
        //"문자 : Trie노드객체하나" 형태이다.

        boolean isLast; //이게 말단 노드이면 true.
    }

    static class Trie { //Trie 트리 전체
        TrieNode root = new TrieNode(); //루트 노드 하나 만들어줌 . 하나의 Trie 트리에서 루트 하나.

        void insert(String word) { //새로운 것 삽입
            TrieNode thisNode = root;

            for(int i = 0; i < word.length(); i++) { //문자열의 모든 문자에 대해
                char n = word.charAt(i); //하나하나씩

                if(thisNode.childNodes.get(n) == null) { //★현재 노드의 자식 노드에 없으면
                    thisNode.childNodes.put(n, new TrieNode()); //현재 노드의 자식노드 map에 "new TrieNode" 추가
                }

                thisNode = thisNode.childNodes.get(n); //★자식 노드 중 해당하는 node로 thisNode 업데이트!

            }

            thisNode.isLast = true; //문자열의 마지막 "문자"가 담긴 Node를 isLast=true 처리해줌
        }

        int countPush(String word){

            //첫번째꺼는 누르고 시작
            TrieNode thisNode = root.childNodes.get(word.charAt(0));

            int len=word.length();
            int count=1; //첫번째꺼는 누르고 시작

            for (int i=1; i<len; i++){
                char thisChar = word.charAt(i);
                TrieNode nextNode =thisNode.childNodes.get(thisChar);

                //★thisNode(i-1)에서, nextNode(i(1~len-1))를 눌러야 하는가?를 판단★
                //다음 버튼을 눌러야 하는경우
                //현재가 isLast
                //현재의 자식들이 2개 이상
                if (thisNode.isLast) count++;
                else if (thisNode.childNodes.size()>=2) count++;
                thisNode = nextNode;

            }

            return count;
        }

    }
}
