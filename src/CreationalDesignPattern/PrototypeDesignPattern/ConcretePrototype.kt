package CreationalDesignPattern.PrototypeDesignPattern

class ConcretePrototype : Prototype {


     var name: String

    constructor(name: String) {
        this.name = name
    }

    constructor(prototype: ConcretePrototype) {
        this.name = prototype.name
    }


    override fun clone(): Prototype {
        return ConcretePrototype(this)
    }
}