// IGNORE_BACKEND: WASM
// IGNORE_BACKEND_FIR: JVM_IR
// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

data class A(var x: Int) : Cloneable {
    public override fun clone(): A = super.clone() as A
}

fun box(): String {
    val a = A(42)
    val b = a.clone()
    if (a != b) return "Fail equals"
    if (a === b) return "Fail identity"
    return "OK"
}

// DONT_TARGET_EXACT_BACKEND: WASM
 //DONT_TARGET_WASM_REASON: UNRESOLVED_REF__ Cloneable 
