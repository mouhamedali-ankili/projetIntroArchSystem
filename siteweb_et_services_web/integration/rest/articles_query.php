<?php
include "../../dao/db_connexion.php";
include "../../domaine/article.class.php";
include "../../domaine/categorie.class.php";
include ("../../dao/db_article_categorie.php");






function rest_get_all_articles(){
    $answer = seach_articles();
    return $answer;
}

function rest_get_all_articles_order_by_categorie($categorie){
    $answer = seach_liste_articles_by_libellecategorie($categorie);
    return $answer;
    
}

function rest_all_articles_for_this_categorie(){
    $answer= seach_articles_groupe_by_cat();
    return $answer;
}