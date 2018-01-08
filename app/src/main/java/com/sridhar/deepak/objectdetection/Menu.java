package com.sridhar.deepak.objectdetection;

/**
 * Created by deep1 on 1/7/2018.
 */

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Field;

public class Menu extends ListActivity {
    String classes[]={"CatsvsDogs","TensorFlowDemo"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //fullscreen
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub

        super.onListItemClick(l, v, position, id);
        String c=classes[position];
        try{
            Class oc=Class.forName("com.sridhar.deepak.objectdetection."+ c);
            Intent our=new Intent(Menu.this,oc);
            startActivity(our);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuInflater bu = getMenuInflater();
        bu.inflate(R.menu.coolmenu, menu);
        getOverflowMenu();
        return true;
    }

    public void getOverflowMenu() {

        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId()){
            case R.id.au:
                Intent i=new Intent("com.sridhar.deepak.objectdetection.ABOUT");
                startActivity(i);
                break;
            case R.id.p:
                Intent is=new Intent("com.sridhar.deepak.objectdetection.PREF");
                startActivity(is);
                break;
            case R.id.e:
                finish();
                break;
        }
        return false;
    }
}
