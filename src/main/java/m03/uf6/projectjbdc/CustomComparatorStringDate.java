package m03.uf6.projectjbdc;

import java.sql.Date;
import java.util.Comparator;

public class CustomComparatorStringDate implements Comparator<Object> {

        @Override
        public int compare(Object o1, Object o2) {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return 1;
            } else if (o2 == null) {
                return -1;
            } else if (o1 instanceof Date && o2 instanceof Date) {
                return ((Date) o1).compareTo((Date) o2);
            } else {
                return o1.toString().compareTo(o2.toString());
            }
        }

}
