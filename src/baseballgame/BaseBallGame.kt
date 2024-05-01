package baseballgame

import inline.charCodeToInt
import inline.intToCharCode
import kotlin.random.Random

class BaseBallGame (private val end: Char, private val howmany: Int){
    private var answer = ""

    private var end_int: Int

    init{
        end_int = charCodeToInt(end)
    }

    fun getGuessCondition(): Pair<Char, Int> {
        return Pair(end, howmany)
    }

    fun makeRandomAnswer() {
        answer = ""
        val temp = mutableListOf<Int>()

        while (temp.size < howmany) {
            val random = Random.nextInt(0, (end_int + 1))

            if (!temp.contains(random)) {
                temp.add(random)
            }
        }

        for (i in temp) {
            if(i >= 10){
                answer += intToCharCode(i)
                continue
            }
            answer += i.toString()
        }
    }

    fun checkAnswer(input: String): Pair<Int, Int> {
        var strike: Int = 0
        var ball: Int = 0

        for (idx in 0 until howmany) {
            if (input[idx] == answer[idx]) {
                strike += 1
                continue
            }

            for (jdx in 0 until howmany) {
                if (idx == jdx) {
                    continue
                }
                if (input[idx] == answer[jdx]) {
                    ball += 1
                    break
                }
            }
        }

        return Pair(strike, ball)
    }

    fun validateInput(input: String): Boolean {
        if (input.length != howmany) {
            return false
        }

        if(end_int < 10){
            for (i in input) {
                if (((i >= '0') && (i <= end)))
                else {
                    return false
                }
            }
        }
        else{
            for (i in input) {
                if (((i >= '0') && (i <= '9')) || ((i >= 'A') && (i <= end)))
                else {
                    return false
                }
            }
        }

        for (idx in 0 until howmany) {
            for (jdx in idx until howmany) {
                if (idx == jdx) {
                    continue
                }
                if (input[idx] == input[jdx]) {
                    return false
                }
            }
        }
        return true
    }
}