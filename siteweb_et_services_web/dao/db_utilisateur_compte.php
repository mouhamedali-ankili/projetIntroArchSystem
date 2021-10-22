<?php
    #include("../domaine/utilisateur.class.php");
    $db_connection = db_connection();
    function add_user ($utilisateur){
        global $db_connection;
        $req = 'INSERT INTO utilisateur (nom,prenom,adresse,telephone,email,mot_de_passe,fonction) VALUES (:nom,:prenom,:adresse,:telephone,:email,:mot_de_passe,:fonction)';
        $request = $db_connection->prepare($req);
        $request->execute(array('nom'=>$utilisateur->getNom(),
                                'prenom'=>$utilisateur->getPrenom(),
                                'adresse'=>$utilisateur->getAdresse(),
                                'telephone'=>$utilisateur->getTelephone(),
                                'email'=>$utilisateur->getEmail(),
                                'mot_de_passe'=>$utilisateur->getPassword(),
                                'fonction'=>$utilisateur->getFonction()))
                                or die(print_r($request->errorInfo()));
        $request->closeCursor();
        return true;
    }

    function  seach_users (){
        global $db_connection;
        $request = 'SELECT * FROM utilisateur';
        $answer = $db_connection->query($request);
        $liste_utilisateurs = array();
        while ($data = $answer->fetch()){
            $utilisateur = new Utilisateur ($data['nom'],$data['prenom'],$data['adresse'],$data['telephone'],$data['email'],$data['mot_de_passe'],$data['fonction']);
            $utilisateur->setId($data['id_utilisateur']);
            $liste_utilisateurs [] = $utilisateur;
        }
        $answer->closeCursor();
        return $liste_utilisateurs;
    }

    function update_user ($utilisateur){
        global $db_connection;
        $req = "UPDATE utilisateur SET nom=:nom, prenom=:prenom, adresse=:adresse, telephone=:telephone, email=:email, mot_de_passe=:mot_de_passe, fonction=:fonction WHERE id_utilisateur=:id";
        $request = $db_connection->prepare($req);
        $request->execute(array('id'=>$utilisateur->getId(),
                                'nom'=>$utilisateur->getNom(),
                                'prenom'=>$utilisateur->getPrenom(),
                                'adresse'=>$utilisateur->getAdresse(),
                                'telephone'=>$utilisateur->getTelephone(),
                                'email'=>$utilisateur->getEmail(),
                                'mot_de_passe'=>$utilisateur->getPassword(),
                                'fonction'=>$utilisateur->getFonction()))
                                or die(print_r($request->errorInfo()));
        $request->closeCursor();        
        return true;
    }

    function delete_user ($id){
        global $db_connection;
        $req = 'DELETE FROM utilisateur WHERE id_utilisateur = ?';
        $request = $db_connection->prepare($req);
        $request->execute(array($id)) 
                or die(print_r($request->errorInfo()));
        return true;
    }

    function authentification ($email,$mot_de_passe){
        global $db_connection;
        $req = 'SELECT *FROM utilisateur WHERE email = :email AND mot_de_passe = :mot_de_passe';
        $request = $db_connection->prepare($req);
        $request->execute(array(
                                'email'=>$email,
                                'mot_de_passe'=>$mot_de_passe
                                ))
                                or die(print_r($request->errorInfo()));
        while ($data = $request->fetch()){
            $utilisateur = new Utilisateur ($data['nom'],$data['prenom'],$data['adresse'],$data['telephone'],$data['email'],$data['mot_de_passe'],$data['fonction']);
            $utilisateur->setId($data['id_utilisateur']);
            
        }
        return $utilisateur;
    }

    