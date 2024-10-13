import java.util.*;
public class inverseOfANumber {
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
          int num = scn.nextInt();
          int itr = 1;
          int sum = 0;
          while(num!=0){
              int rem = num % 10;
              num /= 10;
              sum = sum+ (int)Math.pow(10,rem-1)*itr++;
          }
          System.out.println(sum);
      }
  }
}
