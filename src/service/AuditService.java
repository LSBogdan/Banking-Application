package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    FileWriter writer;

    public void logAction(String action) throws IOException{
        writer.append(action);
        writer.append(",");
        writer.append(formatter.format(LocalDateTime.now()));
        writer.append("\n");
        writer.flush();
    }

    public AuditService(){
        try{
            this.writer = new FileWriter("data/audit.csv");
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
