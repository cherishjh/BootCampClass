package C12ClassLecture;

public class C1203Class2 {
    public static void main(String[] args) {
//      Person클래스를 만들고,
//      객체 변수는 name, email, password, age
//       객체 메서드 whoIs(): name, email, password, age 입니다 -> 출력
        Person myPerson= new Person();
        myPerson.setName("길동");
        myPerson.setEmail("hongnaver.com");
        myPerson.setAge(20);

        System.out.println(myPerson.getName()+"입니다.");
        System.out.println(myPerson.getEmail());
        System.out.println(myPerson.getAge());
        /*Person myPerson2= new Person();
        myPerson2.name="홍길동";
        myPerson2.email="hong@naver.com";
        myPerson2.age=20;
        Person.person_total+=1;            // 복습note: 이게 무슨 의미인지 생각*/
        /*System.out.println(myPerson2.whoIs());*/
    }
}

class Person{
    private String name;
    private String email;
    private int password;
    private int age;


    public String getName() {
            return name;
    }

    public void setName(String name) {
        if (name.length() < 10) {
            this.name = name;
            System.out.println("정상 처리 되었습니다.");
        } else {
            System.out.println("이름이 너무 깁니다.");
        }
    }

    public String getEmail() {
            return email;
        }

    public void setEmail(String email) {
        if(email.contains("@")){
            System.out.println("정상 셋팅되었습니다.");
                this.email= email;
            } else {
            System.out.println("형식이 잘못되었습니다.");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if( age<20){
            System.out.println("미성년은 가입 할 수 없습니다.");
        } else {
            System.out.println("정상 처리 되었습니다");
            this.age = age;
        }
    }

    String whoIs(){
        return "이름은 "+ this.name+ " 나이는 "+ this.age+ " 입니다.";
    }
    void whoIs21() {
        System.out.println(name+","+ email+", "+ password+ ","+ age+"입니다.");
    }
}