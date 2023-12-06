package entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double solde;
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;

    @Enumerated(EnumType.STRING)
    private EtatCompte etatCompte;



    public Compte(double solde, Date dateCreation, TypeCompte typeCompte, EtatCompte etatCompte) {
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.typeCompte = typeCompte;
        this.etatCompte = etatCompte;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public EtatCompte getEtatCompte() {
        return etatCompte;
    }

    public void setEtatCompte(EtatCompte etatCompte) {
        this.etatCompte = etatCompte;
    }
}
