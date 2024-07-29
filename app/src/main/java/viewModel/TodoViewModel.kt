package viewModel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todotask.Todo
import com.example.todotask.dataset
import kotlinx.coroutines.launch


class TodoViewModel : ViewModel() {

    private val _items = MutableLiveData<ArrayList<Todo>>()
    val items: LiveData<ArrayList<Todo>> get() = _items

    fun getItems() {
        val handler = Handler()
        handler.postDelayed({

            _items.value = dataset

        }, 10)
    }

    fun updateItem(todo: Todo) {
        viewModelScope.launch {
            val index = dataset.indexOfFirst { it.name == todo.name }
            if (index != -1) {
                dataset[index] = todo
                _items.value = dataset
            }
        }
    }
}
