package CreationalDesignPattern.SingletonDesignPattern


enum class Singleton{
    INSTANCE;

    var id: Int? = null
}

fun main() {
    var obj1: Singleton =
        Singleton.INSTANCE

    obj1.id = 10;

    println("${obj1.id}") // will print 10

    var obj2: Singleton =
        Singleton.INSTANCE

    obj2.id = 20

    println("${obj1.id}") // will print 20

}