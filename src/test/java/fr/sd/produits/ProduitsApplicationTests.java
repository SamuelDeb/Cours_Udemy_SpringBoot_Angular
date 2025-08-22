package fr.sd.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.sd.produits.entities.Categorie;
import fr.sd.produits.entities.Produit;
import fr.sd.produits.repos.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {

    /**
     * Test de base pour vérifier que le contexte de l'application Spring se charge avec succès.
     * Ce test s'assure que tous les beans sont correctement configurés et que l'application démarre sans erreur.
     */
    @Test
    void contextLoads() {
    }

    @Autowired
    private ProduitRepository produitRepository;

    /**
     * Teste la création et la persistance d'une nouvelle entité Produit.
     * Crée un nouveau produit avec des valeurs prédéfinies et l'enregistre dans la base de données.
     */
    @Test
    public void testCreateProduit() {
        Produit prod = new Produit("PC Dell3",2200.500,new Date());
        produitRepository.save(prod);
    }

    /**
     * Teste la récupération d'une entité Produit par son ID.
     * Récupère un produit avec l'ID 1 depuis la base de données et affiche ses détails.
     */
    @Test
    public void testFindProduit()
    {
        Produit p = produitRepository.findById(1L).get();
        System.out.println(p);
    }

    /**
     * Teste l'opération de mise à jour sur une entité Produit existante.
     * Récupère un produit par ID, modifie son prix et sauvegarde les modifications.
     */
    @Test
    public void testUpdateProduit()
    {
        Produit p = produitRepository.findById(1L).get();
        p.setPrixProduit(1000.0);
        produitRepository.save(p);
    }

    /**
     * Teste la suppression d'une entité Produit par son ID.
     * Supprime le produit avec l'ID 1 de la base de données.
     */
    @Test
    public void testDeleteProduit()
    {
        produitRepository.deleteById(1L);;

    }

    /**
     * Teste la récupération de toutes les entités Produit de la base de données.
     * Récupère tous les produits et affiche chacun d'eux dans la console.
     */
    @Test
    public void testListerTousProduits()
    {
        List<Produit>  prods = produitRepository.findAll();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    /**
     * Teste la recherche de produits par correspondance exacte du nom de produit.
     * Recherche les produits avec le nom exact "PC Dell2" et affiche les résultats.
     */
    @Test
    public void testFindByNomProduit()
    {
        List<Produit>  prods = produitRepository.findByNomProduit("PC Dell2");
        for (Produit p : prods)
        {
            System.out.println(p);
        }

    }

    /**
     * Teste la recherche de produits par correspondance partielle du nom de produit.
     * Recherche les produits dont les noms contiennent "Dell" et affiche les résultats.
     */
    @Test
    public void testFindByNomProduitContains ()
    {
        List<Produit> prods=produitRepository.findByNomProduitContains("Dell");
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    /**
     * Teste la recherche de produits par critères de nom et de prix.
     * Recherche les produits avec le nom "PC Dell2" et le prix 2200.0, puis affiche les résultats.
     */
    @Test
    public void testfindByNomPrix()
    {
        List<Produit>  prods = produitRepository.findByNomPrix("PC Dell2", 2200.0);
        for (Produit p : prods)
        {
            System.out.println(p);
        }

    }

    /**
     * Teste la recherche de produits par entité catégorie.
     * Crée une catégorie avec l'ID 1, recherche les produits dans cette catégorie et affiche les résultats.
     */
    @Test
    public void testfindByCategorie()
    {
        Categorie cat = new Categorie();
        cat.setIdCat(1L);
        List<Produit>  prods = produitRepository.findByCategorie(cat);
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    /**
     * Teste la recherche de produits par ID de catégorie.
     * Recherche les produits appartenant à la catégorie avec l'ID 1 et affiche les résultats.
     */
    @Test
    public void findByCategorieIdCat()
    {
        List<Produit>  prods = produitRepository.findByCategorieIdCat(1L);
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    /**
     * Teste la récupération de produits triés par nom de produit en ordre croissant.
     * Récupère tous les produits triés alphabétiquement par nom et affiche les résultats.
     */
    @Test
    public void testfindByOrderByNomProduitAsc()
    {
        List<Produit>  prods =    produitRepository.findByOrderByNomProduitAsc();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    /**
     * Teste une méthode de requête personnalisée pour trier les produits par nom et prix.
     * Utilise une méthode de repository personnalisée pour récupérer les produits avec des critères de tri spécifiques et affiche les résultats.
     */
    @Test
    public void testTrierProduitsNomsPrix() {
        List<Produit> prods = produitRepository.trierProduitsNomsPrix();
        for (Produit p : prods) {
            System.out.println(p);
        }
    }
}