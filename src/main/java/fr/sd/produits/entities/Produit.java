package fr.sd.produits.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * Représente un produit dans le système.
 * Cette classe est une entité JPA et est mappée à une table en base de données.
 */
@Entity
public class Produit {

    /**
     * Identifiant unique du produit.
     * Généré automatiquement par la base de données.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    /**
     * Nom du produit.
     */
    private String nomProduit;

    /**
     * Prix du produit.
     */
    private Double prixProduit;

    /**
     * Date de création du produit.
     */
    private Date dateCreation;

    /**
     * Catégorie à laquelle appartient le produit.
     */
    @ManyToOne
    private Categorie categorie;

    /**
     * Constructeur par défaut.
     */
    public Produit() {
        super();
    }

    /**
     * Constructeur avec paramètres.
     *
     * @param nomProduit   Le nom du produit.
     * @param prixProduit  Le prix du produit.
     * @param dateCreation La date de création du produit.
     */
    public Produit(String nomProduit, Double prixProduit, Date dateCreation) {
        super();
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
    }

    /**
     * Retourne l'identifiant du produit.
     *
     * @return L'identifiant du produit.
     */
    public Long getIdProduit() {
        return idProduit;
    }

    /**
     * Définit l'identifiant du produit.
     *
     * @param idProduit L'identifiant du produit à définir.
     */
    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    /**
     * Retourne le nom du produit.
     *
     * @return Le nom du produit.
     */
    public String getNomProduit() {
        return nomProduit;
    }

    /**
     * Définit le nom du produit.
     *
     * @param nomProduit Le nom du produit à définir.
     */
    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    /**
     * Retourne le prix du produit.
     *
     * @return Le prix du produit.
     */
    public Double getPrixProduit() {
        return prixProduit;
    }

    /**
     * Définit le prix du produit.
     *
     * @param prixProduit Le prix du produit à définir.
     */
    public void setPrixProduit(Double prixProduit) {
        this.prixProduit = prixProduit;
    }

    /**
     * Retourne la date de création du produit.
     *
     * @return La date de création du produit.
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * Définit la date de création du produit.
     *
     * @param dateCreation La date de création du produit à définir.
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Retourne la catégorie du produit.
     *
     * @return La catégorie du produit.
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Définit la catégorie du produit.
     *
     * @param categorie La catégorie du produit à définir.
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * Retourne une représentation textuelle du produit.
     *
     * @return Une chaîne de caractères représentant le produit.
     */
    @Override
    public String toString() {
        return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixProduit=" + prixProduit
                + ", dateCreation=" + dateCreation + "]";
    }
}
