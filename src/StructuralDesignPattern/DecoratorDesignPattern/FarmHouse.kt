package StructuralDesignPattern.DecoratorDesignPattern

class FarmHouse : Pizza() {

    init {
        description = "FarmHouse"
    }


    override fun getCost(): Int {
        return 200
    }
}