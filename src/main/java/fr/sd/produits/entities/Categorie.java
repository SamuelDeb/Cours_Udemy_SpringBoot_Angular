package fr.sd.produits.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Categorie {

    /**
     * Identifiant unique de la catégorie.
     * Généré automatiquement par la base de données.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCat;
	private String nomCat;
	private String descriptionCat;

     /**
     * Liste des produits associés à cette catégorie.
     */
	@OneToMany(mappedBy = "categorie")
	private List<Produit> produits;


	public void setIdCat(long l) {
		// TODO Auto-generated method stub
		
	}
	

}