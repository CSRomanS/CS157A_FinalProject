package entity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

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
	
	public static void respondWithError(String message, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("success", false);
		jsonResponse.put("message", message);

		PrintWriter out = response.getWriter();
		out.write(jsonResponse.toString());
		out.close();
	}

	public static void respondWithSuccess(HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("success", true);

		PrintWriter out = response.getWriter();
		out.write(jsonResponse.toString());
		out.close();
	}

}
