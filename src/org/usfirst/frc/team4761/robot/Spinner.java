package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Spinner {
	private Talon spinner1;
	private Talon spinner2;
	
	private boolean spinning = false;
	private double defaultSpeed = 0.5;

	public Spinner(int port1, int port2) {
				spinner1 = new Talon(port1);
				spinner2 = new Talon(port2);
			}

		public void spin(double speed) {
			if(speed < 0 || speed > 1) {
				throw new IllegalArgumentException("Invalid speed for spinner (must be 0..1)");
		}
		spinner1.set(-SmartDashboard.getNumber("Speed"));
		spinner2.set(-SmartDashboard.getNumber("Speed"));
	}
	
	public void stop() {
		spinner1.set(0);
		spinner2.set(0);
	}
	
	public void toggleSpinning() {
		if (spinning) {
			stop();
		} else {
			spin(defaultSpeed);
		}
		spinning = !spinning;
	}
	
	public void emergencyStop() {
		spinner1.stopMotor();
		spinner2.stopMotor();
	}
}
