package com.example.calcapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.calcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 개선할 내용
            // 1. 계산한 값이 0으로 나올 경우, 새로운 숫자 입력시 0이 포함되어있음
            // 2. 0으로 계산을 시작할 수 있도록 되어있음 01, 02 ...
            // 3. ++, -- 등 산술연산자가 중복입력 가능하도록 되어있음
            // 4. 중복되는 코드가 많아보임


        /* 0으로 입력을 시작할 경우 경고 다이얼로그 표시하도록 코딩하였으나, 구현되지 않음
           왜 구현되지 않는지 생각해보자.. */
//        if (binding.resultTxt.text == "0") {
//            val builder = AlertDialog.Builder(this)
//            builder.setTitle("경고")
//            builder.setMessage("0으로 시작할 수 없습니다.")
//            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
//                ceBtn()
//            }
//            builder.show()
//        }

        binding.btn0.setOnClickListener {
            numberBtn("0")
        }
        binding.btn1.setOnClickListener {
            numberBtn("1")
        }
        binding.btn2.setOnClickListener {
            numberBtn("2")
        }
        binding.btn3.setOnClickListener {
            numberBtn("3")
        }
        binding.btn4.setOnClickListener {
            numberBtn("4")
        }
        binding.btn5.setOnClickListener {
            numberBtn("5")
        }
        binding.btn6.setOnClickListener {
            numberBtn("6")
        }
        binding.btn7.setOnClickListener {
            numberBtn("7")
        }
        binding.btn8.setOnClickListener {
            numberBtn("8")
        }
        binding.btn9.setOnClickListener {
            numberBtn("9")
        }
        // ++, -- 처럼 산술연산자들을 두번씩 사용할 수 없도록 제한해보자..
        binding.plusBtn.setOnClickListener {
            numberBtn("+")
        }
        binding.minusBtn.setOnClickListener {
            numberBtn("-")
        }
        binding.multiplyBtn.setOnClickListener {
            numberBtn("×")
        }
        binding.divisionBtn.setOnClickListener {
            numberBtn("÷")
        }
        binding.clearEntryBtn.setOnClickListener {
            ceBtn()
        }


        binding.equalBtn.setOnClickListener {

            val splitNum = binding.resultTxt.text.split("+", "-", "×", "÷")

            /* 산술연산자 구현하기
               중복되는 코드가 많이보인다 정리해보자.. */
            if (binding.resultTxt.text.contains("+")) {
                val toInt = splitNum[0].toInt() + splitNum[1].toInt()
                val toString = toInt.toString()
                binding.resultTxt.text = toString
            }

            if (binding.resultTxt.text.contains("-")) {
                val toInt = splitNum[0].toInt() - splitNum[1].toInt()
                val toString = toInt.toString()
                binding.resultTxt.text = toString
            }

            if (binding.resultTxt.text.contains("×")) {
                val toInt = splitNum[0].toInt() * splitNum[1].toInt()
                val toString = toInt.toString()
                binding.resultTxt.text = toString
            }

            if (binding.resultTxt.text.contains("÷")) {
                val toInt = splitNum[0].toInt() / splitNum[1].toInt()
                val toString = toInt.toString()
                binding.resultTxt.text = toString
            }

        }

        binding.clearAllBtn.setOnClickListener {
            binding.resultTxt.text = ""
        }

    }

    fun numberBtn(number: String) {
        binding.resultTxt.append(number)
    }

    fun ceBtn() {
        val a = binding.resultTxt.text.substring(0, binding.resultTxt.text.length - 1)
        binding.resultTxt.text = a
    }

}