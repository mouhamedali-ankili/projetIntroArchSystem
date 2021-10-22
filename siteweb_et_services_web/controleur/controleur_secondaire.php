
<?php
    if (isset($_GET['edt'])) {
        if($_GET['edt'] == "gestart"){
            $liste_articles = lister_articles();
            include("../vue/gestion_articles.php");
        }elseif($_GET['edt'] == "ajouart"){
            $liste_categories = lister_categorie();
            include("../vue/ajouter_article.php");
        }else{
            include("../vue/vue_par_defaut.php");
        }
    }elseif (isset($_GET['adm'])) {
        if($_GET['adm'] == "gestusr"){
            $liste_utilisateurs = lister_utilisateur();
            include("../vue/gestion_utilisateurs.php");
        }elseif($_GET['adm'] == "ajouusr"){
            include("../vue/ajouter_utilisateur.php");
        }else{
            include("../vue/vue_par_defaut.php");
        }
    }elseif (isset($_GET['opt'])){
        switch ($_GET['opt']) {
            case  'aprart':
                if (isset($_GET['clfar'])) {
                    $liste_articles = lister_articles();
                    if ($_GET['clfar']>=0 && $_GET['clfar']<= count($liste_articles )) {
                        $article = $liste_articles [$_GET['clfar']];
                        include("../vue/affiche_article.php");
                    }else{
                        include("../vue/gestion_articles.php"); 
                    }
                }else{
                    include("../vue/gestion_articles.php");
                }
                break;
            case 'mdfart':
                if (isset($_GET['clfar'])) {
                    $liste_articles = lister_articles();
                    if ($_GET['clfar']>=0 && $_GET['clfar']<= count($liste_articles)) {
                        $article = $liste_articles[$_GET['clfar']];
                        $liste_categories = lister_categorie();
                        include("../vue/modifier_article.php");
                    }else{
                        include("../vue/gestion_articles.php");
                    }
                }else{
                    include("../vue/gestion_articles.php"); 
                }
                break;
            case 'sprart':
                if (isset($_GET['clfar'])) {
                    $liste_articles = lister_articles();
                    if ($_GET['clfar']>=0 && $_GET['clfar']<= count($liste_articles)) {
                        $id_article = $liste_articles[$_GET['clfar']]->getId();
                        $supprimer = supprimer_article($id_article);

                        if (($supprimer)) {
                            ?>
                                <p>
                                    *L'article a été supprimé avec succès !!! ;
                                </p>
                            <?php
                            $liste_articles = lister_articles();
                            include("../vue/gestion_articles.php"); 
                        }else{
                            ?>
                                <p>
                                    *La suppression de l'article a échouée !!! ;
                                </p>
                            <?php
                            $liste_articles = lister_articles();
                            include("../vue/gestion_articles.php");
                        }
                        
                    }
                }
                break;
            case 'mdfut':
                if (isset($_GET['clfut'])) {
                    $liste_utilisateurs = lister_utilisateur();
                    if ($_GET['clfut']>=0 && $_GET['clfut']<= count($liste_utilisateurs)) {
                        $utilisateur = $liste_utilisateurs[$_GET['clfut']];
                        include("../vue/modifier_utilisateur.php");
                    }else{
                        include("../vue/gestion_utilisateurs.php");
                    }
                }else{
                    include("../vue/gestion_utilisateurs.php"); 
                }
                break;
            case 'sprut':
                if (isset($_GET['clfut'])) {
                    $liste_utilisateurs = lister_utilisateur();
                    if ($_GET['clfut']>=0 && $_GET['clfut']<= count($liste_utilisateurs)) {
                        $id_utilisateur = $liste_utilisateurs[$_GET['clfut']]->getId();
                        $supprimer = supprimer_utilisateur($id_utilisateur);

                        if (($supprimer)) {
                            ?>
                                <p>
                                    *L'utilisateur a été supprimé avec succès !!! ;
                                </p>
                            <?php
                            $liste_utilisateurs = lister_utilisateur();
                            include("../vue/gestion_utilisateurs.php");
                        }else{
                            ?>
                                <p>
                                    *La suppression de l'utilisateur a échouée !!! ;
                                </p>
                            <?php
                            $liste_utilisateurs = lister_utilisateur();
                            include("../vue/gestion_utilisateurs.php");
                        }
                        
                    }
                }
                break;
            default:
                $liste_utilisateurs = lister_utilisateur();
                include("../vue/gestion_utilisateurs.php");
                break;
        }
    }else{
        include("../vue/vue_par_defaut.php");
    }
?>
    