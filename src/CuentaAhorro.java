public class CuentaAhorro extends CuentaBancaria {
    private String fechaApertura;
    private static final double TASA_INTERES = 2.5;

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, String fechaApertura){
        super(numeroCuenta, titular, saldoInicial, TASA_INTERES);

        if (saldoInicial < 10000) {
            throw new IllegalArgumentException(
                    "Error: El saldo mínimo para abrir una Cuenta de Ahorro es de $10.000");
        }
        this.fechaApertura = fechaApertura;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto debe ser mayor que cero.");
            return;
        }
        if (monto > getSaldo()) {
//            System.out.println("Error: Saldo insuficiente.");
            System.out.println("Saldo disponible: $" + getSaldo());
            return;
        }
        setSaldo(getSaldo() - monto);
        System.out.println("Retiro realizado correctamente.");
        System.out.println("Monto retirado: $" + monto);
        System.out.println("Nuevo saldo: $" + getSaldo());
    }

    @Override
    public void mostrarInfo() {
        System.out.println("CUENTA DE AHORRO\n");
        super.mostrarInfo();
        System.out.println("Fecha de apertura: " + fechaApertura);
    }
}
