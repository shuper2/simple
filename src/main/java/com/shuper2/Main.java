package com.shuper2;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: <xmlAddress> <exportDir>");
            return;
        }
        String xmlAddress = args[0];
        String exportDir = args.length >= 2 ? args[1] : getParentDirAddress(xmlAddress);
        System.out.println("xmlAddress: " + xmlAddress);
        System.out.println("exportDir: " + exportDir);
    }

    static String getParentDirAddress(String fileAddress) {
        File file = new File(fileAddress);
        return file.getParent();
    }

    public void handle(String xmlAddress, String exportDir) {
        File inFile = new File(xmlAddress);
        File outFile = new File(exportDir, inFile.getName()+".out");
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(inFile);
            Element rootElement = document.getRootElement();
            processElement(rootElement);
            writeXML(outFile, document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    void writeXML(File outFile, Document document) {
        try {
            XMLWriter writer = new XMLWriter(new OutputStreamWriter(
                    new FileOutputStream(outFile)));
            writer.write(document);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    void processElement(Element rootElement) {

    }
}
