package IfStatements;

import java.util.Scanner;

public class ovenClock
{
    
    public static void main (String[] args) {
        setOvenClock();
    }
    
    public static void setOvenClock() {
        Scanner scan = new Scanner(System.in);
        
        String startTime = scan.nextLine();
        int usingTime = scan.nextInt();
        
        String[] startTimes = startTime.split(" ");
        
        int startHour = Integer.parseInt(startTimes[0]);
        int startMinute = Integer.parseInt(startTimes[1]);
        
        int endHour = startHour;
        int endMinute = startMinute + usingTime;
        
        if (endMinute >= 60) {
            int count = endMinute / 60;
            endHour += count;
            endMinute -= 60 * count;
        }
        
        if (endHour >= 24) {
            endHour -= 24;
        }
        System.out.printf("%d %d", endHour, endMinute);
    }
}
