package tiy.gui;

/**
 * Created by jfabiano on 8/29/2016.
 */
public class FrenchGreeting implements HelloWorld{
    String name = "tout le monde";
    public void greet() {
        greetSomeone("tout le monde");
    }
    public void greetSomeone(String someone) {
        name = someone;
        System.out.println("Salut " + name);
    }
}
