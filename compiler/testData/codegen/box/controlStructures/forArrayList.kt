// IGNORE_BACKEND: WASM
// IGNORE_BACKEND_FIR: JVM_IR
// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME
val alist = arrayListOf(1, 2, 3) // : j.u.ArrayList<k.Int>

fun box(): String {
    var result = 0
    for (i: Int in alist) {
        result += i
    }

    return if (result == 6) "OK" else "fail: $result"
}
// DONT_TARGET_EXACT_BACKEND: WASM
 //DONT_TARGET_WASM_REASON: UNRESOLVED_REF__ arrayListOf 
