import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C11StackQueueDeque {
    public static void main(String[] args) {
       /* Stack<Integer> myst = new Stack<>();
        myst.push(10);
        myst.push(20);
        myst.push(30);*/
        // pop: 스택에서 요소를 제거 후 해당 요소 반환
       /* myst.pop();
        System.out.println(myst);
        System.out.println(myst.pop());*/
        // peek: 끝자리에 뭐가 있는지 반환해주고 다시 제자리에 돌려 놓음
       /* System.out.println(myst.peek());
        System.out.println(myst.size());   //size도 있고
        System.out.println(myst.isEmpty());  // isEmpty도 있다*/

        //실습 예제: String 타입 5개 정도 추가후 while 문 통해 모두 출력
        /*Stack<String> myStack = new Stack<>();
        myStack.push("hello");
        myStack.push("my");
        myStack.push("name");
        myStack.push("is");
        myStack.push("hello1");

        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
        while (myStack.size() != 0) {
            System.out.println(myStack.pop());
        }*/

        //웹페이지 방문 뒤로 가기 구현
        /*Stack<String>backwards= new Stack<>();
        Stack<String>forwards= new Stack<>();
        while(true){
            System.out.println("신규방문시 1번, 앞으로가기 2번, 뒤로가기 3번");
            Scanner my_scan= new Scanner(System.in);
            String input= my_scan.nextLine();
            if (input.equals("1")) {
                System.out.println("방문하신 사이트를 입력해주세요");
                Scanner sc2= new Scanner(System.in);
                String input2= sc2.next();
                System.out.println("방문하신 사이트는 "+ input2 + "입니다.");
                backwards.push(input2);
            } else if (input.equals("2")){
                String temp = forwards.pop();
                backwards.push(temp);
                System.out.println("앞으로 가기 통해 간 곳은 " + forwards.pop()+ "입니다");
            } else {
                String temp = backwards.pop();
                forwards.push(temp);
                System.out.println("뒤로 가기로 방문하신 곳은 " + backwards.peek() + "입니다");
            }
        }
        //방문한 사이트 출력 + 뒤로가기 기능 구현
        //스캐너로 신규사이트 방문 or 뒤로가기
        //신규사이트방문일 경우, 해당 주소 추가
        // 뒤로 가기 일 경우 , 해당 주소 pop

        Stack<String> myHistroy = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b= sc.nextLine();
        if (!a.equals(myHistroy.peek())) {
            myHistroy.push(a);
            System.out.println(myHistroy.peek());
        }
        if(a.equals(myHistroy.peek())){
            System.out.println(myHistroy.peek());
        }*/

        //큐선언
        /*Queue<Integer> myQue = new LinkedList<>();
        myQue.add(10);
        myQue.add(20);
        myQue.add(30);
        //poll() : 값을 소모하면서 return
        System.out.println(myQue.poll());//10
        System.out.println(myQue);  //20,30*/

//        프린트 대기열 예제
//        문서 1추가, 2추가, 3추가
//        while 문을 통해 "현재 출력 중인 문서: " 로 포맷 출력
       /* Queue<String> myPrinter= new LinkedList<>();
        myPrinter.add("Document 1");
        myPrinter.add("문서 2");
        myPrinter.add("문서 3");

        while(!myPrinter.isEmpty()){
            System.out.println("현재 출력 중인 문서: "+ myPrinter.poll() );
        }*/


//      길이의 제한이 있는 큐: ArrayBlockingQueue
        /*Queue<String> myQue = new ArrayBlockingQueue<>(3);*/  //capactiy: 길이 제한
//        add와 offer 의 차이: add는 길이가 다 찼을때 에러를 발생, offer 공간이 충분할때만 add
     /*   myQue.offer("hello1");
        myQue.offer("hello1");
        myQue.offer("hello1");
        myQue.offer("hello2");
        System.out.println(myQue);*/

//        우선순위 que
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(50);
        pq.add(30);
        pq.add(40);
        System.out.println(pq.poll());
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
            }

        //        ArrayDeque : 양방향에서 데이터를 삽입/제거할 수 있다.
        // 성능 빠름 !
       /* Deque<Integer> myDeque = new ArrayDeque<>();
        myDeque.addFirst(10);
        myDeque.addFirst(20);
        System.out.println(myDeque);   //20,10
        myDeque.addLast(30);
        System.out.println(myDeque);        //20,10,30

        System.out.println(myDeque.pollFirst()); //20
        System.out.println(myDeque.pollLast());  //30
        System.out.println(myDeque);             //10*/
        /*String s="(()(";
        Deque<Character> clause = new ArrayDeque<>();
        for(int a=0; a<s.length(); a++)
            if(clause.isEmpty()) {
                clause.addLast(s.charAt(a));
            }else{
                if(clause.peekLast()=='(' && s.charAt(a)==')')

        boolean answer = true;
        int count_a = 0;
        int count_b = 0;

        if (clause.size() % 2 != 0) {
            answer = false;        //return 쓰는게 효율성 좋음 /바로 끊어줌
        }
            if (clause.pollFirst() == ')' || clause.pollLast() == '(') {
                answer = false;
            }
            if (clause.peekFirst() == '(' && clause.peekLast() == ')') {
                for (int i = 0; i < clause.size(); i++) {
                    if (clause.pollFirst() == '(') {
                        count_a++;
                    } else {
                        count_b++;
                    }
                }
                if (count_a == count_b) {
                    answer = true;
                } else {
                    answer = false;
                }
            }
        }
        System.out.println(answer);
    }*/
    }
}
