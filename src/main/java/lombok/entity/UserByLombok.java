package lombok.entity;

import lombok.Builder;

@Builder
public class UserByLombok {
    private String name;
    private int age;
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
