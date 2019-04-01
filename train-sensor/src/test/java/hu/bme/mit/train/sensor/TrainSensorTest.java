package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.interfaces.*;
import hu.bme.mit.train.sensor.TrainSensorImpl;

public class TrainSensorTest {

    TrainController mockC;
    TrainUser mockU;
    TrainSensor sensor;

    @Before
    public void before() {
        mockC = mock(TrainController.class);
        mockU = mock(TrainUser.class);
        sensor = new TrainSensorImpl(mockC, mockU);
        
        when(mockC.getReferenceSpeed()).thenReturn(120);
    }

    @Test
    public void overrideSpeedLimit_underAbsoluteMargin_setAlarmStateTrue() {
        sensor.overrideSpeedLimit(-5);
         
        verify(mockU, times(1)).setAlarmState(true);
    }
    
    @Test
    public void overrideSpeedLimit_overAbsoluteMargin_setAlarmStateTrue() {
        sensor.overrideSpeedLimit(562);
         
        verify(mockU, times(1)).setAlarmState(true);
    }
    
    @Test
    public void overrideSpeedLimit_relativeMargin_setAlarmStateTrue() {
        sensor.overrideSpeedLimit(42);
         
        verify(mockU, times(1)).setAlarmState(true);
    }
    
    @Test
    public void overrideSpeedLimit_backToDefaultAlarmState_speedLimitBetweenMargins() {
        sensor.overrideSpeedLimit(573);
        
        verify(mockU, times(1)).setAlarmState(true);
        
        sensor.overrideSpeedLimit(120);
         
        verify(mockU, times(1)).setAlarmState(false);
    }
}
