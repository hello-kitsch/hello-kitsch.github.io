package ch02.sec06;

public class TextBlockExample {
    public static void main(String[] args) {
        String str1 = "{\n" +
        "\t\"id\":\"winter\",\n" +
        "\t\"name\":\"눈송이\"\n" +
        "}";
        
        String str2 = """
        {
            "id":"winter",
            "name":"눈송이"
        }
        """;
        
        System.out.println(str1);
        System.out.println("------------------------------");
        System.out.println(str2);
        System.out.println("------------------------------");
        String str = """
        나는 자바를 \
        학습합니다.
        나는 스프링도 배워야합니다.
        """;
        System.out.println(str);
    }
}
/*
 * tab키(\t)와 에디터 상의 인덴테이션 자동 적용이 되는 탭키는 다른건가
 * tab은 원래 8칸, 사전상 정의는 다음번 탭의 위치까지 커서를 옮기는데 쓰는 자판의 글쇠.
 */