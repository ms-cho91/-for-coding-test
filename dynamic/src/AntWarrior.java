import java.util.Scanner;

public class AntWarrior {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 식량창고의 개수 n 입력
        int n = scanner.nextInt();

        // 각 식량창고에 저장된 식량의 개수 배열
        int[] foodStorages = new int[n];

        // 식량창고에 저장된 식량의 개수 입력
        for (int i = 0; i < n; i++) {
            foodStorages[i] = scanner.nextInt();
        }

        // 각 식량창고까지의 최대 식량 양을 저장하는 배열
        int[] dp = new int[n];

        // 첫 번째 식량창고까지의 최대 식량 양
        dp[0] = foodStorages[0];

        // 두 번째 식량창고까지의 최대 식량 양
        dp[1] = Math.max(foodStorages[0], foodStorages[1]);

        // 동적 프로그래밍을 사용하여 각 식량창고까지의 최대 식량 양 계산
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + foodStorages[i]);
        }

        // 결과 출력
        System.out.println(dp[n - 1]);
    }
}