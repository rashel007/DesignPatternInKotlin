package StructuralDesignPattern.DecoratorDesignPattern

abstract class Pizza {

    var description: String = "Unknown Item"

    abstract fun getCost(): Int
}