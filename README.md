# BearPlatform Quickstart

Start an FTC robot project on [BearPlatform](https://github.com/Beargineers/BearPlatform): robot code in Kotlin, built
from small parts, with real units and settings you change on the robot without rebuilding.

This is FIRST's [FtcRobotController](https://github.com/FIRST-Tech-Challenge/FtcRobotController), SDK 12.0 for the
BIOBUZZ (2026–2027) season, with two changes:

- `TeamCode` is in Kotlin, on BearPlatform: a robot with a mecanum drive and goBILDA Pinpoint odometry, a TeleOp, an
  autonomous and the robot's settings.
- FIRST's Java samples are gone. They don't use BearPlatform, so they would only be in the way. For devices
  BearPlatform doesn't cover yet, they are still on [FIRST's GitHub](https://github.com/FIRST-Tech-Challenge/FtcRobotController/tree/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples).

You need Android Studio Narwhal 3 Feature Drop or later.

## Getting started

1. **Fork** this repository on GitHub, then clone your fork. A fork keeps the way to updates open (see below).
2. Open the project folder in Android Studio and let it sync.
3. In the robot configuration on the Driver Station, name the drive motors `leftFront`, `rightFront`, `leftBack` and
   `rightBack`, and the Pinpoint `pinpoint`.
4. Measure where your odometry pods are, and set `localizer.forwardPodLeft` and `localizer.strafePodForward` in
   [config.properties](TeamCode/src/main/res/raw/config.properties).
5. Connect to the robot and run **TeamCode** in Android Studio, which installs the app.
6. On the Driver Station, start **Driving**:
   - With the robot on a box, wheels off the ground, press **Back**: each wheel turns for a second and should turn
     so it would push the robot forward. The left motors start reversed (`R`), the right ones forward (`F`): flip one
     that turns backward, like `drive.leftFront.direction = F`. A different wheel turning than the Driver Station
     names means a motor is plugged into another port than configured.
   - Push the robot by hand and watch **Pose**: x should grow when it moves forward, y when it moves to its left.
   - Drive! The left stick moves, the right stick turns.
7. Put the robot on the floor with some room, facing away from you, and start **Auto**: it drives a 60 cm square.

## What's where

| In `TeamCode/src/main`                                   | What                                                    |
|----------------------------------------------------------|---------------------------------------------------------|
| [MyRobot.kt](TeamCode/src/main/java/org/firstinspires/ftc/teamcode/MyRobot.kt) | The robot: the parts it is made of |
| [Driving.kt](TeamCode/src/main/java/org/firstinspires/ftc/teamcode/Driving.kt) | The TeleOp                         |
| [Auto.kt](TeamCode/src/main/java/org/firstinspires/ftc/teamcode/Auto.kt)       | An autonomous                      |
| [Claw.kt](TeamCode/src/main/java/org/firstinspires/ftc/teamcode/Claw.kt)       | An example part to start your own from; not on the robot until you add it |
| [res/raw/config.properties](TeamCode/src/main/res/raw/config.properties)       | The robot's settings               |

[BearPlatform's README](https://github.com/Beargineers/BearPlatform#readme) explains the rest: parts and their
settings, gamepad buttons, motors, servos and sensors, driving to poses, and robot code as plain step-by-step
functions.

## On the robot

With the laptop on the robot's WiFi:

- http://192.168.43.1:8080/bear/config shows every setting, with its default, and changes them live: no rebuilding,
  and they apply right away, even while an opmode runs. They stay until the next install, so download the edited
  file there and copy it into the project to keep them.
- http://192.168.43.1:8080/bear/graphs draws live graphs of what the robot records, like the follower's errors
  while Auto drives, and shows the Driver Station's lines.

## Updates

- **BearPlatform**: change the version in [TeamCode/build.gradle](TeamCode/build.gradle). Its release notes say
  what changed and how to update your code.
- **The FTC SDK, and this project**: when FIRST releases a new SDK, it comes here too. Pull it into your fork:

  ```
  git pull https://github.com/Beargineers/Quickstart.git master
  ```

## Working on BearPlatform itself

With BearPlatform cloned next to this project, build against your checkout instead of the released version:

```
./gradlew --include-build ../BearPlatform :TeamCode:assembleDebug
```

or, for Android Studio too, add `includeBuild('../BearPlatform')` to `settings.gradle`.

## License

FIRST's SDK code is under FIRST's [license](LICENSE). BearPlatform and the starter code in `TeamCode` are
[MIT licensed](https://github.com/Beargineers/BearPlatform/blob/master/LICENSE): use them, change them, share them.
