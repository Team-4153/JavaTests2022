// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.IntakeCommand;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

 

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final XboxController m_xbox = new XboxController(0);
  private final JoystickButton Xbox1_A = new JoystickButton(m_xbox, XboxController.Button.kA.value);
  private final JoystickButton Xbox1_X = new JoystickButton(m_xbox, XboxController.Button.kX.value);
//extra comment
  // The robot's subsystems and commands are defined here...
  private final IntakeSubsystem m_IntakeSubsystem = new IntakeSubsystem();

    private final IntakeCommand m_autoCommand = new IntakeCommand(m_IntakeSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Define Robot boot state
    initRobot();
        // Configure the button bindings
    configureButtonBindings();

  }

private void initRobot()
{
  m_IntakeSubsystem.Sol_init();
  m_IntakeSubsystem.Motor_init();
}

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

  Xbox1_A.whenPressed(() ->  m_IntakeSubsystem.Sol_toggle());
  Xbox1_X.whileHeld(() ->  m_IntakeSubsystem.Motor_Start());
  Xbox1_X.whenReleased(() ->  m_IntakeSubsystem.Motor_Stop());
  //Xbox1_B.whenPressed(() ->  m_IntakeSubsystem.Sol_reverse());
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An IntakeCommand will run in autonomous
    return m_autoCommand;
  }
}
