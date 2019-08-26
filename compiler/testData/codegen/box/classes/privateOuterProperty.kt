// IGNORE_BACKEND: WASM
// IGNORE_BACKEND_FIR: JVM_IR
class C{
    private var v : Int = 0

    public fun foo() : Int {
        {
            v = v + 1
        }.invoke()

        object : Runnable {
            public override fun run() {
                v = v + 1
            }
        }.run()

        Inner().innerFun()

        return v
    }

    private inner class Inner() {
        fun innerFun() {
            v = v + 1
        }
    }
}

interface Runnable {
    fun run(): Unit
}

fun box() = if (C().foo() == 3) "OK" else "NOT OK"

// DONT_TARGET_EXACT_BACKEND: WASM
 //DONT_TARGET_WASM_REASON: UNRESOLVED_REF__ WASM_FUNCTION_REFERENCES_UNSUPPORTED
