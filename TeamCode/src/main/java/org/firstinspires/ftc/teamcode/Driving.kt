package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import kotlinx.coroutines.CoroutineScope
import nl.beargineers.platform.ftc.CoroutineOpMode
import nl.beargineers.platform.runtime.everyTick
import nl.beargineers.platform.units.Heading

/** The drivers' opmode */
@TeleOp(name = "Driving")
class Driving : CoroutineOpMode() {
    private val robot by robot(::MyRobot)

    override suspend fun CoroutineScope.onStart() {
        val drive = robot.drive
        val localizer = robot.localizer

        // Field-centric driving: pushing the stick forward drives away from the drivers, whichever way the robot faces.
        // Heading zero is the way the robot faced when Auto started; Y changes it to the way the robot faces now.
        var driversFace = Heading.ZERO
        var fieldCentric = true
        controller1.y.onPress { driversFace = localizer.pose.heading }
        controller1.b.onPress { fieldCentric = !fieldCentric }

        // Turns each wheel in turn, to check that they go forward and are plugged into the right ports
        controller1.back.onPress { drive.checkWheels() }

        // Buttons for parts of your own, like the example claw:
        // controller1.rightBumper.onPress { robot.claw.toggle() }

        everyTick {
            if (fieldCentric) {
                drive.driveWith(controller1.leftStick, controller1.rightStick.x, localizer.pose.heading, driversFace)
            } else {
                drive.driveWith(controller1.leftStick, controller1.rightStick.x)
            }

            show("Y: the robot faces away from you now. B: field-centric on/off. Back: check wheels")
            show("Driving", if (fieldCentric) "field-centric" else "robot-centric")
            show("Pose") { localizer.pose }
        }
    }
}
