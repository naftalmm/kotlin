// "Replace with 'prefix + joinTo(StringBuilder(), separator, "", postfix, limit, truncated, transform)'" "true"

public fun <T> Iterable<T>.joinToString2(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((T) -> CharSequence)? = null): String {
    return joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
}

fun foo() {
    listOf(1, 2, 3).<caret>joinToString2(limit = 10)
}