public class Cuentabancaria {

    private String titular;
    private double saldo;
    private String numeroCuenta;
    private static final double limdep = 1000000.0;
    private static final int limrep = 3;
    private int retitotal = 0;

    public Cuentabancaria() {
    }

    public Cuentabancaria(String titular, double saldo, String numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "Cuentabancaria{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", retiros restantes=" + (limrep - retitotal) +
                '}';
    }

    public void depositarDinero(double monto) {
        if (monto <= 0) {
            System.out.println("No se pueden depositar valores negativos o cero.");
        } else if (monto > limdep) {
            System.out.println("No puedes depositar más de " + limdep + " en una sola transacción.");
        } else {
            saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
        }
    }

    public void retirarDinero(double monto) {
        if (monto <= 0) {
            System.out.println("No se pueden retirar valores negativos o cero.");
        } else if (monto > saldo) {
            System.out.println("Fondos insuficientes. Tu saldo actual es: " + saldo);
        } else if (retitotal >= limrep) {
            System.out.println("Has alcanzado el límite de retiros permitidos (" + limdep + ").");
        } else {
            saldo -= monto;
            retitotal++;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo + ". Retiros restantes: " + (limrep - retitotal));
        }

    }


    public void mostrarInformacion() {
        System.out.println("El titular es: " + this.titular);
        System.out.println("El saldo de la cuenta es: " + this.saldo);
        System.out.println("El numero de cuenta es: " + this.numeroCuenta);
        System.out.println("Retiros restantes: " + (limrep - retitotal));
    }





}