package com.example.intent;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class HelloIntentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_intent);
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);
		menu.add(0, Menu.FIRST+1, 1, R.string.open_menu);
		menu.add(0, Menu.FIRST+2, 2, R.string.edit_menu);
		menu.add(0, Menu.FIRST+3, 3, R.string.update_ment);
		menu.add(0, Menu.FIRST+4, 4, R.string.close_menu);
		return true;
		
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		super.onOptionsItemSelected(item);
		
		switch(item.getItemId())
		{
		
		case Menu.FIRST+1:
		{
				this.setTitle("Open text!");
				Intent inte=new Intent();
				inte.setAction("Open_action");
				this.startActivity(inte);
				/*if(Tools.isIntentAvailable(this,inte)){
					this.startActivity(inte);
				}
				else{
					this.setTitle("Can't availabel.");
				}*/
			break;
		}
		case Menu.FIRST+2:
		{
			this.setTitle("Edit text!");
			break;
		}
		case Menu.FIRST+3:
		{
			this.setTitle("Update text!");
			break;
		}
		case Menu.FIRST+4:
		{
			this.setTitle("Exit text!");
			AlertDialog alertdialog= new AlertDialog.Builder(HelloIntentActivity.this)
			.setTitle("Dialog")
			.setMessage("Are you sure to exit!")
			.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					System.exit(0);
					dialog.cancel();
				}
			})
			.setNegativeButton("No", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			}).create();
		//Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG).show();
		alertdialog.show();
			break;
		}
			
		}
		
		return true;
	}

}
