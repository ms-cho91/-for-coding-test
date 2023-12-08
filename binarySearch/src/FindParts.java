import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class FindParts {

    // 이진 탐색 소스코드 구현(반복문)
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) return mid;
                // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) end = mid - 1;
                // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args){

        /** 부품찾기
         *  동빈이네 전자 매장에는 부품이 N개 있다.
         *  각 부품은 정수 형태의 고유한 번호가 있다.
         *  어느 날 손님이 M개 종류의 부품을 대량으로 구매하겠다며 당일 날 견적서를 요청했다.
         *  동빈이는 때를 놓치지 않고 손님이 문의한 부품 M개 종류를 모두 확인해서 견적서를 작성해야 한다.
         *  이때 가게 안에 부품이 모두 있는지 확인하는 프로그램을 작성해보자.
         *
         * 예를 들어 가게의 부품이 총 5개일 때 부품 번호가 다음과 같다고 하자.
         * N = 5
         * [8, 3, 7, 9, 2]
         * 손님은 총 3개의 부품이 있는지 확인 요청했는데 부품 번호는 다음과 같다.
         * M = 3
         * [5, 7, 9]
         *
         * 이때 손님이 요청한 부품 번호의 순서대로 부품을 확인해 부품이 있으면 yes를, 없으면 no를 출력한다. 구분은 공백으로 한다.
         *
         * 입력
         * 첫째 줄에 정수 N이 주어진다. (1 <= N <= 1,000,000)
         * 둘째 줄에는 공백으로 구분하여 N개의 정수가 주어진다. 이때 정수는 1 보다 크고 1,000,000 이하이다.
         * 셋째 줄에는 정수 M이 주어진다. (1 <= M <= 100,000)
         * 넷째 줄에는 공백으로 구분하여 M개의 정수가 주어진다. 이때 정수는 1 보다 크고 1,000,000 이하이다.
         * 출력
         * 첫째 줄에 공백으로 구분하여 각 부품이 존재하면 yes를, 없으면 no를 출력한다.
         */

        /** solution
         *
         */


        Scanner sc = new Scanner(System.in);

        // N(가게의 부품 개수)
        int n = sc.nextInt();
        int[] arr = new int[n];
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
            s.add(x);

        }

        // 이진 탐색을 수행하기 위해 사전에 정렬 수행
        Arrays.sort(arr);

        // M(손님이 확인 요청한 부품 개수)
        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for (int i = 0; i < m; i++) {
            // 해당 부품이 존재하는지 확인
            int result = binarySearch(arr, targets[i], 0, n - 1);
            if (result != -1) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for (int i = 0; i < m; i++) {
            // 해당 부품이 존재하는지 확인
            if (s.contains(targets[i])) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}
