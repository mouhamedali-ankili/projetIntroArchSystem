<?php
    class Categorie{
        
        protected $idCategorie;
        protected $libelle;

        public function __construct($libelle){
            $this->setLibelle($libelle);
        }

        public function setIdCategorie($idCategorie){
            $this->idCategorie = $idCategorie;
        }
        public function setLibelle($libelle){
            $this->libelle = $libelle;
        }

        public function getLibelle(){
            return $this->libelle;
        }

        public function getId(){
            return $this->idCategorie;
        }
    }