package ru.you11.rusilomer.tasks

import androidx.recyclerview.widget.RecyclerView
import ru.you11.rusilomer.databinding.ItemTaskBinding
import ru.you11.rusilomer.model.Task

class TaskViewHolder(private val binding: ItemTaskBinding,
                     private val onTaskClick: (points: Int) -> Unit): RecyclerView.ViewHolder(binding.root) {

    fun bind(task: Task) {
        binding.task = task
        binding.viewHolder = this
        binding.executePendingBindings()
    }

    fun onTaskClick() {
        val task = binding.task ?: return
        task.timesCompleted += 1
        binding.task = task
        onTaskClick.invoke(task.points)
    }
}