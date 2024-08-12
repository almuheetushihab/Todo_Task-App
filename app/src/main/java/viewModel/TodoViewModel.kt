import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todotask.Todo
import com.example.todotask.dataset

class TodoViewModel : ViewModel() {


    private val _items = MutableLiveData<ArrayList<Todo>>()
    val items: LiveData<ArrayList<Todo>> get() = _items

    init {
        _items.value = ArrayList(dataset)
    }
    fun setTasks(tasks: ArrayList<Todo>) {
        _items.value = tasks
    }

    fun addItem(item: Todo) {
        val currentList = _items.value ?: ArrayList()
        currentList.add(item)
        _items.value = currentList
        Log.d("TAG", "addItem: $currentList")
    }

}