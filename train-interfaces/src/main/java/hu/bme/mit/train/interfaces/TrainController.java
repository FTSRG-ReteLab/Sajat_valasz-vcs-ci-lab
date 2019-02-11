package hu.bme.mit.train.interfaces;

import com.google.common.collect.Table;

public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();

	public Table<Long, Integer, Integer> getTachograph();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

}
