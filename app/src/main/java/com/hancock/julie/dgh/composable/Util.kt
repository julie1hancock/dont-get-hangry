package com.hancock.julie.dgh.composable

fun listenerOrEmpty(listener: () -> Unit, enabled: Boolean): () -> Unit {
    return if (enabled) listener else {{}}
}
