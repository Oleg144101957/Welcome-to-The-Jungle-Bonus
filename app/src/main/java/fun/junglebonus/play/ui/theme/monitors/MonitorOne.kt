package `fun`.junglebonus.play.ui.theme.monitors

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import `fun`.junglebonus.play.Constants
import `fun`.junglebonus.play.R
import `fun`.junglebonus.play.ui.theme.Monitor
import kotlinx.coroutines.delay


@Composable
fun MonitorOne(navigator: NavHostController){

    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    val screenHeight = LocalConfiguration.current.screenHeightDp

    val speed = remember {
        mutableStateOf(5000)
    }
    
    val fall1 = remember {
        Animatable(-200f)
    }

    val fall2 = remember {
        Animatable(-200f)
    }

    val rotate = remember {
        Animatable(0f)
    }

    val goAwayX = remember {
        Animatable(0f)
    }

    val goAwayY = remember {
        Animatable(0f)
    }

    LaunchedEffect(Unit){
        delay(2500)
        navigator.navigate(Monitor.Monitor2.route)
    }

    LaunchedEffect(Unit){
        goAwayY.animateTo(
            targetValue = -64f,
            animationSpec = tween(1000, delayMillis = 300, easing = LinearEasing)
        )
    }

    LaunchedEffect(Unit){
        goAwayX.animateTo(
            targetValue = -128f,
            animationSpec = tween(1400, delayMillis = 500, easing = LinearEasing)
        )
    }


    
    LaunchedEffect(Unit){
        fall1.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(durationMillis = speed.value, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(Unit){
        fall2.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(durationMillis = speed.value-1000, delayMillis = 500, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(Unit){
        rotate.animateTo(
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                tween(
                    durationMillis = 1200,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        )
    }



    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.junglebackground),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        
        Image(
            painter = painterResource(id = R.drawable.qqq7),
            contentDescription = "leaf",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = fall1.value.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.qqq8),
            contentDescription = "leaf",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = fall2.value.dp, x = 64.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.qqq6),
            contentDescription = "rotating element",
            modifier = Modifier
                .align(Alignment.Center)
                .rotate(rotate.value)
                .offset(x = goAwayX.value.dp, y = goAwayY.value.dp)
        )

        Text(
            text = "Loading...",
            fontFamily = Constants.mainCustomFont,
            fontSize = 32.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 64.dp)
        )
        
    }
}