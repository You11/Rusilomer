package ru.you11.rusilomer.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.you11.rusilomer.base.BaseViewModel
import ru.you11.rusilomer.model.Task

class TasksViewModel: BaseViewModel() {

    private var _totalPoints = MutableLiveData<Int>()
    val totalPoints: LiveData<Int> = _totalPoints

    fun addPoints(points: Int) {
        val currentPoints = _totalPoints.value ?: 0
        _totalPoints.value = currentPoints + points
    }

    fun getTasksData(): ArrayList<Task> {
        val data = ArrayList<Task>()
        data.add(Task("Отжимание", 10))
        data.add(Task("Подтягивание", 20))
        return data
    }
}