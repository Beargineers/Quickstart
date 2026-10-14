package org.firstinspires.ftc.teamcode

import kotlinx.coroutines.delay
import nl.beargineers.platform.component.Component
import nl.beargineers.platform.config.config
import nl.beargineers.platform.ftc.PositionServo
import kotlin.time.Duration.Companion.milliseconds

/**
 * An example part of the robot: a claw on a servo named claw in the robot configuration. To try it, add
 * `val claw = Claw(this)` to [MyRobot] and give it a button in [Driving].
 *
 * Its settings are `claw.openPosition`, `claw.closedPosition`, `claw.closeTime` and the servo's `claw.servo.direction`:
 * find the positions live on the settings page instead of rebuilding the app for each try.
 */
class Claw(parent: Component) : Component(parent) {
    val servo = PositionServo(this, "servo", device = "claw")

    val openPosition by config(0.6)
    val closedPosition by config(0.3)

    /** How long the servo takes to close */
    val closeTime by config(300.milliseconds)

    var isOpen = false
        private set

    fun open() {
        servo.position = openPosition
        isOpen = true
    }

    fun close() {
        servo.position = closedPosition
        isOpen = false
    }

    fun toggle() = if (isOpen) close() else open()

    /** Closes, and returns once the claw holds what it closed on: an autonomous can drive on right after */
    suspend fun grab() {
        close()
        delay(closeTime)
    }
}
