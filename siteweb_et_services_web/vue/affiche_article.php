<div class ="affiche_art" >

   <div class = "affiche_info_art">
            <h3 class ="titreArt"> <?php echo $article->getTitre();?> </h3>
            <span class = "contenuArt"><?php echo $article->getContenu();?></span>
            <div class ="info">
                <span class = "info_art editeur">Editeur</span>
                <span class = "info_art editeur"><?php echo $editeur = ($article->getEditeur()=='inconnu')?'inconnu':$article->getEditeur()->getEmail();?></span>
                <span class = "info_art categorie">Categorie</span>
                <span class = "info_art categorie"><?php echo $article->getCategorie()->getLibelle();?></span>
                <span class = "info_art date_creation">Date de creation</span>
                <span class = "info_art date_creation"><?php echo $article->getDateCreation();?></span>
                <span class = "info_art date_modification">Date de modification</span>
                <span class = "info_art date_modification"><?php echo $article->getDateModification();?></span>
            </div>
    </div>
</div>