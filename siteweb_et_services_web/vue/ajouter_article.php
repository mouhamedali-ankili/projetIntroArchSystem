<div class = "inner">
    <h4>Creez vos articles ici</h4>
    <form method = "POST" action = "../metier/gestion_des_articles.php">
        <label for = "titre" >Le titre de l'article : </label>
        <input type = "texte" name = "titre" placeholder = "titre" id = "titre" >
        <br>
        <label for = "contenu" >Le contenu de l'article : </label>
        <textarea name = "contenu" row = "100" cols = "50" placeholder = "contenu" id = "contenu">
        Saisissez le contenu de votre article 
        </textarea>
        <label for = "categorie">Categorie</label>
        <select name = "categorie" id = "categorie">
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
            <input type = "submit" name = "ajouter" value = "Ajouter">&nbsp;<input type = "reset" value = "Annuler">
        </div>
    </form>
</div>

