package inline

inline fun charCodeToInt(ch: Char): Int {
    if ((ch >= '0') && (ch <= '9')) {
        return (ch.code - '0'.code)
    } else {
        when (ch){
            'A' -> return 10
            'B' -> return 11
            'C' -> return 12
            'D' -> return 13
            'E' -> return 14
            'F' -> return 15
        }
    }
    return -1
}