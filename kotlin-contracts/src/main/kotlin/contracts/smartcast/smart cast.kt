package contracts.smartcast

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun main() {
    println(
        showHiddenScreens(
            Admin(listOf("my hidden screen"))
        )
    )
}

fun showHiddenScreens(entity: Entity): List<String> {
    validate(entity) //won't work without contract
    return entity.hiddenScreens
}

@UseExperimental(ExperimentalContracts::class)
fun validate(entity: Entity) {
    contract {
        returns() implies (entity is Admin)
    }
    require(entity is Admin)
}

interface Entity

class User: Entity

class Admin(val hiddenScreens: List<String>): Entity