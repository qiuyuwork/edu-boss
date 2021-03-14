package com.lagou.commom;

import lombok.Data;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.Objects;

public class Config {

    public static final String IMGSTORE;
    public static final String DOMAIN;

    static {
        String imgStore=null;
        String domain=null;
        try {
            SAXReader reader = new SAXReader();
            Document doc = null;
            doc = reader.read(Config.class.getResourceAsStream("/Config.xml"));
            imgStore = doc.selectSingleNode("//img-store").getStringValue();
            domain = doc.selectSingleNode("//domain").getStringValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        IMGSTORE = Objects.requireNonNullElse(imgStore,"imgStore");
        DOMAIN = Objects.requireNonNullElse(domain,"http://localhost:8080");

    }
}
