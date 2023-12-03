import java.util.Arrays;
import java.util.Stack;

public class BubbleSort {
    public static void main(String[] args) {

        /** 버블 정렬
         * 인접한 두 원소를 비교하여 정렬하는 간단한 정렬 알고리즘
         * 배열의 끝까지 도달할 때까지 인접한 두 원소를 계속해서 비교하면서 큰 값이 뒤로 이동
         */

        /** solution
         */

        int[] array = {64, 25, 12, 22, 11};

        System.out.println("원본 배열:"+ Arrays.toString(array));

        bubbleSort(array);

        System.out.println("정렬된 배열:"+ Arrays.toString(array));
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;

        // 배열의 모든 요소에 대해 반복합니다.
        for (int i = 0; i < n - 1; i++) {
            // 현재 요소와 다음 요소를 비교하여 큰 값을 뒤로 이동시킵니다.
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 두 요소를 교체합니다.
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}