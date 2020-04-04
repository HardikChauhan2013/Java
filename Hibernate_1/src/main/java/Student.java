import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int studentId;
	
	@Column(name = "stdname")
	public String studnetName;
	
	public String standard;
	
	public int mark;
}

