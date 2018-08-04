package entity;

import java.sql.Date;

public class IssuedBook extends GeneralEntity {

	private static final long serialVersionUID = 1L;

	private String returnTime;

	private int bookId;
	private int personId;

	private Date date;

	public IssuedBook() {
		super();
	}

	public IssuedBook(int id) {
		super(id);
	}

	public IssuedBook(int bookId, int personId, Date date) {
		super();
		this.bookId = bookId;
		this.personId = personId;
		this.date = date;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + bookId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + personId;
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
		IssuedBook other = (IssuedBook) obj;
		if (bookId != other.bookId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (personId != other.personId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IssuedBook [bookId=" + bookId + ", personId=" + personId + ", date=" + date + ", getId()=" + getId()
				+ "]";
	}

}
