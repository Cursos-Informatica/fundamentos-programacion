package app_9_1;
public class PruebaGato {
    public static void main(String[] args) {
        
        GatoAnimado garfield = new GatoAnimado("macho");
        
        System.out.println("hola gatito");
        garfield.maulla();
        
        System.out.println("toma tarta");
        garfield.come("tarta selva negra");
        
        System.out.println("toma pescado, a ver si esto te gusta");
        garfield.come("pescado");
        
        GatoAnimado tom = new GatoAnimado("macho");
        
        System.out.println("Tom, toma sopita de verduras");
        tom.come("sopa de verduras");
        
        GatoAnimado lisa = new GatoAnimado("hembra");
        
        System.out.println("gatitos, a ver cómo maulláis");
        garfield.maulla();
        tom.maulla();
        lisa.maulla();
        garfield.peleaCon(lisa);
        lisa.peleaCon(tom);
        tom.peleaCon(garfield);
    }
}
