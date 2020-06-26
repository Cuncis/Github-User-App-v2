package com.cuncisboss.githubuserappv2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cuncisboss.githubuserappv2.R
import com.cuncisboss.githubuserappv2.model.UserGithub
import com.cuncisboss.githubuserappv2.util.ImageHelper.Companion.getImageFromDrawable
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(val context: Context, val itemClickListener: ItemClickListener): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var userList = arrayListOf<UserGithub>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    fun setUserList(newUser: List<UserGithub>) {
        userList.clear()
        userList.addAll(newUser)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val tvName: TextView = view.tv_name
        private val tvRepo: TextView = view.tv_repo
        private val tvFollower: TextView = view.tv_follower
        private val tvFollowing: TextView = view.tv_following
        private val imgPhoto: CircleImageView = view.img_profil

        fun bind(userGithub: UserGithub) {
            tvName.text = userGithub.username
            tvRepo.text = String.format(context.getString(R.string.repo_value), userGithub.repository)
            tvFollower.text = String.format(context.getString(R.string.value_fol), userGithub.follower)
            tvFollowing.text = String.format(context.getString(R.string.value_fol), userGithub.following)
            imgPhoto.getImageFromDrawable(userGithub.avatar)

            itemView.setOnClickListener {
                itemClickListener.onItemClick(userGithub)
            }
        }
    }

    interface ItemClickListener {
        fun onItemClick(userGithub: UserGithub)
    }

}