package CreationalDesignPattern.AbstractFactoryDesignPattern.client

import CreationalDesignPattern.AbstractFactoryDesignPattern.factory.RestaurantWithAbstractfactory

class Customer(var _restaurantFactory: RestaurantWithAbstractfactory) {


//    var restaurantFactory: RestaurantWithAbstractfactory = _restaurantFactory
//    set(value) {
//        field = value
//    }

    fun generate(){
        _restaurantFactory.renderShop()
    }


}