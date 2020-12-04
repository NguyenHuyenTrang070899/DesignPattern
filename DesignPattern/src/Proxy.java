//lazy load
public class Proxy {
    public static void main(String[] args) {
        ProxyImage proxyImage = new ProxyImage("https://github.com/");
        proxyImage.showImage();
        proxyImage.showImage();
    }
}
interface Image {
    void showImage();
}
class RealImage implements Image {
    private String url;

    public RealImage(String url) {
        this.url = url;
        System.out.println("Image loaded");
    }
    @Override
    public void showImage() {
        System.out.println("Image showed");
    }
}
class ProxyImage implements Image {
    private Image realImage;
    private String url;
    public ProxyImage(String url) {
        this.url = url;
        System.out.println("Image unloaded: " + this.url);
    }

    @Override
    public void showImage() {
        if (realImage == null) {
            realImage = new RealImage(this.url);
        } else {
            System.out.println("Image already existed");
        }
        realImage.showImage();
    }
}