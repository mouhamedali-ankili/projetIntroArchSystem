package metier;
import integration.ServiceUtilisateurPortTypeProxy;
import integration.Utilisateur;

import java.rmi.RemoteException;
public class Traitement {
	ServiceUtilisateurPortTypeProxy service = new ServiceUtilisateurPortTypeProxy();
	
	
	
	
	public Utilisateur authentification(String email , String password) throws RemoteException{
		Utilisateur user=null;
		user = service.soap_authentification_utilisateur(email,password);
		if(user != null){
			if(user.getFonction().equals("administrateur"))
				return user;
		}	
		return null;
	}
 
	
	
	public boolean deleteUser(int id ) throws RemoteException{
		return service.soap_supprimer_utilisateur(id);
	}
	
	public boolean modifyUser(int id , String name ,String surname ,String address ,long cel ,String email ,String password ,String function ) throws RemoteException{
		return service.soap_modifier_utilisateur(id, name, surname, address, cel, email, password, function,"","");
	}
	
	
	public Utilisateur[] allUser() throws RemoteException{
		return service.soap_lister_utilisateur();
	}
	
	public boolean addUser(String name , String surname ,String address,long cel ,String email ,String password ,String function) throws RemoteException{
		return service.soap_ajouter_utilisateur(name,surname, address, cel, email, password,function);
	}
	
	

}
