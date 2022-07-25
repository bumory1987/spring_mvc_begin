package hello.springmvc.basic;

import lombok.Data;

@Data
public class NestedHello {
    private String username;
    private int age;
    private NestedData nestedata;
}
