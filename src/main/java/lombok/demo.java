package lombok;

import lombok.entity.User;
import lombok.entity.UserByLombok;

public class demo {
    public static void main(String[] args) {
        /*User user = User.of("zhangsan").setAge(13);
        System.out.println(user.toString());
        User user2=User.builder().age(14).name("444").build();
        System.out.println(user2.toString());
        UserByLombok userByLombok = UserByLombok.builder().age(16).name("lisi").build();
        System.out.println(userByLombok.toString());*/
        System.out.println(Character.SIZE);
    }
}
