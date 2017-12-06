package Service.Impl;

import Entities.Partita;
import Service.FileSaver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileSaverImplHTML implements FileSaver {

    @Override
    public String salvaClassifica(List righe) {


        int k=1;
        String css = "<style>" +
                ".col1{width:30px; text-align:right; padding-right:10px; font-weight:bold; display:inline-block;}\n" +
                ".col2{width:120px; text-align:left; padding:0 10px; display:inline-block;}\n" +
                ".col3{width:50px; text-align:right; padding:0px; font-weight:bold; display:inline-block;}\n" +
                "ol {list-style-type: none;}\n" +
                "</style>";
        String html_stars = "<html>\n<head>\n"+css+"\n</head>\n<body>\n";
        String html_end = "\n</body>\n<html>";

        String pag = "<ol>\n";
        for (Partita p : (List<Partita>) righe){
            String pos = "<span class=\"col1\" >"+k+"</span>\n";
            String persona = "<span class=\"col2\" >"+p.getPersona().getNickname()+"</span>\n";
            String punti = "<span class=\"col3\" >"+p.getPunteggio()+"</span>\n";

            String s = pos+persona+punti;
            pag += "<li>\n" + s + "</li>\n";
            k++;
        }
        pag +="</ol>\n";

        String fileName = "classifica.html";

        try {
            FileWriter fw =  new FileWriter(fileName);
            fw.write(html_stars+pag+html_end);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }
}
