package com.example.sb.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMP_ID")
    private int EMP_ID;
    
    @Column(name = "Name")
    private String Name;

    public int getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(int eMP_ID) {
		EMP_ID = eMP_ID;
	}

	@Column(name = "RM")
    private String RM;

    @Column(name = "Band")
    private String Band;
    
    @Column(name = "DOJ")
    private String DOJ;

    

	@Column(name = "skillset")
    private String skillset;

    @Column(name = "RASalloc")
    private String RASalloc;

    @Column(name = "Project")
    private String Project;

    @Column
    private String block;

    @Column
    private Date blockTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRM() {
		return RM;
	}

	public void setRM(String rM) {
		RM = rM;
	}

	public String getBand() {
		return Band;
	}

	public void setBand(String band) {
		Band = band;
	}
	public String getDOJ() {
		return DOJ;
	}

	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}

	public String getSkillset() {
		return skillset;
	}

	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}

	public String getRASalloc() {
		return RASalloc;
	}

	public void setRASalloc(String rASalloc) {
		RASalloc = rASalloc;
	}

	public String getProject() {
		return Project;
	}

	public void setProject(String project) {
		Project = project;
	}

	public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
       this.block = block;
    }

    public Date getBlockTime() {
       return blockTime;
    }

    public void setBlockTime(Date blockTime) {
        this.blockTime = blockTime;
   }
}
