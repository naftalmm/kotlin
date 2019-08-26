// !LANGUAGE: +InlineClasses
// IGNORE_BACKEND: WASM
// IGNORE_BACKEND_FIR: JVM_IR

fun <T> T.runExt(fn: T.() -> String) = fn()

inline class R(private val r: String) {
    fun test() = runExt { r }
}

fun box() = R("OK").test()
// DONT_TARGET_EXACT_BACKEND: WASM
 //DONT_TARGET_WASM_REASON: UNRESOLVED_REF__ WASM_FUNCTION_REFERENCES_UNSUPPORTED
