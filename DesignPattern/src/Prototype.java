class A implements Cloneable {
    private String a;
    private String b;
    private String c;
    private String d;

    public A(String a, String b, String c, String d) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    protected A clone() {
        try {
            return (A) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void setOthers(String d) {
        this.d = d;
    }
}
public class Prototype {
    public static void main(String args[]) {
        A a = new A("Trang", "17021075", "Female", "level 1");
        A a2 = a.clone();
        a2.setOthers("level 1, 1m67");
        System.out.println(a);
        System.out.println(a2);
    }
}
