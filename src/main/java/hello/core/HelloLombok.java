package hello.core;

import lombok.*;


@ToString
@AllArgsConstructor
@Setter(AccessLevel.PACKAGE)
public class HelloLombok {
    @ToString.Exclude
    private String name;

    private int age;

    private String address;

    public static void main(String[] args) {
       HelloLombok helloLombok1 = new HelloLombok("test2" , 88 , "busan");
       System.out.println(helloLombok1);
    }
}
