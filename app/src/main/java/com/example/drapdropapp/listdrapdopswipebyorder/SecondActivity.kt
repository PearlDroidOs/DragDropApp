package com.example.drapdropapp.listdrapdropbyinorder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.drapdropapp.User
import com.example.drapdropapp.databinding.ActivitySecondBinding
import com.example.drapdropapp.listdrapdopswipebyorder.CustomItemTouchHelperCallback
import com.example.drapdropapp.listdrapdopswipebyorder.UserInfoAdapter

/**
 * Ref
 * https://akexorcist.dev/item-touch-helper-in-recycler-view/
 */
class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() = with (binding) {
        val adapter = UserInfoAdapter(getUsers())
//        recyclerview2.layoutManager = LinearLayoutManager(this@SecondActivity)
        recyclerview2.layoutManager = GridLayoutManager(this@SecondActivity, 2)
        recyclerview2.adapter = adapter
        val callback = CustomItemTouchHelperCallback(adapter)
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerview2)
    }

    private fun getUsers() : MutableList<User>{
        val users = mutableListOf<User>()
        users.add(User("Peter","London",35))
        users.add(User("Jame","Paris",32))
        users.add(User("Luk","Bangkok",23))
        users.add(User("Pare","New York",45))
        users.add(User("Sara","Rome",27))
        return users
    }
}