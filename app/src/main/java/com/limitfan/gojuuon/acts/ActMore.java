package com.limitfan.gojuuon.acts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.limitfan.gojuuon.R;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.UMFeedbackService;
import com.umeng.xp.common.ExchangeConstants;
import com.umeng.xp.controller.ExchangeDataService;
import com.umeng.xp.view.ExchangeViewManager;

public class ActMore extends Activity {
	
	 ImageButton gojuon_intro,more_apps,about_this_app,feedback,down_more,remove_ad,test;
	 
	 String ret="【获取余额失败，请重新打开本对话框】";
	 public String getBalance(){

			   return ret;
	
	 }
	 
	 
	 private static ExchangeDataService exchangeDataService2;


	 public void onCreate(Bundle paramBundle)
	  {
		// System.out.println("ActMore:Here!!!!");
	    super.onCreate(paramBundle);
	    
	    
	   // TextView tv=new TextView(this);
	   // tv.setText("hellO");

	    setContentView(R.layout.more);
	    
	    
	    exchangeDataService2 = new ExchangeDataService();
//		ImageView imageview2 = (ImageView)findViewById(R.id.imageview2);
//		ExchangeViewManager viewManager = new ExchangeViewManager(this, exchangeDataService2);
//		viewManager.addView(ExchangeConstants.type_list_curtain, imageview2,this.getResources().getDrawable(R.drawable.umeng_xp_handler_rc));
	    

	    TextView title=(TextView)findViewById(R.id.title);	    
	    title.setText(R.string.title_more);
	    
	    
	    
	    gojuon_intro=(ImageButton)this.findViewById(R.id.gojuon_intro);
	    more_apps=(ImageButton)this.findViewById(R.id.more_apps);
	    about_this_app=(ImageButton)this.findViewById(R.id.about_this_app);
	    feedback=(ImageButton)this.findViewById(R.id.feedback);
	    down_more=(ImageButton)this.findViewById(R.id.down_more);
	    remove_ad=(ImageButton)this.findViewById(R.id.remove_ad);
	    //test=(ImageButton)this.findViewById(R.id.drill);
	    gojuon_intro.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent intent=new Intent(ActMore.this,ActInfo.class);
				 
				 Bundle bundle=new Bundle();
				 bundle.putInt("id", 0);
				 intent.putExtras(bundle);
		         ActMore.this.startActivity(intent);
				
				
			}
	    	
	    	
	    });
	    more_apps.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent intent=new Intent(ActMore.this,ActRecommend.class);
//				 
//				 Bundle bundle=new Bundle();
//				 bundle.putInt("id", 1);
//				 intent.putExtras(bundle);
		         ActMore.this.startActivity(intent);
				
				
			}
	    	
	    	
	    });
	    
	    about_this_app.setOnClickListener(new ForwardListener());
	 
	    feedback.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			//	MobclickAgent.openFeedbackActivity(ActMoreAbout.this);
			//	UMFeedbackService.openUmengFeedbackSDK(this);
				UMFeedbackService.openUmengFeedbackSDK(ActMore.this);
			}
	    	
	    	
	    });
	    
//	    test.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View arg0) {
//				   Intent intent=new Intent(ActMore.this,ActTest.class);
//		           ActMore.this.startActivity(intent);
//					
//			}
//	    	
//	    	
//	    });
//	    
	    down_more.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			}
	    	
	    	
	    });
	    
	    
	    
	    
	    remove_ad.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String balance=getBalance();
				String detail=ActMore.this.getResources().getString(R.string.need_extra_detail);
				String me=ActMore.this.getResources().getString(R.string.current_coin);
				String chuui=ActMore.this.getResources().getString(R.string.coin_error);
				AlertDialog alertDialog = new AlertDialog.Builder(ActMore.this)
				.setTitle(R.string.need_extra)
				.setMessage(detail+"\n"+me+balance+"\n"+chuui).
				setNeutralButton(R.string.get_coin, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which){
						//new WallThread().start();
					}
				})
				.setPositiveButton(R.string.activate, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which){
						Toast.makeText(ActMore.this,
								R.string.processing,
								Toast.LENGTH_SHORT).show();
						//new WallThread().start();
					}
				}).setNegativeButton(R.string.confirm,
						new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which){
					
					}}).create();  //创建对话框
					alertDialog.show(); // 显示对话框	
	
			}
	    	
	    	
	    });
	    
	  }
	 
	 class ForwardListener implements OnClickListener{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	           //Intent intent=new Intent(ActMore.this,ActMoreAbout.class);
	           //ActMore.this.startActivity(intent);
				
			}
			 
			 
		 }
	   public void onResume() { 
	        super.onResume(); 
	       MobclickAgent.onResume(this);
	    }
	    public void onPause() { 
	        super.onPause(); 
	      MobclickAgent.onPause(this); 
	    }
		 @Override
		    public boolean onKeyDown(int keyCode, KeyEvent event) {
		    if(keyCode == KeyEvent.KEYCODE_BACK) {
		        new AlertDialog.Builder(this)
		        .setTitle(R.string.exit)
		        .setMessage(R.string.confirm_exit)
		        .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {

		            @Override
		            public void onClick(DialogInterface dialog, int which) {
	                       ActMore.this.finish();
		            }

		        })
		        .setNegativeButton(R.string.cancel, null)
		        .show();

		        return true;
		    }
		    else {
		        return super.onKeyDown(keyCode, event);
		    }

		}
		 public void onDestroy(){
			 super.onDestroy();
		 }
			public int isUnlocked(){
				SharedPreferences sp=this.getSharedPreferences("key", Context.MODE_PRIVATE);
				return sp.getInt("key", 0);
			}
		    public void unlock(){
		    	SharedPreferences sp=this.getSharedPreferences("key", Context.MODE_PRIVATE);
		    	Editor ed=sp.edit();
		    	ed.putInt("key", 1);
		    	ed.commit();	
		    	//unlocked=1;
		    	
		    }
}