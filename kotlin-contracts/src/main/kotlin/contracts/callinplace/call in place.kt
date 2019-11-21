package contracts.callinplace

import java.util.*
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun main() {

    val value: String

//    lambdaRunner {
//        value = UUID.randomUUID().toString() // doesn't work
//    }

    lambdaRunnerWithContract {
        value = UUID.randomUUID().toString() // works
        println(value)
    }
//    println(value) // not initialized
}

fun lambdaRunner(lambda: () -> Unit) {
    lambda()
}

@UseExperimental(ExperimentalContracts::class)
fun lambdaRunnerWithContract(lambda: () -> Unit) {
    contract {
        callsInPlace(lambda, InvocationKind.EXACTLY_ONCE)
    }
    lambda()
}

