package com.example.larsonsadienov12.heartbeat;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import com.wahoofitness.connector.HardwareConnector;
import com.wahoofitness.connector.HardwareConnectorEnums;
import com.wahoofitness.connector.HardwareConnectorTypes;
import com.wahoofitness.connector.HardwareConnectorTypes.SensorType;
import com.wahoofitness.connector.capabilities.Capability;
import com.wahoofitness.connector.conn.connections.SensorConnection;
import com.wahoofitness.connector.conn.connections.params.ConnectionParams;
import com.wahoofitness.connector.listeners.discovery.DiscoveryListener;

import java.util.Collection;

public class MainService extends Service {

    private HardwareConnector mHardwareConnector;

    private final HardwareConnector.Callback mHardwareConnectorCallback= new HardwareConnector.Callback() {
        @Override
        public void connectorStateChanged(HardwareConnectorTypes.NetworkType networkType, HardwareConnectorEnums.HardwareConnectorState hardwareConnectorState) {

        }

        @Override
        public void connectedSensor(SensorConnection sensorConnection) {

        }

        @Override
        public void disconnectedSensor(SensorConnection sensorConnection) {

        }

        @Override
        public void hasData() {

        }

        @Override
        public void onFirmwareUpdateRequired(SensorConnection sensorConnection, String s, String s1) {

        }
    };

    public void onCreate() {
        super.onCreate();
        DiscoveryListener me = new DiscoveryListener() {
            @Override
            public void onDeviceDiscovered(ConnectionParams connectionParams) {

            }

            @Override
            public void onDiscoveredDeviceLost(ConnectionParams connectionParams) {

            }

            @Override
            public void onDiscoveredDeviceRssiChanged(ConnectionParams connectionParams, int i) {

            }
        };
        mHardwareConnector = new HardwareConnector(this, mHardwareConnectorCallback);
        mHardwareConnector.startDiscovery(SensorType.HEARTRATE,
                HardwareConnectorTypes.NetworkType.BTLE,
                me);

        ConnectionParams heartRateParams = new ConnectionParams(HardwareConnectorTypes.NetworkType.BTLE,SensorType.HEARTRATE ) {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public Bundle bundleState() {
                return null;
            }

            @Override
            public String serialize() {
                return null;
            }

            @Override
            public int getRssi() {
                return 0;
            }

            @Override
            public Collection<Capability.CapabilityType> getCapabilities() {
                return null;
            }

            @Override
            public String getManufacturer() {
                return null;
            }
        };

        mHardwareConnector.requestSensorConnection(heartRateParams,mSensorConnectionListener);

       mHardwareConnector.stopDiscovery(HardwareConnectorTypes.NetworkType.BTLE);
    }
    public MainService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    public void onDestroy(){
        super.onDestroy();
        mHardwareConnector.shutdown();
    }

    private final SensorConnection.Listener mSensorConnectionListener = new SensorConnection.Listener() {
        @Override
        public void onSensorConnectionStateChanged(SensorConnection sensorConnection, HardwareConnectorEnums.SensorConnectionState sensorConnectionState) {
        }

        @Override
        public void onSensorConnectionError(SensorConnection sensorConnection, HardwareConnectorEnums.SensorConnectionError sensorConnectionError) {

        }

        @Override
        public void onNewCapabilityDetected(SensorConnection sensorConnection, Capability.CapabilityType capabilityType) {
           /* if(capabilityType== Capability.CapabilityType.Heartrate){
                Heartrate heartrate=(Heartrate)sensorConnection.getCurrentCapability(Capability.CapabilityType.Heartrate);
                heartrate.addListener(new Heartrate.Listener mHeartRateListener);
            }*/
        }
    };



}
