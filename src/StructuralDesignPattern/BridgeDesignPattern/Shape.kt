package StructuralDesignPattern.BridgeDesignPattern

abstract class Shape(protected var drawAPI: DrawAPI) {

    abstract fun draw()
}