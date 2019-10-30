package StructuralDesignPattern.AdapterDesignPattern


fun main() {

    val player = AudioPlayer();

    player.play("mp3", "SongA")
    player.play("vlc", "SongB")
    player.play("mp4", "SongC")
    player.play("avi", "SongD")
}