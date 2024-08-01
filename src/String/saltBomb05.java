package String;

import java.util.Scanner;

public class saltBomb05 {

    public static void main(String[] args) {
//        timeCheck();
//        timeSubstring();
//        timeSplit();
        saltBomb();
    }

    // 철수는 화학 시험을 망치고, 애꿎은 화학 선생님에게 복수를하기로 한다.
    // 철수는 집에서 만든 자동 로봇팔을 선생님의 책상에 숨겨, 선생님이 수업을 시작하려 들어온 순간 숨겨놓은 로봇팔을 이용해 선생님을 혼내주려고한다.
    // 철수는 선생님이 늘 애용하는 물컵에 시간이 되면 로봇팔이 소금을 잔뜩 집어넣도록 프로그램을 짜려고한다.
    // 철수는 현재시각과 선생님이 언제 컵을 사용할지 시간을 알고있지만, 수 계산에 정말 약해서 로봇팔에 입력해야할 시간 계산을 못한다. 철수가 로봇팔에 알맞은 시간을 입력할수 있도록 도와주자.

    // 입력
    // 첫째 줄에는 현재 시각이 hh:mm:ss로 주어진다. 시간의 경우 0≤h≤23 이며, 분과 초는 각각 0≤m≤59, 0≤s≤59 이다.
    // 두 번째 줄에는 소금 투하의 시간이 hh:mm:ss로 주어진다.

    // 출력
    // 로봇팔이 소금을 투하할때까지 필요한 시간을 hh:mm:ss로 출력한다. 이 시간은 1초보다 크거나 같고, 24시간보다 작거나 같다.  = 0이 되면 안된다.


    // 문제 HH:MM:SS 포맷의 두 시각의 차이를 HH:MM:SS 포맷으로 출력하기.
    // 1. ":" 문자를 기준으로 시간, 분, 초를 쪼갠다.
    // 2. 두 시간, 분, 초의 차이를 계산한다.
    // 3. 구해진 시간을 HH:MM:SS 형식으로 출력한다.

    public static void saltBomb() {
        Scanner scan = new Scanner(System.in);
        String currentTime = scan.next();
        String dropTime = scan.next();

        String[] currentTimes = currentTime.split(":");
        String[] dropTimes = dropTime.split(":");

        int needHour = Integer.parseInt(dropTimes[0]) - Integer.parseInt(currentTimes[0]);
        int needMinute = Integer.parseInt(dropTimes[1]) - Integer.parseInt(currentTimes[1]);
        int needSecond = Integer.parseInt(dropTimes[2]) - Integer.parseInt(currentTimes[2]);

        // 각 단위에서 음수가 나오면 더 큰 단위에서 내림하여 가져오기
//        if ( needSecond < 0 ) {  // 1분을 60초로 변환해서 더해주기
//            needMinute--;
//            needSecond += 60;
//        }
//        if ( needMinute < 0 ) {  // 1시간을 60분으로 변환해 더해주기
//            needHour--;
//            needMinute += 60;
//        }
//        if ( needHour < 0 ) {  // 하루를 24시간으로 변환해 더해주기
//            needHour += 24;
//        }

        // 계층적으로 표현되는 각 단위를 계산할 때, 가장 작은 단위로 통일하면 더 편할수 있음 = 초로 통일 ex. byte / kb / mb
        int currentSecondAmount = Integer.parseInt(currentTimes[0]) * 3600 + Integer.parseInt(currentTimes[1]) * 60 + Integer.parseInt(currentTimes[2]);  // 현재 시간
        int dropSecondAmount = Integer.parseInt(dropTimes[0]) * 3600 + Integer.parseInt(dropTimes[1]) * 60 + Integer.parseInt(dropTimes[2]);  // 투하 시간

        int needSecondAmount = dropSecondAmount - currentSecondAmount;
        if (needSecondAmount <= 0) {  // 00:00:00 이 나오면 안되니까, 0이랑 같을 경우도 같이 처리해야 한다.
            needSecondAmount += 24 * 3600;  // 음수일 경우 하루만 더해주면 된다
        }

        int needHour2 = needSecondAmount / 3600;
        int needMinute2 = (needSecondAmount % 3600) / 60;
        int needSecond2 = needSecondAmount % 60;

        // HH:MM:SS 로 출력할 때 만약 값이 한자리수면 앞에 0을 붙여서 출력 - 01
//        String answer = "";
//        if (needHour2 < 10) answer += "0" + needHour2 + ":";
//        else answer += needHour2 + ":";
//
//        if (needMinute2 < 10) answer += "0" + needMinute2 + ":";
//        else answer += needMinute2 + ":";
//
//        if (needSecond2 < 10) answer += "0" + needSecond2;
//        else answer += needSecond2;
//
//        System.out.println(answer);

        // String.format() 사용, 02는 글자수 %d는 int 정수형 / %s 문자열 / %c 문자 1개
        String answer2 = String.format("%02d:%02d:%02d", needHour2, needMinute2, needSecond2);
        System.out.println(answer2);
    }

    public static void timeCheck() {
        String time = "09:10:59";
        // 각 인덱스에서 10의 자리와 1의 자리를 구해서 계산
        // 문자로 된 숫자에 아스키 0 값을 빼줘야 함
        int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        int second = (time.charAt(6) - '0') * 10 + (time.charAt(7) - '0');

        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
    }

    public static void timeSubstring() {
        String time = "09:10:59";
        // subString으로 문자열 추출 = String.subString();
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        int second = Integer.parseInt(time.substring(6, 8));

        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
    }

    public static void timeSplit() {
        String[] time = "09:10:59".split(":");
        // subString으로 문자열 추출 = String.subString();
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int second = Integer.parseInt(time[2]);

        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
    }
}
