import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie(); // Trie 트리 하나만

        for(int i = 0; i < n; i++) {
            String alias=trie.insertAndAlias(br.readLine());
            bw.write(alias+"\n");
        }

        bw.flush();
        bw.close();
    }

    static class TrieNode { //Trie노드 ☆하나 하나☆를 나타내는 class.

        Map<Character, TrieNode> childNodes = new HashMap<>(); //☆각 노드의 자식들을 map에 담아둠!
        //"문자 : Trie노드객체하나" 형태이다.
        //각 노드에서, 자식 노드가 10개(0~9)까지 올 수 있기 때문.
        
        boolean isLast; //이게 말단 노드이면 true.
        int times=0; //이 노드로 끝나는 문자열이 몇번 나왔는지
    }

    static class Trie { //Trie 트리 전체
        TrieNode root = new TrieNode(); //루트 노드 하나 만들어줌 . 하나의 Trie 트리에서 루트 하나.

        String insertAndAlias(String word) { //새로운 것 삽입하고, 이전 문장들과 겹치는지도 검사해서 true,false로 반환

            StringBuilder ans = new StringBuilder();
            int aliasIdx=11;
            TrieNode thisNode = root; //현재 노드(trieNode 객체)를 담아줄 field 생성

            for(int i = 0; i < word.length(); i++) { //문자열의 모든 문자에 대해
                char n = word.charAt(i); //하나하나씩

                if(thisNode.childNodes.get(n) == null) { //★현재 노드의 자식 노드에 없으면
                    thisNode.childNodes.put(n, new TrieNode()); //현재 노드의 자식노드 map에 "new TrieNode" 추가
                    aliasIdx=Math.min(aliasIdx,i); //최소 길이의 Alias index
                }

                thisNode = thisNode.childNodes.get(n); //★자식 노드 중 해당하는 node로 thisNode 업데이트!

            }

            //다른 문장과 "완전히" 겹치거나, 다른 문장에 이 문장이 "포함되면"
            if (thisNode.isLast==true || !thisNode.childNodes.isEmpty()) {
                aliasIdx = word.length() - 1; //이 문자열 전체를 써야 함
            }
            ans.append(word.substring(0,aliasIdx+1));

            thisNode.isLast = true; //문자열의 마지막 "문자"가 담긴 Node를 isLast=true 처리해줌
            thisNode.times++;

            //이전에 나온 적 있는 문자면 times까지 넣어줘야 함
            if (thisNode.times!=1){
                ans.append(thisNode.times);
            }



            return ans.toString();

        }
    }
}
