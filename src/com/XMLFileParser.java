package com;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;


public class XMLFileParser implements FileParser {

    private String output;
    private String rootNodeName;
    @Override
    public void parseFile(File file) {

        DocumentBuilder dBuilder = null;
        try {
            dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            Document doc = dBuilder.parse(file);
                 rootNodeName=doc.getDocumentElement().getNodeName();
             output="Type: "+rootNodeName+"\n------------------\n";


            if (doc.hasChildNodes()){
                printNode( doc.getChildNodes());
                Util.Logger.log(output);
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printNode(NodeList nodeList){

        for (int count = 0; count < nodeList.getLength(); count++){
            Node tempNode = nodeList.item(count);


            // make sure it's element node.
            if (tempNode.getNodeType() == Node.ELEMENT_NODE){

                // get node name and value
                if(!rootNodeName.equals(tempNode.getNodeName()))
                    output+=(tempNode.getNodeName() + ": "+tempNode.getTextContent()+"\n");
                if (tempNode.hasAttributes()){

                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();

                    for (int i = 0; i < nodeMap.getLength(); i++){

                        Node node = nodeMap.item(i);
                        output+=("\t" + node.getNodeName()+": "+node.getNodeValue()+"\n");
                    }

                }



            }if (tempNode.hasChildNodes()){

                // loop again if has child nodes
                printNode(tempNode.getChildNodes());
            }
        }


    }
}
