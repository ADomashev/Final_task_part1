package entity;

import java.io.Serializable;

public class GeneralEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	public GeneralEntity() {
	}

	public GeneralEntity(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id=" + id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		GeneralEntity that = (GeneralEntity) o;
		return getId() == that.getId();
	}

	@Override
	public int hashCode() {
		return getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
