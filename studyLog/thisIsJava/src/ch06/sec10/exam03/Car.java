package ch06.sec10.exam03;

public class Car {
    int speed;
    
    void run() {
        System.out.println(speed + "으로 달립니다.");
    }

    static void simulate() {
        Car myCar = new Car(); //객체 생성
        myCar.speed = 200; //인스턴스 멤버 사용
        myCar.run();
    }

    public static void main(String[] args) {
        simulate();

        Car myCar = new Car();
        myCar.speed = 60;
        myCar.run();
    }
}
