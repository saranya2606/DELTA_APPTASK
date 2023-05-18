package com.example.afinal
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.graphics.Color
import android.text.Editable
import android.widget.ImageView
import com.example.afinal.DataHolder.score
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.DialogFragment

var highscore=0

// Create a custom dialog class that extends Dialog
class CustomDialog(context: Context) : Dialog(context) {
    // Set the XML layout file to the dialog view
    fun setDialogContent(layoutResId: Int) {
        setContentView(layoutResId)
    }
}

object DataHolder {
    var score: Int = 0
}

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



        var button1 = findViewById<Button>(R.id.btn11)
        var button2 = findViewById<Button>(R.id.btn12)
        var button3 = findViewById<Button>(R.id.btn13)
        var button4 = findViewById<Button>(R.id.btn14)
        var button5 = findViewById<Button>(R.id.btn21)
        var button6 = findViewById<Button>(R.id.btn22)
        var button7 = findViewById<Button>(R.id.btn23)
        var button8 = findViewById<Button>(R.id.btn24)
        var button9 = findViewById<Button>(R.id.btn31)
        var button10 = findViewById<Button>(R.id.btn32)
        var button11 = findViewById<Button>(R.id.btn33)
        var button12 = findViewById<Button>(R.id.btn34)
        var button13 = findViewById<Button>(R.id.btn41)
        var button14 = findViewById<Button>(R.id.btn42)
        var button15 = findViewById<Button>(R.id.btn43)
        var button16 = findViewById<Button>(R.id.btn44)

        var letters = arrayOf<String>()
        val letterlist = letters.toMutableList()


        fun random(): String {
            var a = ('A'..'Z').random()
            var b = a.toString()
            return b
        }


        for (i in 0 until (16 - inputword.length)) {
            val randomLetter = random()
            letterlist.add(randomLetter)
            letters = letterlist.toTypedArray()
        }

        for (i in inputword.uppercase()) {
            letterlist.add(i.toString())
            letters = letterlist.toTypedArray()
        }

        letters.shuffle()
        button1.text = letters[0]
        button2.text = letters[1]
        button3.text = letters[2]
        button4.text = letters[3]
        button5.text = letters[4]
        button6.text = letters[5]
        button7.text = letters[6]
        button8.text = letters[7]
        button9.text = letters[8]
        button10.text = letters[9]
        button11.text = letters[10]
        button12.text = letters[11]
        button13.text = letters[12]
        button14.text = letters[13]
        button15.text = letters[14]
        button16.text = letters[15]

        val buttons = arrayOf(
            button1,
            button2,
            button3,
            button4,
            button5,
            button6,
            button7,
            button8,
            button9,
            button10,
            button11,
            button12,
            button13,
            button14,
            button15,
            button16
        )

        for (button in buttons)(
                button.setBackgroundColor(Color.parseColor("#D4A0DF"))
                )

        val l1 = findViewById<EditText>(R.id.etletter1)
        val l2 = findViewById<EditText>(R.id.etletter2)
        val l3 = findViewById<EditText>(R.id.etletter3)
        val l4 = findViewById<EditText>(R.id.etletter4)
        val l5 = findViewById<EditText>(R.id.etletter5)
        val l6 = findViewById<EditText>(R.id.etletter6)
        val l7 = findViewById<EditText>(R.id.etletter7)
        val l8 = findViewById<EditText>(R.id.etletter8)
        val l9 = findViewById<EditText>(R.id.etletter9)
        val l10 = findViewById<EditText>(R.id.etletter10)
        val l11 = findViewById<EditText>(R.id.etletter11)
        val l12 = findViewById<EditText>(R.id.etletter12)
        val l13 = findViewById<EditText>(R.id.etletter13)
        val l14 = findViewById<EditText>(R.id.etletter14)
        val l15 = findViewById<EditText>(R.id.etletter15)
        val l16 = findViewById<EditText>(R.id.etletter16)

        var final = arrayOf(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16)


        for (i in inputword.indices) {
            final[i].visibility = VISIBLE
        }

        val reset = findViewById<Button>(R.id.btnreset)
        val check = findViewById<Button>(R.id.btncheck)
        val mAX_CLICKS = inputword.length
        var clickCount = 0
        var l = 0
        var lives = 3
        var p = 0


        // Assuming you have an array of buttons, you can set a click listener on each button


        // Assuming you have an array of buttons, you can set a click listener on each button
        for (button in buttons) {
            button.setOnClickListener {
                if (clickCount < mAX_CLICKS) {
                    val h: Editable = Editable.Factory.getInstance().newEditable(button.text)
                    final[l].text = h
                    l++
                    button.setBackgroundColor(Color.parseColor("#999997"))
                    // Do something when the button is clicked
                    clickCount++
                } else {
                    // Disable the button when the maximum number of clicks has been reached
                    button.isEnabled = false
                }
            }
        }


        var heart1 = findViewById<ImageView>(R.id.ivh1)
        var heart2 = findViewById<ImageView>(R.id.ivh2)
        var heart3 = findViewById<ImageView>(R.id.ivh3)
        DataHolder.score = 0

        fun high(){
            if (score>highscore){
                highscore=score
            }
        }



        check.setOnClickListener {
            if(lives>0){
                p=0
                for(i in inputword.indices){
                    if(final[i].text.toString()== inputword[i].toString().uppercase()){
                        p+=1
                    }
                }
                if(p == inputword.length){
                    Toast.makeText(this@SecondActivity, "YES YOU GOT IT RIGHT", Toast.LENGTH_LONG)
                        .show()
                    if(lives==3){
                        score=150
                        high()

                        hsw = highscore.toString()

                        val dialogbinding = layoutInflater.inflate(R.layout.activity_gameover, null)
                        val dialog = CustomDialog(this)
                        dialog.setContentView(dialogbinding)
                        dialog.setCancelable(true)
                        dialog.show()
                        val home = dialogbinding.findViewById<Button>(R.id.btnhome)
                        val again = dialogbinding.findViewById<Button>(R.id.btnagn)
                        var actual=dialogbinding.findViewById<TextView>(R.id.tvscore)
                        actual.text=score.toString()

                        home.setOnClickListener {
                            val intent = Intent(this, MainActivity::class.java)
                            val sharedPreferences=getSharedPreferences("MY",Context.MODE_PRIVATE)
                            val editor=sharedPreferences.edit()
                            editor.putString("highscore", hsw)
                            editor.apply()
                            startActivity(intent)
                        }
                        again.setOnClickListener {
                            val intent = Intent(this, SecondActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            dialog.dismiss()
                            for (i in inputword.indices) {
                                final[i].setText("")
                            }

                            letters.shuffle()
                            for (i in inputword.indices) {
                                final[i].visibility = VISIBLE
                            }
                            for (i in 0 until 16) {
                                buttons[i].text = letters[i]
                            }

                            for (button in buttons) {
                                button.isEnabled=true
                                button.setBackgroundColor(Color.parseColor("#D4A0DF"))
                                clickCount=0
                                l=0
                                button.setOnClickListener {
                                    if (clickCount < mAX_CLICKS) {
                                        val h: Editable = Editable.Factory.getInstance().newEditable(button.text)
                                        final[l].text = h
                                        l++
                                        button.setBackgroundColor(Color.parseColor("#999997"))
                                        // Do something when the button is clicked
                                        clickCount++
                                    } else {
                                        // Disable the button when the maximum number of clicks has been reached
                                        button.isEnabled = false
                                    }
                                }
                            }
                            startActivity(intent)
                        }


                    }
                    else if(lives==2){
                        score=100
                        high()
                        hsw = highscore.toString()

                        val dialogbinding = layoutInflater.inflate(R.layout.activity_gameover, null)
                        val dialog = CustomDialog(this)
                        dialog.setContentView(dialogbinding)
                        dialog.setCancelable(true)
                        dialog.show()
                        val home = dialogbinding.findViewById<Button>(R.id.btnhome)
                        val again = dialogbinding.findViewById<Button>(R.id.btnagn)
                        var actual=dialogbinding.findViewById<TextView>(R.id.tvscore)
                        actual.text=score.toString()

                        home.setOnClickListener {
                            val intent = Intent(this, MainActivity::class.java)
                            val sharedPreferences=getSharedPreferences("MY",Context.MODE_PRIVATE)
                            val editor=sharedPreferences.edit()
                            editor.putString("highscore", hsw)
                            editor.apply()
                            startActivity(intent)
                        }
                        again.setOnClickListener {
                            val intent = Intent(this, SecondActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            dialog.dismiss()
                            for (i in inputword.indices) {
                                final[i].setText("")
                            }

                            letters.shuffle()
                            for (i in inputword.indices) {
                                final[i].visibility = VISIBLE
                            }
                            for (i in 0 until 16) {
                                buttons[i].text = letters[i]
                            }

                            for (button in buttons) {
                                button.isEnabled=true
                                button.setBackgroundColor(Color.parseColor("#D4A0DF"))
                                clickCount=0
                                l=0
                                button.setOnClickListener {
                                    if (clickCount < mAX_CLICKS) {
                                        val h: Editable = Editable.Factory.getInstance().newEditable(button.text)
                                        final[l].text = h
                                        l++
                                        button.setBackgroundColor(Color.parseColor("#999997"))
                                        // Do something when the button is clicked
                                        clickCount++
                                    } else {
                                        // Disable the button when the maximum number of clicks has been reached
                                        button.isEnabled = false
                                    }
                                }
                            }
                            startActivity(intent)
                        }

                    }else if(lives==1){
                        score=50
                        high()
                        hsw = highscore.toString()

                        val dialogbinding = layoutInflater.inflate(R.layout.activity_gameover, null)
                        val dialog = CustomDialog(this)
                        dialog.setContentView(dialogbinding)
                        dialog.setCancelable(true)
                        dialog.show()
                        val home = dialogbinding.findViewById<Button>(R.id.btnhome)
                        val again = dialogbinding.findViewById<Button>(R.id.btnagn)
                        var actual=dialogbinding.findViewById<TextView>(R.id.tvscore)
                        actual.text=score.toString()

                        home.setOnClickListener {
                            val intent = Intent(this, MainActivity::class.java)
                            val sharedPreferences=getSharedPreferences("MY",Context.MODE_PRIVATE)
                            val editor=sharedPreferences.edit()
                            editor.putString("highscore", hsw)
                            editor.apply()
                            startActivity(intent)

                        }
                        again.setOnClickListener {
                            val intent = Intent(this, SecondActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            dialog.dismiss()
                            for (i in inputword.indices) {
                                final[i].setText("")
                            }

                            letters.shuffle()
                            for (i in inputword.indices) {
                                final[i].visibility = VISIBLE
                            }
                            for (i in 0 until 16) {
                                buttons[i].text = letters[i]
                            }

                            for (button in buttons) {
                                button.isEnabled=true
                                button.setBackgroundColor(Color.parseColor("#D4A0DF"))
                                clickCount=0
                                l=0
                                button.setOnClickListener {
                                    if (clickCount < mAX_CLICKS) {
                                        val h: Editable = Editable.Factory.getInstance().newEditable(button.text)
                                        final[l].text = h
                                        l++
                                        button.setBackgroundColor(Color.parseColor("#999997"))
                                        // Do something when the button is clicked
                                        clickCount++
                                    } else {
                                        // Disable the button when the maximum number of clicks has been reached
                                        button.isEnabled = false
                                    }
                                }
                            }
                            startActivity(intent)
                        }

                    }

                }else{
                    Toast.makeText(this@SecondActivity, "INCORRECT GUESS", Toast.LENGTH_LONG)
                        .show()

                    for (i in inputword.indices) {
                        final[i].setText("")
                    }

                    letters.shuffle()
                    for (i in inputword.indices) {
                        final[i].visibility = VISIBLE
                    }
                    for (i in 0 until 16) {
                        buttons[i].text = letters[i]
                    }

                    for (button in buttons) {
                        button.isEnabled=true
                        button.setBackgroundColor(Color.parseColor("#D4A0DF"))
                        clickCount=0
                        l=0
                        button.setOnClickListener {
                            if (clickCount < mAX_CLICKS) {
                                val h: Editable = Editable.Factory.getInstance().newEditable(button.text)
                                final[l].text = h
                                l++
                                button.setBackgroundColor(Color.parseColor("#999997"))
                                // Do something when the button is clicked
                                clickCount++
                            } else {
                                // Disable the button when the maximum number of clicks has been reached
                                button.isEnabled = false
                            }
                        }
                    }
                    lives--
                    if(lives==2){
                        heart3.setImageResource(R.drawable.heart_empty)
                    }else if(lives==1){
                        heart2.setImageResource(R.drawable.heart_empty)
                        heart3.setImageResource(R.drawable.heart_empty)
                    }else{
                        score=0

                        val dialogbinding = layoutInflater.inflate(R.layout.activity_gameover, null)
                        val dialog = CustomDialog(this)
                        dialog.setContentView(dialogbinding)
                        dialog.setCancelable(true)
                        dialog.show()
                        val home = dialogbinding.findViewById<Button>(R.id.btnhome)
                        val again = dialogbinding.findViewById<Button>(R.id.btnagn)
                        var actual=dialogbinding.findViewById<TextView>(R.id.tvscore)
                        actual.text=score.toString()

                        home.setOnClickListener {
                            val intent = Intent(this, MainActivity::class.java)
                            val sharedPreferences=getSharedPreferences("MY",Context.MODE_PRIVATE)
                            val editor=sharedPreferences.edit()
                            editor.putString("highscore", hsw)
                            editor.apply()
                            startActivity(intent)
                        }
                        again.setOnClickListener {
                            val intent = Intent(this, SecondActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                            dialog.dismiss()
                            for (i in inputword.indices) {
                                final[i].setText("")
                            }

                            letters.shuffle()
                            for (i in inputword.indices) {
                                final[i].visibility = VISIBLE
                            }
                            for (i in 0 until 16) {
                                buttons[i].text = letters[i]
                            }

                            for (button in buttons) {
                                button.isEnabled=true
                                button.setBackgroundColor(Color.parseColor("#D4A0DF"))
                                clickCount=0
                                l=0
                                button.setOnClickListener {
                                    if (clickCount < mAX_CLICKS) {
                                        val h: Editable = Editable.Factory.getInstance().newEditable(button.text)
                                        final[l].text = h
                                        l++
                                        button.setBackgroundColor(Color.parseColor("#999997"))
                                        // Do something when the button is clicked
                                        clickCount++
                                    } else {
                                        // Disable the button when the maximum number of clicks has been reached
                                        button.isEnabled = false
                                    }
                                }
                            }
                            startActivity(intent)
                        }

                    }
                }
            }
        }

        reset.setOnClickListener {
            for (i in inputword.indices) {
                final[i].setText("")
            }
            letters.shuffle()
            for (button in buttons){
                button.isEnabled=true
                button.setBackgroundColor(Color.parseColor("#D4A0DF"))

            }
            for (i in inputword.indices) {
                final[i].visibility = VISIBLE
            }
            for (i in 0 until 16) {
                buttons[i].text = letters[i]
            }
            for (button in buttons) {
                clickCount = 0
                l = 0
                button.setOnClickListener {
                    if (clickCount < mAX_CLICKS) {
                        val h: Editable =
                            Editable.Factory.getInstance().newEditable(button.text)
                        final[l].text = h
                        l++
                        button.setBackgroundColor(Color.parseColor("#999997"))
                        // Do something when the button is clicked
                        clickCount++
                    } else {
                        // Disable the button when the maximum number of clicks has been reached
                        button.isEnabled = false
                    }
                }
            }
        }
        val btn1=findViewById<Button>(R.id.btnclue1)
        btn1.setOnClickListener {
            val dialogb = layoutInflater.inflate(R.layout.custom_dialog, null)
            val dialog = CustomDialog(this)
            dialog.setContentView(dialogb)
            dialog.setCancelable(true)

            dialog.show()
            val ok = dialogb.findViewById<Button>(R.id.btnok)
            val clue=dialogb.findViewById<TextView>(R.id.tvhint)
            clue.text= inputclue
            ok.setOnClickListener {
                dialog.dismiss()
            }

        }


    }
}