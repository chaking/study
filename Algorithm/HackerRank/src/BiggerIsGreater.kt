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

fun recursive(w: String, best: String, bestFlag: Boolean, next: String, nextFlag: Boolean, index: Int): String {
    val subset = w.substring(1)
    val subsets = subset.mapIndexed { subIndex, char ->
        var a: CharArray = w.toCharArray()
        val temp = a[index]
        a[index] = char
        a[subIndex] = temp
        a.joinToString("")
    }
    subsets.sorted().forEach{ println(it) }
    println(subsets)
    return ""
}

// Complete the biggerIsGreater function below.
fun biggerIsGreater(w: String): String {
    return recursive(w, w, false, "", false, 0)
}

fun main(args: Array<String>) {
//    val inputs = arrayOf("ab", "bb", "hefg", "dhck", "dkhc")
    val inputs = arrayOf("hefg")
    inputs.forEach { (biggerIsGreater(it)) }
//    inputs.forEach { println(biggerIsGreater(it)) }
}
