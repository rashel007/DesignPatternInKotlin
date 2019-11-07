package StructuralDesignPattern.DecoratorDesignPattern

class Paneer(_pizza: Pizza) : ToppingsDecorator() {
    override fun getDescriptionToppings(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val pizza = _pizza

    init {
        description = pizza.description + ", Paneer"
    }


    override fun getCost(): Int {
        return pizza.getCost() + 20
    }
}