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

// Complete the organizingContainers function below.
fun organizingContainers(container: Array<Array<Int>>)
        : String = when (MyOrganizingContainers(container)) {
    true -> "Possible"
    else -> "Impossible"
}

fun MyOrganizingContainers(containers: Array<Array<Int>>): Boolean {
    val cons = Array(containers.size) { 0 }
    val types = Array(containers.size) { 0 }
    containers.forEachIndexed { containerIndex, container ->
        container.forEachIndexed { typeIndex, type ->
            cons[containerIndex] += type
            types[typeIndex] += type
        } }

    println(Arrays.deepToString(cons))
    println(Arrays.deepToString(types))
    val consList = cons.sortedArray().toList()
    val typesList = types.sortedArray().toList()

    return consList == typesList
}

fun main(args: Array<String>) {
    val inputs = listOf(
        arrayOf(arrayOf(1, 3, 1), arrayOf(2, 1, 2), arrayOf(3, 3, 3))
        , arrayOf(arrayOf(0, 2, 1), arrayOf(1, 1, 1), arrayOf(2, 0, 0))
    )

    inputs
        .map { organizingContainers(it) }
        .forEach { println(it) }
}
