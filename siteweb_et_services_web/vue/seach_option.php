<div class="seach_option">
    <div class ="inner">
        <!-- fonciionnalité non implementer (raison priorité)
        <div class="seach_by_title" >
            <input class="input" type = "text" hidden>
            <div class="seach_btn">
                <i class="fa fa-search" aria-hidden="true" hidden ></i>
            </div>
        </div>
        -->
        <div class = "seach_by_categorie">
            <?php
                foreach($liste_categories as $categorie){
            ?>
                    <span class = "categorie"><a href ="index.php?opt=artsct&amp;constt=<?php echo $constt = ($con == true) ? 'ok':'ntk';?>&amp;idc=<?php echo $categorie->getId(); ?>" class="l-categorie"><?php echo $categorie->getLibelle(); ?> </a> </span>
            <?php
                }
            ?>
        </div>
    </div>
</div>

