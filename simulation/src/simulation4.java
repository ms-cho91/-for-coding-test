import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class simulation4 {
    public static void main(String[] args) {

        /** 게임 개발
         * 게임 캐릭터가 맵 안에서 움직이는 시스템을 개발 중이다.
         * 캐릭터가 있는 장소는 1x1 크기의 정사각형으로 이뤄진 N x M 크기의 직사각형으로,
         * 각각의 칸은 육지 또는 바다이다. 캐릭터는 동서남북 중 한 곳을 바라본다.
         * 맵의 각 칸은 (A,B)로 나타낼 수 있고, A는 북쪽으로부터 떨어진 칸의 개수,
         * B는 서쪽으로부터 떨어진 칸의 개수이다. 캐릭터는 상하좌우로 움직일 수 있고,
         * 바다로 되어 있는 공간에는 갈 수 없다.
         * 캐릭터의 움직임을 설정하기 위해 정해 놓은 매뉴얼은 이러하다.
         *
         * 현재 위치에서 현재 방향을 기준으로 왼쪽 방향 (반시계 방향으로 90도 회전한 방향)부터 차례대로 갈 곳을 정한다.
         * 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한 칸을 전진한다.
         * 왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향으로 회전만 수행하고 1단계로 돌아간다.
         * 만약 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우에는,
         * 바라보는 방향을 유지한 채로 한 칸 뒤로 가고 1단계로 돌아간다.
         * 단, 이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.
         * 현민이는 위 과저을 반복적으로 수행하면서 캐릭터의 움직임에 이상이 있는지 테스트하려고 한다.
         * 매뉴얼에 따라 캐릭터를 이동시킨 뒤에, 캐릭터가 방문한 칸의 수를 출력하는 프로그램을 만드시오.
         *
         * 입력
         * 첫째 줄에 맵의 세로 크기 N과 가로 크기 M을 공백으로 구분하여 입력한다. (3<=N,M<=50)
         * 둘째 줄에 게임 캐릭터가 있는 칸의 좌표(A,B)와 바라보는 방향 d가 각각 서로 공백으로 구분하여 주어진다. 방향 d의 값으로는 다음과 같이 4가지가 존재한다.
         * 0:북쪽 1:동쪽 2:남쪽 3:서쪽
         * 셋째 줄부터 맵이 육지인지 바다인지에 대한 정보가 주어진다. N개의 줄에 맵의 상태가 북쪽부터 남쪽 순서대로, 각 줄의 데이터는 서쪽부터 동쪽 순서대로 주어진다. 맵의 외곽은 항상 바다로 되어 있다.
         *
         * 출력
         * 첫째 줄에 이동을 마친 후 캐릭터가 방문한 칸의 수를 출력한다.
         */

        /** solution
         * 일반적으로 방향을 설정해서 이동하는 문제 유형에서는 dx, dy라는 별도의 리스트를 만들어 방향을 정하는 것이 효과적이다.
         */




        Scanner sc = new Scanner(System.in);

        // 맵의 크기 입력
        System.out.println("맵의 크기 n m을 입력하시오");
//        int n = sc.nextInt();
//        int m = sc.nextInt();
        int n = 6;
        int m = 6;

        // 캐릭터의 초기 위치 및 방향 입력
        System.out.println("캐릭터의 초기 위치 및 방향 입력");
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        int direction = sc.nextInt();
        int x = 1;
        int y = 1;
        int direction = 0;

        // 맵 정보 입력
//        int[][] map = new int[n][m];
        int[][] map = { {1,1,1,1,1,1},
                        {1,0,0,1,0,1},
                        {1,1,0,0,1,1},
                        {1,0,0,1,0,1},
                        {1,1,0,0,1,1},
                        {1,1,1,1,1,1}
                    };
        int[][] visitMap = new int[n][m];
        visitMap[x][y] = 1;

//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < m; ++j) {
//                System.out.println("맵 정보 입력");
//                map[i][j] = sc.nextInt();
//            }
//        }

        System.out.println("현재 주어진 맵 상태");
        System.out.println(Arrays.deepToString(map));

        System.out.println("현재 플레이어 위치");
        System.out.println(Arrays.deepToString(visitMap));

        // 방문한 칸의 수
        int visitedCount = 0;

        // 북, 동, 남, 서 방향 정의
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        //초기 1번 현재 위치 방문 처리
        ++visitedCount;
        map[x][y] = 1;
        int turnCount = 0;  // 4가지 방향 확인 여부

        // 시뮬레이션 시작
        while (true) {
        boolean moved = false;

        // 왼쪽으로 회전
        direction = (direction + 3) % 4;

        // 이동할 위치 계산
        int nx = x + dx[direction];
        int ny = y + dy[direction];

        //회전한 이후 정면에 육지이고 가보지 않은 칸이면 이동
        if (visitMap[nx][ny] == 0 && map[nx][ny] == 0) {
            x = nx;
            y = ny;
            ++visitedCount;
            visitMap[nx][ny] = 1; //방문 처리
            turnCount = 0;
            System.out.println("현재 플레이어 이동 위치");
            System.out.println(Arrays.deepToString(visitMap));  //현재 맵 출력
            continue;
        } else {
            //회전한 방향에 가보지 않은 칸이 없을 때
            ++turnCount;
        }

        // 네 방향 모두 가봤거나 바다인 경우
        if ( turnCount == 4) {
            nx = x - dx[direction];
            ny = y - dy[direction];

            //가능하다면 한 칸 뒤로
            if (map[nx][ny] == 0 ) {
                x = nx;
                y = ny;
                turnCount = 0;
            } else {
                break;
            }
        }
    }
    // 결과 출력
        System.out.println("총 방문 칸 "+visitedCount);
}


}