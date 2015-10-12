package co.mitro.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by chamakits on 10/11/15.
 */
public class PropertiesLoader {

    private static PropertiesLoader INSTANCE = new PropertiesLoader();

    private final Properties commonProperties;
    private final Properties osProperties;

    private PropertiesLoader(){
        this("");
    }

    private PropertiesLoader(String osPropertyFileIn){
//        this("/win.config.properties", "/common.config.properties");
        this.commonProperties = new Properties();
        String commonPropertyFile = "/common.config.properties";
        InputStream in = PropertiesLoader.class.getResourceAsStream(commonPropertyFile);
        try {
            commonProperties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String osPropertyFile = "";
        if(!StringUtils.isEmpty(osPropertyFileIn)) {
            osPropertyFile = osPropertyFileIn;
        } else if(SystemUtils.IS_OS_WINDOWS){
            osPropertyFile = "/win.config.properties";
        } else if(SystemUtils.IS_OS_UNIX) {
            osPropertyFile = "/lin.config.properties";
        } else {
            throw new RuntimeException("Operating system does not match prepared OSes.");
        }

        this.osProperties = new Properties();
        in = PropertiesLoader.class.getResourceAsStream(osPropertyFile);
        try {
            osProperties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
