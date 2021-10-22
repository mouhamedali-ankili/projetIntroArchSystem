<?php
    if (isset($_POST["ajouter"])){
        include("../dao/db_connexion.php");
        include("../domaine/article.class.php");
        include("../domaine/categorie.class.php");
        include("../dao/db_article_categorie.php");
        
        $titre = strip_tags(trim($_POST['titre']));
        $contenu = strip_tags(trim($_POST['contenu']));
        $id_categorie = strip_tags(trim($_POST['categorie']));
        session_start();
        $id_editeur = $_SESSION['id'];
        $ajout = ajouter_article($titre,$contenu,$id_categorie,$id_editeur);
       
        if($ajout){
           header("location:../controleur/index.php?con=conok&ajt=ok");
        }else {
           header("location:../controleur/index.php?con=conok&ajt=ntk");
        }
    }elseif (isset($_POST["modifier"])){
        include("../dao/db_connexion.php");
        include("../domaine/article.class.php");
        include("../domaine/categorie.class.php");
        include("../dao/db_article_categorie.php");

        $titre = strip_tags(trim($_POST['titre']));
        $contenu = strip_tags(trim($_POST['contenu']));
        $id_categorie = strip_tags(trim($_POST['categorie']));
        session_start();
        $id = $_SESSION['id_article'];
        $modification = modifier_article($id,$titre,$contenu,$id_categorie);

        if($modification){
           header("location:../controleur/index.php?con=conok&mdf=ok");
        }else {
           header("location:../controleur/index.php?con=conok&mdf=ntk");
        }
    }elseif (isset($_POST["ajouter_categorie"])){
        include("../dao/db_connexion.php");
        include("../domaine/categorie.class.php");
        include("../dao/db_article_categorie.php");

        $libelle = strip_tags(trim($_POST['libelle']));
        $ajout = ajouter_categorie($libelle);
        
        if($ajout){
           header("location:../controleur/index.php?con=conok&ajct=ok");
        }else {
           header("location:../controleur/index.php?con=conok&ajct=ntk");
        }

    }elseif (isset($_POST["modifier_categorie"])){
        include("../dao/db_connexion.php");
        include("../domaine/categorie.class.php");
        include("../dao/db_article_categorie.php");

        $encien_nom = strip_tags(trim($_POST['encien_nom']));
        $nouveau_nom = strip_tags(trim($_POST['nouveau_nom']));
        
        $modification = modifier_categorie($encien_nom,$nouveau_nom);
        if($modification){
           header("location:../controleur/index.php?con=conok&mdcat=ok");
        }else {
           header("location:../controleur/index.php?con=conok&mdcat=ntk");
        }
    }elseif (isset($_POST["supprimer_categorie"])){
        include("../dao/db_connexion.php");
        include("../domaine/categorie.class.php");
        include("../dao/db_article_categorie.php");

        $libelle = strip_tags(trim($_POST['nom']));
        $supprimer = supprimer_categorie($libelle);
       
        if($supprimer){
           header("location:../controleur/index.php?con=conok&spct=ok");
        }else {
           header("location:../controleur/index.php?con=conok&spct=ntk");
        }
    }else{
        include("../domaine/article.class.php");
        include("../domaine/categorie.class.php");
        include("../dao/db_article_categorie.php");
    }

    
    function lister_articles(){
        $liste_articles = seach_articles ();
        return $liste_articles;
    }

    function lister_categorie(){
        $liste_categories = seach_categories (); 
        return $liste_categories;
    }

    function rechercher_article_par_id($id_article){
        $article = seach_article_byid($id_article);
        return $article;
    }

    function rechercher_article_par_categorie($id_categorie){
        $liste_articles = seach_liste_articles_bycategorie($id_categorie);
        return $liste_articles;
    }

    function ajouter_article($titre,$contenu,$id_categorie,$id_editeur){
        if (strlen($titre) == 0 || strlen($contenu) == 0 ) {
            return false;
        } else {
            $liste_categories = seach_categories ();
            foreach ($liste_categories as $categorie) {
               if ($categorie->getId() == $id_categorie) {
                return add_article ($titre,$contenu,$id_categorie,$id_editeur);
               }
            }
            return false;
        }
        
    }

    function modifier_article($id,$titre,$contenu,$id_categorie){
        if (strlen($titre) == 0 || strlen($contenu) == 0 ) {
            return false;
        } else {
                $modification = update_article ($id,$titre,$contenu,$id_categorie);
                return $modification;
            }
            return false;
    }

    function supprimer_article($id_article){
        $supprimer  = delete_article ($id_article);
        return $supprimer;
    }

    function ajouter_categorie($libelle){
        if (strlen($libelle) == 0) {
            
            return false;
        }
        $liste_categories = seach_categories (); 
        foreach ($liste_categories as $categorie) {
            if ($libelle == $categorie->getLibelle()){
                return false;
            }
        }
        return add_categorie($libelle);
    }

    function modifier_categorie($encien_libelle,$nouveau_libelle){
        if (strlen($nouveau_libelle) == 0) {
            return false;
        }
        $liste_categories = seach_categories (); 
        foreach ($liste_categories as $categorie) {
            if ($nouveau_libelle == $categorie->getLibelle()){
                return false;
            }elseif ($encien_libelle == $categorie->getLibelle()) {
                return update_categorie($encien_libelle,$nouveau_libelle);
            }
        }
        return false;
    }

    function supprimer_categorie($libelle){
        $liste_categories = seach_categories (); 
        foreach ($liste_categories as $categorie) {
            if ($libelle == $categorie->getLibelle()){
                return delete_categorie($libelle);
            }
        }
        return false;
    }

    function rechercher_article_grouper_par_categorie(){
        return seach_articles_groupe_by_cat();
    }

    function rechercher_article_par_libelle_categorie($libelle){
        return seach_liste_articles_by_libellecategorie($libelle);
    }