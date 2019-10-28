package CreationalDesignPattern.PrototypeDesignPattern

fun main() {

    val original = ConcretePrototype("Rashel")

    // first we have to cache our original object in memory
    val registry = PrototypeRegistry();
    registry.addPropertyToRegistry("original", original)

    val copyItem: ConcretePrototype = registry.getPtototypeFromProtypeRegistry("original") as ConcretePrototype

    println(original)
    println(copyItem)

    println(original.name)
    println(copyItem.name)
}