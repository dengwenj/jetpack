package vip.dengwj.myjetpack.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import vip.dengwj.myjetpack.R;

public class AgreementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        Log.d("pumu", "userName -> " + userName);
        EditText editText = findViewById(R.id.agreementUserName);
        editText.setText(userName);
    }
}
