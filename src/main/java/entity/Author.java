package entity;

import java.sql.Date;
import java.util.Calendar;

public class Author extends GeneralEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String surName;

	private Calendar birthDay;

	public Author() {
		super();
	}

	public Author(int id) {
		super(id);
	}

	public Author(Integer id, String name, String surName, Calendar birthDay) {
		super(id);
		this.name = name;
		this.surName = surName;
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", surName=" + surName + ", birthDay=" + getBirthDay() + ", getId()=" + getId()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (birthDay == null) {
			if (other.birthDay != null)
				return false;
		} else if (!birthDay.equals(other.birthDay))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		return true;
	}

	public Calendar setTime(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		return calendar;
	}

	public void setBirthDay(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		this.birthDay = cal;
	}

	public Date getDateBirthday() {
		Date date = new Date(birthDay.getTimeInMillis());
		return date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Calendar getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int year, int month, int day) {
		this.birthDay = setTime(year, month, day);
	}

}
