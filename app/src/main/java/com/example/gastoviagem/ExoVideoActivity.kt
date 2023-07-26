package com.example.gastoviagem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gastoviagem.databinding.ActivityVideoBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout

class ExoVideoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoBinding

    lateinit var player: ExoPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVideoBinding.inflate(layoutInflater)

        setContentView(binding.root)

        player = ExoPlayer.Builder(applicationContext).build()
        binding.videoPlayer.player= player

        binding.videoPlayer.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT

        val mediaItem: MediaItem = MediaItem.fromUri("https://storage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
        player!!.setMediaItem(mediaItem);
        player!!.prepare();
        player!!.play();
    }
}