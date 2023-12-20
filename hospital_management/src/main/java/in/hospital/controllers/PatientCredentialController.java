package in.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hospital.entities.PatientCredential;
import in.hospital.services.PatientCredentialService;
import in.hospital.userexception.PatientInvalidPasswordException;
import in.hospital.userexception.PatientInvalidUsernameException;

@RestController
@RequestMapping("/in/patient")
public class PatientCredentialController {

	@Autowired
	private PatientCredentialService patientCredentialService;

	@PostMapping("/signup-patient")
	public PatientCredential patientSignUp(@RequestBody PatientCredential patientCredential) {
		return patientCredentialService.patientSignUp(patientCredential);
	}

	@PostMapping("/login-patient")
	public String login(@RequestBody PatientCredential patientCredential) {
		try {
			return patientCredentialService.patientLogin(patientCredential);
		} catch (PatientInvalidPasswordException | PatientInvalidUsernameException e) {
			return e.getMessage();
		}
	}

}
