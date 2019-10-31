package StructuralDesignPattern.BridgeDesignPattern

/**
 * Concrete bridge implementer class implementing the
 * DrawAPI interface
 */
class GreenCircle : DrawAPI{
    override fun drawCircle(radius: Int, x: Int, y: Int) {
        println("Drawing Green Circle")
    }
}