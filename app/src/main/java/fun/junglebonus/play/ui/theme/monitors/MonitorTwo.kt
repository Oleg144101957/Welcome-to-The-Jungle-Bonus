package `fun`.junglebonus.play.ui.theme.monitors

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import `fun`.junglebonus.play.Constants
import `fun`.junglebonus.play.R
import `fun`.junglebonus.play.ui.theme.Monitor

@Composable
fun MonitorTwo(navigator: NavHostController){
    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.junglebackground),
            contentDescription = "background",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.palm),
            contentDescription = "palm",
            modifier = Modifier
                .align(Alignment.BottomStart)
        )
        
        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(64.dp)
        ) {
            
            Box(modifier = Modifier.fillMaxWidth()){
                Image(
                    painter = painterResource(id = R.drawable.textframe),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            navigator.navigate(Monitor.Monitor3.route)
                        }
                )

                Text(
                    text = "Play",
                    color = Color.White,
                    fontFamily = Constants.mainCustomFont,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Box(modifier = Modifier.fillMaxWidth()){
                Image(
                    painter = painterResource(id = R.drawable.textframe),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            navigator.navigate(Monitor.Monitor4.route)
                        }
                )

                Text(
                    text = "Settings",
                    color = Color.White,
                    fontFamily = Constants.mainCustomFont,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}