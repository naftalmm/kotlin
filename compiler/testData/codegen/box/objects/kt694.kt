// IGNORE_BACKEND: WASM
// IGNORE_BACKEND_FIR: JVM_IR
enum class Test {
    A,
    B,
    C
}

fun checkA(a: Test) = when(a) {
    Test.B -> false
    Test.A -> true
    else -> false
}

fun box() : String {
    if(!checkA(Test.A)) return "fail"
    if( checkA(Test.C)) return "fail"
    if( checkA(Test.B)) return "fail"
    return "OK"
}

// DONT_TARGET_EXACT_BACKEND: WASM
 //DONT_TARGET_WASM_REASON: ENUMS
