package home.com.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static float rate = 30.9f;
    private EditText edntd;
    private Button result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edntd = findViewById(R.id.ntd);
        result = findViewById(R.id.go);
    }

    public void changus(View view){
        String ntds = edntd.getText().toString();
        //Toast.makeText(this, "USD is " + us, Toast.LENGTH_LONG).show();
        if (ntds.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter you NTD amount")
                    .setPositiveButton("OK", null)
                    .show();
        }else{
            float nt = Float.parseFloat(ntds);
            float us = nt * rate;
            Log.d("MainActivity","US=" + us);
            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("USD is " + us)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edntd.setText("");
                        }
                    })
                    .show();
        }
    }
}

