import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Snake {
    int x, y;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class simulation7 {

    public static int n, k, l;
    public static int[][] board;
    public static int[] dx = {0, 1, 0, -1}; // 동, 남, 서, 북
    public static int[] dy = {1, 0, -1, 0}; // 동, 남, 서, 북

    public static int turn(int direction, char cmd) {
        if (cmd == 'L') {
            return (direction - 1 + 4) % 4; // 왼쪽으로 90도 회전
        } else {
            return (direction + 1) % 4; // 오른쪽으로 90도 회전
        }
    }

    public static void main(String[] args) {

        /** 뱀 게임
         * 'Dummy'라는 도스 게임이 있습니다. 이 게임에는 뱀이 나와서 기어 다니는데, 사과를 먹으면 뱀 길이가 늘어납니다.
         * 뱀이 이리저리 기어 다니다가 벽 또는 자기 자신의 몸과 부딪히면 게임이 끝납니다.
         * 게임은 N x N 정사각 보드 위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있습니다.
         * 보드의 상하좌우 끝에는 벽이 있습니다.
         * 게임을 시작할 때 뱀은 맨 위 맨 좌측에 위치하고 뱀의 길이는 1입니다. 뱀은 처음에 오른쪽을 향합니다.
         * 뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따릅니다.
         *
         * 먼저 뱀은 몸길이를 늘려 머리를 다음 칸에 위치시킵니다.
         * 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않습니다.
         * 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워줍니다. 즉, 몸길이는 변하지 않습니다.
         *
         * 입력
         * 첫째 줄에 보드의 크기 N이 주어집니다. (2<=N<=100) 다음 줄에 사과의 개수 K가 주어집니다. (0<=K<=100)
         * 다음 K개의 줄에는 사과의 위치가 주어지는데,
         * 첫 번째 정수는 행, 두 번째 정수는 열 위치를 의미합니다.
         * 사과의 위치는 모두 다르며, 맨 위 맨 좌측(1행 1열)에는 사과가 없습니다.
         * 다음 줄에는 뱀의 방향 변환 횟수 L이 주어집니다. (1<=L<=100)
         * 다음 L개의 줄에는 뱀의 방향 변환 정보가 주어지는데, 정수 X와 문자 C로 이루어져 있으며,
         * 게임 시작 시간으로부터 X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')으로 90도 방향을 회전시킨다는 뜻입니다.
         * X는 10,000 이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 주어집니다.
         *
         * 출력
         * 첫째 줄에 게임이 몇 초에 끝나는지 출력합니다.
         */

        /** solution
         * 매 시점마다 뱀이 존재하는 위치를 항상 2차원 리스트에 기록해야 한다.
         */

        Scanner sc = new Scanner(System.in);

        // 보드의 크기와 초기 설정
        System.out.println("보드 크기 입력");
//        n = sc.nextInt();
//        k = sc.nextInt();
        n = 10;
        k = 4;
        board = new int[n + 1][n + 1];

//        // 사과의 위치 설정
//        for (int i = 0; i < k; i++) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            board[x][y] = 1; // 사과 위치 표시
//        }
        board[1][2] = 1;
        board[1][3] = 1;
        board[1][4] = 1;
        board[1][5] = 1;


        // 뱀 초기 설정
        LinkedList<Snake> snake = new LinkedList<>();
        snake.add(new Snake(1, 1));
        int direction = 0; // 초기 방향: 동쪽

        // 방향 변환 정보 입력
//        l = sc.nextInt();
        l = 4;
        int time = 0;
        Queue<int[]> turns = new LinkedList<>();

//        for (int i = 0; i < l; i++) {
//            int x = sc.nextInt();
//            char cmd = sc.next().charAt(0);
//            turns.offer(new int[]{x, cmd});
//        }

        turns.offer(new int[]{8, 'D'});
        turns.offer(new int[]{10, 'D'});
        turns.offer(new int[]{11, 'D'});
        turns.offer(new int[]{13, 'L'});

        while (true) {
            time++;

            // 머리 이동
            Snake head = snake.getFirst();
            int nx = head.x + dx[direction];
            int ny = head.y + dy[direction];

            // 게임 종료 조건 확인
            if (nx <= 0 || nx > n || ny <= 0 || ny > n || board[nx][ny] == 2) {
                break;
            }

            // 사과가 있는 경우
            if (board[nx][ny] == 1) {
                board[nx][ny] = 2;
                snake.addFirst(new Snake(nx, ny));
            } else { // 사과가 없는 경우
                Snake tail = snake.removeLast();
                board[tail.x][tail.y] = 0;
                snake.addFirst(new Snake(nx, ny));
                board[nx][ny] = 2;
            }

            // 방향 변환 시간이 되면 방향 전환
            if (!turns.isEmpty() && time == turns.peek()[0]) {
                direction = turn(direction, (char)turns.poll()[1]);
            }
        }

        System.out.println("게임 종료 시간 "+time);

    }

}

