import java.util.Scanner;

public class CountSpecificNumberInSortedArray {


    public static void main(String[] args) {

        /** 정렬된 배열에서 특정 수의 개수 구하기
         * N개의 원소를 포함하고 있는 수열이 오름차순으로 정렬되어 있습니다.
         * 이때 이 수열에서 x가 등장하는 횟수를 계산하세요.
         * 예를 들어 수열 {1,1,2,2,2,2,3}이 있을 때 x = 2라면,
         * 현재 수열에서 값이 2인 원소가 4개이므로 4를 출력합니다.
         *
         * 단, 이 문제는 시간 복잡도 O(logN)으로 알고리즘을 설계하지 않으면 '시간 초과' 판정을 받습니다.
         *
         * 입력
         * 첫째 줄에 N과 x가 정수 형태로 공백으로 구분되어 입력됩니다. (1<=N<=1,000,000), (-10e9<=x<10e9)
         * 둘째 줄에 N개의 원소가 정수 형태로 공백으로 구분되어 입력됩니다. (-10e9<=각 원소의 값<=10e9)
         *
         * 출력
         * 수열의 원소 중에서 값이 x인 원소의 개수를 출력합니다. 단, 값이 x인 원소가 하나도 없다면 -1을 출력합니다.
         */

        /** solution
         *이 문제는 시간 복잡도 O(logN)으로 동작하는 알고리즘을 요구하고 있다.
         * 따라서 일반적인 선형 탐색으로는 문제를 해결할 수 없다.
         * 원소들은 모두 정렬되어 있기 때문에 x가 처음 등장하는 인덱스와 x가 마지막으로 등장하는 인덱스의 차이를 계산하여 문제를 해결할 수 있다.
         */

        Scanner sc = new Scanner(System.in);

        // 데이터의 개수 N, 찾고자 하는 값 x 입력받기
//        int n = sc.nextInt();
//        int x = sc.nextInt();

        int n = 9;
        int x = 2;

        // 전체 데이터 입력받기
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
        int[] arr = {1,1,2,2,2,2,3,3,3};

        // 결과 출력
        int result = countOccurrences(arr, x);

        if ( result > 0 ) {
            System.out.println(x+" 의 개수 : "+result);
        }else {
            System.out.println(result);
            System.out.println("데이터가 존재하지 않습니다.");
        }

    }

    private static int countOccurrences(int[] arr, int target) {
        int firstOccurrence = findFirstOccurrence(arr, target);

        // 값이 x인 원소가 존재하지 않는다면
        if (firstOccurrence == -1) {
            return -1;
        }

        int lastOccurrence = findLastOccurrence(arr, target);

        return lastOccurrence - firstOccurrence + 1;
    }

    private static int findFirstOccurrence(int[] arr, int target) {
        int start = 0, end = arr.length - 1, result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                result = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    private static int findLastOccurrence(int[] arr, int target) {
        int start = 0, end = arr.length - 1, result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                result = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

}
