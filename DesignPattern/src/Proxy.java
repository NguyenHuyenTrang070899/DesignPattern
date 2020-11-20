public class Proxy {
    public static void main(String[] args) {
        MediaFile mediaFile = new ProxyMediaFile("dat.txt");
        mediaFile.printName();
        mediaFile.printName();
    }
}
interface MediaFile {
    void printName();
}
class MediaFileImpl implements MediaFile {
    private String fileName;

    public MediaFileImpl(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void printName() {
        System.out.println("Tạm Ngưng " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Đang tải " + fileName);
    }
}
class ProxyMediaFile implements MediaFile {

    private MediaFileImpl mediaFileImpl;
    private String fileName;

    public ProxyMediaFile(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void printName() {
        if(mediaFileImpl == null){
            mediaFileImpl = new MediaFileImpl(fileName);
        }
        mediaFileImpl.printName();
    }
}