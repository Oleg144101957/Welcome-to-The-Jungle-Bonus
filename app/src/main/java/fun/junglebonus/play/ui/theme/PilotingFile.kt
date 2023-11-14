package `fun`.junglebonus.play.ui.theme


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import `fun`.junglebonus.play.ui.theme.monitors.MonitorFour
import `fun`.junglebonus.play.ui.theme.monitors.MonitorOne
import `fun`.junglebonus.play.ui.theme.monitors.MonitorThree
import `fun`.junglebonus.play.ui.theme.monitors.MonitorTwo


@Composable
fun PilotingFile(){

    val navigator = rememberNavController()

    NavHost(navController = navigator, startDestination = Monitor.Monitor1.route){
        composable(route = Monitor.Monitor1.route){
            MonitorOne(navigator)
        }

        composable(route = Monitor.Monitor2.route){
            MonitorTwo(navigator)
        }

        composable(route = Monitor.Monitor3.route){
            MonitorThree(navigator)
        }

        composable(route = Monitor.Monitor4.route){
            MonitorFour(navigator)
        }
    }

}