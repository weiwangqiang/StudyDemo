package com.other

import kotlinx.serialization.Serializable

@Serializable
data class Data(val a: Int, val str: String = "str")