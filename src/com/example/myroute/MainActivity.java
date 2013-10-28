package com.example.myroute;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.TabHost;
import android.app.TabActivity;
import android.widget.TabHost.OnTabChangeListener;
 
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity implements OnTabChangeListener{
 
    /** Called when the activity is first created. */
      TabHost tabHost;
       
      @Override
      public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.tablayout_main);
           
          // Get TabHost Reference
          tabHost = getTabHost();
           
          // Set TabChangeListener called when tab changed
          tabHost.setOnTabChangedListener(this);
       
          TabHost.TabSpec spec;
          Intent intent;
     
           /************* TAB1 ************/
          // Create  Intents to launch an Activity for the tab (to be reused)
          intent = new Intent().setClass(this, tab.class);
          spec = tabHost.newTabSpec("First").setIndicator("").setContent(intent);
           
          //Add intent to tab
          tabHost.addTab(spec);
     
          /************* TAB2 ************/
          intent = new Intent().setClass(this, tab.class);
          spec = tabHost.newTabSpec("Second").setIndicator("").setContent(intent);  
          tabHost.addTab(spec);
     
             
          // Set drawable images to tab
          tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.tab);
          tabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.tab1);
             
          // Set Tab1 as Default tab and change image   
          tabHost.getTabWidget().setCurrentTab(0);
          tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.tab);
          
     
       }
 
    @Override
    public void onTabChanged(String tabId) {
         
        /************ Called when tab changed *************/
         
        //********* Check current selected tab and change according images *******/
         
        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
            if(i==0)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab);
            else if(i==1)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab1);
           
        }
         
         
        Log.i("tabs", "CurrentTab: "+tabHost.getCurrentTab());
         
    if(tabHost.getCurrentTab()==0)
        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.tab);
    else if(tabHost.getCurrentTab()==1)
        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.tab1);
    
         
    }
 
}