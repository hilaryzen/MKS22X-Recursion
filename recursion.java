import java.util.ArrayList;

public class recursion {

  /*
  *@param n any non-negative value you want to take the sqrt of
  *@return the approximate sqrt of n within a tolerance of 0.001%
  */
  public static double sqrt(double n, double tolerance) {
    return sqrtH(n, 1.0, tolerance);
  }

  //Square root helper function with guess as a parameter
  public static double sqrtH(double n, double guess, double tolerance) {
    if (Math.abs(n - guess * guess) / n < tolerance) {
      return guess;
    } else {
      guess = (n / guess + guess) / 2;
      return sqrtH(n, guess, tolerance);
    }
  }

  /*Recursively find the n'th fibbonaci number in linear time
  *fib(0) = 1; fib(1) = 1; fib(5) = 5
  *precondition: n is non-negative
  */
  public static int fib(int n){
    return fibH(n, 0, 1);
  }

  //Fibbonaci helper
  public static int fibH(int n, int first, int second) {
    if (n == 0) {
      return first;
    } else if (n == 1) {
      return second;
    } else {
      return fibH(n - 1, second, first + second);
    }
  }

  //Returns all possible sums that can be made with numbers from 1 to n
  public static ArrayList<Integer> makeAllSums(int n) {
    ArrayList<Integer> sums = new ArrayList<Integer>();
    allSumsH(n, 0, sums);
    return sums;
  }

  //Helper method for makeAllSums
  public static void allSumsH(int n, int ans, ArrayList<Integer> list) {
    if (n == 0) {
      list.add(ans);
    } else {
      allSumsH(n - 1, ans + n, list);
      allSumsH(n - 1, ans, list);
    }
  }

  public static void main(String[] args) {
    System.out.println("Testing square root: ");
    System.out.println("Square root of 2: " + sqrt(2, 0.00001));
    System.out.println("Square root of 2 with less precision: " + sqrt(2, 0.1));
    System.out.println("Square root of 10: " + sqrt(10, 0.00001));
    System.out.println("Square root of 10000: " + sqrt(10000, 0.00001));

    System.out.println(" ");

    System.out.println("Testing fib: ");
    System.out.println("Fib number 0: " + fib(0));
    System.out.println("Fib number 1: " + fib(1));
    System.out.println("Fib number 2: " + fib(2));
    System.out.println("Fib number 5: " + fib(5));
    System.out.println("Fib number 15: " + fib(15));
    System.out.println("Fib number 46: " + fib(46));

    System.out.println(" ");

    System.out.println("Testing makeAllSums: ");
    System.out.println(makeAllSums(0));
    System.out.println(makeAllSums(1));
    System.out.println(makeAllSums(3));
    System.out.println(makeAllSums(4));
  }

}
