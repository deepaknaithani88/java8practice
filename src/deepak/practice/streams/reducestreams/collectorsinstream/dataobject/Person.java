package deepak.practice.streams.reducestreams.collectorsinstream.dataobject;

public class Person {

	private String name;
	private int age;
	private int field1;
	private int field2;
	private int field3;
	private int field4;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, int field1, int field2, int field3,
			int field4) {
		this.name = name;
		this.age = age;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getField1() {
		return field1;
	}

	public void setField1(int field1) {
		this.field1 = field1;
	}

	public int getField2() {
		return field2;
	}

	public void setField2(int field2) {
		this.field2 = field2;
	}

	public int getField3() {
		return field3;
	}

	public void setField3(int field3) {
		this.field3 = field3;
	}

	public int getField4() {
		return field4;
	}

	public void setField4(int field4) {
		this.field4 = field4;
	}

	public int getKeys() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		// result = prime * result + field1;
		// result = prime * result + field2;
		// result = prime * result + field3;
		// result = prime * result + field4;
		return result;
	}

	public int getSummedFields() {
		return this.field1 + this.field2 + this.field3 + this.field4;
	}

	@Override
	public int hashCode() {
		return getKeys();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (field1 != other.field1)
			return false;
		if (field2 != other.field2)
			return false;
		if (field3 != other.field3)
			return false;
		if (field4 != other.field4)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nPerson [Name: " + this.getName() + ", Age:" + this.getAge()
				+ ", Summed Fields: " + this.getSummedFields() + "]\n";
	}
}
