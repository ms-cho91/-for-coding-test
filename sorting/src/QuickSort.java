import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        /** 퀵 정렬
         * 퀵 정렬(Quick Sort)은 분할 정복(divide and conquer) 기법을 사용하여 배열을 정렬하는 효율적인 알고리즘입니다.
         * 배열에서 하나의 원소를 피벗(pivot)으로 선택하고, 피벗보다 작은 원소는 왼쪽으로, 큰 원소는 오른쪽으로 옮기면서 정렬을 수행합니다.
         * 이후에 왼쪽 부분과 오른쪽 부분에 대해 재귀적으로 정렬을 수행합니다.
         */

        /** solution
         */

        int[] array = {64, 25, 12, 22, 11};

        System.out.println("원본 배열:"+ Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("정렬된 배열:"+ Arrays.toString(array));
    }

    // 퀵 정렬 알고리즘을 사용하여 배열을 정렬합니다.
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 피벗을 기준으로 배열을 분할합니다.
            int pivotIndex = partition(arr, low, high);

            // 피벗을 기준으로 분할된 두 부분에 대해 재귀적으로 정렬합니다.
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // 배열을 피벗을 기준으로 분할하고 피벗의 최종 위치를 반환하는 메소드입니다.
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        // 배열을 순회하면서 피벗보다 작은 원소는 왼쪽으로 옮깁니다.
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 피벗을 올바른 위치로 이동시킵니다.
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

}