//package com.example.wellcomapp
//
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.wellcomapp.ui.theme.WellcomAppTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//
//        Toast.makeText(this, "خوش آمدید!", Toast.LENGTH_SHORT).show()
//
//        setContent {
//            WellcomAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "مهدی",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Toast.makeText(this, "بدرود!", Toast.LENGTH_SHORT).show()
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "سلام $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    WellcomAppTheme {
//        Greeting("Android")
//    }
//}



package com.example.wellcomapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wellcomapp.ui.theme.WellcomAppTheme

// Dark Colors
private val BackgroundStart = Color(0xFF080C18)
private val BackgroundMiddle = Color(0xFF111827)
private val BackgroundEnd = Color(0xFF172554)

private val CardColor = Color(0xFF1E293B)
private val AccentColor = Color(0xFF38BDF8)
private val MainTextColor = Color(0xFFF8FAFC)
private val SecondaryTextColor = Color(0xFFCBD5E1)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Toast.makeText(this, "خوش آمدید!", Toast.LENGTH_SHORT).show()

        setContent {
            WellcomAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.Transparent
                ) { innerPadding ->

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        BackgroundStart,
                                        BackgroundMiddle,
                                        BackgroundEnd
                                    )
                                )
                            )
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            WelcomeCard(name = "مهدی")

                            Spacer(modifier = Modifier.height(28.dp))

                            Text(
                                text = "MADE WITH ANDROID & JETPACK COMPOSE",
                                color = SecondaryTextColor.copy(alpha = 0.7f),
                                fontSize = 10.sp,
                                letterSpacing = 1.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()

        Toast.makeText(this, "بدرود!", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun WelcomeCard(name: String) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 420.dp),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp, vertical = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "👋",
                fontSize = 56.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Surface(
                shape = RoundedCornerShape(50.dp),
                color = Color(0xFF0F3B54)
            ) {
                Text(
                    text = "WELCOME",
                    modifier = Modifier.padding(
                        horizontal = 18.dp,
                        vertical = 8.dp
                    ),
                    color = AccentColor,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )
            }

            Spacer(modifier = Modifier.height(26.dp))

            Greeting(name = name)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "به برنامه خوش‌آمدگویی ما خوش آمدی!",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MainTextColor,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "امیدواریم تجربه خوبی در استفاده از این برنامه داشته باشی.",
                fontSize = 13.sp,
                lineHeight = 23.sp,
                color = SecondaryTextColor,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .width(55.dp)
                    .height(3.dp)
                    .background(
                        AccentColor,
                        RoundedCornerShape(50.dp)
                    )
            )
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier
) {

    Text(
        text = "سلام $name!",
        modifier = modifier.fillMaxWidth(),
        fontSize = 34.sp,
        fontWeight = FontWeight.Bold,
        color = AccentColor,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    WellcomAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            BackgroundStart,
                            BackgroundMiddle,
                            BackgroundEnd
                        )
                    )
                )
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            WelcomeCard(name = "مهدی")
        }
    }
}
