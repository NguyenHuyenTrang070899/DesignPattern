import java.util.Arrays;
import java.util.List;

public class CompositeClient {
    public static void main(String[] args) {
        Component file1 = new Leaf("file 1");
        Component file2 = new Leaf("file 2");
        Component file3 = new Leaf("file 3");
        List<Component> files = Arrays.asList(file1, file2, file3);
        Component folder = new Composite(files);
        folder.A();
    }
}
interface Component {
    void A();
}
class Leaf implements Component {
    private String name;
    public Leaf(String name) {
        super();
        this.name = name;
    }
    @Override
    public void A() {
    }
}
class Composite implements Component {
    private List<Component> files;
    public Composite(List<Component> files) {
        this.files = files;
    }
    @Override
    public void A() {
        for (Component file : files) {
            file.A();
        }
    }
}