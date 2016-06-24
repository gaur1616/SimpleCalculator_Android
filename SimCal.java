package com.hp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SimCal extends Activity {

	Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, b00, badd, bsub, bmul, bdiv, bclr, bdel, bdec, bsci, beq;
	EditText et;
	Double in1=Double.valueOf(0);
	Double in2=Double.valueOf(0);
	Double in3=Double.valueOf(1);
	Double r=Double.valueOf(0);
	Integer op=Integer.valueOf(0);
	Integer flag=Integer.valueOf(0);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sim_cal);
		b1=(Button)findViewById(R.id.b01);
		b2=(Button)findViewById(R.id.b02);
		b3=(Button)findViewById(R.id.b03);
		b4=(Button)findViewById(R.id.b04);
		b5=(Button)findViewById(R.id.b05);
		b6=(Button)findViewById(R.id.b06);
		b7=(Button)findViewById(R.id.b07);
		b8=(Button)findViewById(R.id.b08);
		b9=(Button)findViewById(R.id.b09);
		b0=(Button)findViewById(R.id.b0);
		b00=(Button)findViewById(R.id.b00);
		badd=(Button)findViewById(R.id.add);
		bsub=(Button)findViewById(R.id.sub);
		bmul=(Button)findViewById(R.id.mul);
		bdiv=(Button)findViewById(R.id.div);
		bclr=(Button)findViewById(R.id.clr);
		bdel=(Button)findViewById(R.id.del);
		bdec=(Button)findViewById(R.id.dec);
		bsci=(Button)findViewById(R.id.sci);
		beq=(Button)findViewById(R.id.res);
		et= (EditText)findViewById(R.id.editText1);
		
		OnClickListener listener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Button b= (Button)v;
				String s;
				if(flag==0)
				{
					s=b.getText().toString();
					et.setText(et.getText() + s);
				}
				else
				{
					et.setText(b.getText());
					flag=0;
				}
			}
		};
		b1.setOnClickListener(listener);
		b2.setOnClickListener(listener);
		b3.setOnClickListener(listener);
		b4.setOnClickListener(listener);
		b5.setOnClickListener(listener);
		b6.setOnClickListener(listener);
		b7.setOnClickListener(listener);
		b8.setOnClickListener(listener);
		b9.setOnClickListener(listener);
		b0.setOnClickListener(listener);
		b00.setOnClickListener(listener);
		bdec.setOnClickListener(listener);
		
        OnClickListener listener1 = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(op==0)
					in1=Double.parseDouble(et.getText().toString());
				else
					{
						switch(op)
						{
						case R.id.add:
							in2=Double.parseDouble(et.getText().toString());
							if(r==0)
								r=in1+in2;
							else
								r+=in2;
							break;
						case R.id.sub:
							in2=Double.parseDouble(et.getText().toString());
							if(r==0)
								r=in1-in2;
							else
								r-=in2;
							break;
						case R.id.mul:
							in2=Double.parseDouble(et.getText().toString());
							if(in3==1)
							{
								r=in1*in2;
								in3=r;
							}
							else
								r=in3*in2;
							break;
						case R.id.div:
							try{
							in2=Double.parseDouble(et.getText().toString());
							if(in3==1.0)
							{
								r=in1/in2;
								in3=r;
							}
							else
								r=in3/in2;
							}
							catch(ArithmeticException ee)
							{
								Toast.makeText(SimCal.this, ee.getMessage(), 3000).show();
							}

							break;
						}
						
					}
					et.setText(" ");
					op=v.getId();

			}
		};
		badd.setOnClickListener(listener1);
		bsub.setOnClickListener(listener1);
		bmul.setOnClickListener(listener1);
		bdiv.setOnClickListener(listener1);
		   
        beq.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(op)
				{
				case R.id.add:
					in2=Double.parseDouble(et.getText().toString());
					if(r==0)
						r=in1+in2;
					else
						r+=in2;
					et.setText(" ");
					op=R.id.add;
					break;
				case R.id.sub:
					in2=Double.parseDouble(et.getText().toString());
					if(r==0)
					r=in1-in2;
					else
					r-=in2;
					et.setText(" ");
					op=R.id.sub;
					break;
				case R.id.mul:
					in2=Double.parseDouble(et.getText().toString());
					if(in3==1)
					{
						r=in1*in2;
						in3=r;
					}
					else
						r=in3*in2;
					et.setText(" ");
					op=R.id.mul;
					break;
				case R.id.div:
					try{
					in2=Double.parseDouble(et.getText().toString());
					if(in3==1)
					{
						r=in1/in2;
						in3=r;
					}
					else
						r=in3/in2;
					et.setText(" ");
					op=R.id.div;
					}
					catch(ArithmeticException ee)
					{
						Toast.makeText(SimCal.this, ee.getMessage(), 3000).show();
						et.setText(" ");
					}

					break;
				}
				et.setText(r.toString());
				flag=1;
				in3=1.0;
				r=0.0;
				op=0;
			}
		});
        bclr.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				et.setText(" ");
			}
		});
        bdel.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				et.setText(" ");
			}
		});
     }
	
}
