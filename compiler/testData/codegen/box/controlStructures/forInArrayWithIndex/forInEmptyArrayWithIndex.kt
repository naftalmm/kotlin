// IGNORE_BACKEND: WASM
// IGNORE_BACKEND_FIR: JVM_IR
// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME

val arr = intArrayOf()

fun box(): String {
    val s = StringBuilder()
    for ((index, x) in arr.withIndex()) {
        return "Loop over empty array should not be executed"
    }
    return "OK"
}
// DONT_TARGET_EXACT_BACKEND: WASM
 //DONT_TARGET_WASM_REASON: UNRESOLVED_REF__ StringBuilder 
