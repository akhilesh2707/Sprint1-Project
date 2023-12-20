package in.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hospital.entities.DoctorCredential;
import in.hospital.repositories.DoctorCredentialRepository;
import in.hospital.userexception.DoctorInvalidPasswordException;
import in.hospital.userexception.DoctorInvalidUsernameException;

@Service
public class DoctorCredentialServiceImpl implements DoctorCredentialService {

	@Autowired
	private DoctorCredentialRepository doctorCredentialRepository;

	@Override
	public DoctorCredential doctorSignUp(DoctorCredential doctorCredential) {
		System.out.println(doctorCredential);
		return doctorCredentialRepository.save(doctorCredential);
	}

//	@Override
//	public String doctorLogin(String email, String password) {
//		DoctorCredential doctorCred = doctorCredentialRepository.findbyemailid(email);
//
//		if (doctorCred != null) {
//			if (doctorCred.getPassword().equals(password)) {
//				return "Login Successfully, WELCOME!...";
//			} else {
//				return "Invalid Password!...";
//			}
//		} else {
//			return "Kindly Create Account!...";
//		}
//	}

	@Override
	public String login(DoctorCredential doctorCredential)
			throws DoctorInvalidPasswordException, DoctorInvalidUsernameException {
		DoctorCredential doctorCred = doctorCredentialRepository.findbyemailid(doctorCredential.getEmail());

		if (doctorCred != null) {
			if (doctorCred.getPassword().equals(doctorCredential.getPassword())) {
				return "Login Successfully, WELCOME!...";
			} else {
				throw new DoctorInvalidPasswordException("Invalid Password!...");
			}
		} else {
			throw new DoctorInvalidUsernameException("Email not found. Kindly Create Account!...");
		}
	}

}
