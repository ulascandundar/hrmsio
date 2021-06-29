package kodlamaio.hrmsio.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidates")
public class Candidate extends User {
	@Column(name ="first_name")
	private String first_name;
	
	@Column(name ="last_name")
	private String last_name;
	                 
	@Column(name ="identity_number")
	private int identity_number;
	
	@Column(name ="birth_date")
	private Date birth_date;
	

	
	@Column(name = "nationality_id")
    private long nationalityId;

    @Column(name = "linkedin_account")
    private String linkedInAccount; 

    @Column(name = "github_account")
    private String githubAccount;
    
    @ManyToMany(cascade=CascadeType.ALL )
	@JoinTable(name = "candidates_who_like_it_favourite_job_advertisements",
		joinColumns = { @JoinColumn(name = "candidate_who_like_it_id") },
		inverseJoinColumns = { @JoinColumn(name = "favourite_job_advertisement_id") })
	private List<JobAdvertisement> favouriteJobAdvertisements;
}
