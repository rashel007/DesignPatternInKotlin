package CreationalDesignPattern.AbstractFactoryDesignPattern.factory

import CreationalDesignPattern.AbstractFactoryDesignPattern.products.FoodMenu
import CreationalDesignPattern.AbstractFactoryDesignPattern.products.Furniture


/**
 * Abstract Factory provides an interface
 * which encapsulates object creation , and lets you
 * create a family of related products
 */
interface FoodChainFactory {

    fun createFoodMenu(): FoodMenu

    fun createFurniture(): Furniture
}