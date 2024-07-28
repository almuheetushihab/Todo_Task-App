package com.example.todotask

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todotask.databinding.FragmentTodoTaskBinding

class TodoTask : Fragment(), TodoAdapter.ItemClickListener {
    private val viewModel: TodoTaskViewModel by viewModels()
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var binding: FragmentTodoTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoTaskBinding.inflate(inflater, container, false)
        return binding.root
    }
}