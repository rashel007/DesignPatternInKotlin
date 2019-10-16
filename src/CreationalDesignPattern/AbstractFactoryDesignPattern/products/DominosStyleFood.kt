package CreationalDesignPattern.AbstractFactoryDesignPattern.products

class DominosStyleFood(value: String) : FoodMenu(value) {

    override fun render() {
        println("Dominos $menuStyle")
    }
}