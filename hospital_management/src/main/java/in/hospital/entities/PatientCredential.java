package in.hospital.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "PatientCredentials")
public class PatientCredential {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long credentialId;
	private String username;
	private String password;

//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Patient patient;

}
