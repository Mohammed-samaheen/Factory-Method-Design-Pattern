package com;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


public class JSONFileParser implements FileParser {

    @Override
    public void parseFile(File file) {

        try {
            Object obj = new JSONParser().parse(new FileReader(file));
            JSONObject jsonObject=(JSONObject)obj;
            ArrayList<String> arrayKey= new ArrayList<String>();

            jsonObject.keySet().forEach(key -> arrayKey.add((String) key));

            for(int i=0;i<arrayKey.size();i++){

                String output="Type: "+ arrayKey.get(i)+"\n------------------\n";

                Map key = ((Map)jsonObject.get(arrayKey.get(i)));

                Iterator<Map.Entry> itr1 = key.entrySet().iterator();
                while (itr1.hasNext()) {
                    Map.Entry pair = itr1.next();
                    output+=pair.getKey()+" : "+pair.getValue()+"\n";

                }
                Util.Logger.log(output);
            }




        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
