package kodlamaio.hrmsio.entities.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUpdateAdd {


    private String companyName;
    private String webSite;
    private String phoneNumber;
    private String email;
    private String password;
    private int employer_id;
}
