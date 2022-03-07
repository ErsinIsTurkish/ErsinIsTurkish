// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivesubsystem;

public class DriveWithJoystick extends CommandBase {
  /** Creates a new Drive. */

  private Drivesubsystem driver;
  private Joystick joy;

  public DriveWithJoystick(Drivesubsystem driver, Joystick joy) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driver = driver;
    this.joy = joy;
    addRequirements(driver);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {
    double x = MathUtil.applyDeadband(joy.getX(), 0.1);
    double y = MathUtil.applyDeadband(joy.getY(), 0.1);
    double z = MathUtil.applyDeadband(joy.getZ(), 0.1);

    driver.motorDrive(x, y, z / 2);
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
