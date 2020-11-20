package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevators;

import java.util.function.Supplier;

public class MoveElevators extends CommandBase {
    private Elevators elevators;
    private Supplier<Double> speed;
    private Supplier<Double> KP;
    private Supplier<Double> KI;
    private Supplier<Double> KD;
    private PIDController pidController;
    private Supplier<Double> source;
    private Supplier<Double> setpoint;
    private Supplier<Double> tolerance;
    private int countBall;

    public MoveElevators(Elevators elevators, Supplier<Double> speed, Supplier<Double> KP, Supplier<Double> KI, Supplier<Double> KD, PIDController pidController,
                         Supplier<Double> source, Supplier<Double> setpoint, Supplier<Double> tolerance) {
        this.elevators = elevators;
        this.speed = speed;
        this.KP = KP;
        this.KI = KI;
        this.KD = KD;
        this.pidController = pidController;
        this.setpoint = setpoint;
        this.source = source;
        this.tolerance = tolerance;
        addRequirements();
    }

    @Override
    public void execute() {
        pidController.setPID(KP.get(), KI.get(), KD.get());
        pidController.setTolerance(tolerance.get());
        elevators.move(pidController.calculate(source.get(), setpoint.get()));
        countBall++;
    }

    @Override
    public boolean isFinished() {
        if (countBall >= 3) {
            return true;
        }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        elevators.stop();
    }
}