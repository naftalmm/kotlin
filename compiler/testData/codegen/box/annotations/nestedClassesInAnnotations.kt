// !LANGUAGE: +NestedClassesInAnnotations
// IGNORE_BACKEND: WASM
// IGNORE_BACKEND_FIR: JVM_IR
// IGNORE_BACKEND: NATIVE

annotation class Foo(val kind: Kind) {
    enum class Kind { FAIL, OK }
}

@Foo(Foo.Kind.OK)
fun box(): String {
    return Foo.Kind.OK.name
}

// DONT_TARGET_EXACT_BACKEND: WASM
 //DONT_TARGET_WASM_REASON: ENUMS
