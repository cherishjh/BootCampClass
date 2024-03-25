package C18Thread;

// Thread 클래스에 이미 구현되어 있는 run 메서드는 깡통으로 비어 있는 메서드임.
// 작업하고 싶은 내용을 run() 메서드를 overriding 하여 정의할 수 있다.
//  상속관계이다보니 다른 클래스 상속 불가
public class ExtendsThreadClass extends Thread{
    //run 메서드는 스레드가 시작되면 바로 실행된다.
    @Override
    public void run(){
        System.out.println("ExtendsThreadClass :"+ Thread.currentThread().getName());
    }
}


