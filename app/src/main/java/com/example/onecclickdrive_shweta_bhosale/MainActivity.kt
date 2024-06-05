package com.example.onecclickdrive_shweta_bhosale

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var textBox1: EditText
    private lateinit var textBox2: EditText
    private lateinit var textBox3: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textBox1 = findViewById(R.id.textBox1)
        textBox2 = findViewById(R.id.textBox2)
        textBox3 = findViewById(R.id.textBox3)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            calculateResults()
        }
    }

    private fun calculateResults() {
        val list1 = textBox1.text.toString().split(",").map { it.trim().toInt() }.toSet()
        val list2 = textBox2.text.toString().split(",").map { it.trim().toInt() }.toSet()
        val list3 = textBox3.text.toString().split(",").map { it.trim().toInt() }.toSet()

        val intersection = list1.intersect(list2).intersect(list3).toList().sorted()
        val union = list1.union(list2).union(list3).toList().sorted()
        val highestNumber = union.maxOrNull()

        val resultText = """
            Intersection: ${intersection.joinToString(", ")}
            Union: ${union.joinToString(", ")}
            Highest Number: $highestNumber
        """.trimIndent()

        resultTextView.text = resultText
    }
}