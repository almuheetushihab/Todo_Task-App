package com.example.todotask

import SharedPrefHelper
import TodoViewModel
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todotask.databinding.FragmentTodoTaskBinding


class TodoTaskFragment : Fragment(), TodoAdapter.ItemClickListener {
    private lateinit var adapter: TodoAdapter
    private lateinit var binding: FragmentTodoTaskBinding
    private val viewModel: TodoViewModel by viewModels()
    private lateinit var sharedPrefHelper: SharedPrefHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoTaskBinding.inflate(inflater, container, false)
        sharedPrefHelper = SharedPrefHelper(requireContext())
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = binding.todoTaskRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        viewModel.items.observe(viewLifecycleOwner, Observer {
            adapter = TodoAdapter(it, this)
            recyclerView.adapter = adapter
        })


        binding.btnAdd.setOnClickListener {
            val action =
                TodoTaskFragmentDirections.actionTodoTaskFragmentNavIdToAddTaskFragmentNavId()
            findNavController().navigate(action)
        }

    }

    override fun onItemClick(todo: Todo) {
        Log.d("Log404", "onItemClick: $todo")
        val action =
            TodoTaskFragmentDirections.actionTodoTaskFragmentNavIdToUpdateTaskFragmentNavId(todo)
        findNavController().navigate(action)
    }

    override fun onResume() {
        super.onResume()

        val tasks = sharedPrefHelper.getTasks()
        Toast.makeText(this.context, "getTasks: $tasks", Toast.LENGTH_LONG).show()
        adapter = TodoAdapter(dataset, this)
        binding.todoTaskRecyclerView.adapter = adapter

        


    }

    override fun onPause() {
        super.onPause()
        val tasks = adapter.dataset
        sharedPrefHelper.saveTask(tasks)

        Toast.makeText(this.context, "saveTask: $tasks", Toast.LENGTH_LONG).show()


    }
}