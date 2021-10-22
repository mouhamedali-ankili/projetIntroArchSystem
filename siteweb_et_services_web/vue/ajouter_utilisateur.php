<div class ="inner">
    <h4 class="libelle"> Ajouter un utilisateur </h4>
    <form method="POST" action = "../metier/gestion_des_utilisateurs.php">
        <label for = "nom">Nom</label>
        <input type = "text" name = "nom" placeholder="Nom" id = "nom">
        
        <label for = "prenom">Prenom</label>
        <input type = "text" name = "prenom" placeholder="Prenom" id = "prenom">
        
        <label for = "adresse">Adresse</label>
        <input type = "text" name = "adresse" placeholder="Adresse" id = "adresse">
        <br>
        <label for = "telephone">Téléphone</label>
        <input type = "number" name = "telephone" placeholder="Telephone" id = "telephone">
        
        <label for = "email">Adresse email</label>
        <input type = "text" name = "email" placeholder="Email" id = "email">
        
        <label for = "mot_de_passe">Mot de passe</label>
        <input type = "password" name = "password" Placeholder = "mot de passe" id = "mot_de_passe">
        <br>
        <label for = "fonction">fonction</label>
        <select name = "fonction" id = "fonction">
            <option value = "administrateur">Administrateur</option>
            <option value = "editeur">editeur</option>
            <option value = "visiteur simple" selected = "selected" >visiteur simple</option>
        </select>
        <br>
        <div class ="action">
            <input type = "submit" name = "ajouter" value = "Ajouter">&nbsp;<input type = "reset" value = "Annuler">
        </div>
    </form>
</div>
