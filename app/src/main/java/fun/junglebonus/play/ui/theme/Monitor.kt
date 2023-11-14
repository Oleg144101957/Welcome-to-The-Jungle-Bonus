package `fun`.junglebonus.play.ui.theme

sealed class Monitor(val route: String){

    object Monitor1 : Monitor("monitor1")
    object Monitor2 : Monitor("monitor2")
    object Monitor3 : Monitor("monitor3")
    object Monitor4 : Monitor("monitor4")

}