<?php
    $_SESSION['id_article'] = $article->getId();
?>
<div class="inner">
    <h4>Modifier vos articles</h4> 
    <form method="POST" action = "../metier/gestion_des_articles.php">
        <label for = "titre" >Le titre de l'article : </label>
        <br>
        <input type = "texte" name = "titre" id = "titre" value = "<?php echo $article->getTitre() ;?>">
        <br>
        <label for = "contenu" >Le contenu de l'article : </label>
        <textarea name = "contenu" row = "100" cols = "50" id = "contenu" value = "<?php echo $article->getContenu() ;?>">
            <?php echo $article->getContenu() ;?>
        </textarea>

        <label for = "categorie">Categorie</label>
        
        <select name = "categorie" id = "categorie">
            <option selected = "selected" value = "<?php echo $article->getCategorie()->getId()?>"><?php echo $article->getCategorie()->getLibelle()?></option>
            <?php
                foreach ($liste_categories as $categorie) {   
                
            ?>
                <option value = "<?php echo $categorie->getId()?>"><?php echo $categorie->getLibelle()?></option>
            <?php
            }
            ?>
        </select> 
        <br>
        <div class="action">
            <input type = "submit" name = "modifier" value = "Modifier" onClick = "return confirmer()">&nbsp;<input type = "reset" value = "Annuler">
        </div>
    </form>
</div>