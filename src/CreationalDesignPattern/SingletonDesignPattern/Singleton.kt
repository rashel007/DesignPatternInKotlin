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

    // another approch

    val faekDatabase = FakeDataBase.getInstance()

}


// another approch

class FakeDataBase private constructor() {

    companion object{
        @Volatile private var instance: FakeDataBase? = null

        fun getInstance() =
                instance ?: synchronized(this){
                    instance ?: FakeDataBase().also{ instance = it}
                }
    }
}