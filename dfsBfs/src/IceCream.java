import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IceCream {

    static int n, m;
    static int[][] iceFrame;
    static boolean[][] visited;

    public static void main(String[] args) {

        /** 음료수 얼려 먹기
         * N x M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
         * 구멍이 뚫려 있는 부분끼리 상,하,좌,우 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
         * 이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시오.
         *
         * 입력
         * 첫 번째 줄에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어진다. (1<=N, M<=1,000)
         * 두 번째 줄부터 N+1 번째 줄까지 얼음 틀의 형태가 주어진다.
         * 이때 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1이다.
         * 출력
         * 한 번에 만들 수 있는 아이스크림의 개수를 출력한다.
         */

        /** solution
         * 이 문제는 DFS로 해결할 수 있다.
         * 먼저 특정한 지점의 주변 상,하,좌,우를 살펴본 뒤에 주변 지점 중에서 값이 '0'이면서 아직 방문하지 않은 지점이 있다면 해당 지점을 방문한다.
         * 방문한 지점에서 다시 상,하,좌,우를 살펴보면서 방문을 다시 진행하면, 연결된 모든 지점을 방문할 수 있다.
         */

        Scanner sc = new Scanner(System.in);

        // 얼음 틀의 크기 입력
        n = sc.nextInt();
        m = sc.nextInt();

        // 얼음 틀 초기화
        iceFrame = new int[n][m];
        visited = new boolean[n][m];

        // 얼음 틀의 상태 입력
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                iceFrame[i][j] = row.charAt(j) - '0';
            }
        }

        // DFS를 사용하여 아이스크림 개수 계산
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (iceFrame[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j);
                    result++;
                }
            }
        }

        System.out.println("총 아이스크림의 개수: " + result);
    }

    // DFS로 연결된 구멍 찾기
    static void dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }

        if (iceFrame[x][y] == 0 && !visited[x][y]) {
            visited[x][y] = true;

            // 상, 하, 좌, 우 방향으로 이동
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
        }

    }

}