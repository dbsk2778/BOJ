package String;

public class theory
{
    // String은 값의 변경이 불가능하다. 하지만 새 String을 만들어 바꿀 수 있다
    // 문자열 함수 정리 : https://hongong.hanbit.co.kr/java-%EC%9E%90%EB%B0%94-%EB%AC%B8%EC%9E%90%EC%97%B4%EC%9D%84-%EB%8B%A4%EB%A3%A8%EB%8A%94-string-%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%A9%94%EC%86%8C%EB%93%9C-%EC%B4%9D%EC%A0%95%EB%A6%AC/
    public static void main(String[] args) {
        changeString();
        changeString2();
        
        compareString();
    }
    
    public static void changeString() {
        String str = "ABCDFFG";
    
        char[] temp_arr = str.toCharArray();
        temp_arr[2] = 'A';
    
        str = new String(temp_arr);
    
        System.out.println(str);
    }
    
    public static void changeString2() {
        String str = "ABCDFFG";
        str = str.substring(0, 4) + 'E' + str.substring(5, 7);
        System.out.println(str);
    }
    
    public static void compareString() {
        String str1 = "abc";  // 공용 String pool에 생성
        String str2 = new String("abc");  // 같은 값이 있는지 확인하지 않고, heap 영역에 바로 생성
        String str3 = "abc";  // 공용 String pool에 생성 (기존 값 이미 있기 때문에, 기존 값 사용 / 없을 경우 생성)
        String str4 = new String("abc");
        
        System.out.println(str1 == str2);  // == 는 주소 값 비교
        System.out.println(str1.equals(str2));  // String 객체 비교는 equals (문자열 비교)
        System.out.println(str1 == str3);  // true
        System.out.println(str2 == str4);  // false
    }
}
