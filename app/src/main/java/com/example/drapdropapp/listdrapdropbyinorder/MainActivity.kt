package com.example.drapdropapp.listdrapdropbyinorder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.RecyclerView
import com.example.drapdropapp.RvAdapter
import com.example.drapdropapp.User
import com.example.drapdropapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerviewAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            itemTouchHelper.attachToRecyclerView(recyclerview)
            recyclerviewAdapter = RvAdapter()
            recyclerviewAdapter.differ.submitList(getUsers())
            recyclerview.layoutManager = GridLayoutManager(this@MainActivity, 2)
            recyclerview.adapter = recyclerviewAdapter
        }
    }

    private val itemTouchHelper by lazy {
        val itemTouchCallback =
            object : ItemTouchHelper.SimpleCallback(UP or DOWN or START or END, 0) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    val recyclerviewAdapter = recyclerView.adapter as RvAdapter
                    val fromPosition = viewHolder.adapterPosition
                    val toPosition = target.adapterPosition
                    recyclerviewAdapter.moveItem(fromPosition, toPosition)
                    recyclerviewAdapter.notifyItemMoved(fromPosition,toPosition)
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                }

                override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                    super.onSelectedChanged(viewHolder, actionState)
                    if(actionState == ACTION_STATE_DRAG) {
                        viewHolder?.itemView?.scaleY = 1.1f
                        viewHolder?.itemView?.scaleX = 1.1f
                        viewHolder?.itemView?.alpha = 0.8f

                    }
                }

                override fun clearView(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder
                ) {
                    super.clearView(recyclerView, viewHolder)
                    viewHolder.itemView.scaleY = 1.0f
                    viewHolder.itemView.scaleX = 1.0f
                    viewHolder.itemView.alpha = 1.0f
                }
            }
        ItemTouchHelper(itemTouchCallback)
    }

    private fun getUsers() : List<User>{
        val users = mutableListOf<User>()
        users.add(User("Peter","London",35))
        users.add(User("Jame","Paris",32))
        users.add(User("Luk","Bangkok",23))
        users.add(User("Pare","New York",45))
        users.add(User("Sara","Rome",27))
        return users
    }
}