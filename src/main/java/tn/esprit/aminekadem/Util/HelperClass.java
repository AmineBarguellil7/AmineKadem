package tn.esprit.aminekadem.Util;

import java.time.LocalDate;
import java.time.Period;


public class HelperClass {
    public static int getDate(LocalDate now,LocalDate param) {
        Period p=Period.between(now,param);
        int days=Math.abs(p.getDays());
        return days;
    }
}
