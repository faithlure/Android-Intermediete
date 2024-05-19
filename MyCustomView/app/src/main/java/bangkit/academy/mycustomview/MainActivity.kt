package bangkit.academy.mycustomview


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var button: MyButton
    private lateinit var editText: MyEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.my_button)
        editText= findViewById(R.id.my_edit_text)

        setMyButtonEnable()

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {
            }
        })
        button.setOnClickListener { Toast.makeText(this@MainActivity, editText.text, Toast.LENGTH_SHORT).show() }

    }

    private fun setMyButtonEnable(){
        val result = editText.text
        button.isEnabled = result != null && result.toString().isNotEmpty()
    }
}