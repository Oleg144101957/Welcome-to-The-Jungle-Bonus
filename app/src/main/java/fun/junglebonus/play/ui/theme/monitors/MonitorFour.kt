package `fun`.junglebonus.play.ui.theme.monitors

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import `fun`.junglebonus.play.Constants
import `fun`.junglebonus.play.R

@Composable
fun MonitorFour(navigator: NavHostController) {

    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    val context = LocalContext.current
    val sp = context.getSharedPreferences(Constants.SHARED, Context.MODE_PRIVATE)


    val isChecked = remember {
        mutableStateOf(false)
    }

    if (isChecked.value){
        sp.edit().putInt(Constants.SPEED_VALUE, 1500).apply()
    }


//Settings


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.junglebackground),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Switch(
            checked = isChecked.value,
            onCheckedChange = {
                isChecked.value = !isChecked.value
            },
            colors = SwitchDefaults.colors(checkedThumbColor = Color.Red),
            modifier = Modifier
                .align(Alignment.Center)
        )

        Text(
            text = "Extra Hard Level",
            fontFamily = Constants.mainCustomFont,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 32.dp)
        )



    }

}