package com.example.mobilesystem;

public class Lamp {
    private boolean isOn;
    private int intensity;
    private Bulb bulb;

    public Lamp() {
        bulb = new Bulb();
        intensity = 0;
        isOn = false;
    }

    public void turnOn() {
        if (!bulb.isBurned()) {
            isOn = true;
            if (intensity == 0) {
                intensity = 1;
            }
            bulb.turnOn();
        }
    }

    public void turnOff() {
        isOn = false;
        intensity = 0;
        bulb.turnOff();
    }

    public void brighten() {
        if (!isOn) return;

        intensity++;

        if (intensity > 10) {
            bulb.burn();
            turnOff();
        }
    }

    public void dim() {
        if (!isOn) return;

        intensity--;

        if (intensity <= 0) {
            turnOff();
        }
    }

    public boolean replaceBulb() {
        if (isOn) return false;

        bulb = new Bulb();
        return true;
    }

    public boolean isOn() {
        return isOn;
    }

    public boolean isShining() {
        return isOn && intensity > 0 && bulb.isOn();
    }

    public boolean isBulbBurned() {
        return bulb.isBurned();
    }

    public int getIntensity() {
        return intensity;
    }
}