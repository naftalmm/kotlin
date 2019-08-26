// IGNORE_BACKEND: WASM
// IGNORE_BACKEND_FIR: JVM_IR
// WITH_RUNTIME

import kotlin.test.assertEquals

inline fun foo(x: String, block: (String) -> String) = block(x)
fun noInlineFoo(x: String, block: (String) -> String) = block(x)

fun box(): String {
    val res = foo("abc") {
        fun bar(y: String) = y + "cde"
        noInlineFoo(it) { bar(it) }
    }

    assertEquals("abccde", res)

    return "OK"
}

// DONT_TARGET_EXACT_BACKEND: WASM
 //DONT_TARGET_WASM_REASON: UNRESOLVED_REF__ WASM_FUNCTION_REFERENCES_UNSUPPORTED
