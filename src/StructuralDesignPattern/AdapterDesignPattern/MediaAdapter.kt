package StructuralDesignPattern.AdapterDesignPattern

class MediaAdapter : MediaPlayer {

    lateinit var advancedMediaPlayer: AdvancedMediaPlayer

    constructor(audioType: String) {
        if (audioType.equals("vlc")) {
            advancedMediaPlayer = VlcPlayer()
        } else if (audioType.equals("mp4")) {
            advancedMediaPlayer = Mp4Player()
        }
    }

    override fun play(audioType: String, fileName: String) {
        if (audioType.equals("vlc")) {
            advancedMediaPlayer.playVlc(fileName)
        } else if (audioType.equals("mp4")) {
            advancedMediaPlayer.playMp4(fileName)
        }
    }
}