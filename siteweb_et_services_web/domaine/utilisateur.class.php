<?php
    class Utilisateur{
        protected $id;
        protected $nom;
        protected $prenom;
        protected $adresse;
        protected $telephone;
        protected $email;
        protected $mot_de_passe;
        protected $fonction;

        public function __construct($nom,$prenom,$adresse,$telephone,$email,$mot_de_passe,$fonction){
            $this->setNom($nom);
            $this->setPrenom($prenom);
            $this->setAdresse($adresse);
            $this->setTelephone($telephone);
            $this->setEmail($email);
            $this->setPassword($mot_de_passe);
            $this->setFonction($fonction);
        }

        public function setId($id){
            $this->id = $id;
        }

        public function setNom($nom){
            $this->nom = $nom;
        }

        public function setPrenom($prenom){
            $this->prenom = $prenom;
        }

        public function setAdresse($adresse){
            $this->adresse = $adresse;
        }

        public function setTelephone($telephone){
            $this->telephone = $telephone;
        }

        public function setEmail($email){
            $this->email = $email;
        }

        public function setPassword($mot_de_passe){
            $this->mot_de_passe = $mot_de_passe;
        }

        public function setFonction($fonction){
            $this->fonction = $fonction;
        }

        public function getId(){
            return $this->id;
        }

        public function getNom(){
            return $this->nom;
        }

        public function getPrenom(){
            return $this->prenom;
        }

        public function getAdresse(){
            return $this->adresse;
        }

        public function getTelephone(){
            return $this->telephone;
        }

        public function getEmail(){
            return $this->email;
        }

        public function getPassword(){
            return $this->mot_de_passe;
        }

        public function getFonction(){
            return $this->fonction;
        }
    }