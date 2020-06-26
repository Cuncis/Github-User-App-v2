package com.cuncisboss.githubuserappv2.ui.detail

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cuncisboss.githubuserappv2.R
import com.cuncisboss.githubuserappv2.adapter.ViewPagerAdapter
import com.cuncisboss.githubuserappv2.model.UserGithub
import com.cuncisboss.githubuserappv2.util.Constants
import com.cuncisboss.githubuserappv2.util.ImageHelper.Companion.getImageFromDrawable
import com.cuncisboss.githubuserappv2.util.ImageHelper.Companion.getImageFromUrl
import com.cuncisboss.githubuserappv2.util.Utils.Companion.hideLoadingBar
import com.cuncisboss.githubuserappv2.util.Utils.Companion.showLoadingBar
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUserActivity : AppCompatActivity() {

    private lateinit var detailUserViewModel: DetailUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailUserViewModel = ViewModelProvider(this).get(DetailUserViewModel::class.java)

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        tabs.setupWithViewPager(viewPager)

        if (intent.hasExtra(Constants.EXTRA_USER)) {
            val user = intent?.getParcelableExtra<UserGithub>(Constants.EXTRA_USER)
            title = user?.username

            observeViewModel(user?.username!!)
        }
    }

    fun getUsername(): String? {
        val user = intent?.getParcelableExtra<UserGithub>(Constants.EXTRA_USER)
        return user?.username
    }

    private fun observeViewModel(username: String) {
        detailUserViewModel.getDetailUser(username).observe(this, Observer { response ->
            tv_follower.text = response.followers.toString()
            tv_following.text = response.following.toString()
            img_profil.getImageFromUrl(response.avatarUrl)
        })
//        detailUserViewModel.onLoading().observe(this, Observer { loading ->
//            if (loading) {
//                layout_progressBar.showLoadingBar(this)
//            } else {
//                layout_progressBar.hideLoadingBar(this)
//            }
//        })
//        detailUserViewModel.getMessage().observe(this, Observer { message ->
//            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//        })
    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}