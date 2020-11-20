import java.util.HashMap;
import java.util.Random;

public class Flyweight {
    private static final String[] names = {"Hoa", "Lan", "An", "Trang"};
    public static void main(String[] args) {
        for(int i = 0; i < 5; ++i) {
            AttendeeImpl attendeeImpl = (AttendeeImpl) AttendeeFactory.getAttendee(getRandomName());
            attendeeImpl.setAge(getRandomAge());
            attendeeImpl.listenToConcert();
        }
    }

    private static String getRandomName() {
        int randomName = new Random().nextInt(names.length);
        return names[randomName];
    }

    private static int getRandomAge() {
        return (int)(Math.random()*10);
    }
}
interface Attendee {
    public void listenToConcert();
}
class AttendeeImpl implements Attendee {
    private String name;
    private int age;

    public AttendeeImpl(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void listenToConcert() {
        System.out.println(name + " đang nghe buổi hòa nhạc " + age + " tuổi!");
    }
}
class AttendeeFactory {
    private static final HashMap attendees = new HashMap();
    public static Attendee getAttendee(String name) {
        AttendeeImpl attendeeImpl = (AttendeeImpl)attendees.get(name);
        if(attendeeImpl == null) {
            attendeeImpl = new AttendeeImpl(name);
            attendees.put(name, attendeeImpl);
            System.out.println("Người tham dự mới: " + name);
        }
        return attendeeImpl;
    }
}