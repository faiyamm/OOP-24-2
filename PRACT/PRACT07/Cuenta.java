public class Cuenta {
    private String titular;
    private String tipoCuenta;
    private double saldo;
    private int numeroCuenta;
    private long clabe;
    private String pin;

    public Cuenta(String titular, String tipoCuenta, double saldo, int numeroCuenta, long clabe, String pin) {
        this.titular = titular;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
        this.clabe = clabe;
        this.pin = pin;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public long getClabe() {
        return clabe;
    }

    public void setClabe(long clabe) {
        this.clabe = clabe;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Cuenta [titular=" + titular + ", tipoCuenta=" + tipoCuenta + ", saldo=" + saldo + ", numeroCuenta="
                + numeroCuenta + ", clabe=" + clabe + "]";
    }

    // depositar
    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    // retirar
    public void retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
    
    // consultar saldo validando el pin
    public void consultarSaldo(String pin) {
        if (this.pin.equals(pin)) {
            System.out.println("Saldo: " + saldo);
        } else {
            System.out.println("PIN incorrecto");
        }
    }
}
