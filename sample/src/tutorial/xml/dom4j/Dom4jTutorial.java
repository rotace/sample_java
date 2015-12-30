package tutorial.xml.dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Dom4J Tutorial
 * [URL] http://rad.ihu.edu.gr/fileadmin/labsfiles/knowledge_management/TUTORIALS/dom4j.pdf
 * Created by usr on 15/11/29.
 */
public class Dom4jTutorial {

    public static void main(String[] args) throws IOException, DocumentException {

        String filePath = "sample/bin/foo.xml";
        FileWriter out = new FileWriter(filePath);
        Document document1 = createDocument();
        document1.write(out);
        out.flush();
        out.close();

        Document document2 = parse(filePath);
        String text = document2.asXML();
        System.out.println(text);

        useIterator(document2);

        navigateWithXPath(document2);
    }

    private static void navigateWithXPath(Document document) {
        System.out.println("navigateWithXPath");
        List list = document.selectNodes("//book/@category");
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            Attribute attribute = (Attribute) iter.next();
            String category = attribute.getValue();
            System.out.println("Category:" + category);
        }
        Node node = document.selectSingleNode("//book");
        System.out.println("category:" + node.valueOf("@category"));
    }

    private static void useIterator(Document document) {
        Element root = document.getRootElement();
        System.out.println("ROOP1");
        for (Iterator i = root.elementIterator(); i.hasNext(); ) {
            Element element = (Element) i.next();
            System.out.println("Name:" + element.getName());
            System.out.println("Value:" + element.getText());
        }
        System.out.println("ROOP2");
        for (Iterator i = root.elementIterator("book"); i.hasNext(); ) {
            Element element = (Element) i.next();
            System.out.println("Name:" + element.getName());
            System.out.println("Value:" + element.getText());
            System.out.println("ROOP-Attribute");
            for (Iterator j = element.attributeIterator(); j.hasNext(); ) {
                Attribute attribute = (Attribute) j.next();
                System.out.println("Name:" + attribute.getName());
            }
        }
        System.out.println("ROOP3");
        for (Iterator j = root.attributeIterator(); j.hasNext(); ) {
            Attribute attribute = (Attribute) j.next();
            System.out.println("Name:" + attribute.getName());
        }
    }

    public static Document createDocument() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("books");

        Element book1 = root.addElement("book").addAttribute("category", "history");
        book1.addElement("title").addText("Cultural Atlas of Ancient Egypt");
        book1.addElement("author").addText("John Baines");
        book1.addElement("author").addText("Jaromir Malek");
        book1.addElement("price").addText("23.99");

        Element book2 = root.addElement("book").addAttribute("category", "science");
        book2.addElement("title").addText("The Einstein Theory of Relativity");
        book2.addElement("author").addText("Hendrik Antoon Lorentz");
        book2.addElement("rating").addText("4");
        book2.addElement("price").addText("3.99");

        return document;
    }

    public static Document parse(String filePath) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(filePath);
        return document;
    }

}
