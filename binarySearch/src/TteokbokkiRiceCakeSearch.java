import java.util.Arrays;
import java.util.Scanner;

public class TteokbokkiRiceCakeSearch {

    public static void main(String[] args) {

        /** 순차 탐색
         * 오늘 동빈이는 여행 가신 부모님을 대신해서 떡집 일을 하기로 했다.
         * 오늘은 떡볶이 떡을 만드는 날이다. 동빈이네 떡볶이 떡은 재밌게도 떡볶이 떡의 길이가 일정하지 않다.
         * 대신에 한 봉지 안에 들어가는 떡의 총 길이는 절단기로 잘라서 맞춰준다.
         * 절단기에 높이(H)를 지정하면 줄지어진 떡을 한 번에 절단한다.
         * 높이가 H보다 긴 떡은 H 위의 부분이 잘릴 것이고, 낮은 떡은 잘리지 않는다.
         * 예를 들어 높이가 19, 14, 10, 17cm인 떡이 나란히 있고 절단기 높이를 15cm로 지정하면
         * 자른 뒤 떡의 높이는 15, 14, 10, 15cm가 될 것이다.
         * 잘린 떡의 길이는 차례대로 4, 0, 0, 2cm이다. 손님은 6cm만큼의 길이를 가져간다.
         * 손님이 왔을 때 요청한 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.
         *
         * 입력
         * 첫째 줄에 떡의 개수 N과 요청한 떡의 길이 M이 주어진다. (1<=N<=1,000,000 1<=M<=2,000,000,000)
         * 둘째 줄에는 떡의 개별 높이가 주어진다. 떡 높이의 총합은 항상 M 이상이므로, 손님은 필요한 양만큼 떡을 사갈 수 있다.
         * 높이는 10억보다 작거나 같은 양의 정수 또는 0이다.
         *
         * 출력
         * 적어도 M만큼의 떡을 집에 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.
         */

        /** solution
         * 전형적인 이진 탐색 문제이자, 파라메트릭 서치 유형의 문제이다.
         * 원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제에 주로 파라메트릭 서치를 사용한다.
         * 적절한 높이를 찾을 때까지 절단기의 높이 H를 반복해서 조정하는 것이다.
         */

        Scanner sc = new Scanner(System.in);

        // 떡의 개수(N)와 요청한 떡의 길이(M)
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 각 떡의 개별 높이 정보
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색을 사용하여 높이 조정
        int result = binarySearchHeight(arr, m);

        // 결과 출력
        System.out.println(result);

    }



    public static int binarySearchHeight(int[] array, int target) {

        // 이진 탐색을 위한 시작점과 끝점 설정
        int result = 0;
        int start = 0;
        int end = Arrays.stream(array).max().getAsInt();

        // 이진 탐색 수행 (반복적)
        while (start <= end) {
            int total = 0;
            int mid = (start + end) / 2;

            for (int x : array) {
                // 잘랐을 때의 떡의 양 계산
                if (x > mid) {
                    total += x - mid;
                }
            }

            if (total < target) {   // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
                end = mid - 1;
            } else {                // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
                result = mid;       // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
                start = mid + 1;
            }
        }

        return result;
    }

}
