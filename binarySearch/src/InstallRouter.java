import java.util.Arrays;
import java.util.Scanner;

public class InstallRouter {


    public static void main(String[] args) {

        /** 공유기 설치
         * 도현이의 집 N개가 수직선 위에 있습니다.
         * 각각의 집의 좌표는 x1, x2, ..., xn이고 집 여러 개가 같은 좌표를 가지는 일은 없습니다.
         *
         * 도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 합니다.
         * 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에,
         * 한 집에서는 공유기를 하나만 설치할 수 있고, 가장 인접한 두 공유기 사이의 거리를 가능한 크게하여 설치하려고 합니다.
         *
         * C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하세요.
         *
         * 입력
         * 첫째 줄에 집의 개수 N (2<=N<=200,000)과 공유기의 개수 C (2<=C<=N)가 하나 이상의 빈칸을 사이에 두고 주어집니다.
         * 둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (1<=xi<=1,000,000,000)가 한 줄에 하나씩 주어집니다.
         *
         * 출력
         * 첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력합니다.
         */

        /** solution
         * 가장 인접한 두 공유기 사이의 거리'의 최댓값을 탐색해야 하는 문제로 이해할 수 있다.
         */

        Scanner sc = new Scanner(System.in);

        // 집의 개수 N 공유기 개수 c
//        int n = sc.nextInt();

        int n = 5;
        int c = 3;

        // 전체 데이터 입력받기
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
        int[] houses  = {1, 2, 8, 4, 9};

        // 집 좌표 오름차순 정렬
        Arrays.sort(houses);


        // 이진 탐색을 이용하여 최적의 거리를 찾기
        int result = binarySearch(houses, c);
        System.out.println(result);


    }

    private static int binarySearch(int[] houses, int c) {
        int start = 1;  // 최소 거리
        int end = houses[houses.length - 1] - houses[0];  // 최대 거리
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 1;  // 현재 설정된 거리로 공유기 설치

            int currentHouse = houses[0];
            for (int i = 1; i < houses.length; i++) {
                if (houses[i] - currentHouse >= mid) {
                    count++;
                    currentHouse = houses[i];
                }
            }

            if (count >= c) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

}
