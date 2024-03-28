package forStatements;

import java.util.Scanner;

public class receipt {

  public static void main(String[] args) {
    receiptSum();  // 백준 25304
    A();           // 백준 25314
  }

  public static void receiptSum() {
    Scanner scan = new Scanner(System.in);

    long amount = scan.nextLong();

    int type = scan.nextInt();

    int sum = 0;

    scan.nextLine();

    for (int i = 0; i < type; i++) {
      String[] counts = scan.nextLine().split(" ");
      sum += Integer.parseInt(counts[0]) * Integer.parseInt(counts[1]);
    }
    String answer;
    if ( amount == sum ) {
      answer = "Yes";
    } else answer = "No";

    System.out.println(answer);
  }
  
  
  public static void A() {
    Scanner scan = new Scanner(System.in);
    
    int a = scan.nextInt();
    int number = a / 4 ;

    for (int i = 0; i < number; i++) {
      System.out.print("long ");
    }
    System.out.print("int");
  }
}
