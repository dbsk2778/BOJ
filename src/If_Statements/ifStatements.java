package If_Statements;

import java.util.Scanner;

public class ifStatements
{
    
    public static void main (String[] args) {
        compareNum();  // 백준 1330
        grade();  // 백준 9498
        compareYear();  // 백준 2753
    }
    
    public static void compareNum() {
        Scanner scan = new Scanner(System.in);
        
        int a = scan.nextInt();
        int b = scan.nextInt();
        
        if ( a > b ){
            System.out.println('>');
        } else if (a < b) {
            System.out.println('<');
        } else {
            System.out.println("==");
        }
    }
    
    public static void grade() {
        Scanner scan = new Scanner(System.in);
    
        int score = scan.nextInt();
        char grade;
        
        if ( score >= 90 ) {
            grade = 'A';
        } else if ( score >= 80 ) {
            grade = 'B';
        } else if ( score >= 70 ) {
            grade = 'C';
        } else if ( score >= 60 ) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        System.out.println(grade);
    }
    
    public static void compareYear() {
        Scanner scan = new Scanner(System.in);
    
        int year = scan.nextInt();
        
        if ( (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ) {
            System.out.println(1);
        } else System.out.println(0);
    }
}
