package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import kotlinx.coroutines.CoroutineScope
import nl.beargineers.platform.drive.Waypoint
import nl.beargineers.platform.ftc.CoroutineOpMode
import nl.beargineers.platform.geometry.Pose
import nl.beargineers.platform.runtime.everyTick
import nl.beargineers.platform.units.cm
import nl.beargineers.platform.units.degrees

/**
 * An autonomous that drives a square and comes back. The robot starts at pose zero: x grows forward from there and y
 * to its left, and heading zero is the way it faces. Robot code reads top to bottom, each line waiting for the one
 * before it to finish.
 */
@Autonomous(name = "Auto")
class Auto : CoroutineOpMode() {
    private val robot by robot(::MyRobot)

    override suspend fun CoroutineScope.onInit() {
        everyTick { show("Put the robot down facing away from you, then START") }
    }

    override suspend fun CoroutineScope.onStart() {
        val localizer = robot.localizer
        val follower = robot.follower
        localizer.pose = Pose.ZERO
        // Shows the pose every loop while the robot drives
        everyTick { show("Pose") { localizer.pose } }

        follower.driveTo(Pose(60.cm, 0.cm, 0.degrees))       // 60 cm forward
        follower.driveTo(Pose(60.cm, 60.cm, 90.degrees))     // 60 cm to the left, turning a quarter turn on the way
        follower.drivePath(                                  // back to the start through a corner, without stopping there
            Waypoint(Pose(0.cm, 60.cm, 0.degrees)),
            Waypoint(Pose.ZERO),
        )
    }
}
