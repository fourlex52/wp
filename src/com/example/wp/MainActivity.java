package com.example.wp;

import java.util.ArrayList;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements TextWatcher, OnTouchListener, OnClickListener {
 ArrayList<EditText> array;
 int cnt;
 int i;
 int j;
 int n;
 int test;

 int lenDegLat, lenMin, lenDecMin, lenDegLon;
 
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
			
		edText1.setOnTouchListener(this);
		edText2.setOnTouchListener(this);
		edText3.setOnTouchListener(this);
		edText4.setOnTouchListener(this);
		edText5.setOnTouchListener(this);
		edText6.setOnTouchListener(this);
		
		
		array.add(0, edText1);
		array.add(1, edText2);
		array.add(2, edText3);
		array.add(3, edText4);
		array.add(4, edText5);
		array.add(5, edText6);
		
		lenDegLat=2;
		lenMin=2;
		lenDecMin=3; // or 4
		lenDegLon=2; // or 3
		
		maxLength();
		
        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(), "yes", Toast.LENGTH_SHORT).show();
            }
        });
        
        PointsAdapter pa = new PointsAdapter (this);
        ArrayList<String> arr = pa.getRecPoint();

        //устанавливаем массив в ListView
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr));
        listView.setTextFilterEnabled(true);
		
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
	
	/*
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
	*/
	
	public void maxLength(){

		array.get(0).setFilters(new InputFilter[] {new InputFilter.LengthFilter(lenDegLat)});
		array.get(1).setFilters(new InputFilter[] {new InputFilter.LengthFilter(lenMin)});
		array.get(2).setFilters(new InputFilter[] {new InputFilter.LengthFilter(lenDecMin)});
		array.get(3).setFilters(new InputFilter[] {new InputFilter.LengthFilter(lenDegLon)});
		array.get(4).setFilters(new InputFilter[] {new InputFilter.LengthFilter(lenMin)});
		array.get(5).setFilters(new InputFilter[] {new InputFilter.LengthFilter(lenDecMin)});
		
				
		/*EditText editText = new EditText(this);
		int maxLength = 3;    
		editText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
		*/

	}
	
 	public void addText(String text){
 		
 		String txt = array.get(i).getText().toString();
		text = txt+text;
		array.get(i).setText(text);
		cnt++;
		
		
		
		if ((i==0) && (cnt==lenDegLat)){
			array.get(i+1).requestFocus();
			i++;
			cnt=0;
		}
		else if (((i==1)||(i==4)) && (cnt==lenMin)){
			array.get(i+1).requestFocus();
			i++;
			cnt=0;
		}
		else if ((i==2) && (cnt==lenDecMin)){
			array.get(i+1).requestFocus();
			i++;
			cnt=0;
		}
		else if ((i==3) && (cnt==lenDegLon)){
			array.get(i+1).requestFocus();
			i++;
			cnt=0;
		}
		
/*
 		String str = array.get(i).getText().toString();
 		i++;
 		switch(i){
 		case lenDegLat:
 			array.get(j).requestFocus();
 			break;
 		case lenMin:
 			array.get(j).requestFocus();
 			break;
 		case lenDecMin:
 			array.get(j).requestFocus();
 			break;
 		case lenDegLon:
 			array.get(j).requestFocus();
 			break;
 		}
 		
 		
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
 		 */	
 		 	
 	}

 	public void clearText(int j){
 		
 		View edText = this.getCurrentFocus();
 		for (i=0; i<7; i++){
 			if (array.get(i)==edText){
 				array.get(i).setText(null);
 		 		array.get(i).requestFocus();
 				break;
 			}
 		}
 		/*
 		View edText = this.getCurrentFocus();
 		((TextView) edText).setText(null);
 		edText.requestFocus();
 		/*
 		array.get(j).setText(null);
 		array.get(j).requestFocus();
 		*/
 		cnt=0;
 	}
 	
 	public void saveWP (View view){
        ListView listView = (ListView) findViewById(R.id.listView1);
        String point = array.get(0).getText().toString() + "." + array.get(1).getText().toString() + "," + array.get(2).getText().toString() + "; " + array.get(3).getText().toString() + "." + array.get(4).getText().toString() + "," + array.get(5).getText().toString();
        clear_edText();

        PointsAdapter pa = new PointsAdapter (this);
        pa.addPoint(point);
        //записываем точки в файл
        pa.WritePoints();

        ArrayList<String> arr = pa.getRecPoint();

        //устанавливаем массив в ListView
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr));
        listView.setTextFilterEnabled(true);
 	}
    public void clear_edText () {
        for (EditText elm : array) {
            elm.setText(null);
        }
        array.get(0).requestFocus();
    }
    public void click_clearallwp(View view) {
        PointsAdapter pa = new PointsAdapter (this);
        pa.removeAllPoint();
        ListView listView = (ListView) findViewById(R.id.listView1);

        ArrayList<String> arr = pa.getRecPoint();

        //устанавливаем массив в ListView
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr));
        listView.setTextFilterEnabled(true);
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

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if( event.getAction() == MotionEvent.ACTION_DOWN){
			
			View edText = this.getCurrentFocus();
	 		for (i=0; i<7; i++){
	 			if (array.get(i)==edText){
	 				array.get(i).setText(null);
	 		 		array.get(i).requestFocus();
	 				break;
	 			}
	 		}
		}
		return false;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.e("","yes_two");
	}
}
