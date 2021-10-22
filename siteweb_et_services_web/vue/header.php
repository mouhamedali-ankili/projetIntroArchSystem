<?php
    if ((isset($_GET['con']) && $_GET['con'] == 'conok') || (isset($_GET['constt']) && $_GET['constt'] == 'ok')) {
        session_start();
        $con = true;
        $fonction = $_SESSION['fonction'];
    } else {
        $con = false;
    }
    
?>

<header >
  <nav  class = "menu">
        <div class="inner">
            <div class = "m-left">
                <h1 id="logo" >the news</h1>
            </div>
            
            <div class = "m-right">
                <span >
                    <a href ="index.php?opt=acc&amp;ett=def&amp;constt=<?php echo $constt = ($con == true) ? 'ok':'ntk';?>" class = "m-link"><i class="fa fa-home" aria-hidden="true"></i> Acceuil </a>
                    <?php
                        if ($con) {
                            $fonction = $_SESSION['fonction'];
                            if ($fonction == "administrateur") { 
                                
                                if (isset($_GET['ett'])) {
                                    switch ($_GET['ett']) {
                                        case 'edt':
                                            $_SESSION['etat'] = "edit";
                                            ?>
                                                <a href ="index.php?con=conok&amp;ett=edt&amp;edt=gestart" class = "m-link"><i class="fa fa-id-card" aria-hidden="true"></i> Gestion des articles </a>
                                                <a href ="index.php?con=conok&amp;ett=edt&amp;edt=ajouart" class = "m-link"><i class="fa fa-id-card" aria-hidden="true">+</i> Ajouter un article </a>  
                                                <a href ="index.php?con=conok&amp;ett=adm" class = "m-link"><i class="fa fa-users" aria-hidden="true"></i> Administrer votre site</a>
                                            <?php
                                            break;
                                        case 'adm':
                                            $_SESSION['etat'] = "admin";
                                            ?>
                                                <a href ="index.php?con=conok&amp;ett=adm&amp;adm=gestusr" class = "m-link"><i class="fa fa-user-md" aria-hidden="true"></i> Gestion des utilisateurs </a>  
                                                <a href ="index.php?con=conok&amp;ett=adm&amp;adm=ajouusr" class = "m-link"><i class="fa fa-user-plus" aria-hidden="true"></i> Ajouter un utilisateur </a>  
                                                <a href ="index.php?con=conok&amp;ett=edt" class = "m-link" ><i class="fa fa-pencil" aria-hidden="true"></i> Editer</a>
                                            <?php
                                            break;
                                        default:
                                            if ($_SESSION['etat'] == "edit"){
                                                ?>
                                                    <a href ="index.php?con=conok&amp;ett=edt&amp;edt=gestart" class = "m-link"><i class="fa fa-id-card" aria-hidden="true"></i> Gestion des articles </a>
                                                    <a href ="index.php?con=conok&amp;ett=edt&amp;edt=ajouart" class = "m-link"><i class="fa fa-id-card" aria-hidden="true">+</i> Ajouter un article </a>  
                                                    <a href ="index.php?con=conok&amp;ett=adm" class = "m-link"><i class="fa fa-users" aria-hidden="true"></i> Administrer votre site</a>
                                                <?php
                                            }else{
                                                ?>
                                                    <a href ="index.php?con=conok&amp;ett=adm&amp;adm=gestusr" class = "m-link"><i class="fa fa-user-md" aria-hidden="true"></i> Gestion des utilisateurs </a>  
                                                    <a href ="index.php?con=conok&amp;ett=adm&amp;adm=ajouusr" class = "m-link"><i class="fa fa-user-plus" aria-hidden="true"></i> Ajouter un utilisateur </a>  
                                                    <a href ="index.php?con=conok&amp;ett=edt" class = "m-link"><i class="fa fa-pencil" aria-hidden="true"></i> Editer</a>
                                                <?php
                                            }
                                            break;
                                    }
                                }else {
                                    if ($_SESSION['etat'] == "edit"){
                                        ?>
                                            <a href ="index.php?con=conok&amp;ett=edt&amp;edt=gestart" class = "m-link"><i class="fa fa-id-card" aria-hidden="true"></i> Gestion des articles </a>
                                            <a href ="index.php?con=conok&amp;ett=edt&amp;edt=ajouart" class = "m-link"><i class="fa fa-id-card" aria-hidden="true">+</i> Ajouter un article </a>  
                                            <a href ="index.php?con=conok&amp;ett=adm" class = "m-link"><i class="fa fa-users" aria-hidden="true"></i> Administrer votre site</a>
                                        <?php
                                    }else{
                                        ?>
                                            <a href ="index.php?con=conok&amp;ett=adm&amp;adm=gestusr" class = "m-link"><i class="fa fa-user-md" aria-hidden="true"></i> Gestion des utilisateurs </a>  
                                            <a href ="index.php?con=conok&amp;ett=adm&amp;adm=ajouusr" class = "m-link"><i class="fa fa-user-plus" aria-hidden="true"></i> Ajouter un utilisateur </a>  
                                            <a href ="index.php?con=conok&amp;ett=edt" class = "m-link"><i class="fa fa-pencil" aria-hidden="true"></i> Editer</a>
                                        <?php
                                    }
                                }
                                ?>
                                    

                                <?php   
                            } elseif ($fonction == "editeur") {
                                ?>
                                    <a href ="index.php?con=conok&amp;edt=gestart" class = "m-link"><i class="fa fa-id-card" aria-hidden="true"></i> Gestion des articles </a>
                                    <a href ="index.php?con=conok&amp;edt=ajouart" class = "m-link"><i class="fa fa-id-card" aria-hidden="true">+</i> Ajouter un article </a>  
                                <?php
                            }
                            ?>
                                <a href ="../metier/deconnexion.php?opt=dec" class = "m-link"><i class="fa fa-sign-out" aria-hidden="true"></i> Deconnexion </a>
                            <?php
                        }else{
                            ?>
                                <a href ="index.php?opt=con" class = "m-link"><i class="fa fa-sign-in" aria-hidden="true"></i> Connexion </a>
                            <?php
                        }
                            ?>
                </span>
            </div>
        </div>
    </nav>
</header>