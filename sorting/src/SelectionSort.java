import java.util.Arrays;


public class SelectionSort {
    public static void main(String[] args) {

        /** 선택 정렬
         * 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고,
         * 그다음 작은 데이터를 선택해 앞에서 두 번재 데이터와 바꾸는 과정을 반복하는 방법이다.
         */

        /** solution
         */

        int[] array = {64, 25, 12, 22, 11};

        System.out.println("원본 배열:"+ Arrays.toString(array));

        selectionSort(array);

        System.out.println("정렬된 배열:"+ Arrays.toString(array));
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;

        // 배열을 순회하면서 최솟값을 찾아 현재 위치의 요소와 교체하는 과정을 반복합니다.
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // 나머지 정렬되지 않은 배열에서 최솟값의 인덱스를 찾습니다.
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 찾은 최솟값과 현재 위치의 요소를 교체합니다.
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}