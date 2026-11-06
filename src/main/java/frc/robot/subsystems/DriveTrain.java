// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.ctre.phoenix6.controls.SolidColor;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
private SparkMax leftLeader =new SparkMax(14,MotorType.kBrushless);
private SparkMax leftFollower =new SparkMax(15,MotorType.kBrushless);
private SparkMax rightLeader =new SparkMax(16,MotorType.kBrushless);
private SparkMax rightFollower =new SparkMax(17,MotorType.kBrushless);


/** Creates a new DriveTrain. */
 public DriveTrain() {
 // rightFront.set
SparkMaxConfig globalConfig = new SparkMaxConfig();
SparkMaxConfig rightLeaderConfig = new SparkMaxConfig();
SparkMaxConfig leftFollowerConfig = new SparkMaxConfig();
SparkMaxConfig rightFollowerConfig = new SparkMaxConfig();

 globalConfig
        .smartCurrentLimit(50)
        .idleMode(IdleMode.kBrake);

    // Apply the global config and invert since it is on the opposite side
    rightLeaderConfig
        .apply(globalConfig)
        .inverted(true);

    // Apply the global config and set the leader SPARK for follower mode
    leftFollowerConfig
        .apply(globalConfig)
        .follow(leftLeader);

    // Apply the global config and set the leader SPARK for follower mode
    rightFollowerConfig
        .apply(globalConfig)
        .follow(rightLeader);
//globalConfig.smartCurrentLimit(50)
 leftLeader.configure(globalConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    leftFollower.configure(leftFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    rightLeader.configure(rightLeaderConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    rightFollower.configure(rightFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

public void driveCommand(double speed, double rotation){
  leftLeader.set(speed + rotation);
  rightLeader.set(speed - rotation);
} 
  //public Command driveCommand(double speed, double rotation){
//return new InstantCommand(( )-> {leftBack.setControl(new SolidColor(0, 3).withColor(kGreen));
//m_candle.setControl(new SolidColor(4, 7).withColor(kMustard));});
//}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
