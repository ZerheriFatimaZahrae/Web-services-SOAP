package ma.enset;

import proxy.BanqueService;
import proxy.BanqueServiceService;
import proxy.Compte;

public class Main {
    public static void main(String[] args) {
        BanqueService proxy = new BanqueServiceService().getBanqueServicePort();
        System.out.println(proxy.conversionEuroToDh(800));

        System.out.println("************************************");
        Compte compte = proxy.getCompte(4);
        System.out.println(compte.getSolde());
        System.out.println(compte.getCode());
        System.out.println(compte.getDateCreation());

        System.out.println("************************************");
        System.out.println("Liste des comptes");

        proxy.listComptes().forEach(c->{
            System.out.println(c.getCode());
            System.out.println(c.getSolde());
            System.out.println(c.getDateCreation());
        });
    }
}