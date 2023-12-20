import java.math.BigInteger;

//피보나치 함수를 재귀 함수로 구현
public class Fibonacci {
    static BigInteger [] dpTD;
    static BigInteger [] dpBU;
    public static int fibo(int x) {

        if (x == 1 || x == 2 ) {
            return 1;
        }
        return fibo(x-1) + fibo(x-2);

    }

    public static BigInteger  fiboTD(int x) {

        if (x == 1 || x == 2 ) {

            //int형을 바로 BigInteger로 변경할 수 없기 때문에 valueOf메소드 이용
            //valueOf의 파라미터 값은 Long형이다. 그래서 파라미터에 1L로 적어줘야하지만 1도 된다.
            return BigInteger.valueOf(1);

        }

        //이미 계산한 적 있는 문제라면 그대로 반환
        if (  dpTD[x] != null ) {
            return dpTD[x];
        }

        //아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
        dpTD[x] = fiboTD(x-1).add(fiboTD(x-2));
        return dpTD[x];

    }

    public static BigInteger  fiboBU(int x) {

        //int형을 바로 BigInteger로 변경할 수 없기 때문에 valueOf메소드 이용
        //valueOf의 파라미터 값은 Long형이다. 그래서 파라미터에 1L로 적어줘야하지만 1도 된다.
        dpBU[1] = BigInteger.valueOf(1);
        dpBU[2] = BigInteger.valueOf(1);
        int n = 100;

        for (int i = 3; i < n; i++) {

            BigInteger result = dpBU[i-2].add(dpBU[i-1]);
            dpBU[i] = result;
        }
        return dpBU[x];
    }

    public static void main(String[] args) {

        System.out.println(fibo(4));


        //Top-Down
        dpTD  = new BigInteger[100];
        System.out.println(fiboTD(99));

        //Bottom-up
        dpBU  = new BigInteger[100];
        System.out.println(fiboBU(99));

    }

}
