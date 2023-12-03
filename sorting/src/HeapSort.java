import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {

        /** 힙 정렬
         * 오름차 순 정렬일 때 최대힙을 사용하는 정렬이다. (내림차는 최소힙)
         * 주어진 배열을 힙으로 만들고, 힙에서 최상위 노드를 꺼내어 배열의 맨 뒤로 옮기는 작업을 반복하여 정렬합니다.
         */

        /** solution
         */

        int[] array = {64, 25, 12, 22, 11};

        System.out.println("원본 배열:"+ Arrays.toString(array));

        heapSort(array);

        System.out.println("정렬된 배열:"+ Arrays.toString(array));
    }

    // 힙 정렬 알고리즘을 사용하여 배열을 정렬합니다.
    static void heapSort(int[] arr) {
        int n = arr.length;

        // 최대 힙을 구성합니다.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 힙에서 요소를 하나씩 꺼내어 배열의 맨 뒤로 이동시키면서 정렬합니다.
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    // 특정 노드를 루트로 하는 서브트리를 최대 힙으로 만드는 메소드입니다.
    static void heapify(int[] arr, int n, int root) {
        int largest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;

        // 왼쪽 자식이 루트보다 크면 largest를 업데이트합니다.
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // 오른쪽 자식이 루트보다 크면 largest를 업데이트합니다.
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // largest가 root가 아니라면 교체하고, 해당 서브트리에 대해 다시 heapify를 호출합니다.
        if (largest != root) {
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

}