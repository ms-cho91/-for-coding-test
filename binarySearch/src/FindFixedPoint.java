import java.util.Scanner;

public class FindFixedPoint {


    public static void main(String[] args) {

        /** 고정점 찾기
         * 고정점(Fixed Point)이란, 수열의 원소 중에서 그 값이 인덱스와 동일한 원소를 의미합니다.
         * 예를 들어 수열 a = {-15, -4, 2, 8 ,13}이 있을 때 a[2] = 2이므로, 고정점은 2가 됩니다.
         * 하나의 수열이 N개의 서로 다른 원소를 포함하고 있으며, 모든 원소가 오름차순으로 정렬되어 있습니다.
         * 이때 이 수열에서 고정점이 있다면, 고정점을 출력하는 프로그램을 작성하세요. 만약 고정점이 없다면 -1을 출력합니다.
         *
         * 단, 이 문제는 시간 복잡도 O(logN)으로 알고리즘을 설계하지 않으면 '시간 초과' 판정을 받습니다.
         *
         * 입력
         * 첫째 줄에 N이 입력됩니다. (1<=N<=1,000,000)
         * 둘째 줄에 N개의 원소가 정수 형태로 공백으로 구분되어 입력됩니다. (-10e9<=각 원소의 값<=10e9)
         *
         * 출력
         * 고정점을 출력한다. 고정점이 없다면 -1을 출력합니다.
         */

        /** solution
         *이 문제는 시간 복잡도 O(logN)으로 동작하는 알고리즘을 요구하고 있다.
         * 따라서 일반적인 선형 탐색으로는 문제를 해결할 수 없다.
         * '찾고자 하는 값'이 '중간점'과 동일하다고 가정하고, 탐색을 수행하면 된다.
         */

        Scanner sc = new Scanner(System.in);

        // 데이터의 개수 N
//        int n = sc.nextInt();

        int n = 5;

        // 전체 데이터 입력받기
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
        int[] arr = {-15, 1, 5, 7 ,13};

        // 결과 출력
        int result = findFixedPoint(arr);

        if ( result > 0 ) {
            System.out.println("고정점 : "+result);
        }else {
            System.out.println(result);
            System.out.println("데이터가 존재하지 않습니다.");
        }

    }

    private static int findFixedPoint(int[] arr) {
        int start = 0, end = arr.length - 1, result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == mid) {
                return  mid;
            } else if (arr[mid] < mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

}
