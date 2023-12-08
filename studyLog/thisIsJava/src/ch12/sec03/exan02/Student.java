package ch12.sec03.exan02;

public class Student {
    private int no;
    private String name;

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() { return no; }
    public String getName() { return name; }

    @Override
    public int hashCode() {
        int hashCode = no + name.hashCode(); //String은 다른 객체여도 동일한 해시코드가 나옴.
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student target) {

        }
    }
}
