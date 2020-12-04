class SinhVien {
    private final String name;
    private final String mssv;
    private final String email;
    private final String sex;
    public SinhVien(String name, String mssv, String email, String sex) {
        super();
        this.name = name;
        this.mssv = mssv;
        this.email = email;
        this.sex = sex;
    }
    //class Builder
    public static class SinhVienBuilder {
        private String name;
        private String mssv;
        private String email;
        private String sex;
        public SinhVienBuilder(String name, String mssv) {
            this.name = name;
            this.mssv = mssv;
        }
        public SinhVienBuilder getEmail(String email) {
            this.email = email;
            return this;
        }
        public SinhVienBuilder getSex(String sex) {
            this.sex = sex;
            return this;
        }
        public SinhVien build() {
            return new SinhVien(this.name, this.mssv, this.email, this.sex);
        }
    }
    public String toString() {
        return "Sinh vien [name=" + name + ", mssv=" + mssv + ", email=" + email + ", sex=" + sex + "]";
    }
}
public class Builder {
    public static void main(String args[]) {
        SinhVien sv = new SinhVien
                .SinhVienBuilder("Trang", "17020112")
                .getSex("Male")
                .build();
        System.out.println(sv);
    }
}