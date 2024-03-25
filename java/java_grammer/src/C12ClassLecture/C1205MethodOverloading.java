package C12ClassLecture;

public class C1205MethodOverloading {
    public static void main(String[] args) {
        C1205MethodOverloading c = new C1205MethodOverloading();
        //메소드 오버로딩을 통해 같은 함수 이름 재활용
        System.out.println(c.sum(1,2));
        System.out.println(c.sum(1,2,3));
        System.out.println(c.sum(10.5,2.21));

    }
    int sum (int a, int b) {
        return a+b;
    }
    int sum (int a, int b, int c) {
        return a+b+c;
    }

    double sum (double a, double b) {
        return a+b;
    }

}

