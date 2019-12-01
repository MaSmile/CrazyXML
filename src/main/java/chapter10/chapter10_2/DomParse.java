package chapter10.chapter10_2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author 10152323
 * @date 2019/12/1
 * @description
 */
public class DomParse {
    public static void main(String[] args) throws Exception {
        // DOM解析器工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 设置解析器是否删除元素内容里的空格
        factory.setIgnoringElementContentWhitespace(true);
        // 获取DOM解析器
        DocumentBuilder builder = factory.newDocumentBuilder();
        // 解析XML文档，并获取该XML文件对应的Document
        Document document = builder.parse(new File("src/main/resources/xml/book-list.xml"));
        // 获取根节点的方法
        Element bookList = document.getDocumentElement();
        // 获取根节点包含的所有“计算机书籍”子元素，如果传入*作参数，可获取所有子元素
        NodeList nodeList = bookList.getElementsByTagName("计算机书籍");
        // 遍历每个子元素
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("----------第" + i + "本计算机书籍----------");
            Node comBook = nodeList.item(i);
            // 获取ISBN属性节点
            Node isbnAttr = comBook.getAttributes().getNamedItem("ISBN");
            if (null != isbnAttr) {
                System.out.println("该图书的ISBN为：" + isbnAttr.getTextContent());
            }
            // 获取comBook下的所有子元素
            NodeList attList = comBook.getChildNodes();
            for (int j = 0; j < attList.getLength(); j++) {
                System.out.println(attList.item(j).getTextContent().trim());
            }
        }
        // 获取根元素中包含所有“文学书籍”的子元素
        nodeList = bookList.getElementsByTagName("文学书籍");
        // 遍历每个子元素
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("----------第" + i + "本文学书籍----------");
            System.out.println(nodeList.item(i).getTextContent().trim());
        }
        // 获取根元素中包含所有“哲学书籍”的子元素
        nodeList = bookList.getElementsByTagName("哲学书籍");
        // 遍历每个子元素
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("----------第" + i + "本哲学书籍----------");
            System.out.println(nodeList.item(i).getTextContent().trim());
        }
    }
}
