import java.util.Arrays;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        FileComponent file1 = new FileLeaf("file 1", 10);
        FileComponent file2 = new FileLeaf("file 2", 5);
        FileComponent file3 = new FileLeaf("file 3", 12);
        List<FileComponent> files = Arrays.asList(file1, file2, file3);
        FileComponent folder = new FolderComposite(files);
        folder.showProperty();
        System.out.println("Total Size: " + folder.totalSize());
    }
}
interface FileComponent {
    void showProperty();
    long totalSize();
}
class FileLeaf implements FileComponent {

    private String name;
    private long size;

    public FileLeaf(String name, long size) {
        super();
        this.name = name;
        this.size = size;
    }

    @Override
    public long totalSize() {
        return size;
    }

    @Override
    public void showProperty() {
        System.out.println("FileLeaf [name=" + name + ", size=" + size + "]");
    }
}
class FolderComposite implements FileComponent {

    private List<FileComponent> files;

    public FolderComposite(List<FileComponent> files) {
        this.files = files;
    }

    @Override
    public void showProperty() {
        for (FileComponent file : files) {
            file.showProperty();
        }
    }

    @Override
    public long totalSize() {
        long total = 0;
        for (FileComponent file : files) {
            total += file.totalSize();
        }
        return total;
    }
}