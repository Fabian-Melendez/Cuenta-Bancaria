import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //añadí una variable para el limite de depositos
        //se agregó un if anidado tanto a depositar como retirar para el limite de depositos como para evitar valores negativos
        //se agregó un limite para retiros en total creando 2 nuevas variables

        Scanner tcl= new Scanner(System.in);
        int op;
        double monto;
        boolean est= true;

        List<Cuentabancaria> lstBanco =new ArrayList<>();

        Cuentabancaria cl1=new Cuentabancaria();
        do {

            System.out.println("""
                    1.Crear Cliente
                    2. Mostrar
                    3. Mostrar info de cuenta especifica
                    4. Depositar dinero
                    5. Retirar dinero
                    6. Salir
                    """);
            op = tcl.nextInt();
            switch (op) {

                case 1 -> {

                    System.out.println("Ingrese el nombre del titular");
                    cl1.setTitular(tcl.next());

                    System.out.println("Ingrese el saldo de la cuenta");
                    cl1.setSaldo(tcl.nextDouble());

                    System.out.println("Ingrese el numero de la cuenta");
                    cl1.setNumeroCuenta(tcl.next());

                    //cl1= new Cuentabancaria(cl1.getTitular(), cl1.getSaldo(), cl1.getNumeroCuenta());
                    //lstBanco.add(cl1);
                    lstBanco.add(new Cuentabancaria(cl1.getTitular(), cl1.getSaldo(), cl1.getNumeroCuenta()));
                }
                case 2 -> {
                    for (Cuentabancaria cu : lstBanco) {
                        System.out.println(cu);
                    }
                }
                case 3-> {
                    String nCuenta;
                    System.out.println("Ingrese el numnero de cuenta");
                    nCuenta= tcl.next();
                    //for tradicional
                    for (int i = 0; i <lstBanco.size(); i++) {
                        if (lstBanco.get(i).getNumeroCuenta().equalsIgnoreCase(nCuenta)) {
                            cl1.mostrarInformacion();
                        }
                    }
                }
                case 4 -> {
                    String nCuenta;
                    System.out.println("Ingrese el numnero de cuenta");
                    nCuenta= tcl.next();
                    //for tradicional
                    for (int i = 0; i <lstBanco.size(); i++) {
                        if (lstBanco.get(i).getNumeroCuenta().equalsIgnoreCase(nCuenta)) {
                            System.out.println(lstBanco.get(i));
                        }
                    }

                    do {
                        System.out.println("DEPOSITAR");
                        System.out.println("De cuando será el deposito?");
                        monto = tcl.nextDouble();
                        cl1.depositarDinero(monto);
                    }while(monto<0);

                }case 5 ->{
                    String nCuenta;
                    System.out.println("Ingrese el numnero de cuenta");
                    nCuenta= tcl.next();
                    //for tradicional
                    for (int i = 0; i <lstBanco.size(); i++) {
                        if (lstBanco.get(i).getNumeroCuenta().equalsIgnoreCase(nCuenta)) {
                            System.out.println(lstBanco.get(i));
                        }
                    }
                    do {
                        System.out.println("RETIRAR");
                        System.out.println("De cuando será el retiro?");
                        monto = tcl.nextDouble();
                        cl1.retirarDinero(monto);
                    }while(monto<=0);

                }
                case 6-> {
                    System.out.println("Salir");
                    est=false;
                }

            }
        }while(est);



        /*do {
        /*do {

            System.out.println("""

                    1. Depositar dinero
                    2. Retirar dinero
                    3. Mostrar informacion
                    4. Mostrar info desde la lista
                    5. Salir
                    """);

            op = tcl.nextInt();

            switch (op) {
                case 1 -> {
                    do {
                        System.out.println("DEPOSITAR");
                        System.out.println("De cuando será el deposito?");
                        monto = tcl.nextDouble();
                        cl1.depositarDinero(monto);
                    }while(monto<0);
                }
                case 2 -> {
                    do {
                        System.out.println("RETIRAR");
                        System.out.println("De cuando será el retiro?");
                        monto = tcl.nextDouble();
                        cl1.retirarDinero(monto);
                    }while(monto<=0);
                }
                case 3 -> {
                    System.out.println("Mostrar informacion de la cuenta");
                    cl1.mostrarInformacion();
                }
                case 4 -> {
                    System.out.println("Mostrar clientes desde la Lista");
                    //System.out.println(lstBanco.toString());
                    for (Cuentabancaria cu : lstBanco) {
                        System.out.println(cu);
                    }
                }
                case 5 -> {
                    System.out.println("Salir");
                    est=false;
                }
                default -> {
                    System.out.println("Esa opcion NO existe");
                }
            }
        }while (est);*/
    }
}