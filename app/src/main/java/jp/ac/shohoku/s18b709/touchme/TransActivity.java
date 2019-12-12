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
        setContentView(R.layout.activity_view);
        // ボタンを押したときにイベントを取得できるようにす
        Button button1 = findViewById(R.id.button2);
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
                    LinearLayout layout = findViewById(R.id.ConstraintLayout2);
                    layout.removeAllViews();
                    getLayoutInflater().inflate(R.layout.view3, layout);
                    count = 3;
                } else if (count == 3) {
                    LinearLayout layout = findViewById(R.id.ConstraintLayout3);
                    layout.removeAllViews();
                    getLayoutInflater().inflate(R.layout.view2, layout);
                    count = 2;
                }
            }
        });
    }


    public class TransActivity {
        protected void onCreate(Bundle savedInstanceState) {
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

