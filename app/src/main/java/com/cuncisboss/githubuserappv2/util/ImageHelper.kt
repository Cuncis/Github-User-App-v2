package com.cuncisboss.githubuserappv2.util

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cuncisboss.githubuserappv2.R

class ImageHelper {
    companion object {
        fun ImageView.getImageFromDrawable(avatar: String) {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
            val path = Uri.parse("android.resource://com.cuncisboss.githubuserappv2/${avatar.replace("@", "")}")
            Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(path)
                .into(this)
        }

        fun ImageView.getImageFromUrl(avatar: String) {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
            Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(avatar)
                .into(this)
        }
    }
}