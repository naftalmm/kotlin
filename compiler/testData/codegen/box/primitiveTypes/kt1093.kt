// IGNORE_BACKEND: WASM
val f : (Any) -> String = { it.toString() }

fun box() : String {
    if(!(f === f)) return "fail 1"
    if(!(f == f)) return "fail 2"
    if(!(f.equals(f))) return "fail 3"
    return "OK"
}

// DONT_TARGET_EXACT_BACKEND: WASM
 //DONT_TARGET_WASM_REASON: UNRESOLVED_REF__ WASM_FUNCTION_REFERENCES_UNSUPPORTED
