<?php
    function db_connection(){
        $host = 'localhost';
        $dbname = 'theNews';
        $login = 'newsdba';
        $password = '@passer';
        try {
            $dbconnection = new PDO ('mysql:host='.$host.';dbname='.$dbname.';charset=utf8',''.$login.'',''.$password.'');
        } catch (Exception $e) {
            die ('Erreur de connection:'.$e->getMessage());
        }
        return $dbconnection;
    }