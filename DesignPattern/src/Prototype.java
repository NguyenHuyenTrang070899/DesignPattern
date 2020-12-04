class User implements Cloneable {
    private String name;
    private String id;
    private int age;
    private String sex;
    private String others;

    public User(String name, String id, int age, String sex, String others) {
        super();
        this.name = name;
        this.id = id;
        this.age = age;
        this.sex = sex;
        this.others = others;
    }
    protected User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String toString() {
        return "User [name= " + name + ", id= " + id + ", age= " + age + ", sex= " + sex + ", others= " + others + "]";
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
public class Prototype {
    public static void main(String args[]) {
        User user = new User("Trang", "17021075", 22, "Female", "level 1");
        User user2 = user.clone();
        user2.setOthers("level 1, 1m67");
        System.out.println(user);
        System.out.println(user2);
    }
}