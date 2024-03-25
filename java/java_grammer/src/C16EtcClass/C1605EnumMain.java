package C16EtcClass;

public class C1605EnumMain {
    public static void main(String[] args) {
        EnumStudent s1= new EnumStudent();
        s1.setName("jam");
        s1.setClassGrade(classGrade.a1);
        EnumStudent s2 = new EnumStudent();
        //타입이 여전히 String 타입이므로 클래스 변술를 사용하지 않을 수 있다.
        s2.setName("jammy");
        s2.setClassGrade("second grade");

        // 이거 아니면 못 쓰게 막아줘야 함 ->
        EnumStudent s3 = new EnumStudent();
        s3.setName("jammy");
        //String으로 셋팅 불가 -> 타입까지 체크하므로
       /* s3.setRole("GENERAL_USER");*/
        // Enum 타입 사용 시에는 static final 변수와 동일한 방법으로 사용
        s3.setRole(Role.GENERAL_USER);
        System.out.println(s3.getRole());
        System.out.println(s3.getRole().getClass());
        //enum값은 저장된 순서대로 0부터 index값이 내부적으로 할당
        System.out.println(s3.getRole().ordinal());


    }
}
class classGrade{
    static final String a1= "first grade";
    static final String a2= "second grade";
    static final String a3= "third grade";
}
enum Role{
    //각 열거형 상수는 ',' 로 구분, 상수 목록 끝에는 ';' 로 마무리
    GENERAL_USER, ADMIN_USER, SUPER_USER;
}

class EnumStudent{
    private String name;
    // 소속 반
    private String classGrade;
    //string 타입이 아닌 Role 타입을 신규로 지정
    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

