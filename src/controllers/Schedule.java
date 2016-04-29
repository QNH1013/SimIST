package controllers;
import org.jsoup.nodes.*;
import org.jsoup.parser.*;
import org.jsoup.select.Elements;
import java.io.*;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class Schedule extends JPanel  {
    
    private JPanel sch;
    private JLabel classInfo;
    private JTextArea course_abbrev;
    private JTextArea class_details;
    
    
    
    public Schedule(){
        setLayout(null);
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        classInfo = new JLabel("IST 2015-2016 Schedule");
        classInfo.setEnabled(false);
        sch = new JPanel();
       
            File inputSchedule = new File("src/controllers/ISTschedule.htm");
         try {
            Document html = Jsoup.parse(inputSchedule, "UTF-8");
            Elements allCourses = html.body().getElementsByClass("course_abbrev");
            String test = allCourses.text();
            course_abbrev = new JTextArea(test);
            Elements moreInfo = html.body().getElementsByClass("course_description");
            String test2 = moreInfo.text();
            class_details = new JTextArea(test2);
        }catch (IOException e){
            System.out.printf("Fail");
        }
        
    }
}
