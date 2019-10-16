package CreationalDesignPattern.AbstractFactoryDesignPattern.products

class KfcStyleFood(value: String) : FoodMenu(value) {
    override fun render() {
        println("KFC $menuStyle")
    }
}