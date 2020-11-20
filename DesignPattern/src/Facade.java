public class Facade {
    public static void main(String[] args) {
        ZooKeeper zookeeper = new ZooKeeper();
        zookeeper.feedLion();
        zookeeper.feedWolf();
        zookeeper.feedBear();
    }
}
interface Animal {
    void feed();
}
class Lion implements Animal {
    @Override
    public void feed() {
        System.out.println("Sư tử đang được cho ăn!");
    }
}
class Wolf implements Animal {
    @Override
    public void feed() {
        System.out.println("Sói đang được cho ăn");
    }
}
class Bear implements Animal {
    @Override
    public void feed() {
        System.out.println("Gấu đang được cho ăn");
    }
}
class ZooKeeper {
    private Animal lion;
    private Animal wolf;
    private Animal bear;

    public ZooKeeper() {
        lion = new Lion();
        wolf = new Wolf();
        bear = new Bear();
    }

    public void feedLion() {
        lion.feed();
    }

    public void feedWolf() {
        wolf.feed();
    }

    public void feedBear() {
        bear.feed();
    }
}