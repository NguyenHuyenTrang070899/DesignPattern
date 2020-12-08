class Context {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    public Context(String a, String b, String c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    public static class ContextBuilder {
        private String a;
        private String b;
        private String c;
        private String d;
        public ContextBuilder(String a, String b) {
            this.a = a;
            this.b = b;
        }
        public ContextBuilder getC(String c) {
            this.c = c;
            return this;
        }
        public ContextBuilder getD(String d) {
            this.d = d;
            return this;
        }
        public Context build() {
            return new Context(this.a, this.b, this.c, this.d);
        }
    }
}
public class Builder {
    public static void main(String args[]) {
        Context c = new Context
                    .ContextBuilder("a", "b")
                    .getD("d")
                    .build();
        System.out.println(c);
    }
}
