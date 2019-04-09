
fun countedLongestCommonSubstringLength(firstString: String, secondString: String): Int{
    val counts = Array<String>(secondString.length){"00"}
    for (i in 0..firstString.length) {
        for (j in 0..secondString.length) {
            val first = firstString.get(i)
            val second = secondString.get(j)
            val previousSecond = if (j == 0) '$' else secondString.get(j - 1)
            if (first == second)
            println("$first $second $previousSecond")
        }
    }
    return 1
}

fun test() {
    val inputs = arrayOf(
        arrayOf("ababc", "babca", "4")
        , arrayOf("abbacd", "ebacab", "3")
    )
    inputs.forEach{
        val answer = countedLongestCommonSubstringLength(it.get(0), it.get(1))
        val correctAnswer = it.get(2).toInt()
        println("answer: $answer, correctAnswer: $correctAnswer, correct: ${answer == correctAnswer}")
    }
}

fun main(args: Array<String>) {
    test()
}