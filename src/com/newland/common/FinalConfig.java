package com.newland.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;

import com.android.uiautomator.tree.BasicTreeNode;
import com.newland.common.util.MyHttpClient;

public class FinalConfig {
	public static HashMap<String, String> applicationMap ;
	public static List<BasicTreeNode> checkList;
	public static File myScreenshotFile = null;
    public static String httpServer;
    public static Document document;
	/**
     * ��ȡ�����ļ�
     */
    public static void init(){
    	checkList = new ArrayList<BasicTreeNode>();
        String path = "config/config.ini";
        InputStream is = FinalConfig.class.getClassLoader().getResourceAsStream(path);
        BufferedReader reader = null;
        try {
            InputStreamReader read = new InputStreamReader(is, "UTF-8");
            reader = new BufferedReader(read);
            String tempString = "";
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
                // ��ʾ�к�
                if (tempString.indexOf("http��������") >= 0) {
                    tempString = reader.readLine();
                    FinalConfig.httpServer = tempString.substring(11);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        applicationMap = new HashMap<String,String>();
    }
}