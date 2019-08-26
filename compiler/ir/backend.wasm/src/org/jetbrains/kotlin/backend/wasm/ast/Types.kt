/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.wasm.ast

sealed class WasmValueType
object WasmUnreachableType : WasmValueType()
sealed class WasmSimpleValueType(val mnemonic: String) : WasmValueType() {
    override fun toString(): String = mnemonic
}
object WasmI32 : WasmSimpleValueType("i32")
object WasmI64 : WasmSimpleValueType("i64")
object WasmF32 : WasmSimpleValueType("f32")
object WasmF64 : WasmSimpleValueType("f64")

object WasmAnyRef : WasmSimpleValueType("anyref")
object WasmNullRefType : WasmSimpleValueType("anyref")

data class WasmStructRef(val structType: WasmSymbol<WasmStructType>) : WasmValueType() {
    override fun toString(): String = "(sref $structType)"
}