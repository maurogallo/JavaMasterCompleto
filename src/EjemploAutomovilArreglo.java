package src;

import java.sql.PseudoColumnUsage;
import java.util.Arrays;

public class EjemploAutomovilArreglo {
    public static void main(String[] args) {
        Persona conductorSubaru = new Persona("luci", "Martinez");
        Automovil subaru = new Automovil("subaru", "Impreza");
        subaru.setMotor(new Motor(2.0, TipoMotor.BENCINA));
        subaru.setEstanque(new Estanque());
        subaru.setColor(Color.BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setConductor(conductorSubaru);


        Persona pato = new Persona("Pato", "Rodriguez");
        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setEstanque(new Estanque());
        mazda.setConductor(pato);


        Persona bea = new Persona("Bea", "gonazalez");
        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS, new Motor(4.0, TipoMotor.DIESEL), new Estanque(45) );
        nissan.setConductor(bea);
        nissan.setTipo(TipoAutomovil.PICKUP);


        Persona lalo = new Persona("lalo", "mena");
        Automovil suzuki = new Automovil("Suzuki", "Vitara", Color.GRIS, new Motor(1.6, TipoMotor.DIESEL), new Estanque(50));
        suzuki.setConductor(lalo);
        suzuki.setTipo(TipoAutomovil.SUV);
        suzuki.setColor(Color.AMARILLO);
        Automovil.setColorPatente(Color.AZUL);

        Automovil audi = new Automovil("Audi","A3");
        audi.setConductor(new Persona("Jano","Pérez"));

        Automovil[] autos = new Automovil[5];
        autos[0] = subaru;
        autos[1] = mazda;
        autos[2] = nissan;
        autos[3] = suzuki;
        autos[4] = audi;

        Arrays.sort(autos);
        Arrays.stream(autos).forEach(System.out::println);



    }

}
