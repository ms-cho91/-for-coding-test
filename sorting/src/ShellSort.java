import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {

        /** 셀 정렬
         * 삽입 정렬을 개선한 알고리즘으로,
         * 배열을 일정한 간격으로 나누어 부분적으로 정렬하고, 이후에 전체적으로 정렬하는 방식
         */

        /** solution
         */

        int[] array = {64, 25, 12, 22, 11};

        System.out.println("원본 배열:"+ Arrays.toString(array));

        shellSort(array);

        System.out.println("정렬된 배열:"+ Arrays.toString(array));
    }

    static void shellSort(int[] arr) {
        int n = arr.length;

        // 간격을 절반으로 줄여가며 부분적으로 정렬합니다.
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 간격을 나눈 부분 배열에 대해 삽입 정렬을 수행합니다.
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                // 부분 배열을 순회하면서 현재 요소를 올바른 위치에 삽입합니다.
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }
        }
    }
}