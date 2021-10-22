/**
 * Utilisateur.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package integration;

public class Utilisateur  implements java.io.Serializable {
    private int id;

    private java.lang.String nom;

    private java.lang.String prenom;

    private java.lang.String adresse;

    private long telephone;

    private java.lang.String email;

    private java.lang.String mot_de_passe;

    private java.lang.String fonction;

    public Utilisateur() {
    }

    public Utilisateur(
           int id,
           java.lang.String nom,
           java.lang.String prenom,
           java.lang.String adresse,
           long telephone,
           java.lang.String email,
           java.lang.String mot_de_passe,
           java.lang.String fonction) {
           this.id = id;
           this.nom = nom;
           this.prenom = prenom;
           this.adresse = adresse;
           this.telephone = telephone;
           this.email = email;
           this.mot_de_passe = mot_de_passe;
           this.fonction = fonction;
    }


    /**
     * Gets the id value for this Utilisateur.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Utilisateur.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the nom value for this Utilisateur.
     * 
     * @return nom
     */
    public java.lang.String getNom() {
        return nom;
    }


    /**
     * Sets the nom value for this Utilisateur.
     * 
     * @param nom
     */
    public void setNom(java.lang.String nom) {
        this.nom = nom;
    }


    /**
     * Gets the prenom value for this Utilisateur.
     * 
     * @return prenom
     */
    public java.lang.String getPrenom() {
        return prenom;
    }


    /**
     * Sets the prenom value for this Utilisateur.
     * 
     * @param prenom
     */
    public void setPrenom(java.lang.String prenom) {
        this.prenom = prenom;
    }


    /**
     * Gets the adresse value for this Utilisateur.
     * 
     * @return adresse
     */
    public java.lang.String getAdresse() {
        return adresse;
    }


    /**
     * Sets the adresse value for this Utilisateur.
     * 
     * @param adresse
     */
    public void setAdresse(java.lang.String adresse) {
        this.adresse = adresse;
    }


    /**
     * Gets the telephone value for this Utilisateur.
     * 
     * @return telephone
     */
    public long getTelephone() {
        return telephone;
    }


    /**
     * Sets the telephone value for this Utilisateur.
     * 
     * @param telephone
     */
    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }


    /**
     * Gets the email value for this Utilisateur.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Utilisateur.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the mot_de_passe value for this Utilisateur.
     * 
     * @return mot_de_passe
     */
    public java.lang.String getMot_de_passe() {
        return mot_de_passe;
    }


    /**
     * Sets the mot_de_passe value for this Utilisateur.
     * 
     * @param mot_de_passe
     */
    public void setMot_de_passe(java.lang.String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }


    /**
     * Gets the fonction value for this Utilisateur.
     * 
     * @return fonction
     */
    public java.lang.String getFonction() {
        return fonction;
    }


    /**
     * Sets the fonction value for this Utilisateur.
     * 
     * @param fonction
     */
    public void setFonction(java.lang.String fonction) {
        this.fonction = fonction;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Utilisateur)) return false;
        Utilisateur other = (Utilisateur) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.nom==null && other.getNom()==null) || 
             (this.nom!=null &&
              this.nom.equals(other.getNom()))) &&
            ((this.prenom==null && other.getPrenom()==null) || 
             (this.prenom!=null &&
              this.prenom.equals(other.getPrenom()))) &&
            ((this.adresse==null && other.getAdresse()==null) || 
             (this.adresse!=null &&
              this.adresse.equals(other.getAdresse()))) &&
            this.telephone == other.getTelephone() &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.mot_de_passe==null && other.getMot_de_passe()==null) || 
             (this.mot_de_passe!=null &&
              this.mot_de_passe.equals(other.getMot_de_passe()))) &&
            ((this.fonction==null && other.getFonction()==null) || 
             (this.fonction!=null &&
              this.fonction.equals(other.getFonction())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getId();
        if (getNom() != null) {
            _hashCode += getNom().hashCode();
        }
        if (getPrenom() != null) {
            _hashCode += getPrenom().hashCode();
        }
        if (getAdresse() != null) {
            _hashCode += getAdresse().hashCode();
        }
        _hashCode += new Long(getTelephone()).hashCode();
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getMot_de_passe() != null) {
            _hashCode += getMot_de_passe().hashCode();
        }
        if (getFonction() != null) {
            _hashCode += getFonction().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Utilisateur.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:serviceUtilisateurWsdl", "utilisateur"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prenom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prenom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adresse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "adresse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telephone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telephone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mot_de_passe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mot_de_passe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fonction");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fonction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
