package ch08.sec04;

public interface RemoteControl {
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;

    //추상 메소드에 public abstract 생략 가능
    void turnOn(); 
    void turnOff();
    void setVolume(int volume); 
}