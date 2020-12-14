import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

public class Main {

    private static String getCreateString(String table, String[] values) {
        return new String("INSERT INTO " + table + " VALUES (" + String.join(",", values) + ");");
    }

    private static String getSelectString(String table) {
        return new String("SELECT FROM " + table);
    }

    public static void main(String[] args) {
        try {
            ResourceBundle resource = ResourceBundle.getBundle("jdbc");
            String url = resource.getString("url");
            String user = resource.getString("user");
            String pass = resource.getString("password");
            Properties prop = new Properties();
            prop.put("user", user);
            prop.put("password", pass);
            Connection connection = DriverManager.getConnection(url, prop);

            Statement st = connection.createStatement();


            st.execute("DELETE FROM weather;");
            st.execute("DELETE FROM region;");
            st.execute("DELETE FROM resident;");


            st.execute(getCreateString("resident", new String[] {
                    "1",
                    "\'Русский\'",
                    "\'Россияне\'"
            }));
            st.execute(getCreateString("resident", new String[] {
                    "2",
                    "\'Белорусский\'",
                    "\'Белорусы\'"
            }));
            st.execute(getCreateString("resident", new String[] {
                    "3",
                    "\'Английский\'",
                    "\'Англичане\'"
            }));
            st.execute(getCreateString("resident", new String[] {
                    "4",
                    "\'Немецкий\'",
                    "\'Немцы\'"
            }));


            st.execute(getCreateString("region", new String[] {
                    "1",
                    "\'Россия\'",
                    "\'123123.5\'",
                    "1"
            }));
            st.execute(getCreateString("region", new String[] {
                    "2",
                    "\'Беларусь\'",
                    "\'1233.5\'",
                    "2"
            }));
            st.execute(getCreateString("region", new String[] {
                    "3",
                    "\'Англия\'",
                    "\'2123.5\'",
                    "3"
            }));
            st.execute(getCreateString("region", new String[] {
                    "4",
                    "\'Германия\'",
                    "\'12313.5\'",
                    "4"
            }));


            st.execute(getCreateString("weather", new String[] {
                    "1",
                    "\'2020-01-11\'",
                    "\'Снег\'",
                    "\'-3.5\'",
                    "1"
            }));
            st.execute(getCreateString("weather", new String[] {
                    "2",
                    "\'2020-02-11\'",
                    "\'Снег\'",
                    "\'-15.5\'",
                    "1"
            }));
            st.execute(getCreateString("weather", new String[] {
                    "3",
                    "\'2019-12-12\'",
                    "\'Снег\'",
                    "\'-13.5\'",
                    "1"
            }));
            st.execute(getCreateString("weather", new String[] {
                    "4",
                    "\'2020-03-12\'",
                    "\'Дождь\'",
                    "\'13.5\'",
                    "1"
            }));
            st.execute(getCreateString("weather", new String[] {
                    "5",
                    "\'2020-03-12\'",
                    "\'Дождь\'",
                    "\'13.5\'",
                    "1"
            }));
            st.execute(getCreateString("weather", new String[] {
                    "6",
                    "\'2020-03-12\'",
                    "\'Дождь\'",
                    "\'13.5\'",
                    "1"
            }));
            st.execute(getCreateString("weather", new String[] {
                    "7",
                    "\'2020-03-12\'",
                    "\'Дождь\'",
                    "\'13.5\'",
                    "1"
            }));
            st.execute(getCreateString("weather", new String[] {
                    "8",
                    "\'2020-03-12\'",
                    "\'Дождь\'",
                    "\'13.5\'",
                    "1"
            }));


            StringBuffer result = new StringBuffer("");

            //ЗАДАННЫЙ РЕГИОН
            int regionId = 1;

            ResultSet set = st.executeQuery(
                    "SELECT * FROM weather " +
                            "WHERE region_id = " + regionId);

            while(set.next()) {
                for (int i = 2; i < 5; i++) {
                    result.append(set.getString(i) + ", ");
                }
                result.append("\n");
            }

            System.out.println(result.toString());


            System.out.println("\n");


            result = new StringBuffer("");

            //ЗАДАННЫЙ РЕГИОН
            regionId = 1;
            double temp = -1;

            set = st.executeQuery(
                    "SELECT * FROM weather " +
                            "WHERE region_id = " + regionId +
                            " AND temperature < " + temp +
                            " AND precipitation = 'Снег'"
            );

            while(set.next()) {
                result.append(set.getString(2) + "\n");
            }

            System.out.println(result.toString());




            System.out.println("\n");


            result = new StringBuffer("");

            //ЗАДАННЫЙ РЕГИОН
            regionId = 1;
            String lang = "Русский";

            DateFormat today = new LocalDateTime.now();


            set = st.executeQuery(
                    "SELECT * FROM weather " +
                            "WHERE region_id = " + regionId +
                            " AND temperature < " + temp +
                            " AND precipitation = 'Снег'"
            );

            while(set.next()) {
                result.append(set.getString(2) + "\n");
            }

            System.out.println(result.toString());


        } catch (MissingResourceException e) {
            System.err.println("properties file is missing " + e);
        }
        catch (SQLException e) {
            System.err.println("not obtained connection " + e);
        }



    }
}
