import android.content.Context
import android.content.SharedPreferences
import com.example.todotask.Todo
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson

class SharedPrefHelper(context: Context) {
    private val sharedPref: SharedPreferences = context.getSharedPreferences("TodoSharedPref", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPref.edit()
    private val gson = Gson()
    private val key = "tasks"


    fun saveTask(tasks: List<Todo>) {
        val json = gson.toJson(tasks)
        editor.putString(key, json)
        editor.apply()
    }


    fun getTasks(): List<Todo> {
        val json = sharedPref.getString(key, null) ?: return emptyList()
        val type = object : TypeToken<List<Todo>>() {}.type
        return gson.fromJson(json, type)
    }
}
