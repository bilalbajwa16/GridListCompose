package com.paklab.gridlistviewcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paklab.gridlistviewcompose.R


data class Student(val name: String, val credits: Int)

@Preview(showSystemUi = true)
@Composable
fun App() {
    Column(){
        toolbar()
        SearchBar()
        StudentList(students = students)
    }}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {

    var text by remember { mutableStateOf("") }
    TextField(
         colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Gray,
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        value = text,
        onValueChange = { text = it },
        label = { Text("Search") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(colorResource(id = R.color.card_color)),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun toolbar(){
TopAppBar(
title = {
    Text(text = "")
},
)}



val students = listOf(
    Student("Mass", androidx.core.R.drawable.notification_bg_low_normal),
    Student("Area", androidx.core.R.drawable.notification_bg_low_normal),
    Student("Length",  androidx.core.R.drawable.notification_bg_low_normal),
    Student("Volume",  androidx.core.R.drawable.notification_bg_low_normal),
    Student("Fuel", androidx.core.R.drawable.notification_bg_low_normal),
    Student("Energy",  androidx.core.R.drawable.notification_bg_low_normal),
    Student("Density",  androidx.core.R.drawable.notification_bg_low_normal),
    Student("Torque",  androidx.core.R.drawable.notification_bg_low_normal),
    Student("Current",  androidx.core.R.drawable.notification_bg_low_normal),
    Student("Flow", androidx.core.R.drawable.notification_bg_low_normal),
    Student("Frequency",  androidx.core.R.drawable.notification_bg_low_normal),
    Student("Acceleration",  androidx.core.R.drawable.notification_bg_low_normal),

    )

@Composable
fun StudentList(students: List<Student>) {
    LazyVerticalGrid(
        contentPadding = PaddingValues( 6.dp),
        columns = GridCells.Fixed(3)){
        items(students) { Student ->
            StudentRow(Student.credits, Student.name)
        }
    }
}

@Composable
fun StudentRow(img:Int,title:String) {
    //val context = LocalCo.current
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.card_color), //Card background color
            contentColor = Color.White  //Card content color,e.g.text
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)
            .padding(6.dp),

    ){
        Row(modifier = Modifier
            .padding(0.dp, 25.dp, 0.dp, 0.dp)
            .align(alignment = Alignment.CenterHorizontally)
        ) {

            Image(
                painter = painterResource(id = img),
                contentDescription = "unitimage",
                alignment = Alignment.Center
            )
        }
        Row(modifier = Modifier
            .padding(0.dp, 10.dp, 0.dp, 0.dp)
            .align(alignment = Alignment.CenterHorizontally)
        ) {
            Text(
                color= colorResource(id = R.color.text_color),
                text = title,
                fontFamily = FontFamily(Font(R.font.droidsans)),
                fontSize = 12.sp,
                modifier = Modifier,
                textAlign = TextAlign.Center,
            )
        } } }


