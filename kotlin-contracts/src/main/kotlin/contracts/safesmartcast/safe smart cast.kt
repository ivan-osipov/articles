package contracts.safesmartcast

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun main() {
    applyHammeringComputer(
        Laptop()
    )
}

fun applyHammeringComputer(entity: Any) {
    if (validate(entity)) {
        entity.useToHammer()
        entity.useToCode()
    } else {
        println("I did nothing")
    }
}

@UseExperimental(ExperimentalContracts::class)
fun validate(entity: Any): Boolean {
    contract {
        returns(true) implies (entity is HammeringObject && entity is Computer)
    }
    return entity is HammeringObject && entity is Computer
}

interface HammeringObject {
    fun useToHammer()
}

interface Computer {
    fun useToCode()
}

class Laptop : HammeringObject, Computer {
    override fun useToHammer() {
        println("Bam Bam Bam!")
    }

    override fun useToCode() {
        println("public static void main....")
    }
}