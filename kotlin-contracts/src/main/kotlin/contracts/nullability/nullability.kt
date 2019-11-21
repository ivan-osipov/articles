package contracts.nullability

class Factory(val name: String)

class Robot(var factory: Factory? = null)

fun main() {
    val robot = Robot()
    val factory = Factory("")

    robot.factory = factory

    // robot.factory.name //don't work

    val notNullFactory = requireNotNull(robot.factory)

    println(notNullFactory.name)
    // robot.factory.name //don't work


    var value: String? = null
    value = "my value"

    println(value.length) // smartcast works even without contracts
}