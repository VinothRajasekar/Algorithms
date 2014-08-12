

public class Split {

	public static void main(String[] args) {

		String dt = "Tue Oct 01 16:29:33 +0000 2013";

		String[] valueSplitted = dt.toString().split(" ");
		String monthNumber;
		String month = valueSplitted[1];

		if (month.equals("Jan")) {
			monthNumber = "01";
		} else if (month.equals("Feb")) {
			monthNumber = "02";
		} else if (month.equals("Mar")) {
			monthNumber = "03";
		} else if (month.equals("Apr")) {
			monthNumber = "04";
		} else if (month.equals("May")) {
			monthNumber = "05";
		} else if (month.equals("Jun")) {
			monthNumber = "06";
		} else if (month.equals("Jul")) {
			monthNumber = "07";
		} else if (month.equals("Aug")) {
			monthNumber = "08";
		} else if (month.equals("Sep")) {
			monthNumber = "09";
		} else if (month.equals("Oct")) {
			monthNumber = "10";
		} else if (month.equals("Nov")) {
			monthNumber = "11";
		} else if (month.equals("Dec")) {
			monthNumber = "12";
		} else
			monthNumber = "00";

		String dts = valueSplitted[5] + '-' + monthNumber + '-'
				+ valueSplitted[2] + '+' + valueSplitted[3];
		System.out.println(dts);

	}
}