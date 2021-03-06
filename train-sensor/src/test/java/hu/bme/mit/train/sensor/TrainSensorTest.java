package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.sensor.TrainSensorImpl;

public class TrainSensorTest {

    TrainSensor sensor;

    @Before
    public void before() {
        sensor = new TrainSensorImpl(null, null);
    }

    @Test
    public void SpeedLimitOverriding() {
        Assert.assertEquals(10, sensor.getSpeedLimit());
    }
}
