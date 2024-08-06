import android.content.Context
import android.content.SharedPreferences
import com.example.todotask.Todo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPrefHelper(context: Context) {
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences("TodoSharedPref", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPref.edit()
    private val key = "tasks"

    fun saveTask(tasks: ArrayList<Todo>) {
        val gson = Gson()
        val tasksJson = gson.toJson(tasks)
        editor.putString(key, tasksJson)
        editor.apply()
    }



    fun getTasks(): List<Todo> {
        val tasksJson = sharedPref.getString(key, null)
        val type = object : TypeToken<List<Todo>>() {}.type
        return Gson().fromJson(tasksJson, type) ?: emptyList()
    }
}



