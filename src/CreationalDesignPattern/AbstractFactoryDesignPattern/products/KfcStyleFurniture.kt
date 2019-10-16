package CreationalDesignPattern.AbstractFactoryDesignPattern.products

class KfcStyleFurniture(value: String) : Furniture(value) {

    override fun use() {
        println("KFC $waterMark")
    }
}