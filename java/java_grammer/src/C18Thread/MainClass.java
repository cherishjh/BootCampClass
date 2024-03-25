package C18Thread;

public class MainClass {
    public static void main(String[] args) {
        // 상속 방식으로 thread 생성
        Thread etc1= new ExtendsThreadClass();
        etc1.start();
        Thread etc2= new ExtendsThreadClass();
        etc2.start();
        new ExtendsThreadClass().start();  //이 표현식 많이 사용
//      스레드 생성 시 순차적으로 실행되지 않음에 유의

//       Thread 생성자로 Runnable 객체를 주입하는 방식
//       Thread 클래스에 Runnable 객체가 전달되어 사용자가 직접 정의 run 메서드가 실행

        /*Thread rt1 = new Thread(new RunnableImplementsClass());
        rt1.start();*/
        /*new Thread(new RunnableImplementsClass()).start();
        new Thread(() ->System.out.println("익명 객체 스레드")).start();*/
        //표현식 : 면접 질문에 나올 수 있는 내용 , 왜 runnable 객체를 여기에 주입하냐||


//        thread의 동시성 이슈 테스트
//        단일 스레드 일반 호출
           /* for ( int i=0; i<1000; i++) {
                Library.borrowBook();
            }
            System.out.println("최종 남음 수량"+ Library.bookcount);*/

            for ( int i=0; i<1000; i++) {
                /*Thread th1= new Thread(new RunnableImplementsClass());
                th1.start();*/
                Thread th = new Thread(()->Library.borrowBook());
                th.start();
               /* new Thread(Library::borrowBook).start();*/
                //System.out.println(Thread.currentThread().getName());   //이거 test 해볼려 했는데 main이 떠서.. number 안 뜨고..

                // join 메서드를 통해 다른 스레드의 완료전까지 새로운 스레드가 실행되지 않도록 막음.
                    // 스레드 자체에 락을 거는 것이라 좀 무거움
                /*try {
                    th.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/

            }
            System.out.println("최종 남음 수량"+ Library.bookcount);


    }
}
