package com.example.todotask

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todotask.databinding.FragmentTodoTaskBinding


class TodoTask : Fragment(), TodoAdapter.ItemClickListener {
    private lateinit var adapter: TodoAdapter
    private lateinit var binding: FragmentTodoTaskBinding
//    private val viewModel: TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
        ) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = binding.todoTaskRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        viewModel.getItems()
//        viewModel.items.observe(viewLifecycleOwner, Observer {
//            adapter = TodoAdapter(it, this)
//            recyclerView.adapter = adapter
//        })









//        val viewModel: TodoViewModel by viewModels()
//        viewModel.getItems()
//
//        viewModel.items.observe(viewLifecycleOwner, Observer {
//            recyclerView.adapter = adapter
//        })

//        val viewModel: TodoViewModel by viewModels()
//        viewModel.items.observe(viewLifecycleOwner, Observer {
//            recyclerView.adapter = adapter
//
//        })






        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = TodoAdapter(dataset, this)
        recyclerView.adapter = adapter


    }

    override fun onItemClick(todo: Todo) {
    }
}