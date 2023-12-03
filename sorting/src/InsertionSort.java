import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {

        /** 삽입 정렬
         * 인덱스 1의 원소부터 앞 방향으로 들어갈 위치를 찾아 교환하는 정렬 알고리즘이다.
         * 정렬이 되어 있는 배열의 경우 O(n)의 속도로 정렬되어 있을 수록 성능이 좋다.
         */

        /** solution
         */

        int[] array = {64, 25, 12, 22, 11};

        System.out.println("원본 배열:"+ Arrays.toString(array));

        insertionSort(array);

        System.out.println("정렬된 배열:"+ Arrays.toString(array));
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;

        // 배열을 순회하면서 현재 요소를 이미 정렬된 부분에 적절한 위치에 삽입합니다.
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // 현재 요소를 이미 정렬된 부분과 비교하여 올바른 위치에 삽입합니다.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}