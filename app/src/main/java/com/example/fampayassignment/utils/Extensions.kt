package com.example.fampayassignment.utils

import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
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

val customTab: CustomTabsIntent by lazy {
    CustomTabsIntent.Builder().build()
}

fun View.openUrl(url: String?) {
    rootView.setOnClickListener {
        customTab.launchUrl(
            rootView.context,
            url?.toUri() ?: "www.google.com".toUri()
        )
    }
}
