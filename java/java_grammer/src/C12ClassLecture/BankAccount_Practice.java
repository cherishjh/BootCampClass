package C12ClassLecture;

//public class BankAccount_Practice {
//    public static void main(String[] args) {
//
//        int balance = 4500000;
//        Set myset= new Set();
//        depo_draw mydd= new depo_draw();
//        mydd.getBalance(balance);
//
//        myset.setAccountnum(123341);
//        System.out.println(myset.getAccountnum());
//        mydd.available(121231);
//        mydd.getavailable();
//
//        BankAccount jongwon= new BankAccount("1234");
//        jongwon.deposit(1000000000);
//        jongwon.withdraw(222222);
//        System.out.println(jongwon.getAccountNumber());
//        BankAccount hun = new BankAccount("2222");
//        hun.deposit(15000);
//        hun.withdraw(20000);
//        System.out.println(hun.getAccountNumber());
//
//    }
//}
//class Set{
//        private int accountnum;
//        public void setAccountnum (int accountnum) {
//            if (accountnum > 2000000000) {
//                System.out.println("유효하지 않은 계좌번호");
//            } else {
//                System.out.println("정상처리 되었습니다.");
//                this.accountnum = accountnum;
//            }
//        }
//        public int getAccountnum(){
//            return accountnum;
//        }
//    }
//    class depo_draw{
//        private int balance;
//
//        public void getBalance(int balance){
//            this.balance=balance;
//        }
//        public void available (int want ){
//            if(balance<=want) {
//                System.out.println("잔액이 부족해 인출이 불가능합니다.");
//            } else {
//                System.out.println("정상처리 되었습니다.");
//                balance=this.balance-want;
//            }
//        }
//        public int getavailable(){
//            return balance;
//        }
//    }

public class BankAccount_Practice {
    public static void main(String[] args) {
        BankAccount jongwon = new BankAccount("1234");
        jongwon.deposit(1000000000);
        jongwon.withdraw(500000);
        System.out.println(jongwon.getAccountNumber());
        BankAccount hun = new BankAccount("12345");
        hun.deposit(150000);
        hun.withdraw(200000);
        System.out.println(hun.getAccountNumber());
    }
}

class BankAccount{
    private String accountNumber;
    private int balance;
    //    생성자란 클래스가 객체화 될때 자동으로 실행되는 메서드
//    클래스명(){} : 생성자의 형태
//    별도의 생성자를 만들지 않으면 매개변수없는 기본생성자가 숨겨져있다.
    BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    //    예금
    public void deposit(int money){
        this.balance += money;
        System.out.println(money + "원 입금되었습니다.");
    }

    //    출금
    public void withdraw(int money){
        if(this.balance < money){
            System.out.println("잔액이 부족합니다.");
        }else {
            this.balance -= money;
            System.out.println(money + "원 출금되었습니다.");
        }
    }
    public int checkBalance(){
        return this.balance;
    }
}