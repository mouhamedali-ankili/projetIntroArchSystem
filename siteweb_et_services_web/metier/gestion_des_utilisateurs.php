<?php
   
   if (isset($_POST["ajouter"])){
      include("../dao/db_connexion.php");
      include("../domaine/utilisateur.class.php");
      include("../dao/db_utilisateur_compte.php");
      $nom = strip_tags(trim($_POST['nom']));
      $prenom = strip_tags(trim($_POST['prenom']));
      $adresse = strip_tags(trim($_POST['adresse']));
      $telephone = strip_tags(trim($_POST['telephone']));
      $email = strip_tags(trim($_POST['email']));
      $mot_de_passe = strip_tags(trim($_POST['password']));
      $fonction = strip_tags(trim($_POST['fonction']));

      $utilisateur = new Utilisateur($nom,$prenom,$adresse,$telephone,$email,$mot_de_passe,$fonction);
      $ajout = ajouter_utilisateur($utilisateur);
     
      if($ajout){
         header("location:../controleur/index.php?con=conok&ajt=ok");
      }else {
         header("location:../controleur/index.php?con=conok&ajt=ntk");
      }
   }elseif (isset($_POST["modifier"])){
      session_start();
      include("../dao/db_connexion.php");
      include("../domaine/utilisateur.class.php");
      include("../dao/db_utilisateur_compte.php");
      $nom = strip_tags(trim($_POST['nom']));
      $prenom = strip_tags(trim($_POST['prenom']));
      $adresse = strip_tags(trim($_POST['adresse']));
      $telephone = strip_tags(trim($_POST['telephone']));
      $email = strip_tags(trim($_POST['email']));
      $encien_password = strip_tags(trim($_POST['encien_password']));
      $nouveau_password = strip_tags(trim($_POST['nouveau_password']));
      $fonction = strip_tags(trim($_POST['fonction']));
      $id_utilisateur = $_SESSION['id_utilisateur'];
      $mot_de_passe = $_SESSION['mot_de_passe_utilisateur'];

      $utilisateur = new Utilisateur($nom,$prenom,$adresse,$telephone,$email,$mot_de_passe,$fonction);
      $utilisateur->setId($id_utilisateur);
      $modification = modifier_utilisateur($utilisateur,$encien_password,$nouveau_password);
      unset($_SESSION['id_utilisateur']);
      unset($_SESSION['mot_de_passe_utilisateur']);
     
      if($modification){
         header("location:../controleur/index.php?con=conok&mdf=ok");
      } else {
         header("location:../controleur/index.php?con=conok&mdf=ntk");
      }
   }elseif(isset($_POST["authentification"])){
      include("../dao/db_connexion.php");
      include("../domaine/utilisateur.class.php");
      include("../dao/db_utilisateur_compte.php");
      $email = strip_tags(trim($_POST['email']));
      $mot_de_passe = strip_tags(trim($_POST['password']));
      $authentifie = authentification_utilisateur ($email,$mot_de_passe);
      if ($authentifie) {
         session_start();
         $_SESSION['id'] = $authentifie->getId();
         $_SESSION['email'] = $authentifie->getEmail();
         $_SESSION['fonction'] = $authentifie->getFonction();
         if ($_SESSION['fonction'] == "administrateur") {
            $_SESSION['etat'] = "admin";
         }
         header("location:../controleur/index.php?con=conok&ett=dft");
      }else{
         header("location:../controleur/index.php?con=conntk");
      }
   }else{
      include("../domaine/utilisateur.class.php");
      include("../dao/db_utilisateur_compte.php");
   }

   function ajouter_utilisateur($utilisateur){
      if (strlen($utilisateur->getEmail()) == 0 || strlen($utilisateur->getPassword()) < 8 || strlen($utilisateur->getTelephone()) < 9 || strlen($utilisateur->getTelephone()) > 11) {
         return false;
      }else{
         $liste_utilisateurs = seach_users ();
         foreach ($liste_utilisateurs as $utilisateurs) {
            if ($utilisateurs->getEmail() == $utilisateur->getEmail()) {
               return false; 
            }
         }
      }
      if ($utilisateur->getNom() == "") {
         $utilisateur->setNom("inconnu");
      }
      if ($utilisateur->getPrenom() == "") {
         $utilisateur->setPrenom("inconnu");
      }
      if ($utilisateur->getAdresse() == "") {
         $utilisateur->setAdresse("inconnu");
      }
      $ajout = add_user($utilisateur);
      return $ajout;
   }

   function modifier_utilisateur($utilisateur,$encien_password,$nouveau_password){
      
      if (strlen($utilisateur->getEmail()) == 0 || strlen($utilisateur->getPassword()) < 8 || strlen($utilisateur->getTelephone()) < 9 || strlen($utilisateur->getTelephone()) > 11) {
         return false;
      }else{
         $liste_utilisateurs = seach_users ();
         foreach ($liste_utilisateurs as $utilisateurs) {
            if ($utilisateurs->getEmail() == $utilisateur->getEmail() && $utilisateurs->getId() != $utilisateur->getId()) {
               return false; 
            }
         }

         if (strlen($nouveau_password) != 0 && $encien_password != $utilisateur->getPassword()){  
            return false;
         } elseif(strlen($nouveau_password) != 0 && $encien_password == $utilisateur->getPassword()){
            $utilisateur->setPassword($nouveau_password);
         }
      }
      if ($utilisateur->getNom() == "") {
         $utilisateur->setNom("inconnu");
      }
      if ($utilisateur->getPrenom() == "") {
         $utilisateur->setPrenom("inconnu");
      }
      if ($utilisateur->getAdresse() == "") {
         $utilisateur->setAdresse("inconnu");
      }
      
      $modification = update_user ($utilisateur);
      return $modification;
   }

   function lister_utilisateur(){
      
      $liste_utilisateurs = seach_users ();
      return $liste_utilisateurs;
      
   }

   function supprimer_utilisateur($id_utilisateur){
      return delete_user ($id_utilisateur);
   }

   function authentification_utilisateur ($email,$mot_de_passe){
      $utilisateur_authentifie = authentification ($email,$mot_de_passe);
      return $utilisateur_authentifie;
   }
?>