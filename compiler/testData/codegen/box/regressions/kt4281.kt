// IGNORE_BACKEND: WASM
// IGNORE_BACKEND_FIR: JVM_IR
abstract class C {
    fun test(x: Int) {
        if (x == 0) return
        if (this is D) {
            val d: D = this
            d.test(x - 1)
        }
    }
}

class D: C()

fun box(): String {
    D().test(10)
    return "OK"
}

// DONT_TARGET_EXACT_BACKEND: WASM
//DONT_TARGET_WASM_REASON: UNIT