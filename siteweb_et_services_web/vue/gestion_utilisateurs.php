<?php
if (isset($_GET['ajt'])){
    if ($_GET['ajt'] == 'ok'){
            ?>
                <p class = "annonce">
                    *L'utilisateur a été ajouté avec succès !!! ;
                </p>
            <?php
    }else if($_GET['ajt'] == 'ntk'){
            ?>
                <p class = "annonce">
                    *Echeque de l'ajout de l'utilisateur  !!! ;
                </p>
            <?php
    }
}
if (isset($_GET['mdf'])){
    if ($_GET['mdf'] == 'ok'){
            ?>
                <p class = "annonce">
                    *L'utilisateur a été modifié avec succès !!! ;
                </p>
            <?php
    }else if($_GET['mdf'] == 'ntk'){
            ?>
                <p class = "annonce">
                    *Echeque de la modification de l'utilisateur  !!! ;
                </p>
            <?php
    }
}
?>
<span class="sw3">
    <a  href ="index.php?con=conok&amp;opt=svw3" class = "m-link"><i class="fa fa-home" aria-hidden="true"></i> Services 3W </a>
</span>
<table>
    <tr class ="impaire">
        <th>Nom</th>
        <th>Prenom </th>
        <th>Adresse</th>
        <th>Telephone</th>
        <th>Email</th>
        <th>Fonction</th>
        <th colspan = '2'>Options</th>
    </tr>
    <?php
        $i=0;
        foreach($liste_utilisateurs as $cle => $utilisateur){
            ?>
                <tr class = "<?php echo $couleur = ($i%2==0)?'paire':'impaire'?>">
                    
                    <td><?php echo $utilisateur->getNom();?></td>
                    
                    <td><?php echo $utilisateur->getPrenom();?></td>
                
                    <td><?php echo $utilisateur->getAdresse();?></td>
                
                    <td><?php echo $utilisateur->getTelephone();?></td>
                    
                    <td><?php echo $utilisateur->getEmail();?></td>
                    
                    <td><?php echo $utilisateur->getFonction();?></td>
                    <td><a class = "g-link " href="index.php?con=conok&ett=def&opt=mdfut&clfut=<?php echo $cle ?>"><i class="fa fa-wrench" aria-hidden="true"></i>modifier</a></td>
                    <td><a class = "g-link " href="index.php?con=conok&ett=def&opt=sprut&clfut=<?php echo $cle ?>"><i class="fa fa-trash" aria-hidden="true"></i>supprimer</a></td>
                </tr>
            <?php
            $i++;
        }
    ?>
</table>