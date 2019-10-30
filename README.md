# Design Patterns In Kotlin


## Creational Design Pattern
    1. Factory Pattern
    2. Abstract Factory Pattern
    3. Singleton Pattern
    4. Prototype Pattern
    5. Builder Pattern
    
    
#### 1. Factory Design Pattern

> It's a creational design pattern that provides an interface which encapsulate object creation, and lets the subclasses decide what
objects to create. 

```
    Factory Design Pattern helps us maintain Single Responsibilioty Principle and Open Close Principle
```

#### 2. Abstract Factory Design Pattern

> Its a creational design pattern that provides an interface which encapsulate object creation and lets you produce families
of related objects without specifying their concrete classes



Suppose we want to make KFC style burger and BFC style burger. To make burger we need two things, one in bun and another is patty. 
So, first we will create tow interface Ban and Patty. For KFC we will create tow concrete class KfcStyleBun and KfcStylePatty . KfcStyleBun will implement Bun interface and 
KfcStylePatty will implement Patty interface. Same goes for BFC , BFC classes will implement BfcStyleBun and BfcStylePatty

```kotlin

interface Bun{
    fun createBun()
}

interface Patty{
    fun createPatty()
}

// BFC product class

class BfcStyleBun: Bun {
    override fun createBun() {
        
    }
}

class BfcStylePatty: Patty{
    override fun createPatty() {
        
    }
}

// KFC product class

class KfcStyleBun: Bun {
    override fun createBun(){
    
    }
}

class KfcStylePatty: Patty {
    override fun createPatty(){
    
    }
}

```

Now we have to create our concrete classes which will create families. For that First we have to create an interface BurgerFactory which will have two funtion with return type
Bun and Patty. We will create two concrete class KfcStyleBurgerFactory and BfcStyleBurgerFactory which will implement
BurgerFactory interface.

```kotlin

interface BurgerFactory{
    fun getBun(): Bun
    fun getPatty(): Patty
}

class KfcStyleBurgerFactory: BurgerFactory{
    override fun geteBun(): Bun{
        return KfcStyleBun()
    }
    
    override fun getPatty(): Patty {
        return kfcStylePatty()
    }
}


class BfcStyleBurgerFactory: BurgerFactory {
    override fun getBun(): Bun{
        return BfcStyleBun()
    }
    
    override fun getPatty(): Patty {
        return BfcStylePatty()
    }
}

```

Now, we can create a helper factory that will give us the burger of our choice. 

```kotlin
class MakeMyBurger(burgerFactory: BurgerFactory){
    val burgerBun: Bun = burgerFactory.getBun()
    val burgerPatty: Patty = burgerFactory.getPatty()
    
    // this function will create our burger
    fun create() {
        burgerBun.createBun()
        burgerPatty.createPatty()
    }
}
```

So now we can create an object of MakeMyBurger and pass the Burger we want to create

```kotlin
    
    val myBurger: MakeMyBurger = MakeMyBurger(KfcStyleBurgerFactory())
    myBurger.create() // we get our burger.. nice

```


```
By this way we are ensuring that, if we want KFC style Burger then patty and bun will be from KFC only. No chance for mixing.
```


#### 3. Singleton Design Pattern

> It's  creational design pattern that let's you ensure that a class has only one instance and provide a global 
access to this instance


#### 4. Prototype Design Pattern

> Its a creational design pattern that lets us produce new objects by coping existing ones, without compromising their internals.


So, why do we need this prototype design pattern. The answer is, the creation of that object might be a heavy task, 
like getting from db transaction for fetching from network. Manually coping an object is difficult. We have to go through 
the fields of that object ,and also there might be private fields which we dont have access. So, Here we can use Prototype
design pattern to easily solve this problem.   

For using prototype design pattern we have to follow these steps : 

1. Create an interface named Prototype which expose a close method
2. Design a PrototypeRegistry which acts as a cache to hold the prototypical objects
3. Design a factory method which accepts the arguments and finds the correct prototype object from the registry and returns a copy for it.
4. Use this clone() method to create a copy of a Prototype whenever it is required.


Lets implement these steps : 

1. creating an interface

```kotlin
    interface Prototype {
        fun clone(): Prototype
    }
```

2. PrototypeRegistry
```kotlin
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
```

For 3 and 4 we can create a factory class that will take the prototypeName and return a clone object of that type


```kotlin
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

  val original = ConcretePrototype("Rashel")

  // first we have to cache our original object in memory
  val registry = PrototypeRegistry();
  registry.addPropertyToRegistry("original", original)

  val copyItem: ConcretePrototype = registry.getPtototypeFromProtypeRegistry("original") as ConcretePrototype


```


#### 5. Builder Design pattern

Builder design pattern is a creational design pattern. It is very useful when : 

1. A class has too many variables and many of them have some data type, creating confusion for Client program
2. Some of the Class variables are Optional, so Client will have to pass NULL if Factory pattern is used.
3. Class instance creation is heavy and complex, so all those complexity will become part of factory

By this way we can easily maintain and extend our class.Lets create an example

```kotlin

class Computer private constructor(val ram: String? , var processor: String? , var ssd: String?) {

data class Builder(
    private var ram: String? = null
    private var processor: String? = null
    private var ssd: String? = null
) {

    fun setRam(ram: String)  = apply {this.ram = ram}
    fun setProcessor(processor: String) = apply {this.processor = processor}
    fun setSSD(ssd: String) = apply {this.ssd = ssd}
    fun build() = Computer(ram, processor, ssd)
    
}
}
fun main() {
    var myComputer = Computer.Builder()
                .setRam("RAM")
                .setProcessor("PROCESSOR")
                .setSSD("SSD")
                .build();
                
                // this will build our computer
}

```



## Structural Design Pattern

Structural design pattern are concerned with how classes and objects can be composed. 
The structural design patterns simplifies the structure by identifying the relationships.

    1. Adapter Pattern
    2. Bridge Pattern
    3. Composite Pattern
    4. Decorator Pattern
    5. Facade Pattern
    6. Flyweight Pattern
    7. Proxy Pattern
    
#### 1. Adapter design pattern

Adapter design pattern creates a bridge between two incompatible interfaces.
    
Ex: CardReader , which acts as an adapter between memory card and laptop/computer. So here, memory card and laptop are tow 
incompatible device. and CardReader acts as a bridge between these tow device. 

## References

1. [Creational Design Pattern](https://www.youtube.com/playlist?list=PLn05u4nMKcB-1BSfb3L-09hkcSgNZHrv7)
2. [RefactoringGuru](https://refactoring.guru/design-patterns)
3. [Design Pattern-kudvenkat](https://www.youtube.com/watch?v=YGGg9ecy0K4&list=PL6n9fhu94yhUbctIoxoVTrklN3LMwTCmd&index=2)