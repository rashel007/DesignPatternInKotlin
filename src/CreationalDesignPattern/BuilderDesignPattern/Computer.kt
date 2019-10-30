package CreationalDesignPattern.BuilderDesignPattern

import com.sun.org.apache.xpath.internal.operations.Bool
import javax.swing.DebugGraphics

class Computer private constructor(
    val ram: String?,
    val processor: String?,
    val os: String?,
    val hasGraphicsCard: Boolean?,
    val hasSSDEnabled: Boolean?
) {


    data class Builder(
        private var ram: String? = null,
        private var processor: String? = null,
        private var os: String? = null,
        private var hasGraphicsCard: Boolean? = null,
        private var hasSSDEnabled: Boolean? = null
    ) {

        fun setRam(ram: String) = apply { this.ram = ram }
        fun setProcessor(processor: String) = apply { this.processor = processor }
        fun setOS(os: String) = apply { this.os = os }
        fun setHasGraphics(hasGraphicsCard: Boolean) = apply { this.hasGraphicsCard = hasGraphicsCard }
        fun setHasSSDEnabled(hasSSDEnabled: Boolean) = apply { this.hasSSDEnabled = hasSSDEnabled }
        fun build() = Computer(ram, processor, os, hasGraphicsCard, hasSSDEnabled)
    }

}


fun main() {
    val normalComputer = Computer.Builder()
        .setRam("4 GB")
        .setProcessor("core i4")
        .setOS("Windows")
        .build()

    val superComputer = Computer.Builder()
        .setRam("12 GB")
        .setProcessor("core i7")
        .setOS("Linux")
        .setHasGraphics(true)
        .setHasSSDEnabled(true)
        .build()

    println(
        "${normalComputer.ram} ," +
                "${normalComputer.os}," +
                "${normalComputer.processor}," +
                "${normalComputer.hasGraphicsCard}," +
                "${normalComputer.hasSSDEnabled}"
    )

    println(
        "${superComputer.ram} ," +
                "${superComputer.os}," +
                "${superComputer.processor}," +
                "${superComputer.hasGraphicsCard}," +
                "${superComputer.hasSSDEnabled}"
    )
}