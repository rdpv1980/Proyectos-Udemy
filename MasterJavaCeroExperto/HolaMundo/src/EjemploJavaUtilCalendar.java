import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EjemploJavaUtilCalendar {
    public static void main(String[] args) {

        Calendar calendario=Calendar.getInstance();

        //calendario.set(2022,Calendar.SEPTEMBER,30,17,26,10);//Tambien se pone el
        //número del mes
        calendario.set(Calendar.YEAR,2022);
        calendario.set(Calendar.MONTH,Calendar.JULY);
        calendario.set(Calendar.DAY_OF_MONTH,25);
        //calendario.set(Calendar.HOUR_OF_DAY,21);
        calendario.set(Calendar.HOUR,7);
        calendario.set(Calendar.AM_PM,Calendar.PM);
        calendario.set(Calendar.MINUTE,20);
        calendario.set(Calendar.SECOND,10);
        calendario.set(Calendar.MILLISECOND,125);
        Date fecha=calendario.getTime();
        System.out.println("fecha sin formato = " + fecha);

        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS a");
        String fechaConFormato=formato.format(fecha);
        System.out.println("fecha Con Formato = " + fechaConFormato);

    }
}
