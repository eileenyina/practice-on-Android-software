package com.example.hello;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GridCalcActivity extends Activity {
	
	private Button btn_9;
	private Button btn_8;
	private Button btn_7;
	private Button btn_6;
	private Button btn_5;
	private Button btn_4;
	private Button btn_3;
	private Button btn_2;
	private Button btn_1;

	private Button btn_add;
	private Button btn_min;
	private Button btn_mul;
	private Button btn_div;


	private Button btn_c;
	private Button btn_back;
	private Button btn_equal;
	private Button btn_dot;
	private boolean flag=true;
	private StringBuffer str_display = new StringBuffer();
	
	private TextView tv;
	
	
	
	
	private Double left = null; //×óÔª
	private Double right = null; //ÓÒÔª
	private boolean isleft = true;
	private boolean ismiddle = false;
	
	private Intent intent;
	private Handler mHandler;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_calc);
		btn_9 = (Button) findViewById(R.id.calc_9);
		btn_8 = (Button) findViewById(R.id.calc_8);
		btn_7 = (Button) findViewById(R.id.calc_7);
		btn_6 = (Button) findViewById(R.id.calc_6);
		btn_5 = (Button) findViewById(R.id.calc_5);
		btn_4 = (Button) findViewById(R.id.calc_4);
		btn_3 = (Button) findViewById(R.id.calc_3);
		btn_2 = (Button) findViewById(R.id.calc_2);
		btn_1 = (Button) findViewById(R.id.calc_1);
		

		btn_add = (Button) findViewById(R.id.calc_add);
		btn_min = (Button) findViewById(R.id.calc_jian);
		btn_mul = (Button) findViewById(R.id.calc_mul);
		btn_div = (Button) findViewById(R.id.calc_div);
		
		btn_c = (Button) findViewById(R.id.calc_c);
		btn_back = (Button) findViewById(R.id.calc_back);
        btn_equal = (Button) findViewById(R.id.calc_dengyu);
        btn_dot =(Button) findViewById(R.id.calc_dian);
        
		tv = (TextView) findViewById(R.id.calc_tv);

		
		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intent = new Intent(GridCalcActivity.this, FrameActivity.class);
				startActivity(intent);
				GridCalcActivity.this.finish();
			}
		});

		btn_c.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Builder adb = new Builder(GridCalcActivity.this);
				adb.setMessage("Are U sure to clear?");
				adb.setTitle("Clear!");
				adb.setNegativeButton("NO", null);
				adb.setPositiveButton("YES",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								tv.setText("0");
								left = null;
								right = null;
								isleft = true;
								ismiddle = false;
							}
						});
				adb.show();
			}
		});
		
		btn_equal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btn_dot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(flag){
					str_display.append(".");
					tv.setText(str_display.toString());
					flag = false;
				}
			}
		});

		btn_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				isleft = false;
				if (right != null) {
					Double result = left + right;

					int dot_pos = result.toString().indexOf(".0");
					if (dot_pos == result.toString().length() - 2) {
						tv.setText(result.toString().substring(0,
								result.toString().length() - 2));
					} else {
						tv.setText(result.toString());
					}

					left = result;
					right = null;
					ismiddle = true;
				}
				flash();
			}
		});
		
		btn_min.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				isleft = false;
				if (right != null) {
					Double result = left - right;

					int dot_pos = result.toString().indexOf(".0");
					if (dot_pos == result.toString().length() - 2) {
						tv.setText(result.toString().substring(0,
								result.toString().length() - 2));
					} else {
						tv.setText(result.toString());
					}

					left = result;
					right = null;
					ismiddle = true;
				}
				flash();
			}
		});
		
		btn_mul.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				isleft = false;
				if (right != null) {
					Double result = left * right;

					int dot_pos = result.toString().indexOf(".0");
					if (dot_pos == result.toString().length() - 2) {
						tv.setText(result.toString().substring(0,
								result.toString().length() - 2));
					} else {
						tv.setText(result.toString());
					}

					left = result;
					right = null;
					ismiddle = true;
				}
				flash();
			}
		});
		
		btn_div.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				isleft = false;
				if (right != null) {
					Double result = left / right;

					int dot_pos = result.toString().indexOf(".0");
					if (dot_pos == result.toString().length() - 2) {
						tv.setText(result.toString().substring(0,
								result.toString().length() - 2));
					} else {
						tv.setText(result.toString());
					}

					left = result;
					right = null;
					ismiddle = true;
				}
				flash();
			}
		});



		btn_9.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setnumber("9");

			}
		});

		btn_8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setnumber("8");
				Toast.makeText(getApplicationContext(), "8", Toast.LENGTH_LONG)
						.show();
			}
		});
		
		btn_7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setnumber("7");

			}
		});
		
		btn_6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setnumber("6");

			}
		});
		
		btn_5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setnumber("5");

			}
		});
		
		btn_4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setnumber("4");

			}
		});
		
		btn_3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setnumber("3");

			}
		});
		
		btn_2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setnumber("2");

			}
		});
		
		btn_1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setnumber("1");

			}
		});
        
	}
	
	private void flash(){
		final CharSequence temp = tv.getText();
		tv.setText("");
		mHandler = new Handler(){
			@Override
			public void handleMessage(Message msg){
				super.handleMessage(msg);
				tv.setText(temp);
			}
		};
		mHandler.sendEmptyMessageDelayed(0, 500);
		
	}
	
	private void setnumber(String num){
//		String num = String.valueOf(n);
		if(ismiddle){
			ismiddle = false;
			tv.setText(num);
		}else{
			if(!isleft){
				tv.setText(num);
			}else{
				String temp =tv.getText().toString();
				if(temp.equals("0")){
					tv.setText(num);
				}else{
					tv.setText(temp+num);
				}
			}
			
		}
		
		if(isleft){
			left = Double.parseDouble(tv.getText().toString());
		}else{
			right = Double.parseDouble(tv.getText().toString());
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grid_calc, menu);
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
}
