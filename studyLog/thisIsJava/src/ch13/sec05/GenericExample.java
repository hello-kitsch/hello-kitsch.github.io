package ch13.sec05;

public class GenericExample {
    public static void main(String[] args) {
        Course.registerCourse1(new Applicant<Person>(new Person()));
        Course.registerCourse1(new Applicant<Worker>(new Worker()));
        Course.registerCourse1(new Applicant<Student>(new Student()));
        Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
        Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
        System.out.println();

        Course.registerCourse2(new Applicant<Student>(new Student()));
        Course.registerCourse2(new Applicant<Student>(new HighStudent()));
        Course.registerCourse2(new Applicant<Student>(new MiddleStudent()));
        System.out.println();

        Course.registerCourse3(new Applicant<Person>(new Person()));
        Course.registerCourse3(new Applicant<Worker>(new Worker()));
    }
}