package CreationalDesignPattern.AbstractFactoryDesignPattern.products


/**
 * This will be the base class for all the different types of menu
 */
 abstract class FoodMenu(_menuStyle: String) {

    protected val menuStyle: String = _menuStyle

    abstract fun render();

}