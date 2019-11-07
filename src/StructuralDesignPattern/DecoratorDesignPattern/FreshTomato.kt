package StructuralDesignPattern.DecoratorDesignPattern

class FreshTomato(_pizza: Pizza) : Pizza by _pizza {

    val pizza: Pizza = _pizza

    init {
        description = pizza.description + ", Fresh Tomato"
    }

    override fun getCost(): Int {
        return pizza.getCost() + 50
    }
}