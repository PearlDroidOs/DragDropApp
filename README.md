# DragDropSwipeApp

This examples are about drag droop and swipe an item in list


```
Sample 1: Drag Listener

textView.setOnLongClickListener { v: View ->
        val item = ClipData.Item(v.tag as? CharSequence)

        val dragData = ClipData(
              v.tag as CharSequence,
              arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
              item
        )

        val myShadow = MyDragShadowBuilder(v)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
              v.startDragAndDrop(dragData, myShadow, null, 0)
        } else {
              v.startDrag(dragData, myShadow, null, 0)
        }
}

textView2.setOnDragListener(dragListen)



private val dragListen = View.OnDragListener { v, event ->
        val receiverView: TextView = v as TextView

        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                // Start drag
            }

            DragEvent.ACTION_DRAG_ENTERED -> {
                // In target
                true
            }

            DragEvent.ACTION_DRAG_LOCATION ->
                true

            DragEvent.ACTION_DRAG_EXITED -> {
                // come to target and out exited
                true
            }

            DragEvent.ACTION_DROP -> {
                // when drop
                true
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                // End action
                true
            }

            else -> {
                // An unknown action type was received.
                false
            }
        }
    }
```

```
Simple 2: ItemTouchHelper
class CustomItemTouchHelperCallback(private var listener: CustomItemTouchHelperListener) :
    ItemTouchHelper.Callback() {

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        // Set flags into dragFlags and swipeFlags
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        source: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        // do something when an item's moved
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        // do something when swiped
    }
}
```

Example Result
<img width="387" alt="Screen Shot 2565-04-23 at 20 59 05" src="https://user-images.githubusercontent.com/62892558/164909122-90434aff-3860-4143-87bf-862ae8991d9a.png">

