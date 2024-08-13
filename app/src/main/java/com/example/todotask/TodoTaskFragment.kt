package com.example.todotask

import SharedPrefHelper
import TodoViewModel
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todotask.databinding.FragmentTodoTaskBinding


class TodoTaskFragment : Fragment(), TodoAdapter.ItemClickListener {
    private lateinit var adapter: TodoAdapter
    private lateinit var binding: FragmentTodoTaskBinding
    private lateinit var sharedPrefHelper: SharedPrefHelper
    private val viewModel: TodoViewModel by viewModels()


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

        binding.includeLayout.toolbarTitle.text = "Todo Task"
        binding.includeLayout.backButton.visibility = View.GONE

        val recyclerView: RecyclerView = binding.todoTaskRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.items.observe(viewLifecycleOwner, Observer { newTasks ->
            adapter = TodoAdapter(newTasks, this)
            recyclerView.adapter = adapter
        })

        binding.btnAdd.setOnClickListener {
            val action =
                TodoTaskFragmentDirections.actionTodoTaskFragmentNavIdToAddTaskFragmentNavId()
            findNavController().navigate(action)
        }

    }

    override fun onItemClick(todo: Todo) {
        val action =
            TodoTaskFragmentDirections.actionTodoTaskFragmentNavIdToUpdateTaskFragmentNavId(todo)
        findNavController().navigate(action)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getData(requireContext())
    }


    override fun onPause() {
        super.onPause()
        viewModel.clearData(requireContext())
        viewModel.saveData(requireContext())
    }

    override fun onItemDelete(todo: Todo) {

    }
}