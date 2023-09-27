package logic;

import ir.sharif.ap.hw4.util.Loop;

public class TimerClass {

    private final Loop loop;
    private int time;

    public TimerClass(int time) {
        this.loop = new Loop(1, this::updateTime);
        this.time = time;
    }

    public void start() {
        loop.start();
    }

    public void stop() {
        time = 0;
        loop.stop();
    }

    private void updateTime() {
        time--;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}