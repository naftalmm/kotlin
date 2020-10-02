/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.incremental.storage

import java.io.File

open class IncrementalFileToPathConverter(val baseDirFile: File) : FileToPathConverter {
    //project root dir
    private val projectDirPath = baseDirFile.absolutePath/*.let { normalize(it)}*/

    override fun toPath(file: File): String {
        val path = file.absolutePath
//        if (file.absolutePath.startsWith(projectDirPath)) {
//            throw IllegalStateException("Path $path is out of project dir $projectDirPath")
//        }
        return when {
            path.startsWith(projectDirPath) -> PROJECT_DIR_PLACEHOLDER + path.substring(projectDirPath.length)
            else -> path
        }
    }

    override fun toFile(path: String): File =
        when {
            path.startsWith(PROJECT_DIR_PLACEHOLDER) -> baseDirFile.resolve(path.substring(PROJECT_DIR_PLACEHOLDER.length))
            else -> File(path)
        }

    private companion object {
        private const val PROJECT_DIR_PLACEHOLDER = "${'$'}PROJECT_DIR$"

//        private fun normalize(filename: String): String {
//            return doNormalize(filename, File.pathSeparator, true)
//        }
//
//        /**
//         * Internal method to perform the normalization.
//         *
//         * @param filename  the filename
//         * @param separator The separator character to use
//         * @param keepSeparator  true to keep the final separator
//         * @return the normalized filename. Null bytes inside string will be removed.
//         */
//        private fun doNormalize(filename: String, separator: String, keepSeparator: Boolean): String {
//            var size = filename.length
//            if (size == 0) {
//                return filename
//            }
//            val prefix: Int = filename.
//            if (prefix < 0) {
//                return null
//            }
//            val array = CharArray(size + 2) // +1 for possible extra slash, +2 for arraycopy
//            filename.toCharArray(array, 0, 0, filename.length)
//
//            // fix separators throughout
//            for (i in array.indices) {
//                    array[i] = separator
//            }
//
//            // add extra separator on the end to simplify code below
//            var lastIsDirectory = true
//            if (array[size - 1] != separator) {
//                array[size++] = separator
//                lastIsDirectory = false
//            }
//
//            // adjoining slashes
//            run {
//                var i = prefix + 1
//                while (i < size) {
//                    if (array[i] == separator && array[i - 1] == separator) {
//                        System.arraycopy(array, i, array, i - 1, size - i)
//                        size--
//                        i--
//                    }
//                    i++
//                }
//            }
//
//            // dot slash
//            var i = prefix + 1
//            while (i < size) {
//                if (array[i] == separator && array[i - 1] == '.' &&
//                    (i == prefix + 1 || array[i - 2] == separator)
//                ) {
//                    if (i == size - 1) {
//                        lastIsDirectory = true
//                    }
//                    System.arraycopy(array, i + 1, array, i - 1, size - i)
//                    size -= 2
//                    i--
//                }
//                i++
//            }
//            var i = prefix + 2
//            outer@ while (i < size) {
//                if (array[i] == separator && array[i - 1] == '.' && array[i - 2] == '.' &&
//                    (i == prefix + 2 || array[i - 3] == separator)
//                ) {
//                    if (i == prefix + 2) {
//                        return null
//                    }
//                    if (i == size - 1) {
//                        lastIsDirectory = true
//                    }
//                    var j: Int
//                    j = i - 4
//                    while (j >= prefix) {
//                        if (array[j] == separator) {
//                            // remove b/../ from a/b/../c
//                            System.arraycopy(array, i + 1, array, j + 1, size - i)
//                            size -= i - j
//                            i = j + 1
//                            i++
//                            continue@outer
//                        }
//                        j--
//                    }
//                    // remove a/../ from a/../c
//                    System.arraycopy(array, i + 1, array, prefix, size - i)
//                    size -= i + 1 - prefix
//                    i = prefix + 1
//                }
//                i++
//            }
//            if (size <= 0) {  // should never be less than 0
//                return ""
//            }
//            if (size <= prefix) {  // should never be less than prefix
//                return String(array, 0, size)
//            }
//            return if (lastIsDirectory && keepSeparator) {
//                String(array, 0, size) // keep trailing separator
//            } else String(array, 0, size - 1)
//            // lose trailing separator
//        }
    }

}