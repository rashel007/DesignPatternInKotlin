package StructuralDesignPattern.DecoratorDesignPattern

class FreshTomato(_pizza: Pizza) : ToppingsDecorator() {

    val pizza: Pizza = _pizza

    override fun getDescriptionToppings(): String {

        return "${pizza.description} , FreshTomato"
    }

    override fun getCost(): Int {
        return pizza.getCost() + 50
    }
}