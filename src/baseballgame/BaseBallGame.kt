package baseballgame

interface BaseBallGame {
    fun getGuessCondition(): Triple<Char, Char, Int>
    fun makeRandomAnswer()
    fun checkAnswer(input: String): Pair<Int, Int>
    fun validateInput(input: String): Boolean
}