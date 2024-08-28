package com.example.todotask

import SharedPrefHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.todotask.databinding.TodoTaskLayoutBinding

class TodoAdapter(
    var dataset: ArrayList<Todo>,
    private val listener: ItemClickListener

) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    class ViewHolder(val binding: TodoTaskLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding =
            TodoTaskLayoutBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }


    override fun onBindViewHolder(
        viewHolder: ViewHolder,
        position: Int
    ) {
        val todo = dataset[position]
        viewHolder.binding.tvTodoTaskName.text = todo.name
        viewHolder.binding.tvTodoTaskDetails.text = todo.details
        viewHolder.binding.tvTodoTaskTime.text = todo.time


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



