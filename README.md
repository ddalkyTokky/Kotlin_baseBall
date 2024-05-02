# 0. _**0.1.0 -> 1.0.0**_ 변경점
- 사용자 사용법 변경.
- 내부 로직 변경.
- 16진수 기준, 1부터 F까지 맞출 숫자의 범위를 지정할 수 있음.
- 위에서 입력한 숫자 범위를 초과하지 않는 선에서, 맞출 숫자의 갯수를 지정할 수 있음.
- 0.1.0 에서 변경되었던 위 로직을 사용자 입력단에도 추가함.

# 1. 결과 화면
![image](https://github.com/ddalkyTokky/Kotlin_baseBall/assets/47583083/541e97bc-e88c-4166-af7a-7428fafa90a1)
![image](https://github.com/ddalkyTokky/Kotlin_baseBall/assets/47583083/015e2582-84f4-47fa-be72-096f8922ab9e)

# 2. 작동 흐름

![image](https://github.com/ddalkyTokky/Kotlin_baseBall/assets/47583083/3fb1740b-e398-468a-8d0c-f9e3a1e28629)

# 3. 패키지 설명

## A. inline
### A-1. stringtoint.kt
받은 문자열을 Int 로 변환.
### A-2. intoToCharCode.kt
0 ~ 15 를 hex 코드를 포함한 0 ~ F로 변환.
### A-3. charCodeToInt.kt
hex 코드를 포함한 0 ~ F를 0 ~ 15로 변환.

## B. BaseBallGame.kt
### B-1. fun getGuessCondition(): Pair<Char, Int>
### B-2. fun makeRandomAnswer()
### B-3. fun checkAnswer(input: String): Pair<Int, Int>
### B-4. fun validateInput(input: String): Boolean

# 4. main.kt
각종 입출력과 간단한 입력값 검증을 진행함.
사용자가 원하는 숫자의 범위와 갯수를 받아 BaseBallGame 클래스에 전달.
