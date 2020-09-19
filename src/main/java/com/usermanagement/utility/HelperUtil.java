package com.usermanagement.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * Created by yusep.maulana07 on 20/07/2018.
 */
public class HelperUtil {

	private HelperUtil() {
		throw new IllegalStateException("Utility class");
	}

	static String [] characters = {"!", "@", "#", "<", ">", "?", "*", "~", "+", "-"};

	public static String generateMD5 (String data) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(data.getBytes());

		byte []byteData = md.digest();

		StringBuilder sb = new StringBuilder();
		for (byte byteDatum : byteData) {
			sb.append(Integer.toString((byteDatum & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	public static String getFirstName(String fullName){

		int idx = fullName.lastIndexOf(' ');
		if (idx == -1)
			return fullName;
		return fullName.substring(0, fullName.indexOf(' '));
	}

	public static String getLastName(String fullName){

		int idx = fullName.lastIndexOf(' ');
		if (idx == -1)
			return null;
		return fullName.substring(fullName.indexOf(' ') + 1, fullName.length());
	}

	public static String convertStacktraceToString(Exception e) {
		StringBuilder sb = new StringBuilder();
		StackTraceElement[] stackTrace = e.getStackTrace();
		sb.append(e.getClass().getName()).append(" : ").append(e.getMessage()).append("\n");

		for (StackTraceElement stackTraceElement : stackTrace) {
			sb.append("\t at ").append(stackTraceElement.toString()).append("\n");
		}
		return sb.toString();
	}

	public static String getTippersEmployeeNumber(String phoneNumber){
		return "TP".concat(phoneNumber);
	}

	public static String generateRandomPass (int min, int max, int loop) {
		StringBuilder sb = new StringBuilder();
		Random rnd = new Random();
		for (int i=0; i<loop; i++) {
			char c = (char) (rnd.nextInt(26) + 'a');
			if(i == 0) {
				String a = String.valueOf(c);
				sb.append(a.toUpperCase());
			}else {
				sb.append(c);
			}

		}

		for(int i = 0; i<loop -1; i++){
			sb.append(randomNumber(min, max));
		}

		String temp = sb.toString();
		temp = temp.substring(temp.length() - 1, temp.length());
		sb.append(characters[Integer.parseInt(temp)]);

		return sb.toString();
	}

	public static String generateRandomNumber (int min, int max, int loop) {

		StringBuilder randomNumber=new StringBuilder("");
		for(int i = 0; i<loop; i++){
			randomNumber.append(randomNumber(min, max));
		}

		return randomNumber.toString();
	}

	private static String randomNumber (int min, int max){
		String result = "";
		int number = 0;
		if(min >= max){
			throw new IllegalArgumentException();
		}
		Random r = new Random();
		number = r.nextInt((max - min) + 1);
		result = String.valueOf(number);
		return result;
	}

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		return matcher.find();
	}

	public static int getMonth (Date date){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);

		return calendar.get(Calendar.MONTH );
	}

	public static int getYear (Date date){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		return calendar.get(Calendar.YEAR);
	}

	public static String getAbsoluteDate (){
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		int seconds = calendar.get(Calendar.SECOND);
		return String.valueOf(year) + String.valueOf(month) + String.valueOf(day) + String.valueOf(hours) + String.valueOf(minutes) + String.valueOf(seconds);
	}
}
