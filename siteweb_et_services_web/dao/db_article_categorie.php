<?php
    function seach_categories(){
        $request = 'SELECT * FROM categorie';
        $db_connection = db_connection();
        $answer = $db_connection->query($request);
        $liste_categories = array();

        while ($data = $answer->fetch()) {

            $categorie = new Categorie($data['libelle']);
            $categorie->setIdCategorie($data['idcategorie']);  
            $liste_categories[] = $categorie;  

        }

        $answer->closeCursor();
        return $liste_categories;
    }

    function seach_articles(){

        $request = 'SELECT * FROM article INNER JOIN categorie ON article.idcategorie = categorie.idcategorie';
        $db_connection = db_connection();
        $answer = $db_connection->query($request);
        $liste_articles = array();
        $req_user = 'SELECT * FROM utilisateur WHERE id_utilisateur = ?';
        $ans_user = $db_connection->prepare($req_user);

        while ($data = $answer->fetch()) {
            $categorie = new Categorie($data['libelle']);
            $categorie->setIdCategorie($data['idcategorie']);
            if($data['id_editeur'] == NULL){

                $editeur = "inconnu";

            }else{

                $req_user = "SELECT * FROM utilisateur WHERE utilisateur.id_utilisateur = :id";
                $ans_user = $db_connection->prepare($req_user);
    
                $ans_user->execute(array('id'=>$data['id_editeur']));
                $data_user = $ans_user->fetch();
                
                $editeur = new Utilisateur ($data_user['nom'],$data_user['prenom'],$data_user['adresse'],$data_user['telephone'],$data_user['email'],$data_user['mot_de_passe'],$data_user['fonction']);
                $editeur->setId($data_user['id_utilisateur']);

            }

            $article = new  Article($data['titre'],$data['contenu'],$data['dateCreation'],$data['dateModification'],$categorie,$editeur);
            $article->setId($data['id']);
            $liste_articles[] = $article;

        }

        $answer->closeCursor();
        return $liste_articles;
    }

    function seach_liste_articles_bycategorie($idcategorie){

        $db_connection = db_connection();
        $request = 'SELECT * FROM article NATURAL JOIN categorie WHERE categorie.idcategorie = ?';
        $answer = $db_connection->prepare($request);
        $answer->execute(array($idcategorie));
        $liste_articles = array();

        while ($data = $answer->fetch()) {

            $categorie = new Categorie($data['libelle']);
            $categorie->setIdCategorie($data['idcategorie']);

            if($data['id_editeur'] == NULL){

                $editeur = "inconnu";

            }else{

                $req_user = "SELECT * FROM utilisateur WHERE utilisateur.id_utilisateur = :id";
                $ans_user = $db_connection->prepare($req_user);
    
                $ans_user->execute(array('id'=>$data['id_editeur']));
                $data_user = $ans_user->fetch();
                
                $editeur = new Utilisateur ($data_user['nom'],$data_user['prenom'],$data_user['adresse'],$data_user['telephone'],$data_user['email'],$data_user['mot_de_passe'],$data_user['fonction']);
                $editeur->setId($data_user['id_utilisateur']);

            }

            $article = new  Article($data['titre'],$data['contenu'],$data['dateCreation'],$data['dateModification'],$categorie,$editeur);
            $article->setId($data['id']);
            $liste_articles[] = $article;

        }
        
        $answer->closeCursor();
        return $liste_articles;
    }

    function seach_article_byid($id){
        $db_connection = db_connection();
        $request = "SELECT * FROM article NATURAL JOIN categorie WHERE article.id = :id";
        $answer = $db_connection->prepare($request);
        $answer->execute(array('id'=>$id));
/*        $answer = $db_connection->query($request);*/
        $data = $answer->fetch();
        $categorie = new Categorie($data['libelle']);
        $categorie->setIdCategorie($data['idcategorie']);
        if($data['id_editeur'] == NULL){
            $editeur = "inconnu";
        }else{
            $req_user = "SELECT * FROM utilisateur WHERE utilisateur.id_utilisateur = :id";
            $ans_user = $db_connection->prepare($req_user);

            $ans_user->execute(array('id'=>$data['id_editeur']));
            $data_user = $ans_user->fetch();

            $editeur = new Utilisateur ($data_user['nom'],$data_user['prenom'],$data_user['adresse'],$data_user['telephone'],$data_user['email'],$data_user['mot_de_passe'],$data_user['fonction']);
            $editeur->setId($data_user['id_utilisateur']);
        }
        $article = new  Article($data['titre'],$data['contenu'],$data['dateCreation'],$data['dateModification'],$categorie,$editeur);
        $article->setId($data['id']);
        $answer->closeCursor();
        return $article;
    }

    function articles_bytitle($titre){
        $db_connection = db_connection();
        $request = "SELECT * FROM article NATURAL JOIN categorie WHERE article.titre = :title";
        $answer = $db_connection->prepare($request);
        $answer->execute(array('title'=>$titre));
/*        $answer = $db_connection->query($request);*/
        $liste_articles = array();
        while ($data = $answer->fetch()) {
            $categorie = new Categorie($data['libelle']);
            $categorie->setIdCategorie($data['idcategorie']);
            if($data['id_editeur'] == NULL){
                $editeur = "inconnu";
            }else{
                $ans_user->execute(array($data['id_editeur']));
                $data_user = $ans_user->fetch();
                $editeur = new Utilisateur ($data_user['nom'],$data_user['prenom'],$data_user['adresse'],$data_user['telephone'],$data_user['email'],$data_user['mot_de_passe'],$data_user['fonction']);
                $editeur->setId($data_user['id_utilisateur']);
            }
            $article = new  Article($data['titre'],$data['contenu'],$data['dateCreation'],$data['dateModification'],$categorie,$editeur);
            $article->setId($data['id']);
            $liste_articles[] = $article;
        }
        $answer->closeCursor();
        return $liste_articles;
    }

    function add_article ($titre,$contenu,$id_categorie,$id_editeur){
        $db_connection = db_connection();
        $req = 'INSERT INTO article (titre,contenu,idcategorie,id_editeur) VALUES (:titre,:contenu,:idcategorie,:id_editeur)';
        $request = $db_connection->prepare($req);
        $request->execute(array('titre'=>$titre,
                                'contenu'=>$contenu,
                                'idcategorie'=>$id_categorie,
                                'id_editeur'=>$id_editeur))
                                or die(print_r($request->errorInfo()));
        $request->closeCursor();
        return true;
    }

    function update_article ($id,$titre,$contenu,$idcategorie){
        $db_connection = db_connection();
        $request = "UPDATE article SET titre=:titre, contenu=:contenu, dateModification = NOW(), idcategorie = :idcategorie WHERE id=:id";
        $request = $db_connection->prepare($request);
        $request->execute(array('titre'=>$titre,
                                'contenu'=>$contenu,
                                'idcategorie'=>$idcategorie,
                                'id'=>$id))
                                or die(print_r($request->errorInfo()));
        return $request;
    }

    function delete_article ($id_article){
        $db_connection = db_connection();
        $req = 'DELETE FROM article WHERE id = ?';
        $request = $db_connection->prepare($req);
        $request->execute(array($id_article)) 
                or die(print_r($request->errorInfo()));
        $request->closeCursor();
        return true;
    }

    function add_categorie($libelle){
        $db_connection = db_connection();
        $request = "INSERT INTO categorie (libelle) VALUES (?)";
        $request = $db_connection->prepare($request);
        $request->execute(array($libelle)) or die (print_r($request->errorInfo()));
        return true;
    }

    function update_categorie($encien_libelle,$nouveau_libelle){
        $db_connection = db_connection();
        $request = "UPDATE categorie SET libelle=:nouveau_libelle WHERE libelle =:encien_libelle";
        $request = $db_connection->prepare($request);
        $request->execute(array('nouveau_libelle'=>$nouveau_libelle,
                                'encien_libelle'=>$encien_libelle)) 
                                or die(print_r($request->errorInfo()));
        return true;
    }

    function delete_categorie($libelle){
        $db_connection = db_connection();
        $request = "DELETE FROM categorie WHERE libelle = ?";
        $request = $db_connection->prepare($request);
        $request->execute(array($libelle)) or die (print_r($request->errorInfo()));
        return true;
    }

    function seach_articles_groupe_by_cat(){

        $request = 'SELECT * FROM article INNER JOIN categorie ON article.idcategorie = categorie.idcategorie GROUP BY libelle';
        $db_connection = db_connection();
        $answer = $db_connection->query($request);
        $liste_articles = array();
        $req_user = 'SELECT * FROM utilisateur WHERE id_utilisateur = ?';
        $ans_user = $db_connection->prepare($req_user);

        while ($data = $answer->fetch()) {
            $categorie = new Categorie($data['libelle']);
            $categorie->setIdCategorie($data['idcategorie']);
            if($data['id_editeur'] == NULL){

                $editeur = "inconnu";

            }else{

                $req_user = "SELECT * FROM utilisateur WHERE utilisateur.id_utilisateur = :id";
                $ans_user = $db_connection->prepare($req_user);
    
                $ans_user->execute(array('id'=>$data['id_editeur']));
                $data_user = $ans_user->fetch();
                
                $editeur = new Utilisateur ($data_user['nom'],$data_user['prenom'],$data_user['adresse'],$data_user['telephone'],$data_user['email'],$data_user['mot_de_passe'],$data_user['fonction']);
                $editeur->setId($data_user['id_utilisateur']);

            }

            $article = new  Article($data['titre'],$data['contenu'],$data['dateCreation'],$data['dateModification'],$categorie,$editeur);
            $article->setId($data['id']);
            $liste_articles[] = $article;

        }

        $answer->closeCursor();
        return $liste_articles;
    }

    function seach_liste_articles_by_libellecategorie($libelle){

        $db_connection = db_connection();
        $request = 'SELECT * FROM article NATURAL JOIN categorie WHERE categorie.libelle = ?';
        $answer = $db_connection->prepare($request);
        $answer->execute(array($libelle));
        $liste_articles = array();

        while ($data = $answer->fetch()) {

            $categorie = new Categorie($data['libelle']);
            $categorie->setIdCategorie($data['idcategorie']);

            if($data['id_editeur'] == NULL){

                $editeur = "inconnu";

            }else{

                $req_user = "SELECT * FROM utilisateur WHERE utilisateur.id_utilisateur = :id";
                $ans_user = $db_connection->prepare($req_user);
    
                $ans_user->execute(array('id'=>$data['id_editeur']));
                $data_user = $ans_user->fetch();
                
                $editeur = new Utilisateur ($data_user['nom'],$data_user['prenom'],$data_user['adresse'],$data_user['telephone'],$data_user['email'],$data_user['mot_de_passe'],$data_user['fonction']);
                $editeur->setId($data_user['id_utilisateur']);

            }

            $article = new  Article($data['titre'],$data['contenu'],$data['dateCreation'],$data['dateModification'],$categorie,$editeur);
            $article->setId($data['id']);
            $liste_articles[] = $article;

        }
        
        $answer->closeCursor();
        return $liste_articles;
    }
?>