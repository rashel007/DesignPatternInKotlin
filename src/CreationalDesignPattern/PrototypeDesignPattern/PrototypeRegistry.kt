package CreationalDesignPattern.PrototypeDesignPattern

class PrototypeRegistry {

    private var prototypeRegistry: HashMap<String, Prototype>

    init {
        println("PrototypeRegistry init called")
        prototypeRegistry = HashMap()
    }

    fun addPropertyToRegistry(prototypeName: String,prototype: Prototype ){
        prototypeRegistry.put(prototypeName, prototype)
    }

    fun getPtototypeFromProtypeRegistry(prototypeName: String): Prototype{

        return prototypeRegistry.get(prototypeName)!!.clone()
    }
}