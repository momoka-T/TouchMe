package jp.ac.shohoku.s18b709.touchme;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
        int count = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view);
            // ボタンを押したときにイベントを取得できるようにす
            Button button1 = (Button) findViewById(R.id.button1);
            button1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (count == 1) {
                        // 変更したいレイアウトを取得する
                        LinearLayout layout = findViewById(R.id.ConstraintLayout1);
                        // レイアウトのビューをすべて削除する
                        layout.removeAllViews();
                        // レイアウトをR.layout.sampleに変更する
                        getLayoutInflater().inflate(R.layout.view2, layout);
                        count = 2;
                    } else if (count == 2) {
                        LinearLayout layout =  findViewById(R.id.linearlayout2);
                        layout.removeAllViews();
                        getLayoutInflater().inflate(R.layout.view3, layout);
                        count = 3;
                    }else if (count == 3) {
                        LinearLayout layout =  findViewById(R.id.linearlayout3);
                        layout.removeAllViews();
                        getLayoutInflater().inflate(R.layout.view2, layout);
                        count = 2;
                    }
                }
            });
        }




    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //音楽開始ボタン
        Button buttonStart = findViewById(R.id.start);

        //リスナーをボタンに登録
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //音楽再生
                audioPlay();
            }
        });

        //音楽停止ボタン
        Button buttonStop = findViewById(R.id.stop);

        //リスナーをボタンに登録
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    //音楽停止
                    audioStop();
                }
            }
        });
    }

    private boolean audioSetup() {
        boolean fileCheck = false;

        //rawに音声ファイルを置いた場合
        mediaPlayer = MediaPlayer.create(this, R.raw.marbletechno2);
        //音量調整を端末のボタンに任せる
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        fileCheck = true;

        return fileCheck;
    }

    private void audioPlay() {
        if (mediaPlayer == null) {
            //audioファイルを読出し
            if (audioSetup()) {
                Toast.makeText(getApplication(), "Rread audio file", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplication(), "Error: read audio file", Toast.LENGTH_SHORT).show();
                return;
            }

        } else {
            //繰り返し再生する場合
            mediaPlayer.stop();
            mediaPlayer.reset();
            //リソースの解放
            mediaPlayer.release();
        }
        //再生する
        mediaPlayer.start();

        //終了を検知するリスナー
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.d("debug", "end of audio");
                audioStop();
            }
        });
    }
    private void audioStop(){
        //再生終了
        mediaPlayer.stop();
        //リセット
        mediaPlayer.reset();
        //リソースの解放
        mediaPlayer.release();

        mediaPlayer = null;
    }
}