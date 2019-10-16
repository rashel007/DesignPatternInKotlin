package CreationalDesignPattern.AbstractFactoryDesignPattern.factory

import CreationalDesignPattern.AbstractFactoryDesignPattern.products.FoodMenu
import CreationalDesignPattern.AbstractFactoryDesignPattern.products.Furniture

class RestaurantWithAbstractfactory(foodChainFactory: FoodChainFactory) {

    val menu: FoodMenu = foodChainFactory.createFoodMenu()
    val furniture: Furniture = foodChainFactory.createFurniture()

    fun renderShop() {
        menu.render()
        furniture.use()
    }

}