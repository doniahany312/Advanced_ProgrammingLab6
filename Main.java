import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
       // System.out.println("Hello world!");
        try
        {
            String filename=args[0];
            if(!filename.endsWith(".arxml")){
                throw new NotValidExtension("Invalid file extension");}
            File file= new File(filename);
            FileInputStream inputStream = new FileInputStream(file);
            int d;
            StringBuilder stringBuilder= new StringBuilder();
            while ((d=inputStream.read())!=-1)
            {
               stringBuilder.append((char)d);
            }
            System.out.println(stringBuilder.toString());
            String data=stringBuilder.toString();
            Scanner scanner = new Scanner(data);
            ArrayList<arxml> arxmls = new ArrayList<>();
            while(scanner.hasNextLine()){
                String line= scanner.nextLine();
                if(line.contains("<CONTAINER")){
                    String id = line.substring(line.indexOf("=")+1,line.indexOf(">"));
                    String shortName = scanner.nextLine();
                    String ShortName = shortName.substring(shortName.indexOf("er")+2,shortName.indexOf("</S"));
                    String longName = scanner.nextLine();
                    String LongName = longName.substring(longName.indexOf(">")+1,longName.indexOf("</"));
                    arxml arxml = new arxml();
                    arxml.setUuid(id);
                    arxml.setShortName(ShortName);
                    arxml.setLongName(LongName);
                    arxmls.add(arxml);
                }
            }
            Collections.sort(arxmls);
            String outNme=filename.substring(0,filename.indexOf("."))+"_mod.arxml";
            FileOutputStream fileOutputStream = new FileOutputStream(outNme);
            fileOutputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            fileOutputStream.write("<AUTOSAR>\n".getBytes());
            for(int i=0 ;i<arxmls.size();i++){

                    fileOutputStream.write(arxmls.get(i).toString().getBytes());
            }
            fileOutputStream.write("</AUTOSAR>\n".getBytes());






        } catch (NotValidExtension e) {
            NotValidExtension notValidExtension= new NotValidExtension("Not Valid Extension Invoked");
        } catch (FileNotFoundException e) {
            e= new FileNotFoundException("File Not Found");
        } catch (IOException e) {
            e=new IOException("IO Exception");
        }
    }
}