// IGNORE_BACKEND: WASM
// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// DONT_RUN_GENERATED_CODE: JS
// IGNORE_BACKEND: JS

<!NO_TAIL_CALLS_FOUND!>tailrec fun foo()<!> {
    fun bar() {
        <!NON_TAIL_RECURSIVE_CALL!>foo<!>()
    }
}

fun box(): String {
    foo()
    return "OK"
}
// DONT_TARGET_EXACT_BACKEND: WASM
 //DONT_TARGET_WASM_REASON: IGNORED_IN_JS
