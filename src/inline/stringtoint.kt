package inline

inline fun stringtoint(str: String): Int {
    return try {
        str.toInt()
    } catch (e: Exception) {
        return -1
    }
}