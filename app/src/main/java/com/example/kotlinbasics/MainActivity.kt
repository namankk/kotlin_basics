package com.example.kotlinbasics

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.core.R
import coil.compose.AsyncImage
import com.example.kotlinbasics.ui.theme.KotlinBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview()
                }
            }
        }
        myLoopOf(a = 12, b = 15)
    }
}

fun myLoopOf(a: Int, b: Int): Int {
    println("Hello ${a + b}")
    return a + b;
}

@Composable
fun Greeting(model: GridModal, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = Color.White)
            .border(width = 2.dp, color = Color.Black)
            .padding(top = 10.dp, start = 10.dp, bottom = 10.dp, end = 10.dp)
    ) {
       var imageview=Box(
           modifier
               .width(width = LocalConfiguration.current.screenWidthDp.dp)
               .height(
                   height = (LocalConfiguration.current.screenWidthDp / 2).dp
               )
               .background(Color.DarkGray)
        ) {
            AsyncImage(
                model = model.productImage,
                contentDescription = "kuch",
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.Green)
            )
            Box(modifier = modifier
                .align(Alignment.BottomStart)
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints)
                    layout(placeable.width, placeable.height) {
                        placeable.place(0, placeable.height / 2)
                    }
                }
                .shadow(
                    4.dp,
                    shape = CircleShape,
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                )
                .background(Color.White, shape = CircleShape)
                .padding(8.dp)) {
                Text(
                    text = "3 Offers",

                )
            }
        }

        Text(
            text = model.productTitle + "bht sara text hai yeh too kese add kru",
            style = TextStyle(
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp,
            modifier = modifier.padding(top = 30.dp)
        )
        Row(
            modifier = modifier.padding(top = 10.dp)
        ) {
            Text(
                text = "₹ 201",
                style = TextStyle(
                    color = Color(color = 0xFF000000),
                    fontSize = 16.sp,
                ),
            )
            Text(
                text = "₹ 201",
                style = TextStyle(
                    color = Color(color = 0xFF988989),
                    fontSize = 12.sp,
                    baselineShift = BaselineShift.Subscript,
                    textDecoration = TextDecoration.LineThrough
                ),
                modifier = modifier.padding(start = 4.dp)
            )
            Text(
                text = "10% Off",
                style = TextStyle(
                    color = Color.Green,
                    fontSize = 12.sp,
                    baselineShift = BaselineShift.Subscript,
                ),
                modifier = modifier.padding(start = 4.dp)
            )
        }
        Row(modifier.padding(top = 10.dp)) {
            Text(
                text = "3 ★",
                style = TextStyle(
                    color = Color.White
                ),
                modifier = modifier
                    .background(Color.Green, shape = RoundedCornerShape(8.dp))
                    .padding(end = 5.dp, start = 5.dp)

            )
            Text(
                text = "4 Ratings",
                style = TextStyle(
                    color = Color(color = 0xFF988989),
                    fontSize = 12.sp,
                    baselineShift = BaselineShift(-0.2f),
                ),
                modifier = modifier.padding(start = 4.dp)
            )
        }
        Row(modifier = modifier.padding(top = 40.dp, bottom = 15.dp)) {
            Button(colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
            ),
                border = BorderStroke(color = Color(color = 0xFF800080), width = 1.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = { /*TODO*/ }) {
                Text(style = TextStyle(color = Color(color = 0xFF800080)), text = "Add to Cart")
            }
            Text(
                text = "\uD83D\uDC9C",
                style = TextStyle(
                    color = Color(color = 0xFF988989),
                    fontSize = 28.sp,
                    baselineShift = BaselineShift(-0.2f),
                ),
                modifier = modifier.padding(start = 10.dp)
            )

        }
    }

}

@Composable
fun MyGridView(dataList: List<GridModal>) {
    LazyVerticalGrid(columns = GridCells.Fixed(count = 2)) {
        items(count = dataList.size) { index ->

            Greeting(model = dataList[index])
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    MyGridView(dataList = products)

}