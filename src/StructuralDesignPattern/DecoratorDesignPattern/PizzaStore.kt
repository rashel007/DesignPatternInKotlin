package StructuralDesignPattern.DecoratorDesignPattern

fun main() {

    var pizzaMargherito = Mergherita()

    println("${pizzaMargherito.description} -> ${pizzaMargherito.getCost()}")

    var pizzaMergheritaWithPanner = Paneer(pizzaMargherito)

    println("${pizzaMergheritaWithPanner.description} -> ${pizzaMergheritaWithPanner.getCost()}")

    var pizzaMergheritaWithPannerAndTomato = FreshTomato(pizzaMergheritaWithPanner)

    println("${pizzaMergheritaWithPanner.description} -> ${pizzaMergheritaWithPanner.getCost()}")
}