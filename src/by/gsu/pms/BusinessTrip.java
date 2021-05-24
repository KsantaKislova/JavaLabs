package by.gsu.pms;

public class BusinessTrip {
    final double DAILY_RATE = 25000;
    String account;
    double transportExpenses;
    int days;

    // Default constructor
    public BusinessTrip() {}

    // General-purpose constructor
    public BusinessTrip(String account, double transportExpenses, int days) {
        this.account = account;
        this.transportExpenses = transportExpenses;
        this.days = days;
    }

    public String getAccount() {
        return account;
    }

    public double getTransportExpenses() {
        return transportExpenses;
    }

    public int getDays() {
        return days;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setTransportExpenses(double transportExpenses) {
        this.transportExpenses = transportExpenses;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getTotal() {
        if (days == 1) {
            return transportExpenses;
        } else if (days > 1) {
            return transportExpenses + DAILY_RATE * days;
        } else {
            return 0;
        }
    }

    public void show() {
        System.out.printf("rate = %.2f\n" +
                        "account = %s\n" +
                        "transport = %.2f\n" +
                        "days = %d\n" +
                        "total = %.2f\n\n",
                    DAILY_RATE,
                    account,
                    transportExpenses,
                    days,
                    getTotal());
    }

    @Override
    public String toString() {
        return String.format(DAILY_RATE + ";" + account + ";" + transportExpenses + ";" + days + ";" + getTotal() + ";");
    }
}
