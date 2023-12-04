import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraysSort {
    public static void main(String[] args) {

        /** 기본 배열 정렬
         * Arrays.sort 이용 자바 배열 기본 정렬
         * 오름차순 내림차순
         */

        /** solution
         */

        int[] array = {25, 13, 12, 1, 11, 32};

        System.out.println("원본 배열:"+ Arrays.toString(array));

        Arrays.sort(array);

        System.out.println("오름차순 정렬:"+ Arrays.toString(array));

        //sort(T[] a, Comparator <? super T> c) 에서 사용되는 T는 Generic Class로 어떠한 객체도 허용하게 해주었지만, int는 객체가 아닌 primitive type
        //해당 코드를 int[]가 아닌 Integer[]로 변경 해주면 컴파일 에러 없이 내림차순 구현 가능

        Integer[] arrays = {25, 13, 12, 1, 11, 32};
        Arrays.sort(arrays, Collections.reverseOrder());

        System.out.println("내림차순 배열1:"+ Arrays.toString(arrays));

        // int[] 배열을 Integer[] 배열로 형변환
        Integer[] integerArray = Arrays.stream(array).boxed().toArray(Integer[]::new);

        // Integer[] 배열을 역순으로 정렬
        Arrays.sort(integerArray, Collections.reverseOrder());

        System.out.println("내림차순 배열2:"+ Arrays.toString(integerArray));
    }

}