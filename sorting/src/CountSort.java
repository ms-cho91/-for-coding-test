import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {

        /** 계수 정렬
         *  정수 혹은 정수로 표현 가능한 자료에 대해 정렬을 수행하는 비교 없는 정렬 알고리즘
         */

        /** solution
         */

        int[] array = {64, 25, 12, 22, 11};

        System.out.println("원본 배열:"+ Arrays.toString(array));

        countingSort(array);

        System.out.println("정렬된 배열:"+ Arrays.toString(array));
    }

    // 계수 정렬 알고리즘을 사용하여 배열을 정렬합니다.
    static void countingSort(int[] arr) {
        int n = arr.length;

        // 입력 배열에서 최댓값을 찾습니다.
        int max = getMax(arr, n);

        // 카운트 배열을 초기화합니다.
        int[] count = new int[max + 1];

        // 입력 배열의 각 원소의 빈도수를 카운트합니다.
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // 카운트 배열을 누적 빈도수로 업데이트합니다.
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // 정렬된 결과를 저장할 임시 배열을 생성합니다.
        int[] output = new int[n];

        // 입력 배열을 순회하면서 정렬된 결과를 임시 배열에 저장합니다.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // 임시 배열의 내용을 원래 배열에 복사합니다.
        System.arraycopy(output, 0, arr, 0, n);
    }

    // 배열의 최댓값을 찾는 메소드입니다.
    static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}