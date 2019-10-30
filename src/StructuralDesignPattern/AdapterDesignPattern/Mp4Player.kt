package StructuralDesignPattern.AdapterDesignPattern

class Mp4Player : AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
    }

    override fun playMp4(fileName: String) {
        println("mp4 playing $fileName song")
    }
}