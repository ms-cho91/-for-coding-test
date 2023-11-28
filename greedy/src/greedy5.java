import java.util.Scanner;
import java.util.Arrays;

public class greedy5 {

    public static void main(String[] args) {

        /** 모험가 길드
         * 한 마을에 모험가가 N명 있습니다.
         * 모험가 길드에서는 N명의 모험가를 대상으로 '공포도'를 측정했는데, '공포도'가 높은 모험가는 쉽게 공포를 느껴 위험 상황에서 제대로 대처할 능력이 떨어집니다.
         * 모험가 길드장인 동빈이는 모험가 그룹을 안전하게 구성하고자 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야 여행을 떠날 수 있도록 규정했습니다.
         * 동빈이는 최대 몇개의 모험가 그룹을 만들 수 있는지 궁금합니다.
         * 동빈이를 위해 N명의 모험가에 대한 정보가 주어졌을 때, 여행을 떠날 수 있는 그룹 수의 최댓값을 구하는 프로그램을 작성하세요.
         * (몇 명의 모험가는 마을에 그대로 남아 있어도 되기 때문에, 모든 모험가를 특정한 그룹에 넣을 필요는 없습니다.)
         *
         * 첫째 줄에 모험가의 수 N이 주어집니다.(1<=N<=100,000)
         * 둘째 줄에 각 모험가의 공포도의 값을 N 이하의 자연수로 주어지며, 각 자연수는 공백으로 구분합니다.
         */

        /** solution
         * 일단 공포도를 기준으로 오름차순으로 정렬을 수행했다.
         * 이후에 공포도가 가장 낮은 모험가부터 하나씩 확인하며, 그룹에 포함될 모험가의 수를 계산할 수 있다.
         * 만약에 현재 그룹에 포함된 모험가의 수가 현재 확인하고 있는 공포도보다 크거나 같다면, 그룹을 결성할 수 있을 것이다.
         * 즉, '현재 그룹에 포함된 모험가의 수'가 '현재 확인하고 있는 공포도'보다 크거나 같다면, 이를 그룹으로 설정하면 된다.
         */


        Scanner sc = new Scanner(System.in);

        System.out.println("모험가 수 n을 입력");

        int n = sc.nextInt();

        int[] adventurers = new int[n]; // 모험가 수

        for (int i = 0; i < n; ++i) {
            System.out.println(i+1+" 모험가의 공포도를 입력");
            adventurers[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(adventurers));

        int result = findMaximumGroups(adventurers);

        System.out.printf("최대로 구성할 수 있는 그룹은 "+result+" 그룹입니다.");
    }

    public static int findMaximumGroups(int[] arr) {
        Arrays.sort(arr);  // 공포도를 기준으로 오름차순 정렬

        System.out.println(Arrays.toString(arr));

        int groupCount = 0;  // 그룹 수 초기화
        int membersInGroup = 0;  // 현재 그룹에 포함된 모험가 수 초기화

        for (int fear : arr) {
            ++membersInGroup;  // 현재 그룹에 모험가 추가

            // 현재 모험가의 공포도가 현재 그룹의 인원 수와 같거나 크면 그룹 결성
            if (membersInGroup >= fear) {
                groupCount++;  // 그룹 수 증가
                membersInGroup = 0;  // 현재 그룹의 모험가 수 초기화
            }
        }

        return groupCount;
    }
}