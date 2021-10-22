<?php
    if (isset($_GET['opt']) && $_GET['opt'] == "dec") {
        session_start();
        session_unset();
        session_destroy();
        header("location:../controleur/index.php");
      }