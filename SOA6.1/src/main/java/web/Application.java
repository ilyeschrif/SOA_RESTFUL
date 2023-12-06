package web;

import entities.Compte;
import entities.EtatCompte;
import entities.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CompteRepository;

import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "repositories")
@EntityScan(basePackages = "entities")

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Cette méthode est annotée avec @Bean et renvoie un CommandLineRunner.
    // CommandLineRunner exécute le code fourni lorsque l'application Spring démarre.
    @Bean
    public CommandLineRunner initData(CompteRepository compteRepository) {
        return args -> {

            // Création et sauvegarde d'entités Compte en utilisant CompteRepository.
            compteRepository.save(new Compte(1000.0, new Date(), TypeCompte.EPARGNE, EtatCompte.CREE));
            compteRepository.save(new Compte(2000.0, new Date(), TypeCompte.EPARGNE, EtatCompte.ACTIVE));
            compteRepository.save(new Compte(3000.0, new Date(), TypeCompte.COURANT, EtatCompte.SUSPENDU));

            // Récupération de toutes les entités Compte
            compteRepository.findAll().forEach(compte -> System.out.println(" compte " + compte.getId() + ":" +
                    " " + "  Type de compte:  " + compte.getTypeCompte() + "  Etat de compte:  " + compte.getEtatCompte() + "  Solde du compte :" + compte.getSolde()));

        };
    }
}