package by.gsu.pms;

public class BusinessTrip {
    private static int DAILY_RATE = 25000;
    private String account;
    private int transportExpenses;
    private int days;

    // Default constructor
    public BusinessTrip() {}

    // General-purpose constructor
    public BusinessTrip(String account, int transportExpenses, int days) {
        this.account = account;
        this.transportExpenses = transportExpenses;
        this.days = days;
    }

    public static void setDailyRate(int dailyRate) {
        DAILY_RATE = dailyRate;
    }

    public String getAccount() {
        return account;
    }

    public int getTransportExpenses() {
        return transportExpenses;
    }

    public int getDays() {
        return days;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setTransportExpenses(int transportExpenses) {
        this.transportExpenses = transportExpenses;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTotal() {
        if (days == 1) {
            return transportExpenses;
        } else if (days > 1) {
            return transportExpenses + DAILY_RATE * days;
        } else {
            return 0;
        }
    }

    public void show() {
        System.out.printf("rate = %d\n" +
                        "account = %s\n" +
                        "transport = %d\n" +
                        "days = %d\n" +
                        "total = %d\n\n",
                DAILY_RATE,
                account,
                transportExpenses,
                days,
                getTotal());
    }

    @Override
    public String toString() {
        return DAILY_RATE + ";" + account + ";" + transportExpenses + ";" + days + ";" + getTotal() + ";";
    }
}