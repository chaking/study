import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the plusMinus function below.
fun multipliedBigNumbers(number1: String, number2: String): String {
    return realMul(number1.toCharArray(), number2.toCharArray()).joinToString("")
}

fun realMul(number1: CharArray, number2: CharArray): CharArray {
    val results = (0..9).map {
        mulSingle(number1, it)
    }

    results.map { it.joinToString { "" } }.forEach{println(it)}

    return charArrayOf('3', '4')
}

fun mulSingle(number1: CharArray, target: Int): CharArray {
    val result = CharArray(number1.size + 1){ '0' }
    number1.reversed().forEachIndexed { index, c ->
        val r = c.toInt() * target
        if (r > 9) result[index + 1] = 1.toChar()
        val sum = result[index].toInt() + r % 10
        if (sum > 9 ) result[index + 1] = (result[index + 1].toInt() + 1).toChar()
        result[index] = (result[index].toInt() + sum % 10).toChar()
    }
    return result
}

fun input() {
    val scan = Scanner(System.`in`)

    val arr = scan.nextLine().split(" ").map{ it.trim() }.toTypedArray()

    multipliedBigNumbers(arr[0], arr[1])
}

fun auto() {
    val result = multipliedBigNumbers("4819", "9")
    println(result)
}
fun main(args: Array<String>) {
//    input()
    auto()
}
