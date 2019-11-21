package contracts.customnullability

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun main() {
    try {
        processValue(null)
    } catch (e: ValidationException) {
        println("Properly processed validation with code: ${e.code}")
    }
}

@UseExperimental(ExperimentalContracts::class)
fun processValue(justNullableValue: String?) {
    // requireNotNull(justNullableValue) //throws IllegalArgumentException exception
    validate(justNullableValue)

    println(justNullableValue.length)
}

@ExperimentalContracts
fun validate(value: String?) {
    contract {
        returns() implies (value != null)
    }
    if(value == null) {
        throw ValidationException("wrong_null_value")
    }
}