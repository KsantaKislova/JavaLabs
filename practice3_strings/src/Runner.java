import by.gsu.pms.BusinessTrip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Runner {
    private static class IndexedTrip implements Comparable<Integer>{
        private int index;
        private BusinessTrip businessTrip;

        IndexedTrip(int i,BusinessTrip b){
            this.index = i;
            this.businessTrip = b;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public BusinessTrip getBusinessTrip() {
            return businessTrip;
        }

        public void setBusinessTrip(BusinessTrip businessTrip) {
            this.businessTrip = businessTrip;
        }

        @Override
        public int compareTo(Integer o) {
            return this.index - o;
        }
    }
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("src/in.txt"));
            BusinessTrip.setDailyRate(Integer.parseInt(getValue(in.nextLine())));
            String[] indicesS = getValue(in.nextLine()).split(";");
            IndexedTrip[] trips = new IndexedTrip[indicesS.length];
            for (int i = 0; i < indicesS.length; i++) {
                trips[i] = new IndexedTrip(Integer.parseInt(indicesS[i].trim()),new BusinessTrip());
            }
            Arrays.sort(trips, new Comparator<IndexedTrip>() {
                @Override
                public int compare(IndexedTrip o1, IndexedTrip o2) {
                    return o1.getIndex() - o2.getIndex();
                }
            });
            if(in.hasNext()){
                while(readLine(in,trips));
            }
            String account;


            //       Task 1 requires command line arguments

            try {
                for (IndexedTrip t :
                        trips) {
                    account = t.getBusinessTrip().getAccount();
                    t.getBusinessTrip().setAccount(account.replaceAll(args[0], args[1]));
                }
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("No command line arguments were found!");
            }

            Arrays.sort(trips, new Comparator<IndexedTrip>() {
                @Override
                public int compare(IndexedTrip o1, IndexedTrip o2) {
                    return o2.getBusinessTrip().getTotal() - o1.getBusinessTrip().getTotal();
                }
            });
            for (IndexedTrip i :
                    trips) {
                System.out.println(i.getBusinessTrip().toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean readLine(Scanner in, IndexedTrip[] t){
        String val = in.nextLine();
        if(val.contains("account")){
            t[Arrays.binarySearch(t,Integer.valueOf(val.substring(7,9)))]
                    .getBusinessTrip().setAccount(getValue(val));
        } else
        if(val.contains("transport")){
            t[Arrays.binarySearch(t,Integer.valueOf(val.substring(9,11)))]
                    .getBusinessTrip().setTransportExpenses(Integer.parseInt(getValue(val)));
        } else
        if(val.contains("days")){
            t[Arrays.binarySearch(t,Integer.valueOf(val.substring(4,6)))]
                    .getBusinessTrip().setDays(Integer.parseInt(getValue(val)));
        }
        return in.hasNext();
    }

    private static String getValue(String s){
        return s.substring(s.lastIndexOf('=')+1).trim();
    }

    private static String getNumber(int i){
        if(i<10)
            return "0"+i;
        return String.valueOf(i);
    }
}

