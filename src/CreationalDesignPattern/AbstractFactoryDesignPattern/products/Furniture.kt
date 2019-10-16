package CreationalDesignPattern.AbstractFactoryDesignPattern.products

/**
 * This will the base class for all the different types of furniture
 */

abstract class Furniture(_waterMark: String) {

    protected val waterMark: String = _waterMark
    abstract fun use();
}