package com.cuncisboss.githubuserappv2.ui.detail.foll

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cuncisboss.githubuserappv2.R
import com.cuncisboss.githubuserappv2.adapter.UserFollAdapter
import com.cuncisboss.githubuserappv2.ui.detail.DetailUserActivity
import com.cuncisboss.githubuserappv2.util.Utils.Companion.hideLoadingBar
import com.cuncisboss.githubuserappv2.util.Utils.Companion.showLoadingBar
import kotlinx.android.synthetic.main.fragment_follower.*
import kotlinx.android.synthetic.main.fragment_follower.view.*


class FollowerFragment : Fragment(R.layout.fragment_follower) {

    lateinit var follViewModel: FollViewModel
    lateinit var userFollAdapter: UserFollAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userFollAdapter = UserFollAdapter()
        follViewModel = ViewModelProvider(requireActivity()).get(FollViewModel::class.java)
        view.rv_followers.adapter = userFollAdapter

        val act = activity as DetailUserActivity
        follViewModel.getFollowers(act.getUsername().toString()).observe(viewLifecycleOwner, Observer { followers ->
            userFollAdapter.setFollList(followers)
        })
        follViewModel.onLoading().observe(viewLifecycleOwner, Observer { loading ->
            if (loading) {
                progressBar.showLoadingBar(requireActivity())
            } else {
                progressBar.hideLoadingBar(requireActivity())
            }
        })
        follViewModel.getMessage().observe(viewLifecycleOwner, Observer { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        })
    }
}