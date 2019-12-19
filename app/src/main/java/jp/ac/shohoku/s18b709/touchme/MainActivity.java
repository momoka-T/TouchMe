//package jp.ac.shohoku.s18b709.touchme;
//
//import android.app.Activity;
//import android.media.AudioManager;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//import android.widget.LinearLayout;
//import android.view.View.OnClickListener;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//    int count = 1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {  //viewの遷移処理
//        super.onCreate(savedInstanceState);
//
//        // ボタンを押したときにイベントを取得できるようにす
//        Button button1 = findViewById(R.id.button2);
//        button1.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (count == 1) {
//                    // 変更したいレイアウトを取得する
//                    LinearLayout layout = findViewById(R.id.ConstraintLayout1);
//                    // レイアウトのビューをすべて削除する
//                    layout.removeAllViews();
//                    // レイアウトをR.layout.sampleに変更する
//                    getLayoutInflater().inflate(R.layout.sub, layout);
//                    count = 2;
//                } else if (count == 2) {
//                    LinearLayout layout = findViewById(R.id.ConstraintLayout2);
//                    layout.removeAllViews();
//                    getLayoutInflater().inflate(R.layout.third, layout);
//                    count = 3;
//                }
//            }
//        });
//    }
//
//}
//
