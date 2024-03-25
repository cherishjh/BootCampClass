package C14Interface;

public class StaticFinalInterface {
    public static void main(String[] args) {
        MyImplements mine = new MyImplements();
        mine.print();
        System.out.println(MyInterface.my_constant);
        System.out.println(mine.my_constant);
    }
}

interface MyInterface {
//    아래 변수는 컴파일 타임에 static final이 붙는다.  static final -> 상수이자 final
    String my_constant ="test";
    void method();
    }


class MyImplements implements MyInterface{
      void print(){
          System.out.println("hello world");
      }

    @Override
    public void method() {

    }
}

