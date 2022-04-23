package com.example.drapdropapp.listdrapdopswipebyorder

interface CustomItemTouchHelperListener {
    fun onItemMove(fromPosition: Int, toPosition: Int): Boolean
    fun onItemDismiss(position: Int)
}