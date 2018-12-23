let rotationStep = 0
let micPower = 0
let maxColors = 0
let maxLimit = 0
let numPix = 0
let directionB = 0
let directionA = 0
let pixColor = 0
let pixelIndex = 0
let strip: neopixel.Strip = null
let analogValue = 0
function setLightIntensity() {
    analogValue = pins.analogReadPin(AnalogPin.P2)
    lightIntentisty = Math.map(analogValue, 0, 1023, 50, 100)
    Kitronik_Robotics_Board.motorOn(Kitronik_Robotics_Board.Motors.Motor1, Kitronik_Robotics_Board.MotorDirection.Reverse, lightIntentisty)
    Kitronik_Robotics_Board.motorOn(Kitronik_Robotics_Board.Motors.Motor2, Kitronik_Robotics_Board.MotorDirection.Forward, lightIntentisty)
    Kitronik_Robotics_Board.motorOn(Kitronik_Robotics_Board.Motors.Motor3, Kitronik_Robotics_Board.MotorDirection.Reverse, lightIntentisty)
}
function updateServos2() {
    Kitronik_Robotics_Board.servoWrite(Kitronik_Robotics_Board.Servos.Servo2, angleA)
Kitronik_Robotics_Board.servoWrite(Kitronik_Robotics_Board.Servos.Servo3, angleB)
Kitronik_Robotics_Board.servoWrite(Kitronik_Robotics_Board.Servos.Servo4, angleA)
Kitronik_Robotics_Board.servoWrite(Kitronik_Robotics_Board.Servos.Servo5, angleB)
}
function setPixColor2() {
    if (pixColor == 0) {
        strip.setPixelColor(pixelIndex, neopixel.colors(NeoPixelColors.Red))
    }
    if (pixColor == 1) {
        strip.setPixelColor(pixelIndex, neopixel.colors(NeoPixelColors.Orange))
    }
    if (pixColor == 2) {
        strip.setPixelColor(pixelIndex, neopixel.colors(NeoPixelColors.Yellow))
    }
    if (pixColor == 3) {
        strip.setPixelColor(pixelIndex, neopixel.colors(NeoPixelColors.Green))
    }
    if (pixColor == 4) {
        strip.setPixelColor(pixelIndex, neopixel.colors(NeoPixelColors.Blue))
    }
    if (pixColor == 5) {
        strip.setPixelColor(pixelIndex, neopixel.colors(NeoPixelColors.Indigo))
    }
    if (pixColor == 6) {
        strip.setPixelColor(pixelIndex, neopixel.colors(NeoPixelColors.Violet))
    }
    if (pixColor == 7) {
        strip.setPixelColor(pixelIndex, neopixel.colors(NeoPixelColors.Purple))
    }
    if (pixColor == 8) {
        strip.setPixelColor(pixelIndex, neopixel.colors(NeoPixelColors.White))
    }
}
function updatePix2() {
    strip.show()
    pixelIndex = pixelIndex + 1
    if (pixelIndex == numPix) {
        pixelIndex = 0
        pixColor = pixColor + 1
        if (pixColor == maxColors) {
            pixColor = 0
        }
    }
}
function updateAngles2() {
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
}
let angleA = 0
let angleB = 0
let lightIntentisty = 0
pixColor = 0
pixelIndex = 0
numPix = 12
maxColors = 9
strip = neopixel.create(DigitalPin.P16, numPix, NeoPixelMode.RGB_RGB)
strip.setBrightness(255)
Kitronik_Robotics_Board.allOff()
directionA = 1
directionB = -1
lightIntentisty = 80
micPower = 50
maxLimit = 60
angleA = 0
angleB = maxLimit
rotationStep = 1
Kitronik_Robotics_Board.motorOn(Kitronik_Robotics_Board.Motors.Motor1, Kitronik_Robotics_Board.MotorDirection.Reverse, lightIntentisty)
Kitronik_Robotics_Board.motorOn(Kitronik_Robotics_Board.Motors.Motor2, Kitronik_Robotics_Board.MotorDirection.Forward, lightIntentisty)
Kitronik_Robotics_Board.motorOn(Kitronik_Robotics_Board.Motors.Motor3, Kitronik_Robotics_Board.MotorDirection.Reverse, lightIntentisty)
Kitronik_Robotics_Board.motorOn(Kitronik_Robotics_Board.Motors.Motor4, Kitronik_Robotics_Board.MotorDirection.Forward, micPower)
Kitronik_Robotics_Board.servoWrite(Kitronik_Robotics_Board.Servos.Servo1, 98)
basic.forever(function () {
    updateServos2()
    updateAngles2()
    setPixColor2()
    updatePix2()
    setLightIntensity()
})

