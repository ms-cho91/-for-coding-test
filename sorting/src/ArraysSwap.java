import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArraysSwap {
    public static void main(String[] args) {

        /** 배열 교체
         * 동빈이는 두 개의 배열 A와 배열 B를 가지고 있다.
         * 두 배열은 N개의 원소로 구성되어 있으며, 배열의 원소는 모두 자연수이다.
         * 동빈이는 최대 K번의 바꿔치기 연산을 수행할 수 있는데,
         * 바꿔치기 연산이란 배열 A에 있는 원소 하나와 배열 B에 있는 원소 하나를 골라서 두 원소를 서로 바꾸는 것을 말한다.
         * 동빈이의 최종 목표는 배열 A의 모든 원소의 합이 최대가 되도록 하는 것이며, 여러분은 동빈이를 도와야 한다.
         *
         * N, K 그리고 배열 A와 배열 B의 정보가 주어졌을 때, 최대 K번의 바꿔치기 연산을 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최댓값을 출력하는 프로그램을 작성하시오.
         *
         * 입력
         * 첫 번째 줄에 N, K가 공백으로 구분되어 입력된다. (1<=N<=100,000 , 0<=K<=N)
         * 두 번째 줄에 배열 A의 원소들이 공백으로 구분되어 입력된다. 모든 원소는 10,000,000보다 작은 자연수이다.
         * 세 번째 줄에 배열 B의 원소들이 공백으로 구분되어 입력된다. 모든 원소는 10,000,000보다 자은 자연수입니다.
         * 출력
         * 최대 K번의 바꿔치기 연산을 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최댓값을 출력한다.
         */

        /** solution
         * 배열 A에서 가장 작은 원소를 골라서, 배열 B에서 가장 큰 원소와 교체를 하는 것
         */

        Scanner sc = new Scanner(System.in);

        // 입력 받기
        System.out.println("배열의 원소 개수 n 입력:");
        int n = sc.nextInt();
        System.out.println("교체 횟수 k 입력:");
        int k = sc.nextInt();

        // 배열 A 초기화
        Integer [] arrayA = new Integer[n];
        for (int i = 0; i < n; i++) {
            System.out.println("A 배열 "+ (i+1)+" 번째 값 입력:");
            arrayA[i] = sc.nextInt();
        }

        // 배열 B 초기화
        Integer [] arrayB = new Integer[n];
        for (int i = 0; i < n; i++) {
            System.out.println("B 배열 "+ (i+1)+" 번째 값 입력:");
            arrayB[i] = sc.nextInt();
        }

        // 배열 A는 오름차순, 배열 B는 내림차순으로 정렬
        Arrays.sort(arrayA);
        Arrays.sort(arrayB, Collections.reverseOrder());

        System.out.println("A 배열 정렬 : "+Arrays.toString(arrayA));

        System.out.println("B 배열 정렬 : "+Arrays.toString(arrayB));

        for (int i = 0; i < k; i++) {
            // A의 원소가 B의 원소보다 작으면 교체
            if (arrayA[i] < arrayB[i]) {
                // 두 원소를 교체
                int temp = arrayA[i];
                arrayA[i] = arrayB[i];
                arrayB[i] = temp;
            } else {
                // A의 원소가 더 크면 더 이상 바꿔치기 할 필요 없음
                break;
            }
        }

        // 최종 결과 출력
        long sum = 0;
        for (int num : arrayA) {
            sum += num;
        }

        System.out.println(sum);
    }

}