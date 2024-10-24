import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        CountdownTimer timer = new CountdownTimer(30); // 30-second countdown
        addObject(timer, 100, 50);
    }
}
