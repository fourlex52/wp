package com.example.wp;

import java.util.ArrayList;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements TextWatcher {
 ArrayList<EditText> array;
 int cnt;
 int i;
 int j;
 int n;
 int test;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		array=new ArrayList<EditText>(6);
		
		EditText edText1=(EditText)findViewById(R.id.editText1);
		EditText edText2=(EditText)findViewById(R.id.editText2);
		EditText edText3=(EditText)findViewById(R.id.editText3);
		EditText edText4=(EditText)findViewById(R.id.editText4);
		EditText edText5=(EditText)findViewById(R.id.editText5);
		EditText edText6=(EditText)findViewById(R.id.editText6);
			
		array.add(0, edText1);
		array.add(1, edText2);
		array.add(2, edText3);
		array.add(3, edText4);
		array.add(4, edText5);
		array.add(5, edText6);
		
		
		
	}
	
	public void cb0(View view){
		addText("0");
	}
	public void cb1(View view){
		addText("1");
	}
	public void cb2(View view){
		addText("2");
	}
	public void cb3(View view){
		addText("3");
	}
	public void cb4(View view){
		addText("4");
	}
	public void cb5(View view){
		addText("5");
	}
	public void cb6(View view){
		addText("6");
	}
	public void cb7(View view){
		addText("7");
	}
	public void cb8(View view){
		addText("8");
	}
	public void cb9(View view){
		addText("9");
	}
	
	public void cet1(View view){
		clearText(0);
	}
	public void cet2(View view){
		clearText(1);
	}
	public void cet3(View view){
		clearText(2);
	}
	public void cet4(View view){
		clearText(3);
	}
	public void cet5(View view){
		clearText(4);
	}
	public void cet6(View view){
		clearText(5);
	}
	
	
 	public void addText(String text){
 			n=7; //устанавливает точность координат. может быть 7 или 8
 			if (cnt==2 || cnt==4 || cnt==n || cnt==n+2 || cnt==n+4) {
 	 			j++;
 	 			array.get(j).requestFocus();
 	 		}
 			View edText = this.getCurrentFocus();
 			String txt = ((EditText) edText).getText().toString();
 		 	text = txt+text;
 		 	((TextView) edText).setText(text);
 		 	cnt++;
 		 	
 		 	
 	}

 	public void clearText(int j){
 		array.get(j).setText(null);
 		array.get(j).requestFocus();
 		cnt=0;
 	}
 	
 	 	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}
}
