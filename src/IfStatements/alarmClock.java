package IfStatements;

import java.util.Scanner;

public class alarmClock {

    public static void main(String[] args) {
        setAlarm();   // 백준 2884번 - 알람 시계
    }

    public static void setAlarm() {
        Scanner scan = new Scanner(System.in);

        int hour = scan.nextInt();
        int minute = scan.nextInt();

        minute -= 45;

        if (minute < 0) {
            hour -= 1;
            minute += 60;
        }

        if (hour < 0) {
            hour += 24;
        }

        System.out.printf("%d %d", hour, minute);
    }
}
