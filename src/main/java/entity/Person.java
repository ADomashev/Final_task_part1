package entity;

public class Person extends GeneralEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String surname;
	private String login;
	private String password;

	private int accessLevel;
	private int phoneNumber;
	private int numberIssuedBook;
	private int numberReadBook;

	public Person() {
		super();
	}

	public Person(int id) {
		super(id);
	}

	public Person(Integer id, String name, String surname, String login, String password, int accessLevel,
			int phoneNumber, int numberIssuedBook) {
		super(id);
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.accessLevel = accessLevel;
		this.phoneNumber = phoneNumber;
		this.numberIssuedBook = numberIssuedBook;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", login=" + login + ", password=" + password
				+ ", accessLevel=" + accessLevel + ", phoneNumber=" + phoneNumber + ", numberIssuedBook="
				+ numberIssuedBook + ", getId()=" + getId() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + accessLevel;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberIssuedBook;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + phoneNumber;
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Person other = (Person) obj;
		if (accessLevel != other.accessLevel)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberIssuedBook != other.numberIssuedBook)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	public int getNumberReadBook() {
		return numberReadBook;
	}

	public void setNumberReadBook(int numberReadBook) {
		this.numberReadBook = numberReadBook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getNumberIssuedBook() {
		return numberIssuedBook;
	}

	public void setNumberIssuedBook(int numberIssuedBook) {
		this.numberIssuedBook = numberIssuedBook;
	}

}
