package com.bonyzone.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationUtils {

    static public Properties getProperties(String filename) throws IOException{
        Properties props = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream(filename);
        props.load(stream);
        return props;
    }
}