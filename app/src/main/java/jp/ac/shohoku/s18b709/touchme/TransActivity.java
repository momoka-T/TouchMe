package jp.ac.shohoku.s18b709.touchme;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  //viewの遷移処理
        super.onCreate(savedInstanceState);


    }


    public class TransActivity{
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_trans);
            // ボタンを押したときにイベントを取得できるようにする
            Button button = (Button) findViewById(R.id.button);
            //activity_transのボタン
            button.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    //インテントに、この画面と、遷移する別の画面を指定する
                    Intent intent = new Intent(TransActivity.this, SubActivity.class);
                    //インテントで指定した別の画面に遷移する
                    startActivity(intent);
                }
            });


        }
    }
}

