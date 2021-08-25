package com.viliussutkus89.androidissue_minsdkautoupgradefor64bits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.viliussutkus89.androidissue_minsdkautoupgradefor64bits.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'androidissue_minsdkautoupgradefor64bits' library on application startup.
    static {
        System.loadLibrary("androidissue_minsdkautoupgradefor64bits");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'androidissue_minsdkautoupgradefor64bits' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}