package daos;

import model.ADTDate;

public abstract class dateDAO {
    public abstract void setDay(int day);
    public abstract int getDay();
    public abstract void setMonth(int month);
    public abstract int getMonth();
    public abstract void setYear(int year);
    public abstract int getYear();
    public abstract void setElapsedDays();
    public abstract void setElapsedDays(int dd, int mm, int yyyy);
    public abstract int getElapsedDays( );
    public abstract void setDate(int dd, int mm, int yyyy);
    public abstract boolean isLeapYear(int yyyy);
    public abstract ADTDate getDate();
    public abstract void parseDateInput(String outputMsg);
}
