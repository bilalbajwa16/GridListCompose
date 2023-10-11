package com.paklab.gridlistviewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.paklab.gridlistviewcompose.ui.theme.GridListViewComposeTheme
import com.paklab.gridlistviewcompose.screens.SearchBar
import com.paklab.gridlistviewcompose.screens.StudentList
import com.paklab.gridlistviewcompose.screens.students
import com.paklab.gridlistviewcompose.screens.toolbar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridListViewComposeTheme() {
                Surface() {
                    App()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun App(){
    Column{
        toolbar()
        SearchBar()
        StudentList(students = students)
    }

}