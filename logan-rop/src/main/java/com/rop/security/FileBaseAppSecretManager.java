
package com.rop.security;

import java.io.IOException;
import java.util.Properties;

import me.ele.elog.Log;
import me.ele.elog.LogFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.rop.AppKeyContext;
import com.rop.RopException;

/**
 * <pre>
 *   基于文件管理的应用密钥
 * </pre>
 */
public class FileBaseAppSecretManager implements AppSecretManager {

    private static final String ROP_APP_SECRET_PROPERTIES = "rop.appSecret.properties";

    private String appSecretFile = ROP_APP_SECRET_PROPERTIES;

    protected final Log logger = LogFactory.getLog(getClass());

    private Properties properties;

    public String getSecret(String appKey) {
        if (properties == null) {
            try {
                DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
                Resource resource = resourceLoader.getResource(appSecretFile);
                properties =   PropertiesLoaderUtils.loadProperties(resource);
            } catch (IOException e) {
                throw new RopException("在类路径下找不到rop.appSecret.properties的应用密钥的属性文件", e);
            }
        }
        String secret = properties.getProperty(appKey);

        if (secret == null) {
            logger.error("不存在应用键为{0}的密钥,请检查应用密钥的配置文件。", appKey);
        }
        return secret;
    }

    public void setAppSecretFile(String appSecretFile) {
        this.appSecretFile = appSecretFile;
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

