package CreationalDesignPattern.AbstractFactoryDesignPattern.factory

import CreationalDesignPattern.AbstractFactoryDesignPattern.products.DominosStyleFood
import CreationalDesignPattern.AbstractFactoryDesignPattern.products.DominosStyleFurniture
import CreationalDesignPattern.AbstractFactoryDesignPattern.products.FoodMenu
import CreationalDesignPattern.AbstractFactoryDesignPattern.products.Furniture

class DominosFoodChainFactory: FoodChainFactory {
    override fun createFoodMenu(): FoodMenu {
        return DominosStyleFood("DomFood")
    }

    override fun createFurniture(): Furniture {
        return DominosStyleFurniture("DomFur")
        }
}