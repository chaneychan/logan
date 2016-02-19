package me.ele.logan.web; 

import com.rop.AppKeyContext;
import com.rop.security.AppSecretManager;

import java.util.HashMap;
import java.util.Map;


public class SampleAppSecretManager implements AppSecretManager {

    private static Map<String, String> appKeySecretMap = new HashMap<String, String>();

    static {
        appKeySecretMap.put("00001", "abcdeabcdeabcdeabcdeabcde");
        appKeySecretMap.put("00002","abcdeabcdeabcdeabcdeaaaaa");
        appKeySecretMap.put("00003","abcdeabcdeabcdeabcdeaaaaa");
    }


    public String getSecret(String appKey) {
        System.out.println("use SampleAppSecretManager!");
        return appKeySecretMap.get(appKey);
    }


    public boolean isValidAppKey(AppKeyContext appKeyContext) {
        return getSecret(appKeyContext.getAppKey()) != null;
    }


	@Override
	public AppKeyContext getAppKeyContext(String appKey) {
		// TODO Auto-generated method stub
		return null;
	}

}

