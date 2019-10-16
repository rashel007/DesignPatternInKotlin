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





## References

1. [Creational Design Pattern](https://www.youtube.com/playlist?list=PLn05u4nMKcB-1BSfb3L-09hkcSgNZHrv7)
2. [RefactoringGuru](https://refactoring.guru/design-patterns)