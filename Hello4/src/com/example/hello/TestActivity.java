package com.example.hello;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TestActivity extends Activity {
	
	private Button bt_zero;

	private Button bt_one;

	private Button bt_two;

	private Button bt_three;

	private Button bt_four;

	private Button bt_five;

	private Button bt_six;

	private Button bt_seven;

	private Button bt_eight;

	private Button bt_nine;

	private Button bt_back;

	private Button bt_multiply;

	private Button bt_divide;

	private Button bt_sub;

	private Button bt_add;

	private Button bt_point;

	private Button bt_equal;

	private Button bt_clear;

	private EditText et_edit;

 

	private StringBuffer str_display = new StringBuffer();

	private boolean flag = true;

	private String str_oper = "+";

	private String str_result = "0";

	private double num1;

	private double num2;

	private boolean b_sub;

	private boolean b_mul;

	private boolean b_div;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		bt_zero = (Button) findViewById(R.id.bt_zero);

		bt_one = (Button) findViewById(R.id.bt_one);

		bt_two = (Button) findViewById(R.id.bt_two);

		bt_three = (Button) findViewById(R.id.bt_three);

		bt_four = (Button) findViewById(R.id.bt_four);

		bt_five = (Button) findViewById(R.id.bt_five);

		bt_six = (Button) findViewById(R.id.bt_six);

		bt_seven = (Button) findViewById(R.id.bt_seven);

		bt_eight = (Button) findViewById(R.id.bt_eight);

		bt_nine = (Button) findViewById(R.id.bt_nine);

		bt_back = (Button) findViewById(R.id.bt_back);

		bt_multiply = (Button) findViewById(R.id.bt_multiply);

		bt_divide = (Button) findViewById(R.id.bt_divide);

		bt_sub = (Button) findViewById(R.id.bt_sub);

		bt_add = (Button) findViewById(R.id.bt_add);

		bt_point = (Button) findViewById(R.id.bt_point);

		bt_equal = (Button) findViewById(R.id.bt_equal);

		bt_clear = (Button) findViewById(R.id.bt_clear);

		et_edit = (EditText) findViewById(R.id.et_edit);

		et_edit.setText("0.0");
		
		bt_zero.setOnClickListener(new OnClickListener() {

			 

			public void onClick(View v) {

				str_display.append("0");

				et_edit.setText(str_display.toString());

			}

		});

 

		bt_one.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				str_display.append("1");

				et_edit.setText(str_display.toString());

			}

		});

 

		bt_two.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				str_display.append("2");

				et_edit.setText(str_display.toString());

			}

		});

 

		bt_three.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				str_display.append("3");

				et_edit.setText(str_display.toString());

			}

		});

 

		bt_four.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				str_display.append("4");

				et_edit.setText(str_display.toString());

			}

		});

 

		bt_five.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				str_display.append("5");

				et_edit.setText(str_display.toString());

			}

		});

 

		bt_six.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				str_display.append("6");

				et_edit.setText(str_display.toString());

			}

		});

 

		bt_seven.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				str_display.append("7");

				et_edit.setText(str_display.toString());

			}

		});

 

		bt_eight.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				str_display.append("8");

				et_edit.setText(str_display.toString());

			}

		});

 

		bt_nine.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				str_display.append("9");

				et_edit.setText(str_display.toString());

			}

		});

 

		bt_point.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				if (flag) {

					str_display.append(".");

					et_edit.setText(str_display.toString());

					flag = false;

				}

			}

		});

 

		bt_back.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				if (str_display.length() != 0) {

					str_display.deleteCharAt(str_display.length() - 1);

					et_edit.setText(str_display.toString());

				}

			}

		});

 

		bt_add.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				str_oper = "+";

				if (str_display.toString() != "") {

					num1 += Double.parseDouble(str_display.toString());

					str_display = new StringBuffer("");

				}

				// �ڰ��ˡ�=����û����������ʱ��str_result��Ϊ�գ��ڰ��ˡ�=�������������ֺ�str_result���Ϊ�ա�������ͬ��

				if (str_result != null) {

					num1 = Double.parseDouble(str_result);

					str_result = null;

				}

				et_edit.setText(String.valueOf(num1));

				flag = true;

			}

		});

 

		bt_sub.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				str_oper = "-";

				if (b_sub == false && str_display.toString() != "") {

					num1 = Double.parseDouble(str_display.toString());

					et_edit.setText(String.valueOf(num1));

					str_display = new StringBuffer("");

					b_sub = true;

				} else {

					if (str_display.toString() != "") {

						num1 -= Double.parseDouble(str_display.toString());

						str_display = new StringBuffer("");

					}

					if (str_result != null) {

						num1 = Double.parseDouble(str_result);

						str_result = null;

					}

					et_edit.setText(String.valueOf(num1));

				}

				flag = true;

			}

		});

 

		

 

		bt_multiply.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				str_oper = "*";

				if (b_mul == false && str_display.toString() != "") {

					num1 = Double.parseDouble(str_display.toString());

					et_edit.setText(String.valueOf(num1));

					str_display = new StringBuffer("");

					b_mul = true;

				} else {

					if (str_display.toString() != "") {

						num1 *= Double.parseDouble(str_display.toString());

						str_display = new StringBuffer("");

					}

					if (str_result != null) {

						num1 = Double.parseDouble(str_result);

						str_result = null;

					}

					et_edit.setText(String.valueOf(num1));

				}

				flag = true;

			}

		});
		
		bt_divide.setOnClickListener(new OnClickListener() {

			 

			public void onClick(View v) {

				str_oper = "/";

				if (b_div == false && str_display.toString() != "") {

					num1 = Double.parseDouble(str_display.toString());

					et_edit.setText(String.valueOf(num1));

					str_display = new StringBuffer("");

					b_div = true;

				} else {

					if (str_display.toString() != "") {

						num1 /= Double.parseDouble(str_display.toString());

						str_display = new StringBuffer("");

					}

					if (str_result != null) {

						num1 = Double.parseDouble(str_result);

						str_result = null;

					}

					et_edit.setText(String.valueOf(num1));

				}

				flag = true;

			}

		});

 

		bt_equal.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {

				if (str_oper.equals("+")) {

					num2 = Double.parseDouble(str_display.toString());

					str_result = String.valueOf(num1 + num2);

					et_edit.setText(str_result);

					str_display = new StringBuffer("");

				}

				if (str_oper.equals("-")) {

					num2 = Double.parseDouble(str_display.toString());

					str_result = String.valueOf(num1 - num2);

					et_edit.setText(str_result);

					str_display = new StringBuffer("");

				}

				if (str_oper.equals("*")) {

					num2 = Double.parseDouble(str_display.toString());

					str_result = String.valueOf(num1 * num2);

					et_edit.setText(str_result);

					str_display = new StringBuffer("");

				}

				if (str_oper.equals("/")) {

					num2 = Double.parseDouble(str_display.toString());

					if (num2 != 0) {

						str_result = String.valueOf(num1 / num2);

						et_edit.setText(str_result);

					} else {

						Toast.makeText(TestActivity.this, "��������Ϊ�㣡", 0).show();

					}

					str_display = new StringBuffer("");

				}

			}

		});

 

		bt_clear.setOnClickListener(new OnClickListener() {

 

			public void onClick(View v) {
				Builder adb = new Builder(TestActivity.this);
				adb.setMessage("Are U sure to clear?");
				adb.setTitle("Clear!");
				adb.setNegativeButton("NO", null);
				adb.setPositiveButton("YES",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								str_oper = "+";

								str_display = new StringBuffer("");

								str_result = null;

								num1 = 0;

								num2 = 0;

								flag = true;

								b_div = false;

								b_mul = false;

								b_sub = false;

								et_edit.setText("0.0");
							}
						});
				adb.show();

				

			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
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
