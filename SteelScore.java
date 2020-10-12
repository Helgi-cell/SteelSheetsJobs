/*
Класс SteelScore содержит методы для расчета разверток
водосточного колена, правильной пирамиды и вальмы.
Описание методов находятся в интерфейсе MyInterfaceHat
 */
package steelworks;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
class SteelScore implements MyInterfaceHat {
    //Переменные для расчета разверток. Общие для обоих расчетов. 
    private static double ai, bi, hi, biH,angleKnee, step;
    private static int iteration;
     
    // Метод расчета развертки колена 
    @Override
    public void steelKnee(){
    KneeTable outTable;
    outTable = new KneeTable();
                try {        
                ai= inData("\n диаметр колена , мм");
                bi= inData("\n угол колена , град.");
                iteration = (int) inData("количество итераций развертки ");
                iteration= iteration/4*4; 
                angleKnee = angleData(bi);
                step= 3.14*ai/iteration;
                Otrarray(iteration,ai/2, angleKnee,step);
                outTable.KneeTable();
                    }
                catch(ArrayIndexOutOfBoundsException ехс){
                JOptionPane.showMessageDialog (null, "Слишком большое количество итераций. Ошибка ввода");
            }
                catch (NumberFormatException ехс){
                JOptionPane.showMessageDialog (null, "Неверный ввод числового значения. Ошибка ввода");
                }
                catch (ArithmeticException ехс){
                JOptionPane.showMessageDialog (null, "Попытка деления на ноль. Ошибка ввода");
                }
      }
    
  public void steelAngleofHalfPipe(){
    KneeTable outTable;
    outTable = new KneeTable();
                try {        
                ai= inData("\n диаметр желоба , мм");
                bi= inData("\n угол желоба , град.");
                iteration = (int) inData("количество итераций развертки ");
                iteration= iteration/4*4; 
                angleKnee = angleDataofHalfPipe(bi);
                step= 3.14*(ai/2)/(double)iteration;
                OtrarrayofHalfPipe(iteration,ai/2, angleKnee,step);
                outTable.KneeTable();
                    }
                catch(ArrayIndexOutOfBoundsException ехс){
                JOptionPane.showMessageDialog (null, "Слишком большое количество итераций. Ошибка ввода");
            }
                catch (NumberFormatException ехс){
                JOptionPane.showMessageDialog (null, "Неверный ввод числового значения. Ошибка ввода");
                }
                catch (ArithmeticException ехс){
                JOptionPane.showMessageDialog (null, "Попытка деления на ноль. Ошибка ввода");
                }
      }  
    
    
    
// Метод расчета развертки пирамиды правильной    
    @Override
    public void pyramid () {
        
        try{
                ai = inData("Сторону основания А (см) =");
                bi = inData("Сторону основания В (см) (где будет замок) =");
                hi = inData("Высоту пирамиды (см) =");
                biH= bi/2;
JOptionPane.showMessageDialog (null, "Данные для развертки пирамиды : \n " + 
                      "Сторона (см) A= " + ai +"\n Сторона (см) B= " + 
                            bi +"\n Половина стороны В (см) (замок)= " +
                                biH +"\n Высота (см) H= " + String.format("%.1f",showData(ai,hi))+
                                     "\n Ребро пирамиды (см) = " + String.format("%.1f",showData(ai,bi,hi)));                      
                                }
                  
         catch (NumberFormatException ехс){
           JOptionPane.showMessageDialog (null, "Неверный ввод числового значения. Ошибка ввода");
                }
         catch (ArithmeticException ехс){
           JOptionPane.showMessageDialog (null, "Попытка деления на ноль. Ошибка ввода");
                }  
      }

    
    @Override
  public void pyramidV () {
        
        try{
                ai = inData("Сторону боковую основания А (см) (где будет замок) =");
                bi = inData("Сторону основания В (см)(длинную)  =");
                hi = inData("Высоту вальмы (см) =");
                biH= bi/2;
JOptionPane.showMessageDialog (null, "Данные для развертки вальмы : \n " + 
                      "Сторона (см) A= " + ai +"\n Сторона (см) B= " + 
                            bi +"\n Половина стороны А (см) (замок)= " +
                                ai/2 +"\n Высота (см) H= " + String.format("%.1f",showData(ai,hi))+
                                     "\n Ребро вальмы (см) = " + String.format("%.1f",showData(ai,ai,hi)));                      
                                }
                  
         catch (NumberFormatException ехс){
           JOptionPane.showMessageDialog (null, "Неверный ввод числового значения. Ошибка ввода");
                }
         catch (ArithmeticException ехс){
           JOptionPane.showMessageDialog (null, "Попытка деления на ноль. Ошибка ввода");
                }  
      }  
    
    
    
    
    

private void Otrarray (int iter, double radius, double angleknee, double step1){
    double angleO = 2*PI/iter;
    double angl=0;
    int i = 1;

        otrarr [iter/2]=0;
        otrarr [iter]=2*radius;
        otrarr [0]=2*radius;
            while (i <= iter/4){
                    angl= angleO+angl;
                    otrarr[i]= Math.cos(angl)*radius+ radius;
                    otrarr [iter-i]=otrarr[i];
                    otrarr [iter/2+i]=2*radius-otrarr[i];
                    otrarr [iter/2-i]=otrarr [iter/2+i];
            ++i;
            }
            i=0;
            while (i<=iter){
                    otrarr[i]=otrarr[i]/Math.cos(angleknee)*Math.sin(angleknee)+50;
                    data [i][0]= "A"+String.valueOf(i);
                    data [i][1]= "mm" ;
                    data [i][2]= String.format("%.1f",otrarr[i]);
                    data [i][2]= String.format("%.1f",otrarr[i]);
            ++i;
            }
            ++i;
            data [i][0]= "Шаг отрезка";
            data [i][1]= "mm" ;
            data [i][2]= String.format("%.1f",step1);
            
            ++i;
            data [i][0]= "Диаметр колена";
            data [i][1]= "мм" ;
            data [i][2]= String.format("%.0f",2*radius);
            
            ++i;
            data [i][0]= "Угол колена";
            data [i][1]= "град." ;
            data [i][2]= String.format("%.0f",(angleknee*360/PI));
            
}   

private void OtrarrayofHalfPipe (int iter, double radius, double angleknee, double step1){
    double angleO = PI/iter;
    double angl=0;
    int i = 1;

        //otrarr [iter/2]=0;
        otrarr [iter]=0;
        otrarr [0]=2*radius;
            while (i <= iter/2){
                    angl= angleO+angl;
                    otrarr[i]= Math.cos(angl)*radius+ radius;
                    otrarr [iter-i] = 2*radius-otrarr[i];
                    //otrarr [iter/2+i]=2*radius-otrarr[i];
                    //otrarr [iter/2-i]=otrarr [iter/2+i];
            ++i;
            }
            i=0;
            while (i<=iter){
                    otrarr[i]=otrarr[i]/Math.cos(angleknee)*Math.sin(angleknee)+50;
                    data [i][0]= "A"+String.valueOf(i);
                    data [i][1]= "mm" ;
                    data [i][2]= String.format("%.1f",otrarr[i]);
                    //data [i][2]= String.format("%.1f",otrarr[i]);
            ++i;
            }
            ++i;
            data [i][0]= "Шаг отрезка";
            data [i][1]= "mm" ;
            data [i][2]= String.format("%.1f",step1);
            
            ++i;
            data [i][0]= "Диаметр колена";
            data [i][1]= "мм" ;
            data [i][2]= String.format("%.0f",2*radius);
            
            ++i;
            data [i][0]= "Угол колена";
            data [i][1]= "град." ;
            data [i][2]= String.format("%.0f",(angleknee*360/PI));
            
}   


private double angleData (double aa){
    double aa1;
        aa1=aa/2*PI/180;
            return (aa1);
}

private double angleDataofHalfPipe (double aa){
    double aa1;
        aa1=(180-aa)/2*PI/180;
            return (aa1);
}

private double showData (double aa, double hs){
    double h1;
        h1= Math.sqrt(aa/2*aa/2+hs*hs);
            return h1;
}
private double showData (double aa, double bb, double hs) {
    double reb;
        reb= Math.sqrt(aa/2*aa/2+bb/2*bb/2+hs*hs);
            return reb;
}

private double inData (String inStr){
    double inInt;
    String string;
 
        string = JOptionPane.showInputDialog("Введите "+ inStr+" =");
        inInt = Double.parseDouble (string);
            return inInt;
    }    
     
}
