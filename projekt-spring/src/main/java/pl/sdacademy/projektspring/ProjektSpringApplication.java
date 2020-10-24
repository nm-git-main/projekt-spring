package pl.sdacademy.projektspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pl.sdacademy.projektspring.model.Product;
import pl.sdacademy.projektspring.service.ProductService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ProjektSpringApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ProjektSpringApplication.class, args);

        Scanner in = new Scanner(System.in);
        ProductService productService= ctx.getBean(ProductService.class);
        do {
            System.out.println("Wybierz opcje");
            System.out.println("1. Wyswietl katalog produktow.");
            System.out.println("2. Wyszukaj produkt po nazwie.");
            System.out.println("3. Wyszukaj produkt po ID.");
            System.out.println("4. Dodaj produkt do koszyka.");
            System.out.println("5. Wyjdz z programu.");

            String opcjaWybrana = in.next();
            int wyborLiczba = 0;
            try {
                wyborLiczba = Integer.parseInt(opcjaWybrana);
            } catch (Exception e) {
                System.out.println("Cos poszlo nie tak");
                System.out.println(e);
                continue;
            }
            switch (wyborLiczba) {
                case 1:

                    break;

                case 2:
                    System.out.println("Podaj nazwe produktu do wyszukania");
                    List<Product> product2 = productService.findByName(in.next());
                    System.out.println("Podałeś :"+ );


                    break;

                case 3:
                    System.out.println("Podaj prosze ID ;)");
                    Product product = productService.findById(in.nextInt());
                    System.out.println("Wybrałes ptodukt: "+ product);

                    break;
                case 4:

                    break;
                case 5:
                    return;
                default:
                    System.out.println("Podales liczbe z poza zakresu. Spróbuj ponownie.");
            }


        }

        while (true);
    }

}
