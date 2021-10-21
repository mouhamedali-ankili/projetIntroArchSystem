package integration;

public class ServiceUtilisateurPortTypeProxy implements integration.ServiceUtilisateurPortType {
  private String _endpoint = null;
  private integration.ServiceUtilisateurPortType serviceUtilisateurPortType = null;
  
  public ServiceUtilisateurPortTypeProxy() {
    _initServiceUtilisateurPortTypeProxy();
  }
  
  public ServiceUtilisateurPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceUtilisateurPortTypeProxy();
  }
  
  private void _initServiceUtilisateurPortTypeProxy() {
    try {
      serviceUtilisateurPortType = (new integration.ServiceUtilisateurLocator()).getserviceUtilisateurPort();
      if (serviceUtilisateurPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceUtilisateurPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceUtilisateurPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceUtilisateurPortType != null)
      ((javax.xml.rpc.Stub)serviceUtilisateurPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public integration.ServiceUtilisateurPortType getServiceUtilisateurPortType() {
    if (serviceUtilisateurPortType == null)
      _initServiceUtilisateurPortTypeProxy();
    return serviceUtilisateurPortType;
  }
  
  public integration.Utilisateur soap_authentification_utilisateur(java.lang.String email, java.lang.String mot_de_passe) throws java.rmi.RemoteException{
    if (serviceUtilisateurPortType == null)
      _initServiceUtilisateurPortTypeProxy();
    return serviceUtilisateurPortType.soap_authentification_utilisateur(email, mot_de_passe);
  }
  
  public integration.Utilisateur[] soap_lister_utilisateur() throws java.rmi.RemoteException{
    if (serviceUtilisateurPortType == null)
      _initServiceUtilisateurPortTypeProxy();
    return serviceUtilisateurPortType.soap_lister_utilisateur();
  }
  
  public boolean soap_ajouter_utilisateur(java.lang.String nom, java.lang.String prenom, java.lang.String adresse, long telephone, java.lang.String email, java.lang.String mot_de_passe, java.lang.String fonction) throws java.rmi.RemoteException{
    if (serviceUtilisateurPortType == null)
      _initServiceUtilisateurPortTypeProxy();
    return serviceUtilisateurPortType.soap_ajouter_utilisateur(nom, prenom, adresse, telephone, email, mot_de_passe, fonction);
  }
  
  public boolean soap_modifier_utilisateur(int id, java.lang.String nom, java.lang.String prenom, java.lang.String adresse, long telephone, java.lang.String email, java.lang.String mot_de_passe, java.lang.String fonction, java.lang.String encien_password, java.lang.String nouveau_password) throws java.rmi.RemoteException{
    if (serviceUtilisateurPortType == null)
      _initServiceUtilisateurPortTypeProxy();
    return serviceUtilisateurPortType.soap_modifier_utilisateur(id, nom, prenom, adresse, telephone, email, mot_de_passe, fonction, encien_password, nouveau_password);
  }
  
  public boolean soap_supprimer_utilisateur(int id_utilisateur) throws java.rmi.RemoteException{
    if (serviceUtilisateurPortType == null)
      _initServiceUtilisateurPortTypeProxy();
    return serviceUtilisateurPortType.soap_supprimer_utilisateur(id_utilisateur);
  }
  
  
}