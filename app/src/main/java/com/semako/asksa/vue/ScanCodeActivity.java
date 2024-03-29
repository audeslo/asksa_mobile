package com.semako.asksa.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;
import com.semako.asksa.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
    }


    @Override
    public void handleResult(Result result) {
        Toast.makeText(this, result.getText(), Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        scannerView.stopCamera();
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();

        scannerView.setResultHandler(this);
        scannerView.startCamera();

    }
}
