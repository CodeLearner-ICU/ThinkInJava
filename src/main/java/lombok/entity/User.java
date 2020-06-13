package lombok.entity;

public class User {
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static User of(String name){
        return new User().setName(name);
    }

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private String name;
        private int age;
        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public User build(){
            return new User().setAge(this.age).setName(this.name);
        }
    }
}
