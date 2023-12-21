import java.util.Scanner;

public class Tiling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N 입력
        int N = scanner.nextInt();

        // dp 배열 초기화
        int[] dp = new int[N + 1];

        // 초기값 설정
        dp[1] = 1;
        dp[2] = 3;

        // 동적 프로그래밍을 사용하여 모든 경우의 수 계산
        for (int i = 3; i <= N; i++) {
            // 796796로 나누는 이유 모듈러 연산 또는 나머지 연산
            // 일반적으로 결과를 특정 값으로 제한하여 오버플로우나 계산의 효율성을 고려
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 796796;
        }

        // 결과 출력
        System.out.println(dp[N]);
    }
}