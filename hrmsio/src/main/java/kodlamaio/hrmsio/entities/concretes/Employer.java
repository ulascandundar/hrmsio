package kodlamaio.hrmsio.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
public class Employer extends User {
	@Column(name="CompanyName")
    private String companyName;

    @Column(name="WebSite")
    private String webSite;

    @Column(name="PhoneNumber")
    private String phoneNumber;


    @Column(name="VerifiedBySystem")
    private boolean verifiedBySystem =false;

    @Column(name="UpdateVerifiedBySystem")
    private boolean updateVerifiedBySystem =true;
    
    
    @OneToMany(mappedBy = "employer")
    @JsonIgnore
	private List<JobAdvertisement> jobAdvertisements;
    
    @OneToMany(mappedBy = "employer")
    @JsonIgnore
    private List<EmployerUpdate> employerUpdates;
}
