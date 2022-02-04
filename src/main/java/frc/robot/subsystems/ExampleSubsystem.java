// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;



public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {}

  public final Compressor phCompressor = new Compressor(1, PneumaticsModuleType.REVPH);
  DoubleSolenoid exampleSolenoidPH = new DoubleSolenoid(1, PneumaticsModuleType.REVPH, 1, 2);
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void Sol_forward () {
    exampleSolenoidPH.set(DoubleSolenoid.Value.kForward);
  }

  public void Sol_reverse () {
    exampleSolenoidPH.set(DoubleSolenoid.Value.kReverse);
  }

}
