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

// Complete the birthdayCakeCandles function below.
fun birthdayCakeCandles(ar: Array<Int>): Int {
    var max = 0
    var maxCount = 0
    ar.forEach { when {
        it == max -> { maxCount += 1}
        it > max -> { max = it; maxCount = 1 }
    }}
    return maxCount
}

fun test() {
    val array = arrayOf(3, 2, 1, 3)
    val result = birthdayCakeCandles(array)
    println(result)
}

fun main(args: Array<String>) {
    test()
//    val scan = Scanner(System.`in`)
//
//    val arCount = scan.nextLine().trim().toInt()
//
//    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//
//    val result = birthdayCakeCandles(ar)
//
//    println(result)
}
