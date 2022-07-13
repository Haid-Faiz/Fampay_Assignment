package com.example.fampayassignment.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackBar(
    message: String,
    length: Int = Snackbar.LENGTH_LONG,
    actionMsg: String? = null,
    action: (() -> Unit)? = null
) {
    Snackbar.make(this, message, length).apply {
        actionMsg?.let {
            setAction(actionMsg) {
                action?.invoke()
            }
        }
        show()
    }
}
