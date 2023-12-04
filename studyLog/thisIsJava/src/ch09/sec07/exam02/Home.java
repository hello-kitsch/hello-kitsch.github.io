package ch09.sec07.exam02;

public class Home {
    private RemoteControl rc = new RemoteControl() { //필드에 익명 구현 객체 대입
        @Override
        public void turnOn() {
            System.out.println("TV를 켭니다.");
        }
        @Override
        public void turnOff() {
            System.out.println("TV를 끕니다.");
        }
    };
    //(익명 구현 객체를 대입한) 필드를 이용한 메소드
    public void use1() {
        rc.turnOn();
        rc.turnOff();
    }
    //로컬 변수를 이용한 메소드
    public void use2() {
        RemoteControl rc = new RemoteControl() { //로컬 변수에 익명 구현 객체 대입
            @Override
            public void turnOn() {
                System.out.println("에어컨을 켭니다.");
            }
            @Override
            public void turnOff() {
                System.out.println("에어컨을 끕니다.");
            }
        };
        rc.turnOn();
        rc.turnOff();
    }
    //매개변수를 이용한 메소드
    public void use3(RemoteControl rc) {
        rc.turnOn();
        rc.turnOff();
    }
}
