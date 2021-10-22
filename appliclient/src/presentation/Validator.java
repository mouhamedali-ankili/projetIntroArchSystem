package presentation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	public Validator() {
		
	}
	
	private String error="";
	
	public void init(){
		this.error="";
	}
	public String getError(){
		return error;
	}
	public void addError(String error){
		this.error += error;
	}
	String errorEmail = "Email Incorrect !\n";
	String errorPassword = "Le mot de Passe contient au moins 9 caracteres et au plus 255 caracteres !\n";
	String errorCell ="Le numero de telephone contient au moins 9 chiffres au plus 11 chiffres ";
	String errorDuplicateEmail="Ce email Existe déja !\n";
	public boolean emailValidator(String email) {
		if (email.trim().length() <= 255 && email.trim().length() != 0) {
			Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
			if( matcher.find()== true)
				return true;
		}
			error += errorEmail;
			return false;

	}

	public  boolean validData(String data,String name) {
		if (data.trim().length() != 0 && data.trim().length() <= 255)
			return true;
		error+= name+" est une chaine de caracteres compris entre 1 et 255 caracteres ! \n";
		return false;
	}
	
	public boolean validPassword(String password) {
		if(password.trim().length() <=255 && password.trim().length() > 8)
			return true;
		error+=errorPassword;
		return false;
	}
	
	
	
	public boolean celValidator(String number) {
		if (number.matches("\\d{9,11}"))
			return true;
		error+=errorCell;
		return false;
	}

}
