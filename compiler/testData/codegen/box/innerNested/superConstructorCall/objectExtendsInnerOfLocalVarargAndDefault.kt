// IGNORE_BACKEND: WASM
// IGNORE_BACKEND_FIR: JVM_IR
fun box(): String {
    val capture = "oh"

    class Local {
        val captured = capture

        open inner class Inner(val d: Double = -1.0, val s: String, vararg val y: Int) {
            open fun result() = "Fail"
        }

        val obj = object : Inner(s = "OK") {
            override fun result() = s
        }
    }

    return Local().obj.result()
}

// DONT_TARGET_EXACT_BACKEND: WASM
//DONT_TARGET_WASM_REASON: Arrays