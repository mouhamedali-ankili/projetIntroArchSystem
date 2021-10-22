<?php 
header("Content-Type: text/xml;");
include "articles_query.php";

function check_format($query){
    if($query === "xml" || $query == "json"){
         header('Content-Type: application/$query');
        return true;
     }
return false;

}

if(isset($_GET['format']) && check_format($_GET['format']) && sizeof($_GET) <= 2 )
{
    if(isset($_GET['tri']) && $_GET['tri'] == "categorie")
        {
                echo "liste des articles trié en catégorie au format ". $_GET['format'];
        if($_GET['format'] === "xml")
            echo xmlrpc_encode(rest_all_articles_for_this_categorie());
        if($_GET['format'] === "json"){
            $answer['liste']="liste des articles ede la categorie en  JSON : ";
            $answer['articles']=rest_all_articles_for_this_categorie();
            echo json_encode($answer,JSON_PRETTY_PRINT) ;
        }
    }
    elseif(isset($_GET['categorie']))
    {
        echo "liste des articles de la categorie ". $_GET['categorie'] . " au format ". $_GET['format'];
        if($_GET['format'] === "xml")
            echo xmlrpc_encode(rest_get_all_articles_order_by_categorie($_GET['categorie']));
        if($_GET['format'] === "json"){
            $answer['liste']="liste des articles ede la categorie". $_GET['categorie']." JSON : ";
            $answer['articles']=rest_get_all_articles_order_by_categorie($_GET['categorie']);
            echo json_encode($answer,JSON_PRETTY_PRINT) ;
    }
    }

    else{

        if($_GET['format'] === "xml")
            echo xmlrpc_encode(rest_get_all_articles());
        if($_GET['format'] === "json"){
            $answer['liste']="liste des articles en JSON : ";
            $answer['articles']=rest_get_all_articles();
            echo json_encode($answer,JSON_PRETTY_PRINT) ;
        }
        
        }
        
    }

