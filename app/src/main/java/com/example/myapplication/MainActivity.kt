package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.MainViewModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.network.SchoolData


class MainActivity : ComponentActivity() {

    val vm:MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.listData.observe(this,{
            setContent {
                Shools(it)
            }
        })

/*        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }*/
    }
}

@Composable
private fun MyApp(schoolData: List<SchoolData>) {
    var shouldShowOnboarding by remember { mutableStateOf(true) }
    var shouldInfoID by remember { mutableStateOf(0) }

    if (shouldShowOnboarding) {
//        OnboardingScreen(postData, onContinueClicked = { shouldShowOnboarding = false })

        ShoolInfo(schoolData, shouldInfoID)

    } else {
        Shools(schoolData)

    }
}

@Composable
private fun ShoolInfo(names: List<SchoolData>, ID: Int) {
    Text(
        text = names[ID].phoneNumber.toString()
    )
}

@Composable
private fun Shools(names: List<SchoolData>) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
//            School(name = name.schoolName, city = name.city, id = name.id)

            Column(
                modifier = Modifier
                    .padding(12.dp)
            ) {

                Text(text = name.schoolName.toString())
                Text(
                    text = name.city.toString()
                )

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