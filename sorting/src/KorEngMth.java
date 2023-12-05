import java.util.*;

class StudentKorEngMth implements Comparable<StudentKorEngMth> {

    String name;
    int korean;
    int english;
    int math;

    public StudentKorEngMth(String name, int korean, int english, int math) {

        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public String getName() {
        return this.name;
    }
    /*
    [ 정렬 기준 ]
    1) 두 번째 원소를 기준으로 내림차순 정렬
    2) 두 번째 원소가 같은 경우, 세 번째 원소를 기준으로 오름차순 정렬
    3) 세 번째 원소가 같은 경우, 네 번째 원소를 기준으로 내림차순 정렬
    4) 네 번째 원소가 같은 경우, 첫 번째 원소를 기준으로 오름차순 정렬
    */
    @Override
    public int compareTo(StudentKorEngMth other) {
        //모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키코드에서 대문자는 소문자보다 작으므로 사전 순으로 앞에 옵니다.)
        if (this.korean == other.korean && this.english == other.english && this.math == other.math) {
            return this.name.compareTo(other.name);
        }
        //국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
        if (this.korean == other.korean && this.english == other.english) {
            return Integer.compare(other.math, this.math);
        }
        //국어 점수가 같으면 영어 점수가 증가하는 순서로
        if (this.korean == other.korean) {
            return Integer.compare(this.english, other.english);
        }
        //국어 점수가 감소하는 순서로
        return Integer.compare(other.korean, this.korean);
    }
}

public class KorEngMth {
    public static void main(String[] args) {

        /** 국영수
         * 도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어집니다.
         * 이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하세요.
         *
         * 국어 점수가 감소하는 순서로
         * 국어 점수가 같으면 영어 점수가 증가하는 순서로
         * 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
         * 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키코드에서 대문자는 소문자보다 작으므로 사전 순으로 앞에 옵니다.)
         *
         * 입력
         * 첫째 줄에 도현이네 반의 학생 수 N (1<=N<=100,000)이 주어집니다.
         * 둘째 줄부터 한 줄에 하나씩 각 학생의 이름, 국어, 영어, 수학 점수가 공백으로 구분해 주어집니다.
         * 점수는 1보다 크거나 같고, 100보다 작거나 같은 자연수입니다.
         * 이름을 알파벳 대소문자로 이루어진 문자열이고, 길이는 10자리를 넘지 않습니다.
         * 출력
         * 문제에 나와 있는 정렬 기준으로 정렬한 후 첫째 줄부터 N개의 줄에 걸쳐 각 학생의 이름을 출력합니다.
         */

        /** solution
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("학생의 수 n 입력:");

        int n = sc.nextInt();

        ArrayList<StudentKorEngMth> students  = new ArrayList<>();

        //버퍼비우기
        sc.nextLine();

        // 학생 정보 입력 받기
        for (int i = 0; i < n; i++) {
            System.out.println((i+1)+" 번째 학생 이름 국어점수 영어점수 수학점수 순으로 입력 e.g. Junkyu 50 60 100 ");
            String str = sc.nextLine();
            String[] arr = str.split(" ");

            students.add(new StudentKorEngMth(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3])));
        }

        Collections.sort(students);

        // 정렬된 학생 정보에서 이름만 출력
        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i).getName());
        }
    }

}