public abstract class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private double tasaInteres;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial, double tasaInteres){
        this.numeroCuenta= numeroCuenta;
        this.titular= titular;

        if(saldoInicial<0){
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
        }
        this.saldo = saldoInicial;
        this.tasaInteres = tasaInteres;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double monto) {

        if(monto <= 0){
            System.out.println("Error: El monto a depositar debe ser mayor que cero.");
            return;
        }

        saldo += monto;

        System.out.println("Depósito realizado correctamente.");
        System.out.println("Monto depositado: $" + monto);
        System.out.println("Nuevo saldo: $" + saldo);
    }

    public void aplicarInteres() {

        double interes = saldo * (tasaInteres / 100);

        saldo += interes;

        System.out.println("--------------------------------");
        System.out.println("Cuenta: " + numeroCuenta);
        System.out.println("Interés aplicado: $" + interes);
        System.out.println("Nuevo saldo: $" + saldo);
    }

    public void mostrarInfo() {
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: $" + saldo);
        System.out.println("Tasa de interés: " + tasaInteres);
    }

    public abstract void retirar(double monto);






























}
