public class Recursion {

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

  public static void main(String[] args) {
    System.out.println(sqrt(2, 0.00001));
    System.out.println(sqrt(10, 0.00001));
  }

}
