package CreationalDesignPattern.AbstractFactoryDesignPattern.products

class DominosStyleFurniture(value: String) : Furniture(value) {

    override fun use() {
        println("Dominos $waterMark")
    }
}