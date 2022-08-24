package src;

import java.util.Date;

public class EjemploAutomovil {
    public static void main(String[] args) {

        Automovil subaru = new Automovil("subaru", "Impreza");
        subaru.setMotor(new Motor(2.0,TipoMotor.BENCINA));
        subaru.setEstanque(new Estanque());
        subaru.setColor(Color.BLANCO);

        Motor motorMazda =  new Motor(3.0,TipoMotor.DIESEL);
        Automovil mazda = new Automovil("Mazda", "BT-50",Color.ROJO, motorMazda);
        mazda.setEstanque(new Estanque(45));

        System.out.println("Mazda fabricante = " + mazda.getFabricante());

        Automovil nissan = new Automovil("Nissan", "Navara",Color.GRIS ,new Motor(4.0,TipoMotor.DIESEL), new Estanque(45));

        Automovil nissan2 = new Automovil("Nissan", "Navara",Color.GRIS, new Motor(4.0,TipoMotor.DIESEL), new Estanque(50));

        Automovil auto = new Automovil();
        Date fecha = new Date();

        System.out.println("son iguales? " + (nissan == nissan2));
        System.out.println("son iguales con equals? " + (nissan.equals(nissan2)));
        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());

        System.out.println(auto.equals(fecha));
        System.out.println(nissan);
        System.out.println(nissan.toString());

        System.out.println(subaru.acelerar(3000));
        System.out.println(subaru.frenar());

        System.out.println(mazda.acelerarFrenar(4000));

        System.out.println("Kilometros por litro " + subaru.calcularConsumo(300, 0.75f));

        System.out.println("Kilometros por litro " + subaru.calcularConsumo(300, 75));




    }
    
}
