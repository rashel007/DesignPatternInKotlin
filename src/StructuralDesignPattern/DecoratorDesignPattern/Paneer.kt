package StructuralDesignPattern.DecoratorDesignPattern

class Paneer(_pizza: Pizza) : ToppingsDecorator() {

    val pizza = _pizza

    init {
        description = pizza.description + ", Paneer"
    }


    override fun getCost(): Int {
        return pizza.getCost() + 20
    }
}