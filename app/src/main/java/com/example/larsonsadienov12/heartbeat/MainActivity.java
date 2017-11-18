package com.example.larsonsadienov12.heartbeat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView heartRateTextView;
    private int progressPercentage = 0;
    private ProgressBar Sprogress;
    private Handler mhandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                // use this to start and trigger a service
                Intent mHardwareConnector = new Intent(this, MainService.class);
                // potentially add data to the intent
                mHardwareConnector.putExtra("com.example.larsonsadienov12.heartbeat", "Value to be used by the service");
                startService(mHardwareConnector);

                TextView tv = (TextView) findViewById(R.id.BPMTextView);
                String text = getIntent().getExtras().getString("com.example.larsonsadienov12.quickapplauncher");
                tv.setText(text);

    }

   /*Heartrate.Data getHeartrateData() {
        if(mSensorConnection!=null){
            Heartrate heartrate=(Heartrate)mSensorConnection.getCurrentCapability(Capability.CapabilityType.Heartrate);
            if(heartrate!=null){
                return heartrate.getHeartrateData();
            }else{
//Thesensorconnectiondoesnotcurrentlysupporttheheartratecapability
                return null;
            }
        }else{
//Sensornotconnected
            return null;
        }
    }
*/

}

