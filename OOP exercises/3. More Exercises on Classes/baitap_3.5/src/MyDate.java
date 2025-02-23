public class MyDate {
    private int year;
    private int month;
    private int day;

    public static final String[] MONTHS = {
            "Jan","Feb","Mar","Apr","May","Jun",
            "Jul","Aug","Sep","Oct","Nov","Dec"
    };
    public static final String[] DAYS = {
            "Sunday","Monday","Tuesday","Wednesday",
            "Thursday","Friday","Saturday"
    };
    public static final int[] DAYS_IN_MONTH = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999 || month > 12 || month < 1 ){
            return false;
        }
        int maxDays = DAYS_IN_MONTH[month - 1];
        if(month == 2 && isLeapYear(year)) {
            maxDays = 29;
        }
        return day>=1 && day <= maxDays;
    }
    public int getDayOfWeek(int year, int month, int day) {
        int m = month < 3 ? month +12 : month;
        int y = month < 3 ? year -31 : year;
        return (day + 2 * m + (3 *(m + 1)) / 5 + y + (y / 4) - (y / 100) + (y / 400) + 2) % 7;
    }
    public void setDate(int year, int month, int day) {
        if(!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public void setYear(int year) {
        if(year<1 || year >9999){
            throw new IllegalArgumentException("Year out of range");
        }
        this.year = year;
    }
    public void setMonth(int month) {
        if(month<1 || month >12){
            throw new IllegalArgumentException("Month out of range");
        }
        this.month = month;
    }
    public void setDay(int day) {
        int daysInMonth = DAYS_IN_MONTH[month - 1];
        if(month == 2 && isLeapYear(year)) {
            daysInMonth = 29;
        }
        if(day < 1 || day > daysInMonth){
            throw new IllegalArgumentException("Day out of range");
        }
        this.day = day;
    }
    @Override
    public String toString() {
        return String.format("%s %d %s %d", DAYS[getDayOfWeek(year, month, day)], day, MONTHS[month - 1], year);
    }
    public MyDate nextDay() {
        int daysInMonth = DAYS_IN_MONTH[month - 1];
        if(month == 2 && isLeapYear(year)) {
            daysInMonth = 29;
        }
        if(day < daysInMonth){
            day++;
        }
        else{
            day = 1;
            nextMonth();
        }
        return this;
    }
    public MyDate nextMonth() {
        int daysInMonth = DAYS_IN_MONTH[month - 1];
        if(month == 2 && isLeapYear(year)) {
            daysInMonth = 29;
        }
        if(day > daysInMonth){
            day = daysInMonth;
        }
        return this;
    }
    public MyDate previousDay() {
        if(day>1){
            day--;
        }
        else{
            previousMonth();
            day = DAYS_IN_MONTH[month - 1];
            if(month == 2 && isLeapYear(year)) {
                day = 29;
            }
        }
        return this;
    }
    public MyDate previousMonth() {
        if(month>1){
            month--;
        }
        else{
            month = 12;
            previousYear();
        }
        int daysInMonth = DAYS_IN_MONTH[month - 1];
        if(month == 2 && isLeapYear(year)) {
            daysInMonth = 29;
        }
        if(day > daysInMonth){
            day = daysInMonth;
        }
        return this;
    }
    public MyDate previousYear() {
        if(year>1){
            year--;
        }
        else{
            throw new IllegalArgumentException("Year out of range");
        }
        if(month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }
}
