package org.firstinspires.ftc.teamcode

import nl.beargineers.platform.component.Robot
import nl.beargineers.platform.component.RobotHost
import nl.beargineers.platform.drive.PathFollower
import nl.beargineers.platform.ftc.MecanumDrive
import nl.beargineers.platform.ftc.PinpointLocalizer

/**
 * The robot: the parts it is made of. Each part is a component with its settings in config.properties, under the
 * part's name: `drive.maxPower`, `localizer.forwardPodLeft`, `follower.tolerance`.
 *
 * In the robot configuration on the Driver Station: motors leftFront, rightFront, leftBack and rightBack, and a goBILDA
 * Pinpoint named pinpoint.
 */
class MyRobot(host: RobotHost) : Robot(host) {
    // Where the robot is: created first, so it updates before anything drives by it
    val localizer = PinpointLocalizer(this)
    val drive = MecanumDrive(this)
    val follower = PathFollower(this, drive, localizer)

    // Parts of your own go here, like the example claw: add a servo named claw to the robot configuration first
    // val claw = Claw(this)
}
