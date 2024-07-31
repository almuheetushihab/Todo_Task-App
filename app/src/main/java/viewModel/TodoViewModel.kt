package viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todotask.Todo
import com.example.todotask.dataset

class TodoViewModel : ViewModel() {
    private val _items = MutableLiveData<ArrayList<Todo>>()
    val items: LiveData<ArrayList<Todo>> get() = _items

    init {
        _items.value = dataset
    }


}
