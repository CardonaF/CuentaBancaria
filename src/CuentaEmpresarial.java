public class CuentaEmpresarial extends CuentaBancaria {
    private String nombreEmpresa;
    private String RUT;
    private double comisionRetiro;
    private static final double TASA_INTERES = 1.5;
    private static final double COMISION_DEFECTO = 2000;

    public CuentaEmpresarial(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, String RUT) {

        super(numeroCuenta, titular, saldoInicial, TASA_INTERES);
        if (saldoInicial < 100000) {
            throw new IllegalArgumentException(
                    "Error: El saldo mínimo para abrir una Cuenta Empresarial es de $100.000");
        }
        this.nombreEmpresa = nombreEmpresa;
        this.RUT = RUT;
        this.comisionRetiro = COMISION_DEFECTO;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getRUT() {
        return RUT;
    }

    public double getComisionRetiro() {
        return comisionRetiro;
    }

    @Override
    public void retirar(double monto){
        if (monto <= 0){
            System.out.println("Error: El monto debe ser mayor que cero.");
            return;
        }

        if ((monto + comisionRetiro) > getSaldo()) {
            System.out.println("Error: Saldo insuficiente.");
            return;
        }
        setSaldo(getSaldo() - monto);
        setSaldo(getSaldo() - comisionRetiro);

        System.out.println("Retiro exitoso.");
        System.out.println("Comisión por retiro: $" + comisionRetiro);
        System.out.println("Nuevo saldo: $" + getSaldo());
    }

    @Override
    public void mostrarInfo() {
        System.out.println("CUENTA EMPRESARIAL\n");
        super.mostrarInfo();
        System.out.println("Empresa: " + nombreEmpresa);
        System.out.println("RUT: " + RUT);
        System.out.println("Comisión por retiro: $" + comisionRetiro);

    }

}
