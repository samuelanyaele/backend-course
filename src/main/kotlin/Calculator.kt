fun add(a: Double, b: Double): Double = a + b

fun subtract(a: Double, b: Double): Double = a - b

fun multiply(a: Double, b: Double): Double = a * b

fun divide(a: Double, b: Double): Double {
    if (b == 0.0) {
        throw IllegalArgumentException("Cannot divide by zero")
    }
    return a / b
}
fun parseNumber(input: String?): Double? {
    return input?.trim()?.toDoubleOrNull()
}
fun main() {
    println("Welcome to the Kotlin Calculator!")
    println("Enter 'quit' to exit.")

    while (true) {
        print("Enter first number: ")
        val firstInput = readlnOrNull() ?: break
        if (firstInput == "quit") break

        val first = parseNumber(firstInput)
        if (first == null) {
            println("Invalid number. Try again.")
            continue
        }

        print("Enter operator (+, -, *, /): ")
        val operator = readlnOrNull() ?: break
        if (operator == "quit") break

        print("Enter second number: ")
        val secondInput = readlnOrNull() ?: break
        if (secondInput == "quit") break

        val second = parseNumber(secondInput)
        if (second == null) {
            println("Invalid number. Try again.")
            continue
        }

        val result = try {
            when (operator) {
                "+" -> add(first, second)
                "-" -> subtract(first, second)
                "*" -> multiply(first, second)
                "/" -> divide(first, second)
                else -> {
                    println("Unknown operator: $operator")
                    continue
                }
            }
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
            continue
        }

        println("Result: $result")
        println()
    }

    println("Goodbye!")
}