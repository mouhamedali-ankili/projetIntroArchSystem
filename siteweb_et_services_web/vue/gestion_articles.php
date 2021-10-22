<?php
if (isset($_GET['ajt'])){
    if ($_GET['ajt'] == 'ok'){
            ?>
                <p class="annonce">
                    *L'article a été ajouté avec succès !!! ");
                </p>
            <?php
    }else if($_GET['ajt'] == 'ntk'){
            ?>
                <p class="annonce">
                    *Echeque de l'ajout de l'article  !!! ");
                </p>
            <?php
    }
}
if (isset($_GET['mdf'])){
    if ($_GET['mdf'] == 'ok'){
            ?>
                <p class="annonce">
                    *L'article a été modifié avec succès !!! ");
                </p>
            <?php
    }else if($_GET['mdf'] == 'ntk'){
            ?>
                <p class="annonce">
                    *Echeque de la modification de l'article  !!! ");
                </p>
            <?php
    }
}
if (isset($_GET['ajct'])){
    if ($_GET['ajct'] == 'ok'){
            ?>
                <p class="annonce">
                    *La categorie a été ajoutée avec succès !!! ");
                </p>
            <?php
    }else if($_GET['ajct'] == 'ntk'){
            ?>
                <p class="annonce">
                    *Echeque de l'ajout de la categorie  !!! 
                </p>
            <?php
    }
}
if (isset($_GET['mdcat'])){
    if ($_GET['mdcat'] == 'ok'){
            ?>
                <p>
                    *La categorie a été modifié avec succès !!! 
                </p>
            <?php
    }else if($_GET['mdcat'] == 'ntk'){
            ?>
                <p>
                    *Echeque de la modification de La categorie  !!! 
                </p>
            <?php
    }
}
if (isset($_GET['spct'])){
    if ($_GET['spct'] == 'ok'){
            ?>
                <p>
                    *La categorie a été supprimé avec succès !!! 
                </p>
            <?php
    }else if($_GET['spct'] == 'ntk'){
            ?>
                <p>
                    *Echeque de la suppression de la categorie  !!! 
                </p>
            <?php
    }
}
?>

<div class="seach_option">
    <div class ="inner">
        <div class = "seach_by_categorie">
            <span>Gerez vos categories</span>
            <form action="../metier/gestion_des_articles.php" method = "POST" class= "categorie">
                <input type="submit" name ="ajouter_categorie" value = "Ajouter" id="ajout">
                <input type="text" placeholder="nom" name ="libelle">
                <input type="submit" name ="modifier_categorie"value = "Modifier" id="mod">
                <input type="text" placeholder="encien nom" name="encien_nom">
                <input type="text" placeholder="nouveau nom" name="nouveau_nom">
                <input type="submit" name ="supprimer_categorie"value = "Supprimer" id="sup">
                <input type="text" placeholder="libelle" name="nom">
            </form>
        </div>
    </div>
</div>

<table>
    <tr class = "impaire">
        <th>Titre</th>
        <th>Date de creation </th>
        <th>Date de modification</th>
        <th>Categorie</th>
        <th>Editeur</th>
        <th colspan = '3'>Options</th>
    </tr>
    <?php
        $i = 0;
        foreach($liste_articles as $cle => $article){
            ?>
                <tr class = "<?php echo $couleur = ($i%2==0)?'paire':'impaire'?>">
                        <td><?php echo $article->getTitre();?></td>

                        <td><?php echo $article->getDateCreation();?></td>
                    
                        <td><?php echo $article->getDateModification();?></td>
                        
                        <td><?php echo $article->getCategorie()->getLibelle();?></td>
                        
                        <td><?php echo $editeur = ($article->getEditeur()=='inconnu')?'inconnu':$article->getEditeur()->getEmail();?></td>
                        <td><a class="g-link" href="index.php?con=conok&ett=def&opt=aprart&clfar=<?php echo $cle ?>"><i class="fa fa-eye" aria-hidden="true"></i>aperçu</a></td>
                        <td><a class="g-link" href="index.php?con=conok&ett=def&opt=mdfart&clfar=<?php echo $cle ?>"><i class="fa fa-wrench" aria-hidden="true"></i>modifier</a></td>
                        <td><a class="g-link" href="index.php?con=conok&ett=def&opt=sprart&clfar=<?php echo $cle ?>"><i class="fa fa-trash" aria-hidden="true"></i>supprimer</a></td>
                </tr>
            <?php
            $i++;
        }
    ?>
</table>
