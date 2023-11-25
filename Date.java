public class Date {
    private int year;
    private int month;
    private int day;

    private String intToString(int m) {
        if (m == 1) {
            return "January";
        } else if (m == 2) {
            return "February";
        } else if (m == 3) {
            return "March";
        } else if (m == 4) {
            return "April";
        } else if (m == 5) {
            return "May";
        } else if (m == 6) {
            return "June";
        } else if (m == 7) {
            return "July";
        } else if (m == 8) {
            return "August";
        } else if (m == 9) {
            return "September";
        } else if (m == 10) {
            return "October";
        } else if (m == 11) {
            return "November";
        } else if (m == 12) {
            return "December";
        }
        return "";
    }

    private int stringToInt(String m) {
        if (m == "January") {
            return 1;
        } else if (m == "February") {
            return 2;
        } else if (m == "March") {
            return 3;
        } else if (m == "April") {
            return 4;
        } else if (m == "May") {
            return 5;
        } else if (m == "June") {
            return 6;
        } else if (m == "July") {
            return 7;
        } else if (m == "August") {
            return 8;
        } else if (m == "September") {
            return 9;
        } else if (m == "October") {
            return 10;
        } else if (m == "November") {
            return 11;
        } else if (m == "December") {
            return 12;
        }
        return -1;
    }

    public Date(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    public Date(int d, String m, int y) {
        day = d;
        month = stringToInt(m);
        year = y;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String toString() {
        String m = intToString(month);
        return m + " " + day + ", " + year;
    }

    private boolean isLeapYear(int y) {
        if (y % 400 == 0) {
            return true;
        } else if (y % 100 == 0) {
            return false;
        } else if (y % 4 == 0) {
            return true;
        }
        return false;
    }

    public boolean isLeapYear() {
        return isLeapYear(year);
    }

    private int monthDays(int m, int y) {
        if (isLeapYear(y)) {
            if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
                return 31;
            } else if (m == 2) {
                return 29;
            } else {
                return 30;
            }
        } else {
            if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
                return 31;
            } else if (m == 2) {
                return 28;
            } else {
                return 30;
            }
        }
    }

    public void increment() {
        day += 1;
        if (day > monthDays(month, year)) {
            day = 1;
            month += 1;
        }

        if (month > 12) {
            month = 1;
            year += 1;
        }
    }

    public int daysTo(Date d2) {
        int counter = 0;
        Date temp = new Date(day, month, year);
        while (!(temp.getDay() == d2.getDay() && temp.getMonth() == d2.getMonth() && temp.getYear() == d2.getYear())) {
            temp.increment();
            counter++;
        }

        return counter;

    }

    public int daysToChristmas() {
        int x = year;
        if (month == 12 && day > 25) {
            x++;
        }
        Date d2 = new Date(25, 12, x);
        return daysTo(d2);
    }


}
