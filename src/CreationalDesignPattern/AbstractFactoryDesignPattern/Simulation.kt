package CreationalDesignPattern.AbstractFactoryDesignPattern

import CreationalDesignPattern.AbstractFactoryDesignPattern.client.Customer
import CreationalDesignPattern.AbstractFactoryDesignPattern.factory.DominosFoodChainFactory
import CreationalDesignPattern.AbstractFactoryDesignPattern.factory.KfcFoodChainFactory
import CreationalDesignPattern.AbstractFactoryDesignPattern.factory.RestaurantWithAbstractfactory

fun main() {

    val dominosChain: RestaurantWithAbstractfactory = RestaurantWithAbstractfactory(DominosFoodChainFactory());
    val kfcChain: RestaurantWithAbstractfactory = RestaurantWithAbstractfactory(KfcFoodChainFactory())

    val customer: Customer = Customer(dominosChain)
    customer.generate()

    customer._restaurantFactory = kfcChain
    customer.generate()
}