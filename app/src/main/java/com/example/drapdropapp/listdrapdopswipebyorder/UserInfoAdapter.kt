package com.example.drapdropapp.listdrapdopswipebyorder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.drapdropapp.RvAdapter
import com.example.drapdropapp.User
import com.example.drapdropapp.databinding.AdapterItemBinding
import java.util.*

class UserInfoAdapter(private val androidList: MutableList<User>) :
    RecyclerView.Adapter<RvAdapter.ItemViewHolder>(), CustomItemTouchHelperListener {
    override fun getItemCount(): Int {
        return androidList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.ItemViewHolder {
        return RvAdapter.ItemViewHolder(
            AdapterItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RvAdapter.ItemViewHolder, position: Int) {
        val user = androidList[position]
        holder.bindView(user)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        Collections.swap(androidList, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onItemDismiss(position: Int) {
        androidList.removeAt(position)
        notifyItemRemoved(position)
    }
}