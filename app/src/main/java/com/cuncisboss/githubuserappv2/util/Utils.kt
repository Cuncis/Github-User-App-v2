package com.cuncisboss.githubuserappv2.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

class Utils {
    companion object {

        fun View.showLoading() {
            visibility = View.VISIBLE
        }

        fun View.hideLoading() {
            visibility = View.GONE
        }

        fun View.showLoadingBar(act: Activity) {
            visibility = View.VISIBLE
            act.window.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            hideKeyboard()
        }

        fun View.hideLoadingBar(act: Activity) {
            visibility = View.GONE
            act.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }

        fun View.hideKeyboard() {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }

    }
}