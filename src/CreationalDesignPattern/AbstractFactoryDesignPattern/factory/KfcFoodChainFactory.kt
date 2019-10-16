package CreationalDesignPattern.AbstractFactoryDesignPattern.factory

import CreationalDesignPattern.AbstractFactoryDesignPattern.products.FoodMenu
import CreationalDesignPattern.AbstractFactoryDesignPattern.products.Furniture
import CreationalDesignPattern.AbstractFactoryDesignPattern.products.KfcStyleFood
import CreationalDesignPattern.AbstractFactoryDesignPattern.products.KfcStyleFurniture

class KfcFoodChainFactory: FoodChainFactory {
    override fun createFoodMenu(): FoodMenu {
        return KfcStyleFood("KfcFood")
    }

    override fun createFurniture(): Furniture {
        return KfcStyleFurniture("KfcFur")
    }
}