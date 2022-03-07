// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivesubsystem extends SubsystemBase {
  /** Creates a new Drivesubsystem. */

  private CANSparkMax upLeftMotor;
  private CANSparkMax upRightMotor;
  private CANSparkMax downLeftMotor;
  private CANSparkMax downRightMotor;

  private MecanumDrive mecanum;

  public Drivesubsystem()
  {
    upLeftMotor = new CANSparkMax(4, MotorType.kBrushless);
    upRightMotor = new CANSparkMax(2, MotorType.kBrushless);
    downLeftMotor = new CANSparkMax(3,MotorType.kBrushless);
    downRightMotor = new CANSparkMax(1, MotorType.kBrushless);

    downLeftMotor.setInverted(false);
    upRightMotor.setInverted(true);
    downRightMotor.setInverted(true);
    upLeftMotor.setInverted(false);

    mecanum = new MecanumDrive(upLeftMotor, downLeftMotor, upRightMotor, downRightMotor);
  }

public void motorDrive(double x, double y, double z)
{
  mecanum.driveCartesian(y, x, z);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    mecanum.feed();
  }
}
