/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.wasm.utils

import org.jetbrains.kotlin.backend.wasm.ast.WasmImportPair
import org.jetbrains.kotlin.ir.backend.js.utils.getSingleConstStringArgument
import org.jetbrains.kotlin.ir.declarations.IrAnnotationContainer
import org.jetbrains.kotlin.ir.declarations.IrClass
import org.jetbrains.kotlin.ir.expressions.IrConst
import org.jetbrains.kotlin.ir.util.getAnnotation
import org.jetbrains.kotlin.ir.util.hasAnnotation
import org.jetbrains.kotlin.name.FqName

fun IrAnnotationContainer.hasExcludedFromCodegenAnnotation(): Boolean =
    hasAnnotation(FqName("kotlin.wasm.internal.ExcludedFromCodegen"))

fun IrClass.hasSkipRTTIAnnotation(): Boolean =
    hasAnnotation(FqName("kotlin.wasm.internal.SkipRTTI")) || hasExcludedFromCodegenAnnotation()

fun IrAnnotationContainer.getWasmInstructionAnnotation(): String? =
    getAnnotation(FqName("kotlin.wasm.internal.WasmInstruction"))?.getSingleConstStringArgument()

fun IrAnnotationContainer.getWasmBinaryOpAnnotation(): String? =
    getAnnotation(FqName("kotlin.wasm.internal.WasmBinaryOp"))?.getSingleConstStringArgument()

fun IrAnnotationContainer.getWasmRefOpAnnotation(): String? =
    getAnnotation(FqName("kotlin.wasm.internal.WasmRefOp"))?.getSingleConstStringArgument()

fun IrAnnotationContainer.getWasmUnaryOpAnnotation(): String? =
    getAnnotation(FqName("kotlin.wasm.internal.WasmUnaryOp"))?.getSingleConstStringArgument()

fun IrAnnotationContainer.getWasmLoadOpAnnotation(): String? =
    getAnnotation(FqName("kotlin.wasm.internal.WasmLoadOp"))?.getSingleConstStringArgument()

fun IrAnnotationContainer.hasWasmReinterpretAnnotation(): Boolean =
    hasAnnotation(FqName("kotlin.wasm.internal.WasmReinterpret"))

@Suppress("UNCHECKED_CAST")
fun IrAnnotationContainer.getWasmImportAnnotation(): WasmImportPair? =
    getAnnotation(FqName("kotlin.wasm.internal.WasmImport"))?.let {
        WasmImportPair(
            (it.getValueArgument(0) as IrConst<String>).value,
            (it.getValueArgument(1) as IrConst<String>).value
        )
    }
