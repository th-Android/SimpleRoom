package si.um.feri.simpleroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.*
import si.um.feri.simpleroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coroutineScope.launch {
            AppDatabase.getDatabase(this@MainActivity).userDao()
                .insertAll(User(0, "Janez", "Novak"))
        }

        coroutineScope.launch {
            Log.d("baza", AppDatabase.getDatabase(this@MainActivity).userDao().getAll().toString())
        }
    }
}
