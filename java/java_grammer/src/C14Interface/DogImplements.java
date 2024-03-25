package C14Interface;

public class DogImplements implements AnimalInterface1 {

    @Override
    public void makeSound() {
        System.out.println("멍");
    }
}

class DogMultiImplements implements AnimalInterface1, AnimalInterface2 {

    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }

    @Override
    public String play(String a, String b) {
        return a+ "와 "+ b+ "가 놉니다.";
    }
}