package com.edmarsoft.nyethack.extensions

fun <T> Iterable<T>.random(): T = this.shuffled().first()