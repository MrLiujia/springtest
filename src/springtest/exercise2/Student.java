package springtest.exercise2;

public class Student {
	private Long id; // 当表中的数据行可能无限增长时，id列最好用Long
	private String name;
	private Gender gender; // 性别
	private Integer age;
	private String major; // 专业
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Gender getGender() {
		return gender;
	}
	public Integer getAge() {
		return age;
	}
	public String getMajor() {
		return major;
	}
	
	public Student(Long id, String name, Gender gender, Integer age,
			String major) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.major = major;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", major=" + major + "]";
	}
}
