<?php
    include("../dao/db_connexion.php"); 
    include("../metier/gestion_des_utilisateurs.php");
    
    function soap_authentification_utilisateur ($email,$mot_de_passe){
        $utilisateur_authentifie = authentification ($email,$mot_de_passe);
        return $utilisateur_authentifie;
    }

    function soap_authentification_admin ($email,$mot_de_passe){
        $utilisateur_authentifie = authentification ($email,$mot_de_passe);
        return $utilisateur_authentifie;
    }

    function soap_lister_utilisateur (){
        $liste_utilisateurs = lister_utilisateur ();
        return $liste_utilisateurs;
    }

    function soap_ajouter_utilisateur($nom,$prenom,$adresse,$telephone,$email,$mot_de_passe,$fonction){
        $utilisateur = new Utilisateur($nom,$prenom,$adresse,$telephone,$email,$mot_de_passe,$fonction);
        $ajoute = ajouter_utilisateur($utilisateur);
        return $ajoute;
    }

    function soap_modifier_utilisateur($id,$nom,$prenom,$adresse,$telephone,$email,$mot_de_passe,$fonction,$encien_password,$nouveau_password){
        $utilisateur = new Utilisateur($nom,$prenom,$adresse,$telephone,$email,$mot_de_passe,$fonction);
        $utilisateur->setId($id);
        $ajoute = modifier_utilisateur($utilisateur,$encien_password,$nouveau_password);
        return $ajoute;
    }

    function soap_supprimer_utilisateur($id_utilisateur){
        $supprime = supprimer_utilisateur($id_utilisateur);
        return $supprime;
    }


    ini_set('soap.wsdl_cache_enabled','0');
    $serversoap = new SoapServer("http://localhost/TheNewscv2/integration/soap/user.wsdl");
    $serversoap->addFunction("soap_authentification_utilisateur");
    $serversoap->addFunction("soap_lister_utilisateur");
    $serversoap->addFunction("soap_ajouter_utilisateur");
    $serversoap->addFunction("soap_modifier_utilisateur");
    $serversoap->addFunction("soap_supprimer_utilisateur");
    $serversoap->handle();
    
    