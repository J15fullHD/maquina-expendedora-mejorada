public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // El numero de billetes vendidos
    private int billeteVendido;
    // Maquina con o sin premio
    private boolean premioMaquina;
    // Numero maximo de billetes a vender
    private int numeroMaximoBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premio, int numMaximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billeteVendido = 0;
        premioMaquina = premio; 
        numeroMaximoBilletes = numMaximoBilletes;
    }
    
    public MaquinaExpendedoraMejorada(boolean premio, int numMaximoBilletes) {
        precioBillete = 12;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "Leon";
        estacionDestino = "Oviedo"; 
        billeteVendido = 0;
        premioMaquina = premio;
        numeroMaximoBilletes = numMaximoBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroMaximoBilletes == 0) {
            System.out.println("Billetes agotados, no puedes introducir mas dinero");
        } else {
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            } else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            } 
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        int descuento = (precioBillete * 25) / 100;
        if (numeroMaximoBilletes == 0) {
            System.out.println("Lo sentimos, billetes agotados");
            System.out.println();
        } else {
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();
            
                if (premioMaquina == true) {
                    System.out.println("ENHORABUENA, tu billete tiene premio. Has obtenido " + descuento + "€ de descuento en CEX");
                    System.out.println();
                }
            
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
            
                billeteVendido++;
                numeroMaximoBilletes--;
            } else {
                System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
                    
            } 
        }
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    public int vaciarDineroDeLaMaquina() {
        int dineroDevuelto;
        if (balanceClienteActual > 0) {
            dineroDevuelto = -1;
            System.out.println("Imposible devolver dinero, operación en curso");
        } else {
            dineroDevuelto = totalDineroAcumulado;
            totalDineroAcumulado = 0;
        }
        return dineroDevuelto;
    }
    
    public int getNumeroBilletesVendidos() {
        return billeteVendido;
    }
    
    public void imprimirNumeroBilletesVendidos() {
        System.out.println("Se han vendido " + getNumeroBilletesVendidos() + " billetes");
    }
}
