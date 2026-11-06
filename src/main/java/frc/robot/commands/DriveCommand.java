// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveCommand extends Command {
  private DoubleSupplier speedFunction;
  private DoubleSupplier rotationFunction;
  private DriveTrain driveTrain;

  /** Creates a new DriveCommand. */
  public DriveCommand(DoubleSupplier speed, DoubleSupplier rotation, DriveTrain driveTrain) {
    this.rotationFunction = rotation;
    this.speedFunction = speed;
    this.driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.\
  addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = speedFunction.getAsDouble();
    double rotation = rotationFunction.getAsDouble();
    driveTrain.driveCommand(speed, rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
