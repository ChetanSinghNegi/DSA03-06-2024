public class rotateANumber {
  public static void main(String[] args) {
    int a = 571234;
    int rotate = -2; // -ve means clockwise +ve means anticlockwise
    int countOfDigit = getCount(a);
    if (rotate < 0) {
      rotate = countOfDigit - Math.abs(rotate);
    }
    int quo = a / (int) Math.pow(10, rotate);
    int rem = a % (int) Math.pow(10, rotate);
    rem = rem * (int) Math.pow(10, countOfDigit - rotate);
    rem += quo;
    System.out.println(571234);
    System.out.println(rem);
  }

  public static int getCount(int a) {
    int count = 0;
    while (a != 0) {
      count++;
      a /= 10;
    }
    return count;
  }
}
