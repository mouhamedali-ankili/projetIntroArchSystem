<div class="inner">
    <h4>Modifier les informations de l'utilisateur</h4> 
    <form method="POST" action = "../metier/gestion_des_utilisateurs.php">
        <label for = "nom">Nom</label>
        <input type = "text" name = "nom" value = "<?php echo $utilisateur->getNom() ;?>" id = "nom">
        
        <label for = "prenom">Prenom</label>
        <input type = "text" name = "prenom" value = "<?php echo $utilisateur->getPrenom() ;?>" id = "prenom">
        
        <label for = "adresse">Adresse</label>
        <input type = "text" name = "adresse" value = "<?php echo $utilisateur->getAdresse() ;?>" id = "adresse">
        <br>
        <label for = "telephone">Téléphone</label>
        <input type = "number" name = "telephone" value = "<?php echo $utilisateur->getTelephone() ;?>" id = "telephone">
        
        <label for = "email">Adresse email</label>
        <input type = "text" name = "email" value = "<?php echo $utilisateur->getEmail() ;?>" id = "email">
        
        <?php
            $_SESSION['id_utilisateur'] = $utilisateur->getId();
            $_SESSION['mot_de_passe_utilisateur'] = $utilisateur->getPassword();
        ?>
        <br>
        <label for = "encien_password">Encien mot de passe</label>
        <input type = "password" name = "encien_password" placeholder = "Encien mot de passe" id = "encien_password">
        
        <label for = "nouveau_password">Nouveau mot de passe</label>
        <input type = "password" name = "nouveau_password" placeholder = "Nouveau mot de passe" id = "nouveau_password">
        
        <label for = "fonction">fonction</label>
        <select name = "fonction" id = "fonction">
            <option value = "<?php echo $utilisateur->getFonction(); ?>" selected = "selected"><?php echo $utilisateur->getFonction(); ?></option>
            <option value = "administrateur">Administrateur</option>
            <option value = "editeur">editeur</option>
            <option value = "visiteur simple">visiteur simple</option>
        </select>
        <br>
        <div class="action">
            <input type = "submit" name = "modifier" value = "Modifier" onClick = "return confirmer()">&nbsp;<input type = "reset" value = "Annuler">
        </div>
    </form>
</div>