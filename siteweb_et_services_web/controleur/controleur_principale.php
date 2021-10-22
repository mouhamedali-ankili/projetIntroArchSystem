<?php 
    $liste_categories = lister_categorie();
    include("../vue/seach_option.php");
    if (isset($_GET['opt'])) {

        switch ($_GET['opt']) {

            case 'art':
    
                if (isset($_GET['ida'])) {
                    
                    $article = rechercher_article_par_id($_GET['ida']);
                    include("../vue/affiche_article.php");
    
                } else {
    
                    $liste_articles = lister_articles();
                    include("../vue/acceuil.php");
    
                }
                
                break;

            case 'artsct':

                if (isset($_GET['idc'])) {
    
                    $liste_articles = rechercher_article_par_categorie($_GET['idc']);
    
                } else {
    
                    $liste_articles = lister_articles();
    
                }

                include("../vue/acceuil.php");
                break;
                
            default:
    
                $liste_categories = lister_categorie();
                $liste_articles = lister_articles();
                include("../vue/acceuil.php");
                break;
        }

    } else {
        $liste_categories = lister_categorie();
        $liste_articles = lister_articles();
        include("../vue/acceuil.php");          
    }
    
    