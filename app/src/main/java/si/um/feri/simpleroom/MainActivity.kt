package si.um.feri.simpleroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coroutineScope.launch {
            AppDatabase.getDatabase(this@MainActivity).userDao()
                .insertAll(User(0, "Janez", "Novak"))
        }

        coroutineScope.launch {
            Log.d("baza", AppDatabase.getDatabase(this@MainActivity).userDao().getAll().toString())
        }
    }
}
