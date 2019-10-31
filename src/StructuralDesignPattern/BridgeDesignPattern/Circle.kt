package StructuralDesignPattern.BridgeDesignPattern

class Circle(private var x: Int,private var y: Int,private var radius: Int, drawAPI: DrawAPI) :  Shape(drawAPI) {

    override fun draw() {
        drawAPI.drawCircle(radius, x, y)
    }
}