// IGNORE_BACKEND: WASM
// IGNORE_BACKEND_FIR: JVM_IR
class Foo {
    private val fld: String = "O"
        get() = { field }() + "K"

    val indirectFldGetter: () -> String = { fld }
}

fun box() = Foo().indirectFldGetter()

// DONT_TARGET_EXACT_BACKEND: WASM
 //DONT_TARGET_WASM_REASON: UNRESOLVED_REF__ WASM_FUNCTION_REFERENCES_UNSUPPORTED
