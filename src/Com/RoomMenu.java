package Com;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;
//mport java.awt.event.ActionListener;

 class RoomMenu {

     JMenu menu, room_type,availabiltyofroom,time,date;
     JMenuItem Computer_Room,lecture_theatre,tutorial_room,during_weekdays,during_weekends,holidays;
     RoomMenu(){
        JFrame f= new JFrame("Menu and MenuItem Example");
        JMenuBar mb=new JMenuBar();
         menu=new JMenu("Menu");
         room_type=new JMenu("Type of Room");
         availabiltyofroom=new JMenu("Time");
         date=new JMenu("Date");
         Computer_Room=new JMenuItem("Computer Room");
         lecture_theatre=new JMenuItem("Lecture Theatre");
         tutorial_room=new JMenuItem("Tutorial Room");
         during_weekdays=new JMenuItem("During Weekdays");
         during_weekends=new JMenuItem("During Weekends");
         holidays=new JMenuItem("Holidays");
         room_type.add(Computer_Room);
         room_type.add(lecture_theatre);
         room_type.add(tutorial_room);
         menu.add(room_type);
         availabiltyofroom.add(during_weekdays);
         availabiltyofroom.add(during_weekends);
         menu.add(availabiltyofroom);
         availabiltyofroom.add(holidays);
         // menu.add(time);
          menu.add(date);

       //  menu.add(date);menu.add(room_type);menu.add(availabiltyofroom);
         mb.add(menu);
         f.setJMenuBar(mb);
         f.setSize(400,400);
         f.setLayout(null);
         f.setVisible(true);
     }
     public static void main(String[] args) {
        new RoomMenu();
     }

}