// Student: Amina Nazarova L1
// Student id: 54831
// SET 2

package com.example.mobilesystem;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lamp lamp = new Lamp();

        // Test 1 turn on/off
        lamp.turnOn();
        Log.d("TEST", "Turn ON: " + (lamp.isOn() ? "PASS" : "FAIL"));

        lamp.turnOff();
        Log.d("TEST", "Turn OFF: " + (!lamp.isOn() ? "PASS" : "FAIL"));

        // Test 2 brighten to 10
        lamp.turnOn();
        for (int i = 0; i < 9; i++) {
            lamp.brighten();
        }
        Log.d("TEST", "Intensity 10: " + (lamp.getIntensity() == 10 ? "PASS" : "FAIL"));

        // Test 3 burn bulb
        lamp.brighten();
        Log.d("TEST", "Bulb burned: " + (lamp.isBulbBurned() ? "PASS" : "FAIL"));

        // Test 4 burned bulb cannot shine
        lamp.turnOff();
        lamp.turnOn();
        Log.d("TEST", "Burned bulb no light: " + (!lamp.isShining() ? "PASS" : "FAIL"));

        // Test 5 replace bulb when OFF
        boolean replaced = lamp.replaceBulb();
        Log.d("TEST", "Replace bulb OFF: " + (replaced ? "PASS" : "FAIL"));

        // Test 6 replace bulb when ON
        lamp.turnOn();
        boolean failReplace = lamp.replaceBulb();
        Log.d("TEST", "Replace bulb ON: " + (!failReplace ? "PASS" : "FAIL"));


    }
}