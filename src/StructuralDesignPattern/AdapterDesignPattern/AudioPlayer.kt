package StructuralDesignPattern.AdapterDesignPattern

class AudioPlayer : MediaPlayer {

    lateinit var mediaPlayer: MediaPlayer

    override fun play(audioType: String, fileName: String) {

        if (audioType.equals("mp3")) {
            println("Playing mp3 song $fileName")
        } else if (audioType.equals("vlc") || audioType.equals("mp4")) {
            mediaPlayer = MediaAdapter(audioType)
            mediaPlayer.play(audioType, fileName)
        } else {
            println("Invalid audioType. $audioType not supported")
        }

    }
}