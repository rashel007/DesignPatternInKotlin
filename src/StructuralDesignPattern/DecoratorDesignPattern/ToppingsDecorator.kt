package StructuralDesignPattern.DecoratorDesignPattern

abstract class ToppingsDecorator : Pizza() {
    abstract fun getDescriptionToppings(): String
}