import baseballgame.BaseBallGame
import inline.stringtoint

fun main() {
    println("환영합니다!")

    val baseBallGame = BaseBallGame('F', 5)
    var attempt = 0
    val attempts = mutableListOf<Int>()

    while (true) {
        println("\n1. 숫자 야구 게임 시작하기  2. 게임 기록 보기  3. 종료하기")
        print("원하시는 번호를 입력해주세요. : ")

        val input = readLine() ?: ""
        val num_input = stringtoint(input)

        when (num_input) {
            1 -> {
                println("\n< 숫자 야구 게임을 시작합니다 >")
                baseBallGame.makeRandomAnswer()
                val guessCondition = baseBallGame.getGuessCondition()

                while (true) {
                    print("0 ~ ${guessCondition.first}까지의 숫자를 ${guessCondition.second}개 입력하세요. : ")
                    val input = readLine() ?: ""

                    if (!baseBallGame.validateInput(input)) {
                        println("올바르지 않은 입력값입니다.\n")
                        continue
                    }

                    attempt += 1
                    val pair = baseBallGame.checkAnswer(input)
                    if (pair.first == 5) {
                        println("정답입니다!\n")
                        attempts.add(attempt)
                        attempt = 0
                        break
                    }
                    println("${pair.first}스트라이크 ${pair.second}볼")
                }
            }

            2 -> {
                println("\n< 게임 기록 보기 >")
                for (idx in 0 until attempts.size) {
                    println("${idx + 1}번째 게임 : 시도 횟수 - ${attempts[idx]}")
                }
            }

            3 -> {
                println("\n< 숫자 야구 게임을 종료합니다 >")
                return
            }

            else -> println("\n< 1 ~ 3 사이의 숫자를 입력해주세요! > ")
        }
    }
}