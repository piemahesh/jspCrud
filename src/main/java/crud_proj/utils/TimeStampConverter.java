package crud_proj.utils;

public class TimeStampConverter {

	private String date, time, year, month, day;

	public TimeStampConverter(String timestamp) {
		if (timestamp != null) {
			System.out.println(timestamp + "   ======");
			String[] localDate = timestamp.split(" ");
			this.date = localDate[0];
			this.time = localDate[1];
			this.year = date.split("-")[0];
			this.month = date.split("-")[1];
			this.day = date.split("-")[2];
		}
	}

	public String getIndianDate() {
		return day + "/" + month + "/" + year;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

}
