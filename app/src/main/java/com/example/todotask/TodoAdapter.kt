package com.example.todotask

import SharedPrefHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    var dataset: ArrayList<Todo>,
    private val listener: ItemClickListener

    ) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val todoName: TextView
        val todoDescription: TextView
        val todoTime: TextView

        init {
            todoName = view.findViewById(R.id.tv_todoTask_name)
            todoDescription = view.findViewById(R.id.tv_todoTask_details)
            todoTime = view.findViewById(R.id.tv_todoTask_time)
        }
    }


    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.todo_task_layout, viewGroup, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(
        viewHolder: ViewHolder,
        position: Int
    ) {
        val todo = dataset[position]
        viewHolder.todoName.text = todo.name
        viewHolder.todoDescription.text = todo.details
        viewHolder.todoTime.text = todo.time


//        viewHolder.itemView.findViewById<ImageButton>(R.id.btn_delete).setOnClickListener {
//            dataset.removeAt(position)
//            notifyItemRemoved(position)
//            notifyItemRangeChanged(position, dataset.size)
//        }

        viewHolder.itemView.findViewById<ImageButton>(R.id.btn_delete).setOnClickListener {
            listener.onItemDelete(todo)
        }

        viewHolder.itemView.setOnClickListener {
            listener.onItemClick(todo)
        }
    }


    override fun getItemCount(): Int {
        return dataset.size
    }

    interface ItemClickListener {
        fun onItemClick(todo: Todo)
        fun onItemDelete(todo: Todo)
    }

}



