// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.lumynlabs.domain.led.Animation;

import edu.wpi.first.units.Units;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.Color8Bit;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.lumynlabs.connection.usb.USBPort;
import com.lumynlabs.devices.ConnectorXAnimate;

public class LumynLED extends SubsystemBase 
{
  private final ConnectorXAnimate cx = new ConnectorXAnimate();
  // Member field. Connect this instance during robot initialization.

  /** Creates a new LumynLED. */
  public LumynLED() 
  {
    cx.Connect(USBPort.kUSB1);
  }

  @Override
  public void periodic() 
  {
    cx.leds.SetAnimation(Animation.SineRoll)
      .ForZone("train-strip")
      .WithColor(new Color(new Color8Bit(255, 61, 236)))
      .WithDelay(Units.Milliseconds.of(40))
      .Reverse(false)
      .RunOnce(false);
    // This method will be called once per scheduler run
  }
}
