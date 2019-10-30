package StructuralDesignPattern.AdapterDesignPattern

class VlcPlayer : AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        println("Vlc playing $fileName song")
    }

    override fun playMp4(fileName: String) {
    }
}