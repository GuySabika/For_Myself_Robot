package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

import java.util.function.Supplier;

public class MoveDrivetrain extends CommandBase {
    private Drivetrain drivetrain;
    private Supplier<Double> speedLeft, speedRight;

    public MoveDrivetrain(Drivetrain drivetrain, Supplier<Double> speedLeft, Supplier<Double> speedRight) {
        this.drivetrain = drivetrain;
        this.speedLeft = speedLeft;
        this.speedRight = speedRight;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.move(speedRight.get(), speedLeft.get());
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
