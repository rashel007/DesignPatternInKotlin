package StructuralDesignPattern.BridgeDesignPattern

fun main() {
    val redCircle = Circle(10, 10, 100, RedCircle())
    redCircle.draw()

    val greenCircle = Circle(20, 20, 200, GreenCircle())
    greenCircle.draw()
}