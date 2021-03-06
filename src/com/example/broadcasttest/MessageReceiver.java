package com.example.broadcasttest;


import java.util.Set;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MessageReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle=intent.getExtras();
		if(bundle!=null){
			Set<String> keys=bundle.keySet();
			for(String key:keys){
				Log.d("key",key);
			}
			Object[] objArray=(Object[])bundle.get("pdus");//获取得到的短信数据
			SmsMessage[] messages=new SmsMessage[objArray.length];//定义SmsMessage数组，封装短信内容
			for(int i=0;i<objArray.length;i++){
				messages[i]=SmsMessage.createFromPdu((byte[])objArray[i]);//将每条短信转换成SmsMessage类型
				String s="手机号："+messages[i].getOriginatingAddress()+"\n";//获得电话号码和短信内容，toast提示显示
				s+="短信内容："+messages[i].getDisplayMessageBody();
				Toast.makeText(context, s, Toast.LENGTH_LONG).show();
			}
		}
		//Toast.makeText(context, "aaa", Toast.LENGTH_LONG).show();
		
	}

}
