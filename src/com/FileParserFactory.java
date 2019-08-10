package com;

public class FileParserFactory {

    public FileParser getFileParser(String fileParserType){
        if (fileParserType==null)
            return null;
        else if(fileParserType.equalsIgnoreCase("XMLFileParser"))
            return new XMLFileParser();
        else if(fileParserType.equalsIgnoreCase("JSONFileParser"))
            return new JSONFileParser();

        return null;
    }
}
