/*
Интерфейс содержит описание методов для расчета разверток.
Также содержит данные для отображения результатов расчетов в таблицах
 */
package steelworks;


interface MyInterfaceHat  {

// статическая константа число ПИ
final double  PI=3.1415926535;


//Массивы содержащий информацию для таблицы вывода значение развертки колена
static Object[] headers = { "Номер отрезка", "ед изм", "Размер" }; //объект для формирования столбцов таблицы
static Object[][] data = new String [1000][3];
// объект для заполнения таблицы данными
static double [] otrarr = new double [1000]; //массив отрезков развертки колена

// объявление методов . Закомментированные методы private для сопутствующих расчетов
//double showData (double aa, double hs);//вычисление высоты пирамиды
//double showData (double aa, double bb, double hs);//вычисление ребра пирамиды
//double inData (String inStr);// ввод данных типа double
//double angleData (double aa);// вычисление угла развертки (половина угла колена)
//вычисление массива 
//отрезков для получения развертки колена
//void Otrarray (int iter, double radius, double angleknee,double step);

// Расчет развертки вальмы
void pyramidV ();
// Расчет развертки правильной пирамиды
void pyramid ();
// Расчет развертки колена водосточной трубы
void steelKnee();

}