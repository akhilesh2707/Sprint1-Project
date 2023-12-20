package in.hospital.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "DoctorCredentials")
public class DoctorCredential {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long credentialId;
	private String email;
	private String password;

//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Doctor doctor;

}
