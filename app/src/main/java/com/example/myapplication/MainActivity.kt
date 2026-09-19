package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    private val proccesor = TextProccesor()

    private val sourceText = "Вторая часть трилогии о Трисолярианах. Интересно, что ждет читателей в третьей книге, потому что в этой всё вроде бы логически завершилось, дальше можно не продолжать.\n" +
            "\n" +
            "Эта книга оказалась гораздо интереснее первой. Она не душит читателя чрезмерно подробной экспозицией в отличии от первой книги. Описания технологий здесь очень красиво вплетены в общее повествование. Есть много персонажей с интересными сюжетными линиями, что сложно выделить среди них четкого фаворита.\n" +
            "\n" +
            "Отдельно хочется похвалить книгу за \"чеховские ружья\"."
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            MyApplicationTheme {
                var resultText by remember { mutableStateOf("") }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Button(
                        onClick = {
                             resultText = proccesor.processText(sourceText).joinToString( "\n")


                        }
                    ) {

                        Text("Нажми")
                    }
                    OutlinedTextField(
                        value = resultText,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                        label = {Text("результат")}
                    )


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}