package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private WPI_TalonSRX right;
    private WPI_TalonSRX left;

    public Drivetrain(WPI_TalonSRX right, WPI_TalonSRX left, WPI_VictorSPX leftVictor, WPI_VictorSPX rightVictor) {
        this.right = right;
        this.left = left;
        rightVictor.follow(right);
        leftVictor.follow(left);
        left.setInverted(true);
    }

    public void move(double rightSpeed, double leftSpeed) {
        right.set(rightSpeed);
        left.set(leftSpeed);
    }

    public void stop() {
        right.stopMotor();
        left.stopMotor();
    }
}
