public class Adapter {
    public static void main(String[] args) {
        VietnameseTarget client = new TranslatorAdapter(new EnglishAdaptee());
        client.send("Xin chào");
    }
}
interface VietnameseTarget {
    void send(String words);
}
class EnglishAdaptee {
    public void receive(String words) {
        System.out.println("Retrieving words from Adapter ...");
        System.out.println(words);
    }
}
class TranslatorAdapter implements VietnameseTarget {
    private EnglishAdaptee adaptee;
    public TranslatorAdapter(EnglishAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void send(String words) {
        System.out.println("Reading Words ...");
        System.out.println(words);
        String vietnameseWords = this.translate();
        System.out.println("Sending Words ...");
        adaptee.receive(vietnameseWords);
    }

    private String translate() {
        System.out.println("Translated!");
        return "Hello";
    }
}