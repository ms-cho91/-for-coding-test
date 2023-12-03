import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        /** 합병 정렬
         * 분할 정복 알고리즘 중 하나이다.
         * 배열의 길이가 1이 될 때까지 2개의 부분 배열로 분할한다.
         * 분할이 완료됐으면 다시 2개의 부분 배열을 합병하고 정렬한다.
         * 모든 부분 배열이 합병될 때 까지 반복한다.
         */

        /** solution
         */

        int[] array = {64, 25, 12, 22, 11};

        System.out.println("원본 배열:"+ Arrays.toString(array));

        mergeSort(array, 0, array.length - 1);

        System.out.println("정렬된 배열:"+ Arrays.toString(array));
    }

    // 합병 정렬 알고리즘을 사용하여 배열을 정렬합니다.
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 배열을 반으로 나눕니다.
            int mid = (left + right) / 2;

            // 각각의 반씩을 재귀적으로 정렬합니다.
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // 정렬된 두 배열을 합병합니다.
            merge(arr, left, mid, right);
        }
    }

    // 두 개의 정렬된 배열을 합병하는 메소드입니다.
    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 임시 배열을 생성하고 데이터를 복사합니다.
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // 두 배열을 합병하여 정렬합니다.
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 남은 요소들을 복사합니다.
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

}