package neetcode.backtracking;

public class DemoRecursion {

    public static int sumIteration(int n) {

        int result = 0;

        for (int i = 1; i <= n; i++) {
            result += i;
        }

        return result;
    }

    public static int recursionAdd(int n) {

        System.out.println(n);
        if(n == 1) return 1;
        return n + recursionAdd(n - 1);
    }


    public static int fib(int n, int a, int b) {

        if (n == 0) return a;
        if (n == 1) return b;

        return fib(n-1, b, a+b);
    }




    public static void main(String[] args) {
//        System.out.println(DemoRecursion.sumIteration(3));
//            DemoRecursion.recursionAdd(3);

        System.out.println(fib(9, 0, 1));
    }
}
