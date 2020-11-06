package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gripper extends SubsystemBase {
    private VictorSP right;
    private VictorSP left;
    private DigitalInput limit;
    private static final double inSpeed = 0.5;
    private static final double outSpeed = -0.5;

    public Gripper(VictorSP right, VictorSP left, DigitalInput limit) {
        this.right = right;
        this.left = left;
        this.limit = limit;
        left.setInverted(true);
    }

    public void release() {
        if (limit.get()) {
            right.set(outSpeed);
            left.set(outSpeed);
        }
    }

    public void grip() {
        if (!limit.get()) {
            right.set(inSpeed);
            left.set(inSpeed);
        }
    }

    public void stop() {
        right.stopMotor();
        left.stopMotor();
    }

}
