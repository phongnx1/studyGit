package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Convert {
	// chuyen kieu ngay thang sang String
	public static String convertDateToString(Date dateD) {

		SimpleDateFormat dayFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dateS = dayFormat.format(dateD.getTime());
		return dateS;
	}

	public static String convertDateToString2(Date dateD) {
		String weekDate = "";
		SimpleDateFormat dayFormat = new SimpleDateFormat("E dd-MM-yyyy");
		String dateS = dayFormat.format(dateD.getTime());
		String[] dateArr = new String[2];
		StringTokenizer token = new StringTokenizer(dateS, " ");
		for (int i = 0; i < 2; i++) {
			dateArr[i] = token.nextToken();

		}
		weekDate += converDayOfWeek(dateArr[0]) + ", " + dateArr[1];
		return weekDate;
	}

	public static String convertDateString(String date1) {

		String date2 = "";
		String[] date = new String[3];
		StringTokenizer token = new StringTokenizer(date1, "-");
		for (int i = 0; i < 3; i++) {
			date[i] = token.nextToken();
		}
		date2 = date[2] + "-" + date[1] + "-" + date[0];
		return date2;
	}

	public static String convertWeekDateString(String date) {

		String weekDate = "";
		String[] dateArr = new String[2];
		StringTokenizer token = new StringTokenizer(date, " ");
		for (int i = 0; i < 2; i++) {
			dateArr[i] = token.nextToken();

		}
		weekDate += converDayOfWeek(dateArr[0]) + ", " + dateArr[1];
		return weekDate;
	}

	private static String converDayOfWeek(String dayOfWeekEng) {
		// TODO Chuyen thu sang tieng viet
		String dayOfWeekVi = "";
		switch (dayOfWeekEng) {
		case "Mon":
			dayOfWeekVi = "Thứ Hai";
			break;
		case "Tue":
			dayOfWeekVi = "Thứ Ba";
			break;

		case "Wed":
			dayOfWeekVi = "Thứ Tư";
			break;
		case "Thu":
			dayOfWeekVi = "Thứ Năm";
			break;
		case "Fri":
			dayOfWeekVi = "Thứ Sáu";
			break;
		case "Sat":
			dayOfWeekVi = "Thứ Bảy";
			break;
		case "Sun":
			dayOfWeekVi = "Chủ Nhật";
			break;

		default:
			break;
		}
		return dayOfWeekVi;
	}

	// chuyen kieu String sang kieu SqlDate
	public static String untilDateToSqlDate(String dateip) {
		SimpleDateFormat dateinput = new SimpleDateFormat("dd-MM-yyyy");
		java.sql.Date dateSQL = null;
		try {
			Date date1 = dateinput.parse(dateip);
			dateSQL = new java.sql.Date(date1.getTime());

		} catch (ParseException e) {

			e.printStackTrace();
		}
		return dateSQL.toString();
	}

	// chuyen tu mang sang chuoi
	public static String convertArrToString(String[] arr) {
		String hobbies = "";
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {

				hobbies += arr[i];
				if (i < arr.length - 1) {
					hobbies += ", ";
				}
			}
		}
		return hobbies;
	}

	// chuyen chuoi sang mang
	public static String[] convertStringToArray(String s) {
		if ("".equals(s)) {
			return null;
		}
		String[] arr = new String[20];
		StringTokenizer token = new StringTokenizer(s, ",");
		int i = 0;
		while (token.hasMoreTokens()) {
			arr[i] = token.nextToken().trim();

			System.out.println(arr[i]);
			i++;
		}

		return arr;
	}

}
