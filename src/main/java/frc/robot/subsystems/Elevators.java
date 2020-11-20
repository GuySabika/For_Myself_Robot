package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

public class Elevators extends SubsystemBase {
    private Talon talon;
    private WPI_VictorSPX victorSPX1;
    private WPI_VictorSPX victorSPX2;
    private DigitalInput limitUp;
    private DigitalInput limitMiddle;
    private DigitalInput limitDown;

    public Elevators(Talon talon, WPI_VictorSPX victorSPX1, WPI_VictorSPX victorSPX2,DigitalInput limitUp, DigitalInput limitMiddle, DigitalInput limitDown) {
        this.talon = talon;
        this.victorSPX1 = victorSPX1;
        this.victorSPX2 = victorSPX2;
        this.limitUp = limitUp;
        this.limitMiddle = limitMiddle;
        this.limitDown = limitDown;
    }

    public void move(double speed) {
        talon.set(speed);
        victorSPX1.set(speed);
        victorSPX2.set(speed);
    }

    public void stop() {
        talon.stopMotor();
        victorSPX1.stopMotor();
        victorSPX2.stopMotor();
    }
}
