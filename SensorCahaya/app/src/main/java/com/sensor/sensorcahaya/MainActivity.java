package com.sensor.sensorcahaya;

import java.util.List;

import android.app.Activity;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity implements SensorEventListener{

    private SensorManager sMgr;
    private TextView teks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teks = (TextView) findViewById(R.id.textView2);
        TextView sensorsData = (TextView) findViewById(R.id.textView1);

        sMgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        if (sMgr.getDefaultSensor(Sensor.TYPE_LIGHT) != null){

            sensorsData.setText("asdas");
            sensorsData.setText("Bisa Masuk lho");
        }
        else {
            sensorsData.setText("Tidak ada");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float tes = event.values[0];
        teks.setText("Berubah");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
