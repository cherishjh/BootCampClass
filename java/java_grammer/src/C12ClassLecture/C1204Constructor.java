package C12ClassLecture;

import java.io.StringReader;

public class C1204Constructor {
    public static void main(String[] args) {

        Calender mine1= new Calender("2023","03","14");
        Calender mine2 = new Calender("2023");
        Calender mine3 =new Calender();

    }
    static class Calender{
        String year;
        String month;
        String day;

        Calender (String year, String month, String day){
            this.year= year;
            this.month= month;
            this.day=day;
        }

//       메서드 오버로딩을 통해 같은 이름의 생성자 생성 가능
        Calender (String year, String month){
            this.year= year;
            this.month= month;
        }


//        this() 키워드를 통해 클래스 내 매개변수에 맞는 생성자 호출 가능
        Calender (String month){
            this("2022",month,null);                                   //this에 소괄호를 쓰면
        }





        Calender(){
        }
    }
}
