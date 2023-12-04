import java.util.*;

class Student implements Comparable<Student> {

    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }


    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.score, other.score);
    }
}

public class StudentSorter {
    public static void main(String[] args) {

        /** 성적이 낮은 순서로 학생 출력
         * N명의 학생 정보가 있다. 학생 정보는 학생의 이름과 학생의 성적으로 구분된다.
         * 각 학생의 이름과 성적 정보가 주어졌을 때 성적이 낮은 순서대로 학생의 이름을 출력하는 프로그램을 작성하시오.
         *
         * 입력
         * 첫 번재 줄에 학생의 수 N이 입력된다. (1<=N<=100,000)
         * 두 번째 줄부터 N+1번째 줄에는 학생의 이름을 나타내는 문자열 A와 학생의 성적을 나타내는 정수 B가 공백으로 구분되어 입력된다.
         * 문자열 A의 길이와 학생의 성적은 100 이하의 자연수이다.
         *
         * 출력
         * 모든 학생의 이름을 성적이 낮은 순서대로 출력한다. 성적이 동일한 학생들의 순서는 자유롭게 출력해도 괜찮다.
         */

        /** solution
         */

        Scanner sc = new Scanner(System.in);

        // 학생의 수 입력
        System.out.println("학생의 수 n 입력:");
        int numberOfStudents = sc.nextInt();

        // 학생 정보를 담을 리스트 생성
        List<Student> studentList = new ArrayList<>();

        // 학생 정보 입력받기
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println((i+1)+" 번째 학생 이름 입력:");
            String studentName = sc.next();
            System.out.println((i+1)+" 번째 학생 점수 입력:");
            int studentScore = sc.nextInt();

            // Student 객체 생성 후 리스트에 추가
            studentList.add(new Student(studentName, studentScore));
        }

        // 학생 정보를 성적순으로 정렬
        Collections.sort(studentList);

        for (Student student : studentList) {
            System.out.print(student.name + " ");
        }

    }

}