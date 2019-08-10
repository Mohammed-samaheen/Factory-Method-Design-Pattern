package com;




import java.io.File;
import java.util.Scanner;


public class FactoryMethodDesignPattern {
        public static void main(String[] args){


                // Delete log file on project start
                File file = new File("result.txt");

                if (file.delete()) {
                        System.out.println("File deleted successfully");
                }



                FileParserFactory fileParserFactory=new FileParserFactory();

                System.out.print("Choose the type of the file :\n\t1-xml\n\t2-json\n-> ");
                Scanner input =new Scanner(System.in);



                int choose =input.nextInt();
                switch (choose){
                        case 1:
                                System.out.print("Enter the file name :");
                                String nameXmlFile=input.next();//SI2.xml

                                        File xmlFileReader =new File(nameXmlFile);
                                        FileParser xmlFile=fileParserFactory.getFileParser("XMLFileParser");
                                        xmlFile.parseFile(xmlFileReader);

                                break;
                        case 2:
                                System.out.print("Enter the file name :");
                                String nameJsoneFile=input.next();//SI1.json

                                        File JsoneFileReader =new File(nameJsoneFile);
                                        FileParser JsoneFile=fileParserFactory.getFileParser("JSONFileParser");
                                        JsoneFile.parseFile(JsoneFileReader);
                                break;
                        default:
                                System.out.println("\nyour choice does not exist\n");
                                break;


                }

        }
}
