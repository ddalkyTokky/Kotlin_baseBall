package baseballgame

import inline.intToHexCode
import kotlin.random.Random

class HexBaseBallGame: BaseBallGame {
    private val guessCondition = Triple('0', 'F', 5)
    private var answer = ""

    override fun getGuessCondition(): Triple<Char, Char, Int> {
        return guessCondition
    }

    override fun makeRandomAnswer() {
        answer = ""
        val temp = mutableListOf<Int>()

        while (temp.size < guessCondition.third) {
            val random = Random.nextInt(0, 16)

            if (!temp.contains(random)) {
                temp.add(random)
            }
        }

        for (i in temp) {
            answer += intToHexCode(i)
        }
    }

    override fun checkAnswer(input: String): Pair<Int, Int> {
        var strike: Int = 0
        var ball: Int = 0

        for (idx in 0 until guessCondition.third) {
            if (input[idx] == answer[idx]) {
                strike += 1
                continue
            }

            for (jdx in 0 until guessCondition.third) {
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

    override fun validateInput(input: String): Boolean {
        if (input.length != guessCondition.third) {
            return false
        }

        for (i in input) {
            if (((i >= '0') && (i <= '9')) || ((i >= 'A') && (i <= 'F')))
            else {
                return false
            }
        }

        for (idx in 0 until guessCondition.third) {
            for (jdx in idx until guessCondition.third) {
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