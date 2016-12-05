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
			Object[] objArray=(Object[])bundle.get("pdus");//��ȡ�õ��Ķ�������
			SmsMessage[] messages=new SmsMessage[objArray.length];//����SmsMessage���飬��װ��������
			for(int i=0;i<objArray.length;i++){
				messages[i]=SmsMessage.createFromPdu((byte[])objArray[i]);//��ÿ������ת����SmsMessage����
				String s="�ֻ��ţ�"+messages[i].getOriginatingAddress()+"\n";//��õ绰����Ͷ������ݣ�toast��ʾ��ʾ
				s+="�������ݣ�"+messages[i].getDisplayMessageBody();
				Toast.makeText(context, s, Toast.LENGTH_LONG).show();
			}
		}
		//Toast.makeText(context, "aaa", Toast.LENGTH_LONG).show();
		
	}

}
