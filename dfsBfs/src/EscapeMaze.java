import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EscapeMaze {

    static int n, m;
    static int[][] maze;
    static int[][] distance;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 방향
    static int[] dy = {0, 0, -1, 1};
    // DFS로 연결된 구멍 찾기


    public static void main(String[] args) {

        /** 미로 탈출
         * 동빈이는 N x M 크기의 직사각형 형태의 미로에 갇혀 있다.
         * 미로에는 여러 마리의 괴물이 있어 이를 피해 탈출해야 한다.
         * 동빈이의 위치는 (1,1)이고 미로의 출구는 (N,M)의 위치에 존재하며 한번에 한 칸씩 이동할 수 있다.
         * 이때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있다.
         * 미로는 반드시 탈출할 수 있는 형태로 제시된다.
         * 이때 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하시오.
         * 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산한다.
         *
         * 입력
         * 첫째 줄에 두 정수 N, M (4<=N, M<=200)이 주어집니다.
         * 다음 N개의 줄에는 각각 M개의 정수(0 혹은 1)로 미로의 정보가 주어진다.
         * 각각의 수들은 공백 없이 붙어서 입력으로 제시된다. 또한 시작 칸과 마지막 칸은 항상 1이다.
         *
         * 출력
         * 첫째 줄에 최소 이동 칸의 개수를 출력한다.
         */

        /** solution
         * 이 문제는 최단 거리를 구하는 문제로,
         * 대표적인 그래프 탐색 알고리즘인 BFS(너비 우선 탐색)을 사용하여 해결할 수 있습니다.
         * BFS를 활용하여 시작 지점부터 모든 칸까지의 최소 이동 칸의 개수를 구하면 됩니다.
         */

        Scanner sc = new Scanner(System.in);

        // 미로의 크기 입력
//        n = sc.nextInt();
//        m = sc.nextInt();

        n = 5;
        m = 6;

        // 미로 정보 입력
//        maze = new int[n][m];
        distance = new int[n][m];

        maze = new int[][] { {1, 0, 1, 0, 1, 0},
                            {1, 1, 1, 1, 1, 1},
                            {0, 0, 0, 0, 0, 1},
                            {1, 1, 1, 1, 1, 1},
                            {1, 1, 1, 1, 1, 1}
                         };
//        for (int i = 0; i < n; i++) {
//            String row = sc.next();
//            for (int j = 0; j < m; j++) {
//                maze[i][j] = row.charAt(j) - '0';
//            }
//        }

        // BFS를 사용하여 최소 이동 칸의 개수 계산
        bfs(0, 0);

        // 결과 출력
        System.out.println("최소 이동 칸의 개수: " + distance[n - 1][m - 1]);
    }

    // BFS로 최소 이동 칸의 개수 계산
    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        distance[startX][startY] = 1; // 시작 지점은 1로 초기화

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 상하좌우 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 이동 가능한 위치이면서 방문하지 않은 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 1 && distance[nx][ny] == 0) {
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }


}