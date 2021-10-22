<?php

if ($_SESSION['fonction'] == 'administrateur') {
    if ($_SESSION['etat'] == "edit"){
        $liste_articles = lister_articles();
        include("gestion_articles.php");
    }else{
        $liste_utilisateurs = lister_utilisateur();
        include("gestion_utilisateurs.php");
    }

} elseif ($_SESSION['fonction'] == 'editeur'){

        $liste_articles = lister_articles();
        include("gestion_articles.php");
 
} elseif ($_SESSION['fonction'] == 'visiteur simple'){
    $liste_categories = lister_categorie();
    include("../vue/seach_option.php");
    $liste_articles = lister_articles();
    include("acceuil.php");
}

