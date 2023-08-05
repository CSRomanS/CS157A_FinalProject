package entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Util {

	/**
	 * convert mysql datetime into String
	 * @param t
	 * @return
	 */
	public static String datetimeToString(Timestamp t) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(t);
		return timeStamp;
	}

}
