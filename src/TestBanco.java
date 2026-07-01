public class TestBanco {

    public static void main(String[] args) {
        System.out.print("Paso1: Crear las cuentas\n ");
        CuentaAhorro cuenta1 = new CuentaAhorro("AH001", "Ana Perez", 50000, "2024-01-15");
        CuentaCorriente cuenta2 = new CuentaCorriente( "CC001", "Luis Gomez", 20000);
        CuentaEmpresarial cuenta3 = new CuentaEmpresarial( "EM001", "Tech Solutions", 200000, "Tech Solutions", "123456789-0");
        CuentaAhorro cuenta4 = new CuentaAhorro( "AH002", "Maria Lopez", 15000, "2024-02-01");


        System.out.println("\nPaso 2: Mostrar la informacion inicial\n");
        cuenta1.mostrarInfo();
        cuenta2.mostrarInfo();
        cuenta3.mostrarInfo();
        cuenta4.mostrarInfo();

        System.out.println("\nPaso 3: Realizar las operaciones\n");
        cuenta1.depositar(10000);
        cuenta2.retirar(25000);
        cuenta3.retirar(10000);
        cuenta4.retirar(20000);

        System.out.println("\nPaso 4: Aplicar intereses\n");
        cuenta1.aplicarInteres();
        cuenta2.aplicarInteres();
        cuenta3.aplicarInteres();
        cuenta4.aplicarInteres();

        System.out.println("\nPaso 5: Mostrar el estado final\n");
        cuenta1.mostrarInfo();
        cuenta2.mostrarInfo();
        cuenta3.mostrarInfo();
        cuenta4.mostrarInfo();


        System.out.println("\nPaso 6: Generar un resumen\n");
        int totalCuentas = 4;
        double saldoTotal = cuenta1.getSaldo() + cuenta2.getSaldo() + cuenta3.getSaldo() + cuenta4.getSaldo();
        double promedio = saldoTotal / totalCuentas;
        CuentaBancaria mayor = cuenta1;

        if (cuenta2.getSaldo() > mayor.getSaldo()) {
            mayor = cuenta2;
        }

        if (cuenta3.getSaldo() > mayor.getSaldo()) {
            mayor = cuenta3;
        }

        if (cuenta4.getSaldo() > mayor.getSaldo()) {
            mayor = cuenta4;
        }

        System.out.println("Total de cuentas: " + totalCuentas);

        System.out.println("Saldo total: $" + saldoTotal);

        System.out.println("Promedio de saldo: $" + promedio);

        System.out.println("Cuenta con mayor saldo:\n");

        System.out.println("Número: " + mayor.getNumeroCuenta());
        System.out.println("Titular: " + mayor.getTitular());
        System.out.println("Saldo: $" + mayor.getSaldo());
    }

}
