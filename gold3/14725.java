import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        int n = Integer.parseInt(br.readLine());

        Trie trie = new Trie(); // Trie 트리 하나 만들어줌

        for(int i = 0; i < n; i++) { //n개 입력
            trie.insertAndCheck(br.readLine().split(" ")); //Trie 트리에 삽입

        }

        //Trie 트리 출력
        trie.printT(trie.root,0);
    }

    static class TrieNode { //Trie노드 ☆하나 하나☆를 나타내는 class.

        Map<String, TrieNode> childNodes = new HashMap<>(); //☆각 노드의 자식들을 map에 담아둠!
        //"문자 : Trie노드객체하나" 형태이다.
        //각 노드에서, 자식 노드가 10개(0~9)까지 올 수 있기 때문.

    }

    static class Trie { //Trie 트리 전체
        TrieNode root = new TrieNode(); //루트 노드 하나 만들어줌 . 하나의 Trie 트리에서 루트 하나.

        void insertAndCheck(String[] words) { //새로운 것 삽입
            TrieNode thisNode = root; //현재 노드(trieNode 객체)를 담아줄 field 생성

            for(int i = 1; i < words.length; i++) { //문자 배열의 모든 문자열에 대해
                String str = words[i]; //하나하나씩

                if(thisNode.childNodes.get(str) == null) { //★현재 노드의 자식 노드에 없으면
                    thisNode.childNodes.put(str, new TrieNode()); //현재 노드의 자식노드 map에 "new TrieNode" 추가
                }

                thisNode = thisNode.childNodes.get(str); //★자식 노드 중 해당하는 node로 thisNode 업데이트!
            }
        }

        //재귀로 오름차순, 깊이우선 두 가지 구현
        void printT(TrieNode thisNode, int count){


            Object[] childKeyArr =  thisNode.childNodes.keySet().toArray();
            //System.out.println(childKeyArr);
            Arrays.sort(childKeyArr);
            for (Object s : childKeyArr){
                for (int i=0; i<count; i++) System.out.print("--");
                System.out.println(s);

                printT(thisNode.childNodes.get(s),count+1);
            }

        }
    }
}
