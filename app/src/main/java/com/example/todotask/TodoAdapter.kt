package com.example.todotask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todotask.databinding.FragmentTodoTaskBinding

class TodoAdapter(
    private val dataset: ArrayList<Todo>,
    private val listener: ItemClickListener,
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
        holder: ViewHolder,
        position: Int
    ) {
//        val todo = dataset[position]
//        holder.todoName.text = todo.name
//        holder.todoDescription.text = todo.details
//        holder.todoTime.text = todo.time

    }


    override fun getItemCount(): Int {
        return dataset.size
    }


    interface ItemClickListener {
        fun onItemClick(todo: Todo)

    }
}



