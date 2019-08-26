// !LANGUAGE: +NewInference
// IGNORE_BACKEND: WASM
// IGNORE_BACKEND_FIR: JVM_IR
// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME

class Foo<C : Any> {
    fun test(candidates: Collection<C>): List<C> {
        return candidates.sortedBy { 1 }
    }
}

fun box(): String {
    val foo = Foo<String>()

    val list = listOf("OK")
    val sorted = foo.test(list)

    return list.first()
}
// DONT_TARGET_EXACT_BACKEND: WASM
 //DONT_TARGET_WASM_REASON: UNRESOLVED_REF__ sortedBy 
