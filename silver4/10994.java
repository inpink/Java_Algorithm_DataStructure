import java.util.*;
import java.io.*;

public class Main {

    static char[][] star;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        int m = 4*n -3; //배열(별 전체) 크기
        star = new char[m][m]; //mxm임

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                star[i][j] = ' ';
            }
        }

        pointStar(0, m); //별 그려서 2차원 배열에 담기

        //정답 출력
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
    }

    public static void pointStar(int a, int b) {

        if (b == 1) return; //중앙에 별 1개 그려지면 그만 그려야 함

        for(int i = a; i < b; i++) { //별 그리는 범위 a~b
            star[a][i] = '*'; //윗줄, 왼쪽부터 오른쪽으로 쭉 그리기
            star[b-1][i] = '*'; //맨아랫줄 , 왼쪽부터 오른쪽으로 쭉 그리기
            star[i][a] = '*'; // 왼줄 , 왼쪽부터 오른쪽으로 쭉 그리기
            star[i][b-1] = '*'; // 오른줄 , 왼쪽부터 오른쪽으로 쭉 그리기
        }


        pointStar(a+2, b-2); //★2행, 2열만큼 안쪽으로 이동함
    }
}
