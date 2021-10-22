<html lang = "fr">
    <head>
        <meta charset = "utf-8">
      <?php 
        
        include("../dao/db_connexion.php");  
        include("../metier/gestion_des_articles.php"); 
        include("../metier/gestion_des_utilisateurs.php");  
    
      ?>
      <link rel="stylesheet" href ="../vue/stylesheet/general.css"/>
      <link rel="stylesheet" href ="../vue/stylesheet/header.css"/>
      <link rel="stylesheet" href ="../vue/stylesheet/form.css"/>
      <link rel="stylesheet" href ="../vue/stylesheet/essaie.css"/>
      <link rel="stylesheet" href ="../vue/stylesheet/footer.css"/>
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link href="https://fonts.googleapis.com/css2?family=Besley:ital@0;1&family=Lato:ital,wght@1,100;1,300;1,400;1,700&family=Roboto:ital,wght@1,700;1,900&display=swap" rel="stylesheet">
      <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
      
      <link rel="preconnect" href="https://fonts.gstatic.com">
      <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500&display=swap" rel="stylesheet"> 
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
      
      <script src="../vue/vue.js" async></script>
    </head>
    <body>
      <?php
      include("../vue/header.php");
      $footer = true;
      if (isset($_GET['opt']) && $_GET['opt'] == "con") {
        include("../vue/authentification.php");
        $footer = false;
      }elseif (isset($_GET['con'])){
        if ($_GET['con'] == "conok") {
          include("controleur_secondaire.php");
          $footer = true;
        } else{
          $footer = false;
          include("../vue/authentification.php");
          ?>
            <script>
              alert("Votre connection a échoué verifié votre email et votre mot de passe !!! ");
            </script>
          <?php
        }
      }elseif(isset($_GET['opt']) && ($_GET['opt'] == "acc")){
        include("controleur_principale.php");
      }else {
        include("controleur_principale.php");
      }
      if ($footer) {
        include("../vue/footer.php");
      }
      ?>
    </body>
</html>
