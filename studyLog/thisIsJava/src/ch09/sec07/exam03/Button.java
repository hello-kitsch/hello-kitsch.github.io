package ch09.sec07.exam03;

public class Button {
    public static interface ClickListener {
        void onClick();
    }
    private ClickListener clickListener;

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener; //Button 클래스의 필드에 구현객체의 참조가 저장됨.
    }
    public void click() {
        this.clickListener.onClick(); //구현객체의 onClick() 메소드가 실행됨.
    }
}