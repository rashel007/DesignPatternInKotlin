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

```kotlin

// lets create an audio player app. which have a functionality play music.

interface MediaPlayer {
    fun play(audioType: String, fileName: String)
}



interface AdvancedMediaPlayer {

    fun playVlc(fileName: String)

    fun playMp4(fileName: String)

}

// create 2 advanced media player Mp4 and VlC. Which extends the AdvancedMediaPlayer interface

class Mp4Player : AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
    }

    override fun playMp4(fileName: String) {
        println("mp4 playing $fileName song")
    }
}

class VlcPlayer : AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        println("Vlc playing $fileName song")
    }

    override fun playMp4(fileName: String) {
    }
}

// lets create the mediaplayer adapter. this adapter will extends MediaPlayer and also take an arguments AdvancedMediaPlayer

class MediaAdapter : MediaPlayer {

    lateinit var advancedMediaPlayer: AdvancedMediaPlayer

    constructor(audioType: String) {
        if (audioType.equals("vlc")) {
            advancedMediaPlayer = VlcPlayer()
        } else if (audioType.equals("mp4")) {
            advancedMediaPlayer = Mp4Player()
        }
    }

    override fun play(audioType: String, fileName: String) {
        if (audioType.equals("vlc")) {
            advancedMediaPlayer.playVlc(fileName)
        } else if (audioType.equals("mp4")) {
            advancedMediaPlayer.playMp4(fileName)
        }
    }
}

// lets create our audio player . this player can only run mp3 player. but if the type is mp4 or vlc then it can alos convert and play these format

class AudioPlayer : MediaPlayer {

    lateinit var mediaPlayer: MediaPlayer

    override fun play(audioType: String, fileName: String) {

        if (audioType.equals("mp3")) {
            println("Playing mp3 song $fileName")
        } else if (audioType.equals("vlc") || audioType.equals("mp4")) {
            mediaPlayer = MediaAdapter(audioType)
            mediaPlayer.play(audioType, fileName)
        } else {
            println("Invalid audioType. $audioType not supported")
        }

    }
}

```


#### Bridge Design Pattern
A Bridge Pattern says that just "decouple the functional abstraction from the implementation so that the two can vary independently".


```kotlin
/**
 * Bridge implementer interface
 */
interface DrawAPI {

    fun drawCircle(radius: Int, x: Int, y: Int)

}

/**
 * Concrete bridge implementer class implementing the
 * DrawAPI interface
 */
class RedCircle: DrawAPI {

    override fun drawCircle(radius: Int, x: Int, y: Int) {
        println("Drawing Red Circle")
    }
}

/**
 * Concrete bridge implementer class implementing the
 * DrawAPI interface
 */
class GreenCircle : DrawAPI{
    override fun drawCircle(radius: Int, x: Int, y: Int) {
        println("Drawing Green Circle")
    }
}


abstract class Shape(protected var drawAPI: DrawAPI) {

    abstract fun draw()
}


class Circle(private var x: Int,private var y: Int,private var radius: Int, drawAPI: DrawAPI) :  Shape(drawAPI) {

    override fun draw() {
        drawAPI.drawCircle(radius, x, y)
    }
}


fun main() {
    val redCircle = Circle(10, 10, 100, RedCircle())
    redCircle.draw()

    val greenCircle = Circle(20, 20, 200, GreenCircle())
    greenCircle.draw()
}

```

#### Composite Design Pattern

As described by Gof, "Compose objects into tree structure to represent part-whole hierarchies. Composite lets
client treat individual objects and compositions of objects uniformly[in a way that is the same in all cases and at all times]"
It allows you to have a tree structure and ask each node in the tree structure to perform a task.


[Describe part-hole hierarchy](https://javapapers.com/design-patterns/composite-design-pattern/)

##### The Composite pattern has four participants:
1. Component - declares the interface for objects in the composition and for accessing and managing its child components.
It also implements default behavior for the interface common to all classes as appropriate.

2. Leaf - defines behavior for primitive objects in the composition. It represents lead objects in the composition.

3. Composite - Stores child components and implements child related operations in the component interface.

4. Client - Manipulates the objects in the composition through the component interface.



```kotlin

// 1 Interface Component

interface Employee{
    fun showEmployeeDetails()    
}


// 2 Leaf

class Developer: Employee {

    private var name: String? = null
    private var empId: Long? = null
    private var position: String? = null
    
    constructor(name: String, empId: Long, position: String) {
        this.name = name
        this.empId = empId
        this.position = position        
    }
    
    override fun showEmployeeDetails(){
        println("$name")
    }
    
}

class Manager: Employee {

    private var name: String? = null
    private var empId: Long? = null
    private var position: String? = null
    
    constructor(name: String, empId: Long, position: String) {
        this.name = name
        this.empId = empId
        this.position = position        
    }
    
    override fun showEmployeeDetails(){
        println("$name")
    }
    
}

// 3. Composite

class CompanyDirectory : Employee {

    private var employeeList = ArrayList<Employee>()

    override fun showEmployeeDetails() {
        for (emp in employeeList){
            emp.showEmployeeDetails()
        }
    }

    fun addEmployee(emp: Employee){
        employeeList.add(emp)
    }

    fun remveEmployee(emp: Employee){
        employeeList.remove(emp)
    }

}

// 4 Client

fun main() {
    var dev1 = Developer("Name 1", 100, "Pro Developer")
    var dev2 = Developer(empId = 101, position = "Jr Developer", name = "Name 2")

    var softDirectory = CompanyDirectory()

    softDirectory.addEmployee(dev1)
    softDirectory.addEmployee(dev2)


    var manager1 = Manager("Name 11", 200, "Business Manager")
    var manager2 = Manager(empId = 201, position = "Accounting Manager", name = "Name 22")

    var managerDirectory = CompanyDirectory()

    managerDirectory.addEmployee(manager1)
    managerDirectory.addEmployee(manager2)

    var directory = CompanyDirectory()
    directory.addEmployee(softDirectory)
    directory.addEmployee(managerDirectory)


    directory.showEmployeeDetails()
}


```

#### Decorator Design Pattern

Decorator pattern allows a user to add new functionality to an existing object without altering its structure. This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.

This pattern creates a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact.



















 
## References

1. [Creational Design Pattern](https://www.youtube.com/playlist?list=PLn05u4nMKcB-1BSfb3L-09hkcSgNZHrv7)
2. [RefactoringGuru](https://refactoring.guru/design-patterns)
3. [Design Pattern-kudvenkat](https://www.youtube.com/watch?v=YGGg9ecy0K4&list=PL6n9fhu94yhUbctIoxoVTrklN3LMwTCmd&index=2)
4. [Coding Simplified](https://www.youtube.com/watch?v=VGLjQuEQgkI&list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx)




