package StructuralDesignPattern.BridgeDesignPattern

/**
 * Concrete bridge implementer class implementing the
 * DrawAPI interface
 */
class RedCircle: DrawAPI {

    override fun drawCircle(radius: Int, x: Int, y: Int) {
        println("Drawing Red Circle")
    }
}