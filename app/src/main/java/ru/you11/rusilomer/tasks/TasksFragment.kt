package ru.you11.rusilomer.tasks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import ru.you11.rusilomer.R
import ru.you11.rusilomer.base.BaseFragment
import ru.you11.rusilomer.databinding.FragmentTasksBinding

class TasksFragment: BaseFragment<TasksViewModel>() {

    lateinit var binding: FragmentTasksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tasks, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.apply {
            tasksRv.adapter = TasksRVAdapter(onTaskClick = { points ->
                onTaskClick(points)
            })
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (binding.tasksRv.adapter as TasksRVAdapter).updateData(viewModel.getTasksData())
    }

    override fun createViewModel(): TasksViewModel {
        return ViewModelProviders.of(this).get(TasksViewModel::class.java)
    }

    private fun onTaskClick(points: Int) {
        viewModel.addPoints(points)
    }
}