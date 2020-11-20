import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class Light {

    enum State {
        ON, OFF
    }
    private String color;
    private LightMediator lightMediator;
    private State currentState;

    public Light(String color, LightMediator lightMediator) {
        this.color = color;
        this.currentState = State.OFF;
        this.lightMediator = lightMediator;
        lightMediator.registerLight(this);
    }

    public void turnOn() {
        this.currentState = State.ON;
        lightMediator.notifyMediator(this);
    }

    public void turnOff() {
        this.currentState = State.OFF;
        lightMediator.notifyMediator(this);
    }

    public String getColor() {
        return color;
    }

    public State getCurrentState() {
        return currentState;
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;

        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Light light = (Light) obj;
        return color.equals(light.color);
    }
}
class LightMediator {
    private Set<Light> trafficSignals = new HashSet<>();

    public void registerLight(Light light) {
        trafficSignals.add(light);
    }

    public void unRegisterLight(Light light) {
        trafficSignals.remove(light);
    }

    public void notifyMediator(Light light) {
        System.out.printf("%s is turned %s \n", light.getColor(), light.getCurrentState());
        if (light.getCurrentState() == Light.State.ON) {
            turnOffAllOtherLights(light);
        }
    }

    private void turnOffAllOtherLights(Light light) {
        for (Light otherLight : trafficSignals) {
            if (!(light.equals(otherLight))) {
                otherLight.turnOff();
            }
        }
        System.out.println("---");
    }
}
public class Mediator {

    public static void main(String[] args) {

        LightMediator lightMediator = new LightMediator();
        Light[] lights = {
                new Light("Red", lightMediator),
                new Light("Green", lightMediator),
                new Light("Yellow", lightMediator)
        };

        int currentLightIndex = 0;
        Light light;
        while (true) {
            if (currentLightIndex >= lights.length) {
                currentLightIndex = 0;
            }
            light = lights[currentLightIndex];
            light.turnOn();
            timer();
            currentLightIndex++;
        }
    }

    private static void timer() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}