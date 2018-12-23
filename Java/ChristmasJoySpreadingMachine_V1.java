let rotationStep = 0
let maxLimit = 0
let lightIntentisty = 0
let angleB = 0
let directionB = 0
let angleA = 0
let directionA = 0
input.onButtonPressed(Button.A, function () {
    Kitronik_Robotics_Board.servoWrite(Kitronik_Robotics_Board.Servos.Servo1, 98)
})
Kitronik_Robotics_Board.allOff()
directionA = 1
directionB = -1
lightIntentisty = 80
maxLimit = 60
angleA = 0
angleB = maxLimit
rotationStep = 1
Kitronik_Robotics_Board.motorOn(Kitronik_Robotics_Board.Motors.Motor1, Kitronik_Robotics_Board.MotorDirection.Reverse, lightIntentisty)
Kitronik_Robotics_Board.motorOn(Kitronik_Robotics_Board.Motors.Motor2, Kitronik_Robotics_Board.MotorDirection.Forward, lightIntentisty)
basic.forever(function () {
    Kitronik_Robotics_Board.servoWrite(Kitronik_Robotics_Board.Servos.Servo2, angleA)
    Kitronik_Robotics_Board.servoWrite(Kitronik_Robotics_Board.Servos.Servo3, angleB)
    Kitronik_Robotics_Board.servoWrite(Kitronik_Robotics_Board.Servos.Servo4, angleA)
    Kitronik_Robotics_Board.servoWrite(Kitronik_Robotics_Board.Servos.Servo5, angleB)
    angleA = angleA + directionA
    angleB = angleB + directionB
    if (angleA > maxLimit) {
        directionA = -1
    } else {
        if (angleA < 0) {
            directionA = 1
        }
    }
    if (angleB > maxLimit) {
        directionB = -1
    } else {
        if (angleB < 0) {
            directionB = 1
        }
    }
})

