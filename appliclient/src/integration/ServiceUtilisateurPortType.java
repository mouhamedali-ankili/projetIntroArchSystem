/**
 * ServiceUtilisateurPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package integration;

public interface ServiceUtilisateurPortType extends java.rmi.Remote {

    /**
     * authentification
     */
    public integration.Utilisateur soap_authentification_utilisateur(java.lang.String email, java.lang.String mot_de_passe) throws java.rmi.RemoteException;

    /**
     * renvoie la liste des noms des utlisateurs
     */
    public integration.Utilisateur[] soap_lister_utilisateur() throws java.rmi.RemoteException;

    /**
     * ajoute un utlisateur
     */
    public boolean soap_ajouter_utilisateur(java.lang.String nom, java.lang.String prenom, java.lang.String adresse, long telephone, java.lang.String email, java.lang.String mot_de_passe, java.lang.String fonction) throws java.rmi.RemoteException;

    /**
     * modifie un utlisateur
     */
    public boolean soap_modifier_utilisateur(int id, java.lang.String nom, java.lang.String prenom, java.lang.String adresse, long telephone, java.lang.String email, java.lang.String mot_de_passe, java.lang.String fonction, java.lang.String encien_password, java.lang.String nouveau_password) throws java.rmi.RemoteException;

    /**
     * supprime un utlisateur
     */
    public boolean soap_supprimer_utilisateur(int id_utilisateur) throws java.rmi.RemoteException;
}
