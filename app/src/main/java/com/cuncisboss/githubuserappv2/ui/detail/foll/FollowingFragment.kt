package com.cuncisboss.githubuserappv2.ui.detail.foll

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cuncisboss.githubuserappv2.R
import com.cuncisboss.githubuserappv2.adapter.UserFollAdapter
import com.cuncisboss.githubuserappv2.ui.detail.DetailUserActivity
import com.cuncisboss.githubuserappv2.util.Utils.Companion.hideLoadingBar
import com.cuncisboss.githubuserappv2.util.Utils.Companion.showLoadingBar
import kotlinx.android.synthetic.main.fragment_following.*
import kotlinx.android.synthetic.main.fragment_following.view.*


class FollowingFragment : Fragment(R.layout.fragment_following) {

    lateinit var follViewModel: FollViewModel
    lateinit var userFollAdapter: UserFollAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userFollAdapter = UserFollAdapter()
        follViewModel = ViewModelProvider(requireActivity()).get(FollViewModel::class.java)
        view.rv_following.adapter = userFollAdapter
        val act = activity as DetailUserActivity

        follViewModel.getFollowing(act.getUsername().toString()).observe(viewLifecycleOwner, Observer { following ->
            userFollAdapter.setFollList(following)
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