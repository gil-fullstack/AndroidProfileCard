package com.tinellus.perfilcard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tinellus.perfilcard.ui.theme.PerfilCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PerfilCardTheme {
                myShowCard()
            }
        }
    }
}

@SuppressLint("ResourceAsColor")
@Composable
fun myShowCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White)
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)                     // Define dash pattern
                )
                .padding(10.dp),


            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.celeste))
        ) {
            Spacer(modifier = Modifier.height(42.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                ProfilePhoto(135.dp, 7.dp, Color(0xFF7A5A9E))
                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider(
                    thickness = 4.dp,
                    color = colorResource(id = R.color.dar_blue)
                )
                Column(modifier = Modifier.padding(7.dp)) {
                    Text(
                        text = "Gilvan Pereira",
                        fontSize = 35.sp,
                        color = Color(0xFF7A5A9E),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }

    }
}

@SuppressLint("ResourceAsColor")
@Composable
private fun ProfilePhoto(mySize: Dp, borderSize: Dp, strokeColor: Color) {
    Surface(
        modifier = Modifier.size(mySize),
        shape = CircleShape,
        border = BorderStroke(borderSize, strokeColor),
        tonalElevation = 7.dp,
        shadowElevation = 7.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Image"
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PerfilCardTheme {
        myShowCard()
    }
}

@Preview
@Composable
fun Content() {
    val myItems = listOf("Teste1", "teste 2", "Testando...")
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(14.dp)
    ) {
        Portfolios(myItems)
    }
}

@Composable
private fun Portfolios(myItems: List<String>) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(14.dp),
        shape = RoundedCornerShape(7.dp),
        border = BorderStroke(width = 5.dp, color = Color(0xFF7A5A9E))
    ) {
        LazyColumn(contentPadding = PaddingValues(28.dp)) {

                items(myItems) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(6.dp)
                            .border(2.dp, Color.Gray) ,
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                            Spacer(modifier = Modifier.size(7.dp))
                            ProfilePhoto(35.dp, 2.dp, Color.Gray)
                            Spacer(modifier = Modifier.size(12.dp))
                            Text(text = item)

                    }
                }

        }
    }
}

