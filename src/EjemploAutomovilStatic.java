package src;

import java.sql.SQLOutput;

public class EjemploAutomovilStatic {
    public static void main(String[] args) {

        Automovil.setCapacidadEstanqueEstatico(45);
        Automovil subaru = new Automovil("subaru", "Impreza");
        subaru.setCilindrada(2.0);
        subaru.setColor(Color.BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);


        Automovil mazda = new Automovil("Mazda", "BT-50",Color.ROJO, 3.0);
        mazda.setTipo(TipoAutomovil.PICKUP);
        System.out.println("Mazda fabricante = " + mazda.getFabricante());

        Automovil nissan = new Automovil("Nissan", "Navara",Color.GRIS, 3.5, 50);
        nissan.setTipo(TipoAutomovil.PICKUP);
        Automovil nissan2 = new Automovil("Nissan", "Navara",Color.GRIS, 3.5, 50);
        nissan2.setTipo(TipoAutomovil.PICKUP);
        nissan2.setColor(Color.AMARILLO);
        Automovil.setColorPatente(Color.AZUL);

        Automovil auto = new Automovil();
      
        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());

        System.out.println(nissan2.verDetalle());
        System.out.println("Automovil.getPantenteColor = " + Automovil.getColorPatente());
        System.out.println("Kilometros por ltros = " + Automovil.calcularConsumoEstatico(300,60));
        System.out.println("Velocidad máxima carretera: " + Automovil.VELOCIDAD_MAXIMA_CARRETERA);
        System.out.println("Velocidad máxima ciudad: " + Automovil.VELOCIDAD_MAXIMA_Ciudad);

        TipoAutomovil tipoSubaru = subaru.getTipo();
        System.out.println("tipo subaru: " + tipoSubaru.getNombre());
        System.out.println("tipo desc .subaru: " + tipoSubaru.getDescripcion());
    }
    
}
