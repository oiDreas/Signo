import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Calcular.setOnClickListener{ descobrirSigno() }

        val dayInput = findViewById<EditText>(R.id.DiaText)
        dayInput.filters = arrayOf<InputFilter>(
            InputFilter.LengthFilter(2),
            InputFilterMinMax("1", "31")
        )

        val monthInput = findViewById<EditText>(R.id.MesText)
        monthInput.filters = arrayOf<InputFilter>(
            InputFilter.LengthFilter(2),
            InputFilterMinMax("1", "12")
        )

    }

    private fun descobrirSigno() {
        val MonthText = binding.MesText.text.toString()
        val mesInt = MonthText.toInt()

        val DayText = binding.DiaText.text.toString()
        val dayInt = DayText.toInt()

        val SignoImage: ImageView = findViewById(R.id.signo)
        val SignoText = binding.signoText

        when(mesInt) {
            1 -> if(dayInt >= 1 && dayInt < 20) {
                SignoText.text = "Capricórnio"
            } else {
                SignoText.text = "Aquário"
            }
            2 -> if(dayInt >= 1 && dayInt < 20) {

                SignoText.text = "Aquário"
            } else {

                SignoText.text = "Peixes"
            }
            3 -> if(dayInt >= 1 && dayInt < 21) {

                SignoText.text = "Peixes"
            } else {

                SignoText.text = "Áries"
            }
            4 -> if(dayInt >= 1 && dayInt < 21) {

                SignoText.text = "Áries"
            } else {

                SignoText.text = "Touro"
            }
            5 -> if(dayInt >= 1 && dayInt < 21) {

                SignoText.text = "Touro"
            } else {

                SignoText.text = "Gêmeos"
            }
            6 -> if(dayInt >= 1 && dayInt < 21) {

                SignoText.text = "Gêmeos"
            } else {

                SignoText.text = "Câncer"
            }
            7 -> if(dayInt >= 1 && dayInt < 23) {
                SignoText.text = "Câncer"
            } else {
                SignoText.text = "Leão"
            }
            8 -> if(dayInt >= 1 && dayInt < 23) {
                SignoText.text = "Leão"
            } else {
                SignoText.text = "Virgem"
            }
            9 -> if(dayInt >= 1 && dayInt < 23) {
                SignoText.text = "Virgem"
            } else {
                SignoText.text = "Libra"
            }
            10 -> if(dayInt >= 1 && dayInt < 23) {
                SignoText.text = "Libra"
            } else {
                SignoText.text = "Escorpião"
            }
            11 -> if(dayInt >= 1 && dayInt < 22) {
                SignoText.text = "Escorpião"
            } else {
                SignoText.text = "Sagitário"
            }
            12 -> if(dayInt >= 1 && dayInt < 22) {
                SignoText.text = "Sagitário"
            } else {
                SignoText.text = "Capricórnio"
            }
        }
        class InputFilterMinMax : InputFilter {
            private var min: Int
            private var max: Int

            constructor(minValue: Int, maxValue: Int) {
                this.min = minValue
                this.max = maxValue
            }

            constructor(minValue: String, maxValue: String) {
                this.min = minValue.toInt()
                this.max = maxValue.toInt()
            }

            override fun filter(
                source: CharSequence,
                start: Int,
                end: Int,
                dest: Spanned,
                dstart: Int,
                dend: Int
            ): CharSequence? {
                try {
                    val input = (dest.toString() + source.toString()).toInt()
                    if (isInRange(min, max, input)) return null
                } catch (nfe: NumberFormatException) {
                }
                return ""
            }

            private fun isInRange(a: Int, b: Int, c: Int): Boolean {
                return if (b > a) c in a..b else c in b..a
            }
        }