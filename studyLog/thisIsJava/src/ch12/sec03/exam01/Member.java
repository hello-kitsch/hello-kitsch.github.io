package ch12.sec03.exam01;

public class Member {
    public String id;

    public Member(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member target) { //객체 타입 확인 구문, true일 경우 우측 타입 변수에 대입됨.
            if(id.equals(target.id)) {
                return true;
            }
        }
        return false;
    }
}