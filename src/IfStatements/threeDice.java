package IfStatements;

import java.util.Scanner;

public class threeDice {

    public static void main(String[] args) {
        moneyForDice();
    }

    public static void moneyForDice() {

        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().split(" ");
        int firstNum = Integer.parseInt(numbers[0]);
        int secondNum = Integer.parseInt(numbers[1]);
        int thirdNum = Integer.parseInt(numbers[2]);
        int money;

        boolean isAllEqual = (firstNum == secondNum) && (firstNum == thirdNum);
        boolean isTwoEqual = (firstNum == secondNum) || (firstNum == thirdNum) || (secondNum == thirdNum);

        if (isAllEqual) {
            money = 10000 + (firstNum * 1000);
        } else if (isTwoEqual) {
            money = firstNum != secondNum ? 1000 + (thirdNum * 100) : 1000 + (firstNum * 100);
        } else {
            int max = Math.max(Math.max(firstNum, secondNum), thirdNum);
            money = max * 100;
        }
        System.out.println(money);
    }
}
