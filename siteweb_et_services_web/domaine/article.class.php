<?php
    class Article implements JsonSerializable{

        protected $id;
        protected $titre;
        protected $contenu;
        protected $dateCreation;
        protected $dateModification;
        protected $categorie;
        protected $editeur;

        public function __construct($titre,$contenu,$dateCreation,$dateModification,$categorie,$editeur){
            $this->setTitre($titre);
        	$this->setContenu($contenu);
        	$this->setDatecreation($dateCreation);
            $this->setDateModification($dateModification);
        	$this->setCategorie($categorie);
            $this->setEditeur($editeur);
        }

        
        public function setId($id){
            $this->id = $id;
        }

        public function setTitre($titre){
            $this->titre = $titre;
        }

        public function setContenu($contenu){
            $this->contenu = $contenu;
        }

        public function setDatecreation($dateCreation){
            $this->dateCreation = $dateCreation;
        }

        public function setDateModification($dateModification){
            $this->dateModification = $dateModification;
        }
        
        public function setCategorie($categorie){
            $this->categorie = $categorie;
        }
        public function setEditeur($editeur){
            $this->editeur = $editeur;
        }
        public function getId(){
            return $this->id;
        }

        public function getTitre(){
            return $this->titre;
        }

        public function getContenu(){
            return $this->contenu;
        }

        public function getDateCreation(){
            return $this->dateCreation;
        }

        public function getDateModification(){
            return $this->dateModification;
        }

        public function getCategorie(){
            return $this->categorie;
        }

        public function getEditeur(){
            return $this->editeur;
        }

        public function jsonSerialize() {
            return (object) get_object_vars($this);
        }
    }