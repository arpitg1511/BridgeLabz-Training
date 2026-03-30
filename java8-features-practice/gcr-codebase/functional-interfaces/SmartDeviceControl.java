/*
 *
 *  * Interface defining common device operations
 *
 *   */

interface SmartDevice {

	void turnOn();

	void turnOff();

}

/*
 *
 * * Light device implementation
 *
 */

class Light implements SmartDevice {

	public void turnOn() {

		System.out.println("Light is turned ON");

	}

	public void turnOff() {

		System.out.println("Light is turned OFF");

	}

}

/*
 *
 * * AC device implementation
 *
 */

class AC implements SmartDevice {

	public void turnOn() {

		System.out.println("AC is turned ON");

	}

	public void turnOff() {

		System.out.println("AC is turned OFF");

	}

}

/*
 *
 * * TV device implementation
 *
 */

class TV implements SmartDevice {

	public void turnOn() {

		System.out.println("TV is turned ON");

	}

	public void turnOff() {

		System.out.println("TV is turned OFF");

	}

}

/*
 *
 * * Main class
 *
 */

public class SmartDeviceControl {

	public static void main(String[] args) {

		SmartDevice light = new Light();

		SmartDevice ac = new AC();

		SmartDevice tv = new TV();

		light.turnOn();

		light.turnOff();

		ac.turnOn();

		ac.turnOff();

		tv.turnOn();

		tv.turnOff();

	}

}
