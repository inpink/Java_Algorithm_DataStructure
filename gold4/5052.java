import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) { //케이스 t번 반복

            Trie trie = new Trie(); // 각 케이스당 Trie 트리 하나 만들어줌
            boolean consistency = true; //일관성 true, false 유무 (포함되지 않아야 일관성 true임) 시작은 일관성O

            int n = Integer.parseInt(br.readLine());

            for(int j = 0; j < n; j++) {
                if(!trie.insertAndCheck(br.readLine())) { //★중요한 메소드. 입력받은 "문자열"을 trie에 삽입하고, 일관성 여부 받아옴
                    consistency = false; //일관성이 false면, No를 담아줘야 함.
                }
            }
            sb.append(consistency == true ? "YES\n" : "NO\n"); //일관성 유무에 따라 답을 담아줌
        }

        bw.write(sb.toString()); //정답 출력
        bw.flush();
        bw.close();
    }

    static class TrieNode { //Trie노드 ☆하나 하나☆를 나타내는 class.

        Map<Character, TrieNode> childNodes = new HashMap<>(); //☆각 노드의 자식들을 map에 담아둠!
        //"문자 : Trie노드객체하나" 형태이다.
        //각 노드에서, 자식 노드가 10개(0~9)까지 올 수 있기 때문.

        boolean isLast; //이게 말단 노드이면 true.
    }

    static class Trie { //Trie 트리 전체
        TrieNode root = new TrieNode(); //루트 노드 하나 만들어줌 . 하나의 Trie 트리에서 루트 하나.

        boolean insertAndCheck(String word) { //새로운 것 삽입하고, 이전 문장들과 겹치는지도 검사해서 true,false로 반환
            TrieNode thisNode = root; //현재 노드(trieNode 객체)를 담아줄 field 생성

            for(int i = 0; i < word.length(); i++) { //문자열의 모든 문자에 대해
                char n = word.charAt(i); //하나하나씩

                if(thisNode.childNodes.get(n) == null) { //★현재 노드의 자식 노드에 없으면
                    thisNode.childNodes.put(n, new TrieNode()); //현재 노드의 자식노드 map에 "new TrieNode" 추가
                }

                thisNode = thisNode.childNodes.get(n); //★자식 노드 중 해당하는 node로 thisNode 업데이트!

                if(thisNode.isLast == true) return false; //일관성 없는 경우 1. 문자열 검사하는 도중에, 어떤 것이 이 문자열에 포함된다.
                //★앞서 문자열 끝에 isLast 체크를 해줬기 때문이다!!!!★
                //☆어차피 하나라도 걸리면 전체가 "No"가 되므로, 여기서 탐색 종료해도 됨.
                //만약 중간에 No 걸려도 탐색 지속해야 하면, 여기서 끊어주지 않고 다 넣어줘야 함.
            }

            //일관성 없는 경우 2. 문자열 끝까지 타고왔는데 끝노드가 아니다! 어딘가에 포함된다는 것
            if(thisNode.childNodes.size() != 0) return false;

            thisNode.isLast = true; //문자열의 마지막 "문자"가 담긴 Node를 isLast=true 처리해줌

            return true; //일관성 있는 유일한 경우 1. 어딘가에 포함되지 않고, 어떤것이 여기에 포함되지도 않아야 일관성 있다
        }
    }
}
