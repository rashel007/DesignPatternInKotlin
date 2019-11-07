package StructuralDesignPattern.DecoratorDesignPattern

class Mergherita : Pizza() {

    init {
        description = "Mergherita"
    }


    override fun getCost(): Int {
        return 100
    }

}