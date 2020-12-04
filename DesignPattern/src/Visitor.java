public class Visitor {
    public static void main(String[] args) throws Exception {
        Book book1 = new BusinessBook();
        Book book2 = new JavaCoreBook();
        Book book3 = new DesignPatternBook();
        IVisitor v = new VisitorImpl();
        book1.accept(v);
        book2.accept(v);
        book3.accept(v);
    }
}
interface Book {
    void accept(IVisitor v);
}
class BusinessBook implements Book {
    public void accept(IVisitor v) {
        v.visit(this);
    }
    public String getPublisher() {
        return "The publisher of business book";
    }
}
interface ProgramingBook extends Book {
    String getResource();
}
class DesignPatternBook implements ProgramingBook {
    @Override
    public void accept(IVisitor v) {
        v.visit(this);
    }
    @Override
    public String getResource() {
        return "https://github.com/Design-Pattern-Tutorial/";
    }
    public String getBestSeller() {
        return "The best Seller of design pattern book";
    }
}
class JavaCoreBook implements ProgramingBook {
    @Override
    public void accept(IVisitor v) {
        v.visit(this);
    }
    @Override
    public String getResource() {
        return "https://github.com/Java-Tutorial/";
    }
    public String getFavouriteBook() {
        return "The most favourite book of java core";
    }
}
interface IVisitor {
    void visit(BusinessBook book);
    void visit(DesignPatternBook book);
    void visit(JavaCoreBook book);
}
class VisitorImpl implements IVisitor {
    @Override
    public void visit(BusinessBook a) {
        System.out.println(a.getPublisher());
    }
    @Override
    public void visit(DesignPatternBook w) {
        System.out.println(w.getBestSeller());
    }
    @Override
    public void visit(JavaCoreBook g) {
        System.out.println(g.getFavouriteBook());
    }
}
