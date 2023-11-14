package `fun`.junglebonus.play.ui.theme.monitors

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import `fun`.junglebonus.play.Constants
import `fun`.junglebonus.play.R
import `fun`.junglebonus.play.ui.theme.Monitor
import kotlinx.coroutines.delay
import kotlin.math.roundToInt


@Composable
fun MonitorThree(navigator: NavHostController){


    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    val context = LocalContext.current
    val sp = context.getSharedPreferences(Constants.SHARED, Context.MODE_PRIVATE)
    val shared_speed = sp.getInt(Constants.SPEED_VALUE, 3000)


    val score = remember {
        mutableStateOf(0)
    }

    val speed = remember {
        mutableStateOf(shared_speed)
    }

    val screenHeight = LocalConfiguration.current.screenHeightDp

    val animatableY1 = remember {
        Animatable(initialValue = 0f)
    }

    val element1globalOffsetX = remember {
        mutableStateOf(0f)
    }

    val element1globalOffsetY = remember {
        mutableStateOf(0f)
    }

    val isVisible1 = remember {
        mutableStateOf(true)
    }


    val animatableY2 = remember {
        Animatable(initialValue = 0f)
    }

    val element2globalOffsetX = remember {
        mutableStateOf(0f)
    }

    val element2globalOffsetY = remember {
        mutableStateOf(0f)
    }

    val isVisible2 = remember {
        mutableStateOf(true)
    }

    val animatableY3 = remember {
        Animatable(initialValue = 0f)
    }

    val element3globalOffsetX = remember {
        mutableStateOf(0f)
    }

    val element3globalOffsetY = remember {
        mutableStateOf(0f)
    }

    val isVisible3 = remember {
        mutableStateOf(true)
    }


    val animatableY4 = remember {
        Animatable(initialValue = 0f)
    }

    val element4globalOffsetX = remember {
        mutableStateOf(0f)
    }

    val element4globalOffsetY = remember {
        mutableStateOf(0f)
    }

    val isVisible4 = remember {
        mutableStateOf(true)
    }


    val animatableY5 = remember {
        Animatable(initialValue = 0f)
    }

    val element5globalOffsetX = remember {
        mutableStateOf(0f)
    }

    val element5globalOffsetY = remember {
        mutableStateOf(0f)
    }

    val isVisible5 = remember {
        mutableStateOf(true)
    }



    val animatableY6 = remember {
        Animatable(initialValue = 0f)
    }

    val element6globalOffsetX = remember {
        mutableStateOf(0f)
    }

    val element6globalOffsetY = remember {
        mutableStateOf(0f)
    }

    val isVisible6 = remember {
        mutableStateOf(true)
    }



    val basePositionX = remember {
        mutableStateOf(0f)
    }

    val globalBaseX = remember {
        mutableStateOf(0f)
    }

    val globalBaseXEnd = remember {
        mutableStateOf(0f)
    }

    val globalBaseY = remember {
        mutableStateOf(0f)
    }

    fun checkCross1(){
        if (element1globalOffsetX.value in globalBaseX.value .. globalBaseXEnd.value && element1globalOffsetY.value >= globalBaseY.value){
            score.value += 1
            isVisible1.value = false
            speed.value -= 200
        }
    }

    fun checkCross2(){
        if (element2globalOffsetX.value in globalBaseX.value .. globalBaseXEnd.value && element2globalOffsetY.value >= globalBaseY.value){
            score.value += 1
            isVisible2.value = false
            speed.value -= 200
        }
    }

    fun checkCross3(){
        if (element3globalOffsetX.value in globalBaseX.value .. globalBaseXEnd.value && element3globalOffsetY.value >= globalBaseY.value){
            score.value += 1
            isVisible3.value = false
            speed.value -= 200
        }
    }

    fun checkCross4(){
        if (element4globalOffsetX.value in globalBaseX.value .. globalBaseXEnd.value && element4globalOffsetY.value >= globalBaseY.value){
            score.value += 1
            isVisible4.value = false
            speed.value -= 200
        }
    }

    fun checkCross5(){
        if (element5globalOffsetX.value in globalBaseX.value .. globalBaseXEnd.value && element5globalOffsetY.value >= globalBaseY.value){
            score.value += 1
            isVisible5.value = false
            speed.value -= 200
        }
    }


    fun checkCross6(){
        if (element5globalOffsetX.value in globalBaseX.value .. globalBaseXEnd.value && element5globalOffsetY.value >= globalBaseY.value){
            score.value += 1
            isVisible6.value = false
            speed.value -= 200
        }
    }

    LaunchedEffect(Unit){
        animatableY1.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(tween(
                speed.value,
                delayMillis = 150,
                easing = LinearEasing
            ), repeatMode = RepeatMode.Restart)
        )
    }

    LaunchedEffect(Unit){
        animatableY2.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(tween(
                speed.value,
                delayMillis = 500,
                easing = LinearEasing
            ), repeatMode = RepeatMode.Restart)
        )
    }

    LaunchedEffect(Unit){
        animatableY3.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(tween(
                speed.value,
                delayMillis = 300,
                easing = LinearEasing
            ), repeatMode = RepeatMode.Restart)
        )
    }

    LaunchedEffect(Unit){
        animatableY4.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(tween(
                speed.value,
                delayMillis = 400,
                easing = LinearEasing
            ), repeatMode = RepeatMode.Restart)
        )
    }

    LaunchedEffect(Unit){
        animatableY5.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(tween(
                speed.value,
                delayMillis = 250,
                easing = LinearEasing
            ), repeatMode = RepeatMode.Restart)
        )
    }

    LaunchedEffect(Unit){
        animatableY6.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(tween(
                speed.value,
                delayMillis = 250,
                easing = LinearEasing
            ), repeatMode = RepeatMode.Restart)
        )
    }


    LaunchedEffect(Unit){
        repeat(64){
            delay(3000)
            isVisible1.value = true
            isVisible2.value = true
            isVisible3.value = true
            isVisible4.value = true
            isVisible5.value = true
            isVisible6.value = true
        }
    }


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.junglebackground),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "Your score is ${score.value}",
            fontFamily = Constants.mainCustomFont,
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(32.dp)
        )

        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "close",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .clickable {
                    navigator.navigate(Monitor.Monitor2.route)
                }
        )


        if (isVisible1.value){
            Image(
                painter = painterResource(id = R.drawable.qqq1),
                contentDescription = "element 1",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = 64.dp, y = animatableY1.value.dp)
                    .size(32.dp)
                    .onGloballyPositioned {
                        element1globalOffsetX.value = it.positionInParent().x + it.size.width / 2
                        element1globalOffsetY.value = it.positionInParent().y + it.size.height
                        checkCross1()
                    }
            )
        }

        if (isVisible2.value){
            Image(
                painter = painterResource(id = R.drawable.qqq2),
                contentDescription = "element 2",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(32.dp)
                    .offset(y = animatableY2.value.dp)
                    .onGloballyPositioned {
                        element2globalOffsetX.value = it.positionInParent().x + it.size.width / 2
                        element2globalOffsetY.value = it.positionInParent().y + it.size.height
                        checkCross2()
                    }
            )
        }


        if (isVisible3.value){
            Image(
                painter = painterResource(id = R.drawable.qqq3),
                contentDescription = "element 3",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = 128.dp, y = animatableY3.value.dp)
                    .size(32.dp)
                    .onGloballyPositioned {
                        element3globalOffsetX.value = it.positionInParent().x + it.size.width / 2
                        element3globalOffsetY.value = it.positionInParent().y + it.size.height
                        checkCross3()
                    }

            )
        }

        if (isVisible4.value){

            Image(
                painter = painterResource(id = R.drawable.qqq4),
                contentDescription = "element 4",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = (-128).dp, y = animatableY4.value.dp)
                    .size(32.dp)
                    .onGloballyPositioned {
                        element4globalOffsetX.value = it.positionInParent().x + it.size.width / 2
                        element4globalOffsetY.value = it.positionInParent().y + it.size.height
                        checkCross4()
                    }
            )
        }


        if (isVisible5.value){
            Image(
                painter = painterResource(id = R.drawable.qqq5),
                contentDescription = "element 5",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = (-64).dp, y = animatableY5.value.dp)
                    .size(32.dp)
                    .onGloballyPositioned {
                        element5globalOffsetX.value = it.positionInParent().x + it.size.width / 2
                        element5globalOffsetY.value = it.positionInParent().y + it.size.height
                        checkCross5()
                    }
            )
        }

        if (isVisible6.value){
            Image(
                painter = painterResource(id = R.drawable.qqq11),
                contentDescription = "element 6",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(32.dp)
                    .offset(x = 16.dp, y = animatableY6.value.dp)
                    .onGloballyPositioned {
                        element6globalOffsetX.value = it.positionInParent().x + it.size.width / 2
                        element6globalOffsetY.value = it.positionInParent().y + it.size.height
                        checkCross6()
                    }

            )
        }


        Image(
            painter = painterResource(id = R.drawable.textframe),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(48.dp)
                .padding(bottom = 16.dp)
                .offset {
                    IntOffset(x = basePositionX.value.roundToInt(), y = 0)
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        basePositionX.value += dragAmount.x
                    }
                }
                .onGloballyPositioned {
                    globalBaseX.value = it.positionInParent().x
                    globalBaseXEnd.value = it.positionInParent().x + it.size.width
                    globalBaseY.value = it.positionInParent().y
                }
        )
    }
}