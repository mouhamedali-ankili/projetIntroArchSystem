<div class ="affiche_listes_art" >
    <div class="inner">
    <?php
     $i = 0;
     while($i<count($liste_articles)){
         ?>
            <div class = "affiche_groupe_art">
                <?php
                    for($j = $i; $j<$i+3; $j++){
                        if ($j == count($liste_articles)) {
                            break;
                        } else {
                            ?>
                            <div class = "affiche_arts">
                                <h3 class ="titreArt"> 
                                    <a href ="index.php?constt=<?php echo $constt = ($con == true) ? 'ok':'ntk';?>&amp;opt=art&amp;ida=<?php echo $liste_articles[$j]->getId();?>"> 
                                        <?php echo $liste_articles[$j]->getTitre();?> 
                                    </a>
                                </h3>
                                <span class = "contenuArt">
                                    
                                    <?php echo substr($liste_articles[$j]->getContenu(),0,1).substr($liste_articles[$j]->getContenu(),1,25).'...';?>
                                   
                                </span>
                                <div class ="info">
                                    <span class = "date_creation">Créer le : <?php echo $liste_articles[$j]->getDateCreation();?></span>
                                    <span class = "date_modification">Modifier le : <?php echo $liste_articles[$j]->getDateModification();?></span>
                                    <span class = "categorie">categorie : <?php echo $liste_articles[$j]->getCategorie()->getLibelle();?></span>
                                </div>
                            </div>
                            <?php
                        }   
                    }
                    $i = $j;
                ?>
            </div>
         <?php
     }
    ?>
    </div>
</div>