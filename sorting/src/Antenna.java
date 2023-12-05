import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Antenna {
    public static void main(String[] args) {

        /** 국영수
         * 일직선 상의 마을에 여러 채의 집이 위치해 있습니다.
         * 이 중에서 특별히 한 개의 안테나를 설치하기로 결정했습니다.
         * 효율성을 위해 안테나로부터 모든 집까지의 거리의 총 합이 최소가 되도록 설치하려고 합니다.
         * 이때 안테나는 집이 위치한 곳에만 설치할 수 있고, 논리적으로 동일한 위치에 여러 개의 집이 존재하는 것이 가능합니다.
         * 집들의 위치 값이 주어질 때, 안테나를 설치할 위치를 선택하는 프로그램을 작성하시오.
         *
         * 예를 들어 N=4이고, 각 위치가 1, 5, 7, 9일 때를 가정하겠습니다.
         * 이 경우 5의 위치에 설치했을 때, 안테나로부터 모든 집까지의 거리의 총 합이 (4+0+2+4)=10으로, 최소가 됩니다.
         */

        /** solution
         * 단순히 모든 집의 위치 정보를 입력받은 뒤에, 이를 정렬해서 중간값을 출력하면 정답 판정을 받을 수 있다.
         */

        Scanner sc = new Scanner(System.in);

        // 집의 수 입력
        int n = sc.nextInt();

        // 집의 위치를 저장할 배열
        int[] houses = new int[n];

        // 집의 위치 입력
        for (int i = 0; i < n; i++) {
            houses[i] = sc.nextInt();
        }

        // 집의 위치를 오름차순으로 정렬
        Arrays.sort(houses);

        // 중간에 위치한 값 출력
        System.out.println(houses[(n - 1) / 2]);

    }


}