package jp.ac.shohoku.s18b709.touchme;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
        //ボタンを押したときにイベントを取得できるようにする
        Button button = findViewById(R.id.button2);
        //activity_transのボタン
        button.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v){
                //インテントにこの画面と、遷移する別の画面を指定する
                Intent intent = new Intent(SubActivity.this, ThirdActivity.class);
                startActivity(intent);

            }
        });
        setContentView(R.layout.sub);

          //音楽開始ボタン
          Button buttonStart = findViewById(R.id.start);

          //リスナーをボタンに登録
          buttonStart.setOnClickListener(new View.OnClickListener(){
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
