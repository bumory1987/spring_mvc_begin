package hello.springmvc.basic.testobject;

import lombok.Data;

@Data
public class NestedHello {
    private String username;
    private int age;
    private NestedData nestedata;
}
