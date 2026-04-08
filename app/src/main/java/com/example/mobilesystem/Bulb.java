package com.example.mobilesystem;

public class Bulb {
    private boolean isOn;
    private boolean isBurned;

    public void turnOn() {
        if (!isBurned) {
            isOn = true;
        }
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public boolean isBurned() {
        return isBurned;
    }

    public void burn() {
        isBurned = true;
        isOn = false;
    }
}