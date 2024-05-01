package inline

inline fun intToCharCode(i: Int): Char {
    if ((i >= 0) && (i <= 9)) {
        return ((i + '0'.code).toChar())
    } else {
        when (i) {
            10 -> return 'A'
            11 -> return 'B'
            12 -> return 'C'
            13 -> return 'D'
            14 -> return 'E'
            15 -> return 'F'
        }
    }
    return '?'
}