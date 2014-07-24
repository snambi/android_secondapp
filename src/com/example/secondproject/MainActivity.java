package com.example.secondproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        text = (EditText ) findViewById(R.id.editText1);
    }
    
    public void onClick( View view ){
    	
    	switch ( view.getId() ){
    	case R.id.button1:
    		RadioButton celsiusBtn = (RadioButton)findViewById(R.id.radio0);
    		RadioButton fahrenheitBtn = (RadioButton)findViewById(R.id.radio1);
    		
    		if( text.getText().length() == 0 ){
    			Toast t = Toast.makeText(this, "please enter a valid number", Toast.LENGTH_LONG);
    			t.show();
    			return;
    		}
    		
    		TextView textView = (TextView) findViewById(R.id.textView1);
    		Float input = Float.parseFloat(text.getText().toString());
    		if( celsiusBtn.isChecked() ){
    			float output = ConverterUtil.convertFahrenheitToCelsius(input);
    			String outtext = String.format("%f %s", output, "C");
    			textView.setText(outtext);
    		}
    		if(fahrenheitBtn.isChecked() ){
    			float output = ConverterUtil.convertCelsiusToFahrenheit(input);
    			String outtext = String.format("%f %s", output, " F");
    			textView.setText(outtext);
    		}
    	}
    }
}
