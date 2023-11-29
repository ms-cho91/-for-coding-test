import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class simulation3 {
    public static void main(String[] args) {

        /** 왕실의 나이트
         * 행복 왕국의 왕실 정원은 체스판과 같은 8x8 좌표 평면이다.
         * 왕실 정원의 특정한 한 칸에 나이트가 서 있다.
         * 나이트는 매우 충성스러운 신하로서 매일 무술을 연마한다.
         * 나이트는 말을 타고 있기 때문에 이동을 할 때는 L자 형태로만 이동할 수 있으며 정원 밖으로는 나갈 수 없다.
         * 나이트는 특정한 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.
         *
         * 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
         * 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
         * 이처럼 8x8 좌표 평면상에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하시오.
         * 이때 왕실의 정원에서 행 위치를 표현할 때는 1부터 8로 표현하며, 열 위치를 표현할 때는 a부터 h로 표현한다.
         *
         * 예를 들어 만약 나이트가 a1에 있을 때 이동할 수 있는 경우의 수는 다음 2가지이다.
         * a1의 위치는 좌표 평면에서 구석의 위치에 해당하며 나이트는 정원의 밖으로는 나갈 수 없기 때문이다.
         *
         * 오른쪽으로 두 칸 이동 후 아래로 한 칸 이동하기
         * 아래로 두 칸 이동 후 오른쪽으로 한 칸 이동하기
         *
         * 입력
         * 첫째 줄에 8x8 좌표 평면상에서 현재 나이트가 위치한 곳의 좌표를 나타내는 두 문자로 구성된 문자열이 입력된다. 입력 문자는 a1처럼 열과 행으로 이뤄진다.
         *
         * 출력
         * 첫째 줄에 나이트가 이동할 수 있는 경우의 수를 출력하시오.
         */

        /** solution
         * 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
         * 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
         * 나이트의 이동 경로를 move_type 변수에 넣는다면,
         * 이 2가지 규칙에 따라 move_type = [(-2,1),(-2,-1),(2,1),(2,-1),(-1,2),(-1,-2),(1,-2),(1,2)]로 값을 대입할 수 있다.
         */


        Scanner sc = new Scanner(System.in);

        System.out.println("좌표 입력 e.g. a5");
        String position = sc.next();


        // 이동 가능한 경우의 수 계산
        int moveCount = countPossibleMoves(position);

        // 결과 출력
        System.out.println(moveCount);
    }


    // 나이트가 이동할 수 있는 경우의 수 계산하는 함수
    private static int countPossibleMoves(String position) {

        int col = position.charAt(0) - 'a' + 1; // 열
        int row = position.charAt(1) - '0'; // 행

        int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = col + dx[i];
            int ny = row + dy[i];

            // 이동 가능한 좌표인지 확인
            if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
                count++;
            }
        }

        return count;
    }


    //2차원 배열
//    private static int countPossibleMoves(String position) {
//
//        int col = position.charAt(0) - 'a' + 1; // 열
//        int row = position.charAt(1) - '0'; // 행
//
//        int count = 0;
//
//        // 이동 가능한 경우의 수 계산
//        int[][] moveType = { {-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {1, -2}, {1, 2} };
//
//        for (int[] move : moveType) {
//            int nrow = row + move[0];
//            int ncol = col + move[1];
//
//            // 이동 가능한 좌표인지 확인
//            if (nrow >= 1 && nrow <= 8 && ncol >= 1 && ncol <= 8) {
//                ++count;
//            }
//        }
//
//        return count;
//    }


}