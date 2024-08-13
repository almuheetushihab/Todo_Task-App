import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todotask.Todo
import com.example.todotask.dataset

class TodoViewModel : ViewModel() {
    private lateinit var sharedPrefHelper: SharedPrefHelper

    private val _items = MutableLiveData<ArrayList<Todo>>()
    val items: LiveData<ArrayList<Todo>> get() = _items


    fun getData(context: Context) {
        sharedPrefHelper = SharedPrefHelper(context)
        if (!dataset.isEmpty()) {
            sharedPrefHelper.saveTask(dataset)

        }
        val tasks = sharedPrefHelper.getTasks()
        _items.value = tasks as ArrayList<Todo>
        dataset.clear()
        dataset.addAll(tasks)
    }

    fun saveData(context: Context) {
        sharedPrefHelper = SharedPrefHelper(context)
        sharedPrefHelper.saveTask(dataset)
    }

    fun clearData(context: Context) {
        sharedPrefHelper = SharedPrefHelper(context)
        sharedPrefHelper.clearAllData()
    }



}