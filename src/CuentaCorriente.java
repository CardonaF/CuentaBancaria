public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;
    private double porcentajeComisionSobregiro;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, double limiteSobregiro, double porcentajeComisionSobregiro) {

        super(numeroCuenta, titular, saldoInicial, 0.0);
        this.limiteSobregiro = limiteSobregiro;
        this.porcentajeComisionSobregiro = porcentajeComisionSobregiro;
    }

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        this(numeroCuenta, titular, saldoInicial, 50000, 5.0);
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public double getPorcentajeComisionSobregiro() {
        return porcentajeComisionSobregiro;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto debe ser mayor que cero.");
            return;
        }

        if (monto > (getSaldo() + limiteSobregiro)) {
            System.out.println("Error: El monto supera el límite de sobregiro.");
            return;
        }

        setSaldo(getSaldo() - monto);
        System.out.println("Retiro exitoso.");

        if (getSaldo() < 0) {
            double sobregiro = Math.abs(getSaldo());
            double comision = sobregiro * (porcentajeComisionSobregiro / 100);

            setSaldo(getSaldo() - comision);
            System.out.println("Comisión por sobregiro: $" + comision);
        }
        System.out.println("Nuevo saldo: $" + getSaldo());
    }

    @Override
    public void mostrarInfo() {
        System.out.println("CUENTA CORRIENTE\n");
        super.mostrarInfo();
        System.out.println("Límite sobregiro: $" + limiteSobregiro);
        System.out.println("Comisión sobregiro: " + porcentajeComisionSobregiro);
    }
}