package com.sfera.peoplefilter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sfera.peoplefilter.R
import com.sfera.peoplefilter.User
import com.sfera.peoplefilter.databinding.RvItemUserBinding

class UserListAdapter(private val usersList: ArrayList<User>) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    class UserViewHolder(
        item: View
    ) : RecyclerView.ViewHolder(item) {

        private val binding = RvItemUserBinding.bind(item)
        fun bind(user: User) {
            binding.apply {
                rvName.text = user.name
                rvAge.text = user.age.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_user, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val userPosition = usersList[position]
        holder.bind(userPosition)
    }

    override fun getItemCount(): Int = usersList.size
}