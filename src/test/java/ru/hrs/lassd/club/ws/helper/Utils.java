package ru.hrs.lassd.club.ws.helper;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Component
@PropertySource({"data.properties"})
public class Utils {



    public String generateDate(String dateFormat, int dayShift){
        SimpleDateFormat f = new SimpleDateFormat(dateFormat);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, dayShift);
        return f.format( DateUtils.ceiling(cal.getTime(), Calendar.HOUR) );
    }





    public long generateDateMS(int dayShift){
        LocalDateTime localDateTime = LocalDateTime.parse(generateDate("dd.MM.YYYY HH:mm", dayShift),
                DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm") );
            return localDateTime
                        .atZone(ZoneId.systemDefault())
                        .toInstant().toEpochMilli();
    }




    public String getMonthFirstDay(String format){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(cal.getTime());
    }



    public String getMonthLastDay(String format){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(cal.getTime());
    }





    public String generateString(){
        return generateString(5);
    }

    public String generateString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }






    public long generateDigits() {
        return generateDigits(10);
    }

    public long generateDigits(int length) {
        int m = (int) Math.pow(10, length-1);
        return Math.abs(m + new Random().nextInt(9 * m));
    }











    public Utils(){}


}
