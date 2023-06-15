package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.calculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var input: String = ""
    private var number1: Double = 0.0
    private var number2: Double = 0.0
    private var operator: String = ""
    private var calculated: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonAC.setOnClickListener {
            binding.textViewResult.text = ""
            binding.textViewResult.text = ""
        }
        
        binding.buttonC.setOnClickListener {
            val removedLast = binding.textViewResult.text.toString().dropLast(1)
            binding.textViewResult.text = removedLast
        }

        binding.button0.setOnClickListener {
            binding.textViewResult.text = addToInputText("0")
        }
        binding.button1.setOnClickListener {
            binding.textViewResult.text = addToInputText("1")
        }
        binding.button2.setOnClickListener {
            binding.textViewResult.text = addToInputText("2")
        }
        binding.button3.setOnClickListener {
            binding.textViewResult.text = addToInputText("3")
        }
        binding.button4.setOnClickListener {
            binding.textViewResult.text = addToInputText("4")
        }
        binding.button5.setOnClickListener {
            binding.textViewResult.text = addToInputText("5")
        }
        binding.button6.setOnClickListener {
            binding.textViewResult.text = addToInputText("6")
        }
        binding.button7.setOnClickListener {
            binding.textViewResult.text = addToInputText("7")
        }
        binding.button8.setOnClickListener {
            binding.textViewResult.text = addToInputText("8")
        }
        binding.button9.setOnClickListener {
            binding.textViewResult.text = addToInputText("9")
        }
        binding.buttonCham.setOnClickListener {
            binding.textViewResult.text = addToInputText(".")
        }
        binding.buttonChia.setOnClickListener {
            binding.textViewResult.text = addToInputText("÷") // ALT + 0247
        }
        binding.buttonNhan.setOnClickListener {
            binding.textViewResult.text = addToInputText("×") // ALT + 0215
        }

        binding.buttonTru.setOnClickListener {
            binding.textViewResult.text = addToInputText("-")
        }
        binding.buttonCong.setOnClickListener {
            binding.textViewResult.text = addToInputText("+")
        }

        binding.buttonBang.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {

        return binding.textViewResult.text.toString() + "" + buttonValue
    }

    private fun getInputExpression(): String {
        var expression = binding.textViewResult.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                binding.textViewResult.text = ""
                } else {
                // Show Result
                binding.textViewResult.text = DecimalFormat("0.######").format(result).toString()
                
                }
        } catch (e: Exception) {
            // Show Error Message
            binding.textViewResult.text = ""
            }
    }
}
