package C14Interface;

public class InterfaceMain {
    public static void main(String[] args) {
        CatImplements myCat = new CatImplements();
        DogImplements myDog = new DogImplements();
        myCat.makeSound();
        myDog.makeSound();

//      다형성이란 하나의 객체가 여러 개의 참조 변수를 가질 수 있음을 의미
        CatMultiImplements myMultiCat = new CatMultiImplements();
        myMultiCat.makeSound();
        System.out.println(myMultiCat.play("코리안숏헤어","브리티시폴드"));
//      타입을 interface1로 선언하면 interface2에 정의된 메서드는 사용 불가
       /* AnimalInterface1 myMultiDog = new DogMultiImplements();
        myMultiDog.makeSound();
        System.out.println(myMultiDog.play("시바견","진돗개"));*/

//      기본적으로 추상클래스, 인터페이스는 객체 생성이 불가능하나, 익명내부클래스 방식으로 사용 가능
        AnimalInterface1 ai = new AnimalInterface1() {
            @Override
            public void makeSound() {

            }
        };

    }
}
