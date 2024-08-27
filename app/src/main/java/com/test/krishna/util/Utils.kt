package com.test.krishna.util

import android.content.Context
import android.widget.Toast

fun Context.toast(msg : String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}