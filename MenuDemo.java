 
package steelworks;

import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 Класс формирования меню с регистрацией событий выбора пунктов меню
 * @author User
 */
public class MenuDemo extends JFrame implements ActionListener {

    JLabel jlab;
    SteelScore x;
    ReadFile f;
    MenuDemo () throws IOException {
        JFrame jfrm = new JFrame ("Расчет разверток пирамиды и колена");
        jfrm.setLayout (new FlowLayout());
        jfrm.setSize(700, 400);
        jfrm.setLocation(500,300);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlab = new JLabel();
        // Объект класса для расчета разверток SteelScore
        x = new SteelScore();
        f = new ReadFile();
            JMenuBar jmb = new JMenuBar();
        //Создать меню Файл
            JMenu jmFile = new JMenu ("Выбор задачи") ; // Файл
            JMenuItem jmiOpen = new JMenuItem("Развертка колена") ; // Открыть
            JMenuItem jmiClose = new JMenuItem("Развертка пирамиды") ; // Закрыть
            JMenuItem jmiSave = new JMenuItem("Развертка вальмы") ; // Сохранить
            JMenuItem jmiHalfPipe = new JMenuItem("Развертка угла желоба") ; // Сохранить
            JMenuItem jmiExit = new JMenuItem("Exit") ; // Выйти
            
            jmFile.add(jmiOpen);
            jmFile.add(jmiClose);
            jmFile.add(jmiSave);
            jmFile.add(jmiHalfPipe);
            jmFile.addSeparator();
            jmFile.add(jmiExit);
            jmb.add(jmFile);

//создать меню Help
JMenu jmHelp = new JMenu ("Help"); // Справка
JMenuItem jmiAbout = new JMenuItem("About"); // О программе
jmHelp.add(jmiAbout);
jmb.add(jmHelp);

// ввести приемники действий от пунктов меню
jmiOpen.addActionListener(this);
jmiClose.addActionListener(this);
jmiSave.addActionListener(this);
jmiHalfPipe.addActionListener(this);
jmiExit.addActionListener(this);

jmiAbout.addActionListener(this);

jfrm.add(jlab);
jfrm.setJMenuBar(jmb);
jfrm.setVisible(true);
}

    /**
     *Вывод файла Help в окне
     */
     void TextAreaTest() 
    {
        //super("Пример JTextArea");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Cоздание многострочных полей
        JTextArea area1 = null;
        try {
            area1 = new JTextArea(f.readfile(), 30, 80);
            //area1 = new JTextArea(f.readfile());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MenuDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MenuDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Шрифт и табуляция
        area1.setFont(new Font("Dialog", Font.PLAIN, 14));
        

        // Добавим поля в окно
        JPanel contents = new JPanel();
        contents.add(new JScrollPane(area1));
        //contents.add(area1);
        setContentPane(contents);
        setLocation (300, 300);
        // Выводим окно на экран
        setSize(1000, 500);
        setVisible(true);
    }
 
   
    
// обработать события действия от пунктов меню

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed (ActionEvent ae){
// получить команду действия из выбранного меню
String comStr = ae.getActionCommand();

if(comStr.equals("Развертка колена")) x.steelKnee();
if(comStr.equals("Развертка вальмы")) x.pyramidV();
if(comStr.equals("Развертка пирамиды")) x.pyramid();
if(comStr.equals("Развертка угла желоба")) x.steelAngleofHalfPipe();
if(comStr.equals("About")) {
        TextAreaTest();
          }

// выйти из програыыы, если пользователь выберет пункт меню Zxit
if(comStr.equals("Exit")) System.exit(0);
   }
 }



   